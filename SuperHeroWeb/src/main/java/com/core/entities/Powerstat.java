/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author RaúlGalán
 */
@Entity
@Table(name = "powerstat")
@NamedQueries({
    @NamedQuery(name = "Powerstat.findAll", query = "SELECT p FROM Powerstat p"),
    @NamedQuery(name = "Powerstat.findById", query = "SELECT p FROM Powerstat p WHERE p.id = :id"),
    @NamedQuery(name = "Powerstat.findByIntelligence", query = "SELECT p FROM Powerstat p WHERE p.intelligence = :intelligence"),
    @NamedQuery(name = "Powerstat.findByStrength", query = "SELECT p FROM Powerstat p WHERE p.strength = :strength"),
    @NamedQuery(name = "Powerstat.findBySpeed", query = "SELECT p FROM Powerstat p WHERE p.speed = :speed"),
    @NamedQuery(name = "Powerstat.findByDurability", query = "SELECT p FROM Powerstat p WHERE p.durability = :durability"),
    @NamedQuery(name = "Powerstat.findByPower", query = "SELECT p FROM Powerstat p WHERE p.power = :power"),
    @NamedQuery(name = "Powerstat.findByCombat", query = "SELECT p FROM Powerstat p WHERE p.combat = :combat")})
public class Powerstat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "intelligence")
    private Integer intelligence;
    @Column(name = "strength")
    private Integer strength;
    @Column(name = "speed")
    private Integer speed;
    @Column(name = "durability")
    private Integer durability;
    @Column(name = "power")
    private Integer power;
    @Column(name = "combat")
    private Integer combat;
    @Column(name = "avg")
    private double avg;
    @OneToMany(mappedBy = "idPowerstat", cascade=CascadeType.ALL)
    private List<Superhero> superheroList;

    public Powerstat() {
    }

    public Powerstat(Integer id) {
        this.id = id;
    }

    public Powerstat(Integer id, Integer intelligence, Integer strength, Integer speed, Integer durability, Integer power, Integer combat, double avg) {
        this.id = id;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
        this.avg = avg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public List<Superhero> getSuperheroList() {
        return superheroList;
    }

    public void setSuperheroList(List<Superhero> superheroList) {
        this.superheroList = superheroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Powerstat)) {
            return false;
        }
        Powerstat other = (Powerstat) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Powerstat{" + "id=" + id + ", intelligence=" + intelligence + ", strength=" + strength + ", speed=" + speed + ", durability=" + durability + ", power=" + power + ", combat=" + combat + ", avg=" + avg + '}';
    }

}
