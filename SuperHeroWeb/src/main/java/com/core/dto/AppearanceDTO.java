package com.core.dto;

public class AppearanceDTO {
    private String gender;
    private String race;
    private Integer height;
    private Float weight;
    private String eyeColor;
    private String hairColor;

    public AppearanceDTO(String gender, String race, Integer height, Float weight, String eyeColor, String hairColor) {
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    public AppearanceDTO() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    
}
