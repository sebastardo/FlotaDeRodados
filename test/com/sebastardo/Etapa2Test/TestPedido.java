/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa2Test;

import com.sebastardo.Etapa1.ChevroletCorsa;
import com.sebastardo.Etapa1.Rodado;
import com.sebastardo.Etapa2.Pedido;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastian
 */
public class TestPedido {
    
    public TestPedido() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testautoSatisfactorioOK() {
        
        //P.ej. consideremos al auto al que llamamos cachito en el test de la etapa 1 (recordemos: capacidad 4 pasajeros, velocidad máxima 150 km/h, color rojo).
        Rodado cachito = new ChevroletCorsa("rojo");
        
        //este auto puede satisfacer un pedido de 960 kms con tiempo máximo de 8 horas 
        // (lo que da una velocidad requerida de 120 km/h), para 4 pasajeros donde 
        // los colores incompatibles son azul y negro.
        
        
        // int distanciaARecorrer, int tiempoMaximo, int cantidadPasajeros, Set<String> coloresIncompatibles
        
        Pedido p = new Pedido(960,8,4,new HashSet<String>(Arrays.asList("azul","negro")));
        
        assertTrue(p.autoSatisfactorio(cachito));
    }
    
    @Test
    public void testautoSatisfactorioNoOK1() {
        //si cambiamos la cantidad de pasajeros a 6, entonces cachito ya no puede satisfacer el pedido.
        // lo mismo si cambiamos el tiempo máximo a 6 horas, porque eso nos daría una velocidad requerida de 160 km/h. 
        
        Rodado cachito = new ChevroletCorsa("rojo");
        Pedido p = new Pedido(960,8,6,new HashSet<String>(Arrays.asList("azul","negro")));
        assertFalse(p.autoSatisfactorio(cachito));
    }
    
    @Test
    public void testautoSatisfactorioNoOK2() {
        //si agregamos el rojo a los colores incompatibles
        
        Rodado cachito = new ChevroletCorsa("rojo");
        Pedido p = new Pedido(960,8,4,new HashSet<String>(Arrays.asList("azul","negro","rojo")));
        assertFalse(p.autoSatisfactorio(cachito));
    }
    
    
    @Test
    public void testautoSatisfactorioNoOK3() {
        // si cambiamos el tiempo máximo a 6 horas, porque eso nos daría una velocidad requerida de 160 km/h. 
        
        Rodado cachito = new ChevroletCorsa("rojo");
        Pedido p = new Pedido(960,6,4,new HashSet<String>(Arrays.asList("azul","negro")));
        assertFalse(p.autoSatisfactorio(cachito));
    }
}
