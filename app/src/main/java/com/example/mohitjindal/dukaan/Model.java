package com.example.mohitjindal.dukaan;

public class Model {
    private int icon;
    private String title;
    private int delete;

    public Model(int icon,String title,int delete){
        this.icon = icon;
        this.title = title;
        this.delete = delete;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
