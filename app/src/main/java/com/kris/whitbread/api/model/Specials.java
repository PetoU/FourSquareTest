package com.kris.whitbread.api.model;

public class Specials {

    private int count;

    // couldnt find example Model, therefore Object
    private Object[] items;

    public Specials() {
    }

    public Specials(int count, Object[] items) {
        this.count = count;
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object[] getItems() {
        return items;
    }

    public void setItems(Object[] items) {
        this.items = items;
    }
}
