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
@Table(name = "images")
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i"),
    @NamedQuery(name = "Images.findById", query = "SELECT i FROM Images i WHERE i.id = :id"),
    @NamedQuery(name = "Images.findByXs", query = "SELECT i FROM Images i WHERE i.xs = :xs"),
    @NamedQuery(name = "Images.findBySm", query = "SELECT i FROM Images i WHERE i.sm = :sm"),
    @NamedQuery(name = "Images.findByMd", query = "SELECT i FROM Images i WHERE i.md = :md"),
    @NamedQuery(name = "Images.findByLg", query = "SELECT i FROM Images i WHERE i.lg = :lg")})
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 250)
    @Column(name = "xs")
    private String xs;
    @Size(max = 250)
    @Column(name = "sm")
    private String sm;
    @Size(max = 250)
    @Column(name = "md")
    private String md;
    @Size(max = 250)
    @Column(name = "lg")
    private String lg;
    @OneToMany(mappedBy = "idImages", cascade=CascadeType.ALL)
    private List<Superhero> superheroList;

    public Images() {
    }

    public Images(Integer id) {
        this.id = id;
    }

    public Images(Integer id, String xs, String sm, String md, String lg) {
        this.id = id;
        this.xs = xs;
        this.sm = sm;
        this.md = md;
        this.lg = lg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXs() {
        return xs;
    }

    public void setXs(String xs) {
        this.xs = xs;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
        this.lg = lg;
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
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Images{" + "id=" + id + ", xs=" + xs + ", sm=" + sm + ", md=" + md + ", lg=" + lg + '}';
    }
    
    

}
