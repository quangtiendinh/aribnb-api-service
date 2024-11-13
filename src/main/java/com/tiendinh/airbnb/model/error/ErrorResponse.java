package com.tiendinh.airbnb.model.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(
        ignoreUnknown = true)
public class ErrorResponse {
    @JsonProperty(
            index = 1)
    private int status;
    @JsonProperty(
            index = 2)
    private String type;
    @JsonProperty(
            index = 3)
    private String code;
    @JsonProperty(
            index = 4)
    private String message;
    @JsonProperty(
            index = 5)
    private Parameter parameter;

    ErrorResponse(final int status, final String type, final String code, final String message, final Parameter parameter) {
        this.status = status;
        this.type = type;
        this.code = code;
        this.message = message;
        this.parameter = parameter;
    }

    public static ErrorResponseBuilder builder() {
        return new ErrorResponseBuilder();
    }

    @JsonProperty(
            index = 1)
    public void setStatus(final int status) {
        this.status = status;
    }

    @JsonProperty(
            index = 2)
    public void setType(final String type) {
        this.type = type;
    }

    @JsonProperty(
            index = 3)
    public void setCode(final String code) {
        this.code = code;
    }

    @JsonProperty(
            index = 4)
    public void setMessage(final String message) {
        this.message = message;
    }

    @JsonProperty(
            index = 5)
    public void setParameter(final Parameter parameter) {
        this.parameter = parameter;
    }

    public static class ErrorResponseBuilder {
        private int status;
        private String type;
        private String code;
        private String message;
        private Parameter parameter;

        ErrorResponseBuilder() {}

        @JsonProperty(
                index = 1)
        public ErrorResponseBuilder status(final int status) {
            this.status = status;
            return this;
        }

        @JsonProperty(
                index = 2)
        public ErrorResponseBuilder type(final String type) {
            this.type = type;
            return this;
        }

        @JsonProperty(
                index = 3)
        public ErrorResponseBuilder code(final String code) {
            this.code = code;
            return this;
        }

        @JsonProperty(
                index = 4)
        public ErrorResponseBuilder message(final String message) {
            this.message = message;
            return this;
        }

        @JsonProperty(
                index = 5)
        public ErrorResponseBuilder parameter(final Parameter parameter) {
            this.parameter = parameter;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this.status, this.type, this.code, this.message, this.parameter);
        }
    }
}
