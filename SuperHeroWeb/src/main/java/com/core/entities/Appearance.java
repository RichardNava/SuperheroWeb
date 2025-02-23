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
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author RaúlGalán
 */
@Entity
@Table(name = "appearance")
@NamedQueries({
    @NamedQuery(name = "Appearance.findAll", query = "SELECT a FROM Appearance a"),
    @NamedQuery(name = "Appearance.findById", query = "SELECT a FROM Appearance a WHERE a.id = :id"),
    @NamedQuery(name = "Appearance.findByGender", query = "SELECT a FROM Appearance a WHERE a.gender = :gender"),
    @NamedQuery(name = "Appearance.findByRace", query = "SELECT a FROM Appearance a WHERE a.race = :race"),
    @NamedQuery(name = "Appearance.findByHeight", query = "SELECT a FROM Appearance a WHERE a.height = :height"),
    @NamedQuery(name = "Appearance.findByWeight", query = "SELECT a FROM Appearance a WHERE a.weight = :weight"),
    @NamedQuery(name = "Appearance.findByEyeColor", query = "SELECT a FROM Appearance a WHERE a.eyeColor = :eyeColor"),
    @NamedQuery(name = "Appearance.findByHairColor", query = "SELECT a FROM Appearance a WHERE a.hairColor = :hairColor")})
public class Appearance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "gender")
    private String gender;
    @Size(max = 20)
    @Column(name = "race")
    private String race;
    @Column(name = "height")
    private Integer height;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight")
    private Float weight;
    @Size(max = 45)
    @Column(name = "eye_color")
    private String eyeColor;
    @Size(max = 45)
    @Column(name = "hair_color")
    private String hairColor;
    @OneToMany(mappedBy = "idAppearance", cascade= CascadeType.ALL)
    private List<Superhero> superheroList;

    public Appearance() {
    }

    public Appearance(Integer id) {
        this.id = id;
    }

    public Appearance(Integer id, String gender, String race, Integer height, Float weight, String eyeColor, String hairColor) {
        this.id = id;
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Appearance)) {
            return false;
        }
        Appearance other = (Appearance) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Appearance{" + "id=" + id + ", gender=" + gender + ", race=" + race + ", height=" + height + ", weight=" + weight + ", eyeColor=" + eyeColor + ", hairColor=" + hairColor + '}';
    }

}
