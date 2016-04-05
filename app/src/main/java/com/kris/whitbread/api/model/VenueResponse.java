package com.kris.whitbread.api.model;

import java.util.List;

public class VenueResponse {

    private Meta meta;
    private List<Venue> response;

    public VenueResponse() {
    }

    public VenueResponse(Meta meta, List<Venue> response) {
        this.meta = meta;
        this.response = response;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Venue> getResponse() {
        return response;
    }

    public void setResponse(List<Venue> response) {
        this.response = response;
    }
}
