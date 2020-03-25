/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo;

import com.sebastardo.Etapa1.ChevroletCorsa;
import com.sebastardo.Etapa1.Dependencia;
import com.sebastardo.Etapa1.RenaultKwid;

/**
 *
 * @author Sebastian
 */
public class Main {
    public static void main(String[] args) {
        
        Dependencia deportes = new Dependencia(95);
        ChevroletCorsa a = new ChevroletCorsa("rojo");
        ChevroletCorsa b = new ChevroletCorsa("verde");
        ChevroletCorsa c = new ChevroletCorsa("rojo");
        RenaultKwid k = new RenaultKwid(true);
        deportes.agregarAFlota(c);
        deportes.agregarAFlota(a);
        deportes.agregarAFlota(b);
        deportes.agregarAFlota(k);
        System.out.println(deportes.capacidadFaltante());
    }
}
