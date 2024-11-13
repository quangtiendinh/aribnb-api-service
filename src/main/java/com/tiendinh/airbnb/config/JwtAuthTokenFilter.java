package com.tiendinh.airbnb.config;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.tiendinh.airbnb.exception.BusinessLogicException;
import com.tiendinh.airbnb.model.auth.UserAuthority;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.tiendinh.airbnb.utils.AppUtils.getRequestBearerToken;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JwtAuthTokenFilter extends OncePerRequestFilter {
    private final JsonMapper jsonMapper;
    private final JwtProvider jwtProvider;

    @Override
    public void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        authenticate(request, response);
        filterChain.doFilter(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws BusinessLogicException {
        var jwt = getRequestBearerToken(request);
        var isValidJWT = hasText(jwt) && jwtProvider.validate(jwt);

        if (!isValidJWT) {
            return;
        }

        var jwtClaims = jwtProvider.getClaims(jwt);
        var authority = jsonMapper.convertValue(jwtClaims, UserAuthority.class);

        var username = authority.getIdentifier();
        var authorities = AuthorityUtils.createAuthorityList(authority.getAuthorities());
        var user = User.builder()
                .username(username)
                .password(EMPTY)
                .authorities(authorities)
                .build();

        saveAuthentication(user, request);
    }

    private void saveAuthentication(UserDetails user, HttpServletRequest request) {
        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
