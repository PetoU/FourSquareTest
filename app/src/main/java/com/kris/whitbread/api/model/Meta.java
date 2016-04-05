package com.kris.whitbread.api.model;

public class Meta {

    private int code;
    private String requestId;


    public Meta() {
    }

    public Meta(int code, String requestId) {
        this.code = code;
        this.requestId = requestId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
