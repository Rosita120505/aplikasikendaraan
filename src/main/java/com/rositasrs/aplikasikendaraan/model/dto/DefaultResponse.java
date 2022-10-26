package com.rositasrs.aplikasikendaraan.model.dto;

public class DefaultResponse<T> {

    private Boolean status;
    private String pesan;
    private T
            size;


    private T data;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
