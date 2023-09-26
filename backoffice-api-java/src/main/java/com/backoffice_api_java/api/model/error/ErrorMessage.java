package com.backoffice_api_java.api.model.error;

public class ErrorMessage {
    private Integer httpStatus;
    private String statusCode;
    private String title;
    private String message;

    public ErrorMessage(Integer httpStatus, String statusCode, String title, String message) {
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.title = title;
        this.message = message;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
