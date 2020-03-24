/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo;

/**
 *
 * @author Sebastian
 */
public class Rodado {
    // De cada rodado nos van a interesar: capacidad (o sea, cuántos pasajeros puede transportar), velocidad máxima, color y peso.
    private int capacidad;
    public int velocidad;
    private String color;
    private int peso;

    public Rodado(int capacidad, int velocidad, String color, int peso) {
        this.capacidad = capacidad;
        this.velocidad = velocidad;
        this.color = color;
        this.peso = peso;
    }
    
    
}
