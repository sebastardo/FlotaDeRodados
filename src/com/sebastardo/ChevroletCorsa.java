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
public class ChevroletCorsa extends Rodado{

    // La capacidad de estos autos es de 4 pasajeros, su velocidad máxima 150 km/h, y pesan 1300 kg.
    // La municipalidad no estableció un color fijo para sus Corsa; por lo tanto, debe informarse el color de cada uno. 
    
    public ChevroletCorsa(String color) {
        super(4, 150, color, 1300);
    }
}
