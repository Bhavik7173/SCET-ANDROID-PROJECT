package com.example.personalapplication.retro;

public class FolderResponse {
    int id;
    String packageName;

    public FolderResponse() {
    }

    public FolderResponse(int id, String packageName) {
        this.id = id;
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "FolderResponse{" +
                "id=" + id +
                ", packageName='" + packageName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
