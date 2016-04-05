package com.kris.whitbread.api.model;

public class HereNow {

    private long count;
    private String summary;

    //could find example Model, therefor Object
    private Object[] groups;

    public HereNow() {
    }

    public HereNow(long count, String summary, Object[] groups) {
        this.count = count;
        this.summary = summary;
        this.groups = groups;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Object[] getGroups() {
        return groups;
    }

    public void setGroups(Object[] groups) {
        this.groups = groups;
    }
}
