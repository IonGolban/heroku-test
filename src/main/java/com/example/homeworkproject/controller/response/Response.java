package com.example.homeworkproject.controller.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Response<T> extends ResponseEntity<T> {

    private String status;
    private ResponseErrorCode errorCode;
    private List<String> errors;
    private T data;

    public static final Response SUCCESS = new Response<>();

    public Response() {
        super(HttpStatus.OK);
        this.status = Consts.SUCCESS;
        this.data = null;
        this.errors = Collections.emptyList();
    }

    public Response(T data) {
        super(HttpStatus.OK);
        this.status = Consts.SUCCESS;
        this.data = data;
        this.errors = Collections.emptyList();
    }

    public Response(String status, ResponseErrorCode errorCode) {
        super(HttpStatus.OK);
        this.status = status;
        this.data = null;
        this.errorCode = errorCode;
        this.errors = Collections.emptyList();
    }

    public Response(T data, ResponseErrorCode errorCode) {
        super(HttpStatus.OK);
        this.status = Consts.SUCCESS;
        this.data = data;
        this.errorCode = errorCode;
        this.errors = Collections.emptyList();
    }

    public Response(T data, String status) {
        super(HttpStatus.OK);
        this.status = status;
        this.data = data;
        this.errors = Collections.emptyList();
    }

    public Response(T data, final List<String> errors, ResponseErrorCode errorCode) {
        super(HttpStatus.OK);
        this.status = Consts.ERROR;
        this.data = data;
        this.errorCode = errorCode;
        this.errors = errors == null ? Collections.emptyList() : Collections.unmodifiableList(errors);
    }

    public Response(final T data, final String status, final List<String> errors, final ResponseErrorCode errorCode) {
        super(HttpStatus.OK);
        this.status = status;
        this.data = data;
        this.errorCode = errorCode;
        this.errors = errors == null ? Collections.emptyList() : Collections.unmodifiableList(errors);
    }

    protected <T> Response(final List<String> errors, ResponseErrorCode errorCode) {
        super(HttpStatus.OK);
        this.status = Consts.ERROR;
        this.data = null;
        this.errorCode = errorCode;
        this.errors = errors == null ? Collections.emptyList() : Collections.unmodifiableList(errors);
    }

    protected Response(final List<String> errors) {
        super(HttpStatus.OK);
        this.status = Consts.ERROR;
        this.data = null;
        this.errors = errors == null ? Collections.emptyList() : Collections.unmodifiableList(errors);
    }

    public Response(HttpStatus status) {
        super(status);
    }

    public Response(T body, HttpStatus status) {
        super(body, status);
    }

    public Response(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public Response(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public static <T> Response<T> successfulResponse(T data) {
        return new Response<T>(data);
    }

    public static <T> Response<T> errorResponse(String... errors) {
        return new Response<T>(Arrays.asList(errors));
    }

    public static <T> Response<T> errorResponse(List<String> errors, ResponseErrorCode errorCode) {
        return new Response<T>(errors, errorCode);
    }

    public static <T> Response<T> errorResponse(List<String> errors, ResponseErrorCode errorCode, String status) {
        return new Response<T>(null, status, errors, errorCode);
    }

    @JsonIgnore
    public boolean isSuccessful() {
        return Consts.SUCCESS.equalsIgnoreCase(this.getStatus());
    }

}


