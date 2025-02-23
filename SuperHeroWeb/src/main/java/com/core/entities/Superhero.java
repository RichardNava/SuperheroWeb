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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author RaúlGalán
 */
@Entity
@Table(name = "superhero")
@NamedQueries({
    @NamedQuery(name = "Superhero.findAll", query = "SELECT s FROM Superhero s"),
    @NamedQuery(name = "Superhero.findById", query = "SELECT s FROM Superhero s WHERE s.id = :id"),
    @NamedQuery(name = "Superhero.findByName", query = "SELECT s FROM Superhero s WHERE s.name = :name")})
public class Superhero implements Serializable {

    private static final long serialVersionUID = 2L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "id_appearance", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Appearance idAppearance;
    @JoinColumn(name = "id_images", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Images idImages;
    @JoinColumn(name = "id_powerstat", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Powerstat idPowerstat;
    @Basic(optional = false)
    @Column(name = "tier")
    private String tier;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "heroId")
    private List<Team> teamList;

    public Superhero() {
    }

    public Superhero(Integer id, String name, Appearance idAppearance, Images idImages, Powerstat idPowerstat, String tier, int price) {
        this.id = id;
        this.name = name;
        this.idAppearance = idAppearance;
        this.idImages = idImages;
        this.idPowerstat = idPowerstat;
        this.tier = tier;
        this.price = price;
    }

    public Superhero(Integer id) {
        this.id = id;
    }

    public Superhero(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appearance getIdAppearance() {
        return idAppearance;
    }

    public void setIdAppearance(Appearance idAppearance) {
        this.idAppearance = idAppearance;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Images getIdImages() {
        return idImages;
    }

    public void setIdImages(Images idImages) {
        this.idImages = idImages;
    }

    public Powerstat getIdPowerstat() {
        return idPowerstat;
    }

    public void setIdPowerstat(Powerstat idPowerstat) {
        this.idPowerstat = idPowerstat;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
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
        if (!(object instanceof Superhero)) {
            return false;
        }
        Superhero other = (Superhero) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Superhero{" + "id=" + id + ", name=" + name + ", idAppearance=" + idAppearance + ", idImages=" + idImages + ", idPowerstat=" + idPowerstat + ", tier=" + tier + ", price=" + price + '}';
    }

    
}
