package com.epam.pochanin.entities;

import java.util.List;

public class Trip {
    private int id;
    private int price;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private List<String> features;
    private List<String> pictureURLs;

    public Trip(Trip prototype) {
        int id = prototype.getId();
        int price = prototype.getPrice();
        String title = prototype.getTitle();
        String shortDescription = prototype.getShortDescription();
        String fullDescription = prototype.getFullDescription();
        List<String> features = prototype.getFeatures();
        List<String> pictureURLs = prototype.getPictureURLs();
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", features=" + features +
                ", pictureURLs=" + pictureURLs +
                '}';
    }

    public Trip(int id, int price, String title, String shortDescription, String fullDescription) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
    }

    public Trip(int price, String title, String shortDescription, String fullDescription, List<String> features, List<String> pictureURLs) {
        this.price = price;
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.features = features;
        this.pictureURLs = pictureURLs;
    }

    public Trip(int price, String title, String shortDescription) {
        this.price = price;
        this.title = title;
        this.shortDescription = shortDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<String> getPictureURLs() {
        return pictureURLs;
    }

    public void setPictureURLs(List<String> pictureURLs) {
        this.pictureURLs = pictureURLs;
    }
}
