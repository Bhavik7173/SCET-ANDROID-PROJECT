package com.example.personalapplication.retro;

public class PathModel {
    String path;

    public PathModel(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "PathModel{" +
                "path='" + path + '\'' +
                '}';
    }

    public void setPath(String path) {
        this.path = path;
    }
}
