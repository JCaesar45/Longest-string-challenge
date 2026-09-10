// Product.java
package com.aegis.prime.model;

import java.util.List;

public class Product {
    private String tier;
    private String name;
    private String price;
    private List<String> features;

    public Product(String tier, String name, String price, List<String> features) {
        this.tier = tier;
        this.name = name;
        this.price = price;
        this.features = features;
    }

    public String getTier() { return tier; }
    public String getName() { return name; }
    public String getPrice() { return price; }
    public List<String> getFeatures() { return features; }
}
