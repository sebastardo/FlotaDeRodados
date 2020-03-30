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
import com.sebastardo.Etapa1.RenaultTraficSingleton;
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
        
        // probando patron de diseño Singleton
        RenaultTraficSingleton trafic = RenaultTraficSingleton.getComprar();
        
        RenaultTraficSingleton trafic2 = RenaultTraficSingleton.getComprar();
        System.out.println(trafic.getCapacidad());
        trafic.cambiarPorInteriorPopular(true);
        System.out.println(trafic.getCapacidad());
        System.out.println(trafic2.getCapacidad());
        
        
        System.out.println(trafic==trafic2);
        // probando patron de diseño Singleton
        // trafic2 es algo asi como puntero a trafic, pero no es lo que necesito!
        
        
        
        
        
        
        
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
        Pedido p3 = new Pedido(960,8,7,new HashSet<String>(Arrays.asList("azul","negro")));
        
        
        // se agregan a dependencia
        deportes.agregarPedido(p1);
        deportes.agregarPedido(p2);
        deportes.agregarPedido(p3);
        
        deportes.pedidosSinAutos();
        
        System.out.println("Cantidad de pasajeros: " + deportes.cantidadDePasajeros());
        
        // Borrar esto no sirve, solo esta de prueba
        //deportes.mostrar();
        
        deportes.quitarPedido(p1);
        
        // cantidad de pasajeros
        System.out.println("Cantidad de pasajeros: " + deportes.cantidadDePasajeros());
        
        
        // color indeseado
        
        deportes.colorIncompatible("azul");
        deportes.colorIncompatible("rojo");
        
        
        deportes.borrar();
    }
}
