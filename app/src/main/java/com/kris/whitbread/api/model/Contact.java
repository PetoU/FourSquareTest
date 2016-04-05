package com.kris.whitbread.api.model;

public class Contact {

    private String phone;
    private String formattedPhone;
    private String twitter;

    public Contact() {
    }

    public Contact(String phone, String formattedPhone, String twitter) {
        this.phone = phone;
        this.formattedPhone = formattedPhone;
        this.twitter = twitter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
