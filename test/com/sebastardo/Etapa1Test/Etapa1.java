/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa1Test;

import com.sebastardo.Etapa1.ChevroletCorsa;
import com.sebastardo.Etapa1.Dependencia;
import com.sebastardo.Etapa1.RenaultKwid;
import com.sebastardo.Etapa1.RenaultTrafic;
import com.sebastardo.Etapa1.Rodado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastian
 * 
 * 
 * Armar un test en el que hay que se definen dos dependencias: deportes (45 empleados) y cultura (31 empleados).
 * 
 * En este test debe definirse un rodado al que llamaremos cachito; o sea, definir var cachito = .... Este rodado debe ser un Corsa de color rojo.
 * 
 * La flota de deportes incluye a: cachito, un Corsa azul, un Corsa verde, un Kwid con el tanque adicional puesto; y un auto especial con estas 
 * características: capacidad 5 pasajeros, velocidad máxima 160 km/h, peso 1200 kg, color beige.
 * 
 * Por su parte, cultura cuenta con: cachito; dos Kwid con el tanque adicional puesto; un Kwid más, este sin el tanque adicional; y la Trafic, 
 * configurada con el interior popular y el motor batatón.
 *
 * Notar que cachito forma parte de la flota de ambas dependencias.
 *
 * Para cada dependencia, hacer asserts sobre: el peso total de la flota, si está o no bien equipada, la capacidad total en color azul, el color 
 * del rodado más rápido, si es grande o no, y la capacidad faltante.
 *
 * Va una ayudita: la capacidad faltante de deportes es de 25 personas (la flota puede llevar: 12 personas en los 3 Corsa, más 3 del Kwid y 5 del 
 * auto especial; total 20), mientras que la de cultura es de 5 personas (puede llevar en total 26: 6 de los Kwid con tanque adicional, más 4 de 
 * la Kwid sin tanque, más 4 de cachito, más 12 de la Trafic dado que tiene el interior popular). 
 * 
 */
public class Etapa1 {
        Dependencia deportes;
        Dependencia cultura;
    
    public Etapa1() {
        deportes = new Dependencia(45);
        cultura = new Dependencia(31);
        
        // int capacidad, int velocidad, String color, int peso)
        Rodado cachito = new ChevroletCorsa("rojo");
        /*
         * La flota de deportes incluye a: cachito, un Corsa azul, un Corsa verde, un Kwid con el tanque
         * adicional puesto; y un auto especial con estas características: capacidad 5 pasajeros, velocidad 
         * máxima 160 km/h, peso 1200 kg, color beige.
        */
        
        ChevroletCorsa corsaAzul = new ChevroletCorsa("azul");
        ChevroletCorsa corsaVerde = new ChevroletCorsa("verde");
        RenaultKwid kwidConTanqueAdicional1 = new RenaultKwid(true);
        Rodado autoEspecial = new Rodado(5,160, "beige",1200);
        
        
        deportes.agregarAFlota(cachito); 
        deportes.agregarAFlota(corsaAzul);  
        deportes.agregarAFlota(corsaVerde);
        deportes.agregarAFlota(kwidConTanqueAdicional1); 
        deportes.agregarAFlota(autoEspecial);
        
        
        /*
         * Por su parte, cultura cuenta con: cachito; dos Kwid con el tanque adicional puesto; un Kwid más, 
         * este sin el tanque adicional; y la Trafic, configurada con el interior popular y el motor batatón.
        */
        
        RenaultKwid kwidConTanqueAdicional2 = new RenaultKwid(true);
        RenaultKwid kwidSinTanqueAdicional = new RenaultKwid(false);
        

        
        cultura.agregarAFlota(cachito); // 1300
        cultura.agregarAFlota(kwidConTanqueAdicional2); // 1350
        cultura.agregarAFlota(kwidSinTanqueAdicional); // 1200

        
        RenaultTrafic trafic = new RenaultTrafic();        
        trafic.cambiarPorInteriorPopular(true);
        cultura.agregarAFlota(trafic); // 5500
        
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

    /*
     * Para cada dependencia, hacer asserts sobre: 
     * el peso total de la flota, 
     * si está o no bien equipada, 
     * la capacidad total en color azul, 
     * el color del rodado más rápido, 
     * si es grande o no, 
     * y la capacidad faltante.
    */
    
    @Test
    public void TestPesoTotalDeportes() {
        int resultado = deportes.pesoTotalFlota();
        int esperado = 6450;
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void TestEstaBienEquipadaDeportes(){
        boolean resultado = deportes.estaBienEquipada();
        assertTrue(resultado);
    }
    
    
    @Test
    public void TestCapacidadTotalEnColorDeportes(){
        int resultado = deportes.capacidadTotalEnColor("azul");
        int esperado = 7;
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void TestColorDelRodadoMasRapidoDeportes(){
        String resultado = deportes.colorDelRodadoMasRapido();
        String esperado = "beige";
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void TestEsGrandeDeportes(){
        assertTrue(deportes.esGrande());
    }
    
    @Test
    public void TestCapacidadFaltanteDeportes(){
        int resultado = deportes.capacidadFaltante();
        int esperado = 45-20;
        assertEquals(esperado,resultado);
    }
    
    
    /*
     * Para cada dependencia, hacer asserts sobre: 
     * el peso total de la flota, 
     * si está o no bien equipada, 
     * la capacidad total en color azul, 
     * el color del rodado más rápido, 
     * si es grande o no, 
     * y la capacidad faltante.
    */
    
    
    @Test
    public void TestPesoTotalCultura() {
        int resultado = cultura.pesoTotalFlota();
        int esperado = 9350;
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void TestEstaBienEquipadaCultura(){
        boolean resultado = cultura.estaBienEquipada();
        assertFalse(resultado);
    }
    
    
    @Test
    public void TestCapacidadTotalEnColorCultura(){
        int resultado = cultura.capacidadTotalEnColor("azul");
        int esperado = 7;
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void TestColorDelRodadoMasRapidoCultura(){
        String resultado = cultura.colorDelRodadoMasRapido();
        String esperado = "rojo";
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void TestEsGrandeCultura(){
        assertFalse(cultura.esGrande());
    }
    
    @Test
    public void TestCapacidadFaltanteCultura(){
        int resultado = cultura.capacidadFaltante();
        int esperado = 8;
        assertEquals(esperado,resultado);
    }
}
