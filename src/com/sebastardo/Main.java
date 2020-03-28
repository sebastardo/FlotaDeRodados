/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo;

import com.sebastardo.Etapa1.ChevroletCorsa;
import com.sebastardo.Etapa1.Dependencia;
import com.sebastardo.Etapa1.RenaultKwid;
import com.sebastardo.Etapa1.RenaultTrafic;
import com.sebastardo.Etapa1.Rodado;
import com.sebastardo.Etapa2.Pedido;
import com.sebastardo.Etapa3.Registro;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Sebastian
 */
public class Main {
    public static void main(String[] args) {
        
        // Creacion dependencia
        Dependencia deportes = new Dependencia(45);

        
        // Creacion autos
        Rodado cachito = new ChevroletCorsa("rojo");       
        ChevroletCorsa corsaAzul = new ChevroletCorsa("azul");
        ChevroletCorsa corsaVerde = new ChevroletCorsa("verde");
        RenaultKwid kwidConTanqueAdicional1 = new RenaultKwid(true);
        Rodado autoEspecial = new Rodado(5,160, "beige",1200);
        
        
        // se agregan a dependencia
        deportes.agregarAFlota(cachito); 
        deportes.agregarAFlota(corsaAzul);  
        deportes.agregarAFlota(corsaVerde);
        deportes.agregarAFlota(kwidConTanqueAdicional1); 
        deportes.agregarAFlota(autoEspecial);
        
             
        
        // Creacion pedidos
        Pedido p1 = new Pedido(960,8,4,new HashSet<String>(Arrays.asList("azul","negro")));
        Pedido p2 = new Pedido(960,8,6,new HashSet<String>(Arrays.asList("azul","negro")));
        
        
        // se agregan a dependencia
        deportes.agregarPedido(p1);
        
        // Borrar
        deportes.mostrar();
    }
}
