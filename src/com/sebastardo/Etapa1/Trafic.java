/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa1;

/**
 *
 * @author Sebastian
 *  
    Una Trafic (sí, una sola), que es reconfigurable, porque se le puede cambiar el interior y el motor.
 
    La municipalidad cuenta con dos interiores, uno cómodo (capacidad 5 pasajeros, peso 700 kg) y otro popular (capacidad 12 pasajeros, peso 1000 kg). 
        La municipalidad tiene un solo interior de cada tipo.
    También ha comprado dos motores para su Trafic, uno pulenta (que pesa 800 kg y permite una velocidad máxima de 130 km/h) y otro batatón (
        que pesa 500 kg y permite una velocidad máxima de 80 km/h). La municipalidad tiene un solo motor de cada tipo.
    Varias características de la Trafic dependen de qué interior y qué motor le hayan puesto:
        La capacidad de la Trafic es la del interior.
        La velocidad máxima es la que permite el motor.
        El peso es 4000 kg más el peso del interior más el del motor.
    Finalmente, digamos que la Trafic es de color blanco, independientemente del interior y el motor que tenga puestos.
*/

public class Trafic {
    private static int capacidad = 5;
    private static int velocidad = 80;
    private static String color = "blanco";
    private static int peso = 5200;
    
    private static boolean interiorComodo = true;
    private static boolean motorPulenta = false;

    public static int getCapacidad() {
        return capacidad;
    }

    public static int getVelocidad() {
        return velocidad;
    }

    public static String getColor() {
        return color;
    }

    public static int getPeso() {
        return peso;
    }    
    
    public static void cambiarPorMotorPulenta(boolean si){
        motorPulenta = si;
        calculoPeso();
        if(si){
            velocidad = 130;
        }else{
            velocidad = 80;
        }
    }
    
    public static void cambiarPorInteriorPopular(boolean si){
        interiorComodo = !si;
        calculoPeso();
        if(si){
            capacidad = 12;
        }else{
            capacidad = 5;
        }
    }
    
    private static void calculoPeso(){
        peso = 4000;
        if(motorPulenta){
            peso += 800;
        } else {
            peso += 500;
        }
        if(interiorComodo){
            peso += 700;
        } else {
            peso += 1000;
        }
    }

}