/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa3;

import com.sebastardo.Etapa1.Rodado;
import com.sebastardo.Etapa2.Pedido;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Sebastian
 * 
 * Agregar a cada dependencia un registro de los pedidos que hace. Se pueden agregar y quitar pedidos.
 *
 * Agregar lo que haga falta al modelo para que se pueda conocer, para una dependencia:
 *
 *    el total de pasajeros en los pedidos que tiene registrados
 *    cuáles de los pedidos que tiene registrados no puede ser satisfecho por ninguno de los autos afectados a la dependencia.
 *    dado un color, si es cierto que todos los pedidos registrados lo tienen como color incompatible.
 *
 * También debe ser posible, enviando un mensaje al objeto que representa a una dependencia, relajar todos los pedidos que tenga registrados.
 * 
 * 
 */
public class Registro {
    Hashtable<Integer, Pedido> registroPedidos;
    Hashtable<Integer, List<Rodado>> registroAutosParaPedidos;
    private int numeroPedido;

    public Registro(){
        registroPedidos = new Hashtable<Integer, Pedido>();
        registroAutosParaPedidos = new Hashtable<Integer, List<Rodado>>();
        numeroPedido = 0;
    }
    
    public void agregar(Pedido pedido, List<Rodado> autos){
        registroPedidos.put(numeroPedido, pedido);
        registroAutosParaPedidos.put(numeroPedido, autos.stream().filter(a->pedido.autoSatisfactorio(a)).collect(Collectors.toList()));
        numeroPedido++;
    }
    
    
    // TODO: total de pasajeros en lños pedidos
    
    
    // TODO: pedidos sin autos
    
 
    // TODO: dado 1 color, ver si ningun pedido lo quiere
    
    
    // TODO: borrar todos los pedidos
    
    
    
    // TODO: Corregir
    @Override
    public String toString(){
        return registroPedidos.get(0).toString() + "\n\t" + registroAutosParaPedidos.get(0).toString();
    }
}
