/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Terreno;

import com.mycompany.thewalkingtec.poo.Componentes.Tropa;
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
    JPanel pnlTerreno;
    boolean ocupada = false;
    boolean seleccionada = false;
    Color colorActual;
    Color colorOriginal;
    Tropa tropa;

    public Casilla() {
    }
    
    public Casilla(JPanel pnlTerreno, JTextArea txaLog, Point coordenadas, JLabel lblCasilla) {
        this.pnlTerreno = pnlTerreno;
        this.coordenadas = coordenadas;
        this.lblCasilla = lblCasilla;
        this.colorOriginal = lblCasilla.getBackground();
        this.colorActual = lblCasilla.getBackground();
        lblCasilla.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if (!ocupada) {
                            txaLog.append("Se clickeó sobre: X: "
                                + lblCasilla.getLocation().getX() + ",Y: "
                                + lblCasilla.getLocation().getY()+"\n");
                            seleccionar();
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (!ocupada) {
                            lblCasilla.setBackground(new java.awt.Color(66, 66, 245));
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if (!ocupada) {
                            lblCasilla.setBackground(colorActual);
                        }
                    }
                });
    }
    
    public void insertarTropa(JLabel label){
            label.setSize(lblCasilla.getSize()); // mismo tamaño que la casilla
            label.setLocation(lblCasilla.getLocation()); // se alinea exactamente a la casilla
            label.setOpaque(true);

            pnlTerreno.add(label);
            pnlTerreno.setComponentZOrder(label, 0); // poner la tropa encima de la casilla
            pnlTerreno.repaint();

            this.ocupada = true;
            this.tropa = null; // <- Aquí luego será un objeto Tropa real
            System.out.println("Tropa insertada y visible en la casilla.");
    }
    
    public void eliminarTropa(){
        this.ocupada = false;
        System.out.println("Se desocupo la casilla.");
    }
    
    public void seleccionar(){
        if (this.seleccionada == false) {
            colorActual = new java.awt.Color(245, 66, 66);
        }else{
            colorActual = colorOriginal;
        }
        this.seleccionada = !this.seleccionada;
        lblCasilla.setBackground(colorActual);
    }
    
}
