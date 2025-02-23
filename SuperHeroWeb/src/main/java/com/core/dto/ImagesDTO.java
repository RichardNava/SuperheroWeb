/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.dto;

/**
 *
 * @author RaúlGalán
 */
public class ImagesDTO {
    private String xs;
    private String sm;
    private String md;
    private String lg;

    public ImagesDTO(String xs, String sm, String md, String lg) {
        this.xs = xs;
        this.sm = sm;
        this.md = md;
        this.lg = lg;
    }

    public ImagesDTO() {
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
    
}
