package com.brins.fitness;

public class Tip {

    private String tip;
    private int imageId;

    public Tip(String tip, int imageId) {
        this.tip = tip;
        this.imageId = imageId;
    }

    public String getTip() {
        return tip;
    }

    public int getImageId() {
        return imageId;
    }
}
