/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.dto;

import com.core.entities.Superhero;

/**
 *
 * @author RaúlGalán
 */
public class SuperheroDTO {

    private String name;
    private AppearanceDTO appearance;
    private PowerstatDTO powerstat;
    private ImagesDTO images;

    public SuperheroDTO(String name, AppearanceDTO appearance, PowerstatDTO powerstat, ImagesDTO images) {
        this.name = name;
        this.appearance = appearance;
        this.powerstat = powerstat;
        this.images = images;
    }

    public SuperheroDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppearanceDTO getAppearance() {
        return appearance;
    }

    public void setAppearance(AppearanceDTO appearance) {
        this.appearance = appearance;
    }

    public PowerstatDTO getPowerstat() {
        return powerstat;
    }

    public void setPowerstat(PowerstatDTO powerstat) {
        this.powerstat = powerstat;
    }

    public ImagesDTO getImages() {
        return images;
    }

    public void setImages(ImagesDTO images) {
        this.images = images;
    }

    public static SuperheroDTO convertSuperheroDTO(Superhero superhero) {
        if (superhero != null) {
            SuperheroDTO shDTO = new SuperheroDTO(
                    superhero.getName(),
                    new AppearanceDTO(
                            superhero.getIdAppearance().getGender(),
                            superhero.getIdAppearance().getRace(),
                            superhero.getIdAppearance().getHeight(),
                            superhero.getIdAppearance().getWeight(),
                            superhero.getIdAppearance().getEyeColor(),
                            superhero.getIdAppearance().getHairColor()
                    ),
                    new PowerstatDTO(
                            superhero.getIdPowerstat().getIntelligence(),
                            superhero.getIdPowerstat().getStrength(),
                            superhero.getIdPowerstat().getSpeed(),
                            superhero.getIdPowerstat().getDurability(),
                            superhero.getIdPowerstat().getPower(),
                            superhero.getIdPowerstat().getCombat()
                    ),
                    new ImagesDTO(
                            superhero.getIdImages().getXs(),
                            superhero.getIdImages().getSm(),
                            superhero.getIdImages().getMd(),
                            superhero.getIdImages().getLg()
                    )
            );
            return shDTO;
        }
        return null;
    }
}
