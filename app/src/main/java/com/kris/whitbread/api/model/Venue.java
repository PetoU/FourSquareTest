package com.kris.whitbread.api.model;

import java.util.List;

public class Venue {

    private String id;
    private String name;
    private Contact contact;
    private Location location;
    private List<Category> categories;
    private boolean verified;
    private Stats stats;
    private String url;
    private boolean hasMenu;
    private Menu menu;
    private boolean allowMenuUrlEdit;
    private Specials specials;
    private HereNow hereNow;
    private String referralId;
    private List<VenueChain> venueChains;

    public Venue() {
    }

    public Venue(String id, String name, Contact contact, Location location, List<Category> categories, boolean verified, Stats stats, String url, boolean hasMenu, Menu menu, boolean allowMenuUrlEdit, Specials specials, HereNow hereNow, String referralId, List<VenueChain> venueChains) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.categories = categories;
        this.verified = verified;
        this.stats = stats;
        this.url = url;
        this.hasMenu = hasMenu;
        this.menu = menu;
        this.allowMenuUrlEdit = allowMenuUrlEdit;
        this.specials = specials;
        this.hereNow = hereNow;
        this.referralId = referralId;
        this.venueChains = venueChains;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHasMenu() {
        return hasMenu;
    }

    public void setHasMenu(boolean hasMenu) {
        this.hasMenu = hasMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public Specials getSpecials() {
        return specials;
    }

    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    public HereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public List<VenueChain> getVenueChains() {
        return venueChains;
    }

    public void setVenueChains(List<VenueChain> venueChains) {
        this.venueChains = venueChains;
    }
}
