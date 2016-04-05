package com.kris.whitbread.api.model;

import java.util.List;

public class Specials {

    private int count;

    public Specials() {
    }

    public Specials(int count, List<Object> items) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
