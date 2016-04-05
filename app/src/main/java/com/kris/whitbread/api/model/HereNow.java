package com.kris.whitbread.api.model;

import java.util.List;

public class HereNow {

    private long count;
    private String summary;
    private List<Group> groups;

    public HereNow() {
    }

    public HereNow(long count, String summary, List<Group> groups) {
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
