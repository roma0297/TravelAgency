package com.epam.pochanin.product;

public class ProductItem {

    private int id;
    private int price;
    private String title;
    private String shortDescription;

    private String fullDescription;
    private String feature1;
    private String feature2;
    private String feature3;
    private String feature4;
    private String feature5;
    private String pictureUrl1;
    private String pictureUrl2;
    private String pictureUrl3;
    private String pictureUrl4;


    public ProductItem(int id, int price, String title, String shortDescription, String fullDescription, String feature1, String feature2, String feature3, String feature4, String feature5, String pictureUrl1, String pictureUrl2, String pictureUrl3, String pictureUrl4) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
        this.feature4 = feature4;
        this.feature5 = feature5;
        this.pictureUrl1 = pictureUrl1;
        this.pictureUrl2 = pictureUrl2;
        this.pictureUrl3 = pictureUrl3;
        this.pictureUrl4 = pictureUrl4;
    }

    public ProductItem(ProductItem prototype) {
        this.id = prototype.getId();
        this.price = prototype.getPrice();
        this.title = prototype.getTitle();
        this.shortDescription = prototype.getShortDescription();
        this.fullDescription = prototype.getFullDescription();
        this.feature1 = prototype.getFeature1();
        this.feature2 = prototype.getFeature2();
        this.feature3 = prototype.getFeature3();
        this.feature4 = prototype.getFeature4();
        this.feature5 = prototype.getFeature5();
        this.pictureUrl1 = prototype.getPictureUrl1();
        this.pictureUrl2 = prototype.getPictureUrl2();
        this.pictureUrl3 = prototype.getPictureUrl3();
        this.pictureUrl4 = prototype.getPictureUrl4();
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", feature1='" + feature1 + '\'' +
                ", feature2='" + feature2 + '\'' +
                ", feature3='" + feature3 + '\'' +
                ", feature4='" + feature4 + '\'' +
                ", feature5='" + feature5 + '\'' +
                ", pictureUrl1='" + pictureUrl1 + '\'' +
                ", pictureUrl2='" + pictureUrl2 + '\'' +
                ", pictureUrl3='" + pictureUrl3 + '\'' +
                ", pictureUrl4='" + pictureUrl4 + '\'' +
                '}';
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

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public String getFeature3() {
        return feature3;
    }

    public void setFeature3(String feature3) {
        this.feature3 = feature3;
    }

    public String getFeature4() {
        return feature4;
    }

    public void setFeature4(String feature4) {
        this.feature4 = feature4;
    }

    public String getFeature5() {
        return feature5;
    }

    public void setFeature5(String feature5) {
        this.feature5 = feature5;
    }

    public String getPictureUrl1() {
        return pictureUrl1;
    }

    public void setPictureUrl1(String pictureUrl1) {
        this.pictureUrl1 = pictureUrl1;
    }

    public String getPictureUrl2() {
        return pictureUrl2;
    }

    public void setPictureUrl2(String pictureUrl2) {
        this.pictureUrl2 = pictureUrl2;
    }

    public String getPictureUrl3() {
        return pictureUrl3;
    }

    public void setPictureUrl3(String pictureUrl3) {
        this.pictureUrl3 = pictureUrl3;
    }

    public String getPictureUrl4() {
        return pictureUrl4;
    }

    public void setPictureUrl4(String pictureUrl4) {
        this.pictureUrl4 = pictureUrl4;
    }
}
