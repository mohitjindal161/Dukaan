package com.example.mohitjindal.dukaan;

public class ProductItem {
    private int icon;
    private String title;
    private String description;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }




    public ProductItem(int icon, String title, String description,String price) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.price = price;

    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
