/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa2;

import com.sebastardo.Etapa1.Rodado;
import java.util.Set;

/**
 *
 * @author Sebastian
 * 
 *
 * Agregar al modelo los pedidos de translados que se generan en la municipalidad.
 * Cada pedido especifica: la distancia a recorrer (expresada en kilómetros), el tiempo máximo en que se puede hacer el viaje (expresado en horas), 
 * la cantidad de pasajeros a transportar, y también un conjunto de colores incompatibles, o sea, que los pasajeros rechazan hacer el viaje en autos de esos colores.

 * La velocidad requerida de un pedido es el resultado de dividir la cantidad de kilómetros por el tiempo máximo. 
 * P.ej. si para un pedido de un viaje de 480 kilómetros se indica como tiempo máximo 6 horas, entonces la velocidad 
 * requerida de este pedido es de 80 kms/hora (480 / 6 = 80).
 * 
 * Agregar la capacidad de preguntar si un auto puede satisfacer un pedido, enviándole un mensaje al viaje con el auto como parámetro.
 * 
 * Para que un auto pueda satisfacer un pedido se tienen que dar tres condiciones:
 * 
 *  que la velocidad máxima del auto sea al menos 10 km/h mayor a la velocidad requerida del pedido;
 *  que la capacidad del auto dé para la cantidad de pasajeros del viaje; y
 *  que el auto no sea de un color incompatible para el viaje.
 * 
 * P.ej. consideremos al auto al que llamamos cachito en el test de la etapa 1 (recordemos: capacidad 4 pasajeros, velocidad máxima 150 km/h, color rojo).
 * 
 *  este auto puede satisfacer un pedido de 960 kms con tiempo máximo de 8 horas (lo que da una velocidad requerida de 120 km/h), para 4 pasajeros donde 
 *      los colores incompatibles son azul y negro.
 *  si agregamos el rojo a los colores incompatibles, o cambiamos la cantidad de pasajeros a 6, entonces cachito ya no puede satisfacer el pedido.
 *  lo mismo si cambiamos el tiempo máximo a 6 horas, porque eso nos daría una velocidad requerida de 160 km/h.
 * 
 */
public class Pedido {
    private int distanciaARecorrer;
    private int tiempoMaximo;
    private int cantidadPasajeros;
    private Set<String> coloresIncompatibles;

    public Pedido(int distanciaARecorrer, int tiempoMaximo, int cantidadPasajeros, Set<String> coloresIncompatibles) {
        this.distanciaARecorrer = distanciaARecorrer;
        this.tiempoMaximo = tiempoMaximo;
        this.cantidadPasajeros = cantidadPasajeros;
        this.coloresIncompatibles = coloresIncompatibles;
    }

    public boolean autoSatisfactorio(Rodado auto){
        if(distanciaARecorrer/tiempoMaximo + 10 > auto.getVelocidad())
            return false;
        if(cantidadPasajeros > auto.getCapacidad())
            return false;
        if(coloresIncompatibles.stream().anyMatch(c->c.equals(auto.getColor())))
            return false;
        
        return true;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public Set<String> getColoresIncompatibles() {
        return coloresIncompatibles;
    }
   

    @Override
    public String toString() {
        return "Pedido{" + "distanciaARecorrer=" + distanciaARecorrer + ", tiempoMaximo=" + tiempoMaximo + ", cantidadPasajeros=" + cantidadPasajeros + ", coloresIncompatibles=" + coloresIncompatibles + '}';
    }

    
}
