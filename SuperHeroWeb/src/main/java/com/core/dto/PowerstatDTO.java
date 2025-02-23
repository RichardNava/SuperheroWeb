/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.dto;

/**
 *
 * @author RaúlGalán
 */
public class PowerstatDTO {
    private Integer intelligence;
    private Integer strength;
    private Integer speed;
    private Integer durability;
    private Integer power;
    private Integer combat;

    public PowerstatDTO(Integer intelligence, Integer strength, Integer speed, Integer durability, Integer power, Integer combat) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
    }

    public PowerstatDTO() {
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getCombat() {
        return combat;
    }

    public void setCombat(Integer combat) {
        this.combat = combat;
    }
    
    
}
