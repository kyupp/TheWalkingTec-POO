package com.mycompany.thewalkingtec.poo.Terreno;
import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Casilla {

    private Point coordenadas;       // Coordenadas absolutas (en píxeles)
    private JLabel lblCasilla;       // El label visual que representa la casilla
    private JPanel pnlTerreno;       // Referencia al panel principal
    private boolean ocupada = false;
    private boolean seleccionada = false;
    private Color colorActual;
    private Color colorOriginal;
    private Componente tropa;        // Defensa o zombie asignado a la casilla

    // Constructor vacío
    public Casilla() {}

    // Constructor principal
    public Casilla(JPanel pnlTerreno, JTextArea txaLog, Point coordenadas, JLabel lblCasilla) {
        this.pnlTerreno = pnlTerreno;
        this.coordenadas = coordenadas;
        this.lblCasilla = lblCasilla;
        this.colorOriginal = lblCasilla.getBackground();
        this.colorActual = lblCasilla.getBackground();

        // Listener para interacción visual (hover y click)
        lblCasilla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!ocupada) {
                    txaLog.append("Se clickeó sobre: X: "
                            + lblCasilla.getLocation().getX() + ", Y: "
                            + lblCasilla.getLocation().getY() + "\n");
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

    public Point getPosicion() {
        return this.coordenadas;
    }

    public void setPosicion(Point coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public void insertarTropa(Componente tropa) {
        JLabel label = tropa.getRefLabel();
        label.setSize(lblCasilla.getSize()); // mismo tamaño que la casilla
        label.setLocation(lblCasilla.getLocation()); // se alinea exactamente a la casilla
        label.setOpaque(true);
        
        pnlTerreno.add(label);
        pnlTerreno.setComponentZOrder(label, 0); // poner la tropa encima de la casilla
        pnlTerreno.repaint();

        this.ocupada = true;
        this.tropa = tropa;
        System.out.println("Tropa insertada y visible en la casilla.");
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void eliminarTropa() {
        this.ocupada = false;
        this.tropa = null;
        System.out.println("Se desocupó la casilla.");
    }

    public void seleccionar() {
        if (!this.seleccionada) {
            colorActual = new java.awt.Color(245, 66, 66);
        } else {
            colorActual = colorOriginal;
        }
        this.seleccionada = !this.seleccionada;
        lblCasilla.setBackground(colorActual);
    }

    public Componente getTropa() {
        return this.tropa;
    }

    public JLabel getLblCasilla() {
        return lblCasilla;
    }
}