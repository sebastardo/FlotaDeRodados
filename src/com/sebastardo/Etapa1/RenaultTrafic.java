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
 * 
 * Usando un patron de diseño Singleton
 */
public class RenaultTrafic extends Rodado{
    
    
    private static RenaultTrafic comprar;
    
    private boolean interiorComodo;
    private boolean motorPulenta;

    private RenaultTrafic() {
        super(5, 80, "blanco", 5200);
        interiorComodo = true;
        motorPulenta = false;
    }

    public static RenaultTrafic getComprar() {
        if(comprar == null){
            comprar = new RenaultTrafic();
        }
        return comprar;
    }
    
    
    
    
    
    
    public void cambiarPorMotorPulenta(boolean si){
        motorPulenta = si;
        calculoPeso();
        if(si){
            velocidad = 130;
        }else{
            velocidad = 80;
        }
    }
    
    public void cambiarPorInteriorPopular(boolean si){
        interiorComodo = !si;
        calculoPeso();
        if(si){
            capacidad = 12;
        }else{
            capacidad = 5;
        }
    }
    
    private void calculoPeso(){
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
