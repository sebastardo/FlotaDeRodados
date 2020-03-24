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
public class Main {
    public static void main(String[] args) {
        
        System.out.println(Trafic.getColor());
        System.out.println(Trafic.getVelocidad());
        System.out.println(Trafic.getPeso());
        System.out.println(Trafic.getCapacidad());
        
        
        Trafic.cambiarPorInteriorPopular(true);
        System.out.println(Trafic.getPeso());
        System.out.println(Trafic.getCapacidad());
        
        Trafic.cambiarPorMotorPulenta(true);
        System.out.println(Trafic.getVelocidad());
        System.out.println(Trafic.getPeso());
    }
}
