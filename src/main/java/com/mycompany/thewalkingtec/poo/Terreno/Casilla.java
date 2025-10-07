/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Terreno;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author kyup
 */
public class Casilla {
    Point coordenadas;
    JLabel lblCasilla;
    boolean ocupada = false;
    boolean seleccionada = false;
    Color colorActual = new java.awt.Color(66, 245, 66);

    public Casilla() {
    }
    
    public Casilla(JPanel pnlTerreno, JTextArea txaLog, Point coordenadas, JLabel lblCasilla) {
        this.coordenadas = coordenadas;
        this.lblCasilla = lblCasilla;
        
        lblCasilla.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        JOptionPane.showMessageDialog(pnlTerreno, ("Label Clicked" + lblCasilla.getLocation().getX() + ", " + lblCasilla.getLocation().getY()));
                        txaLog.append("Se clickeó sobre: X: " + lblCasilla.getLocation().getX() + ",Y: " + lblCasilla.getLocation().getY()+"\n");
                        seleccionar();
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        lblCasilla.setBackground(new java.awt.Color(66, 66, 245));
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent e) {
                        lblCasilla.setBackground(colorActual);
                    }
                
                });
    }
    
    public void insertarTropa(){
        this.ocupada = true;
        System.out.println("Tropa insertada, casilla ocupada."); 
    }
    
    public void eliminarTropa(){
        this.ocupada = false;
        System.out.println("Se desocupo la casilla.");
    }
    
    public void seleccionar(){
        if (this.seleccionada == false) {
            colorActual = new java.awt.Color(245, 66, 66);
        }else{
            colorActual = new java.awt.Color(66, 245, 66);
        }
        this.seleccionada = !this.seleccionada;
        lblCasilla.setBackground(colorActual);
    }
    
}
