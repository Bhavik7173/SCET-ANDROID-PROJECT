package com.example.recyclerviewexample;

public class MyData {
    String description;
    int img;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public MyData(String description, int img) {
        this.description = description;
        this.img = img;
    }
}
