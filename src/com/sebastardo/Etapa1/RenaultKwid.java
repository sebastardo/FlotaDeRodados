/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa1;

import com.sebastardo.Etapa1.Rodado;

/**
 *
 * @author Sebastian
 */
public class RenaultKwid extends Rodado{
    /*
    * Varios Renault Kwid que funcionan a gas. Cada uno de ellos puede tener puesto, o no, un tanque adicional.
    * La capacidad de un Kwid es de 4 pasajeros si no tiene puesto el tanque adicional, o 3 pasajeros si sí lo tiene puesto.
    * La velocidad máxima es 120 km/h con, o 110 km/h sin, tanque adicional.
    * El peso es 1200 kg, más 150 kg adicionales si tiene tanque adicional.
    * Todos los autos de este tipo con que cuenta la municipalidad son azules. 
    */
    private boolean tanqueDeGasAdicional;
    
    public RenaultKwid(boolean tanqueDeGasAdicional) {
        super((tanqueDeGasAdicional?3:4), (tanqueDeGasAdicional?120:110), "azul", (tanqueDeGasAdicional?1200+150:1200));
        this.tanqueDeGasAdicional = tanqueDeGasAdicional;
    }
    
}
