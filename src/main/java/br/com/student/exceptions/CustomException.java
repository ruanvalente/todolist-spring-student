package br.com.student.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private HttpStatus status;
    private String mensageDetail;

    public CustomException() {
    }

    public CustomException(HttpStatus status, String message, String mensageDetail) {
        super (message);
        this.status = status;
        this.mensageDetail = mensageDetail;
    }

    public CustomException(HttpStatus status, String message) {
        super (message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMensageDetail() {
        return mensageDetail;
    }
}
