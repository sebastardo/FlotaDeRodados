/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa1;

import com.sebastardo.Etapa1.Rodado;
import com.sebastardo.Etapa2.Pedido;
import com.sebastardo.Etapa3.Registro;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sebastian
 * 
 * Como dijimos, cada dependencia de la municipalidad maneja una flota de rodados. 
 * Un rodado puede estar compartido entre varias dependencias (ver test más abajo). 
 * De cada dependencia importa también cuántos empleados tiene.
 * 
 * Debe ser posible enviarle los siguientes mensajes a cada objeto que representa a una dependencia.
 *  agregarAFlota(rodado) y quitarDeFlota(rodado).
 *  pesoTotalFlota(), la suma del peso de cada rodado afectado a la flota.
 *  estaBienEquipada(), es verdadero si la flota tiene al menos 3 rodados, y además, todos los rodados de la flota pueden ir al menos a 100 km/h.
 *  capacidadTotalEnColor(color), la cantidad total de personas que puede transportar la flota afectada a 
 *      la dependencia, considerando solamente los rodados del color indicado.
 *  colorDelRodadoMasRapido(), eso.
 *  capacidadFaltante(), que es el resultado de restar, de la cantidad de empleados, la capacidad sumada de los vehículos de la flota.
 *  esGrande(), la condición es que la dependencia tenga al menos 40 empleados y 5 rodados.
 * 
 */

public class Dependencia {
    private int cantidadEmpleados;
    private List<Rodado> flota;
    private Registro registroViajes;

    public Dependencia(int cantidadEmpleados) {
        flota = new ArrayList<>();
        this.cantidadEmpleados = cantidadEmpleados;
        
        registroViajes = new Registro();
    }
    
    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }
    
    ///////////////////////////////////////////////////////////////////////
    // AUTOS
    ///////////////////////////////////////////////////////////////////////
    
    public void agregarAFlota(Rodado rodado){
        flota.add(rodado);
    }
    public void quitarDeFlota(Rodado rodado){
        flota.remove(rodado);
    }
    
    public int pesoTotalFlota(){
        return flota.stream().mapToInt(r->r.getPeso()).sum();
    }
    
    public boolean estaBienEquipada(){
        return flota.size() >= 3 && flota.stream().allMatch(r->r.getVelocidad()>=100);
    }
    
    public int capacidadTotalEnColor(String color){
        return flota.stream().filter(r->r.getColor().equals(color)).mapToInt(r->r.getCapacidad()).sum();
    }
    
    public String colorDelRodadoMasRapido(){
        return flota.stream().max(Comparator.comparing(Rodado::getVelocidad)).get().getColor();
    }
    
    public int capacidadFaltante(){
        int faltan = cantidadEmpleados - flota.stream().mapToInt(r->r.getCapacidad()).sum();
        return faltan<0?0:faltan;
    }
    
    public boolean esGrande(){
        return cantidadEmpleados>=40 && flota.size() >= 5;
    }

    
    
    

    ///////////////////////////////////////////////////////////////////////
    // PEDIDOS
    ///////////////////////////////////////////////////////////////////////
    
    public void agregarPedido(Pedido pedido){
        registroViajes.agregar(pedido, flota);
        System.out.println("Agregado");
    }
    
    public void quitarPedido(Pedido pedido){
        registroViajes.quitar(pedido);
        System.out.println("Quitado");
    }
    
    public int cantidadDePasajeros(){
        return registroViajes.totalPasajeros();
    }
    
    public void colorIncompatible(String color){
        if(registroViajes.colorIndeseado(color)){
            System.out.println("El " + color + " es un color indeseado");
        } else {
            System.out.println("El " + color + " es un color aceptado");
        }
        
                
    }
    
    // corregir
    public void mostrar(){
        System.out.println(registroViajes.toString());
    }
}
