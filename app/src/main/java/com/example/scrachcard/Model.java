package com.example.scrachcard;

public class Model {

    int image;
    String skim;

    public Model(int image, String skim) {
        this.image = image;
        this.skim = skim;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSkim() {
        return skim;
    }

    public void setSkim(String skim) {
        this.skim = skim;
    }
}
