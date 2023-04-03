package com.example.navdrawerbar;

public class DataModel {
    int icon;
    String name;

    public DataModel(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                '}';
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
