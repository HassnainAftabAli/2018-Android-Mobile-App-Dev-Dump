package com.ctis487.oldschool;

public class Rapper {
    private String stageName;
    private int birthYear;
    private int deathYear;
    private String realName;
    private int imageId;

    public Rapper(String stageName, int birthYear, int deathYear, String realName, int imageId) {
        this.stageName = stageName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.realName = realName;
        this.imageId = imageId;
    }

    public String getStageName() {
        return stageName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public String getRealName() {
        return realName;
    }

    public int getImageId() {
        return imageId;
    }
}
