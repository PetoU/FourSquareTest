package com.kris.whitbread.api.model;

public class Group {

    private String type;
    private String name;
    private int count;

    public Group() {
    }

    public Group(String type, String name, int count) {
        this.type = type;
        this.name = name;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
