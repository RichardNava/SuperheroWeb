/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.exceptions;

/**
 *
 * @author RaúlGalán
 */
public class PreexistingEntityException extends Exception {

    private static final long serialVersionUID = 1L;

    public PreexistingEntityException(String message) {
        super(message);
    }
    
}
