package com.kris.whitbread.api.model;

public class Stats {

    private long checkinsCount;
    private long usersCount;
    private long tipCount;

    public Stats() {
    }

    public Stats(long checkinsCount, long usersCount, long tipCount) {
        this.checkinsCount = checkinsCount;
        this.usersCount = usersCount;
        this.tipCount = tipCount;
    }

    public long getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(long checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    public long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(long usersCount) {
        this.usersCount = usersCount;
    }

    public long getTipCount() {
        return tipCount;
    }

    public void setTipCount(long tipCount) {
        this.tipCount = tipCount;
    }
}
