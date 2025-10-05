/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Terreno;

import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author kyup
 */
public class Casilla {
    Point coordenadas;
    JLabel lblCasilla;
    boolean ocupada = false;

    public Casilla(Point coordenadas, JLabel lblCasilla) {
        this.coordenadas = coordenadas;
        this.lblCasilla = lblCasilla;
    }
    
    public void insertarTropa(){
        this.ocupada = true;
        System.out.println("Tropa insertada, casilla ocupada."); 
    }
    
    public void eliminarTropa(){
        this.ocupada = false;
        System.out.println("Se desocupo la casilla.");
    }
    
}
