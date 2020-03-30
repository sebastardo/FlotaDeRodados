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
 * Intento de hacer la trafic estatica, no se puede poner en la lista, no sirvio para el ejercicio
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