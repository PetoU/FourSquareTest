package com.kris.whitbread.api.model;

import java.util.List;

public class VenueResponse {

    private Meta meta;
    private Response response;

    public VenueResponse() {
    }

    public VenueResponse(Meta meta, Response response) {
        this.meta = meta;
        this.response = response;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
