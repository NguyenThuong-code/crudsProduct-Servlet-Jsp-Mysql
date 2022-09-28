package com.example.manageproduct.entity;

public class Product {
    private int id;
    private String nameProduct;
    private double priceProduct;
    private String describe;
    private String vendor;
    private String image;

    public Product() {
    }


    public Product(int id, String nameProduct, double priceProduct, String describe, String vendor, String image) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.describe = describe;
        this.vendor = vendor;
        this.image = image;
    }
    public Product( String nameProduct, double priceProduct, String describe, String vendor, String image) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.describe = describe;
        this.vendor = vendor;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
