package com.tiendinh.airbnb.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tiendinh.airbnb.model.dto.PhotoDTO;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "view_listings")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ListingView {
    @Id
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price_per_night")
    private Double pricePerNight;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "host_id")
    private Long hostId;

    @Column(name = "host_username")
    private String hostUsername;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "categories")
    @Type(JsonBinaryType.class)
    private List<String> categories;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private List<PhotoDTO> photos;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
