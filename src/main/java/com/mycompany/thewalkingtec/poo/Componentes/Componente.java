/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes;

import com.mycompany.thewalkingtec.poo.fPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;

public abstract class Componente extends Thread {

    // 🔹 Atributos principales
    private int vidaMaxima;
    private int vida;
    private int golpesPorSegundo;
    private int nivel;
    private int campos;
    private int nivelDeAparicion;
    private int alcance;
    private String apariencia;

    // 🔹 Referencias a la interfaz
    private JLabel refLabel;
    private fPrincipal refPantalla;

    // 🔹 Constructores
    public Componente() {
    }

    public Componente(fPrincipal refPantalla, int vida, int golpesPorSegundo, int nivel, 
                      int campos, int nivelDeAparicion, int alcance, String apariencia) {
        this.refLabel = null;
        this.refPantalla = refPantalla;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.golpesPorSegundo = golpesPorSegundo;
        this.nivel = nivel;
        this.campos = campos;
        this.nivelDeAparicion = nivelDeAparicion;
        this.alcance = alcance;
        this.apariencia = apariencia;
    }

    // 🔹 Métodos de imagen y UI
    public void setRefLabel(JLabel refLabel) {
        this.refLabel = refLabel;
        try {
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(apariencia));
            Image imagenEscalada = iconoOriginal.getImage()
                    .getScaledInstance(refLabel.getWidth(), refLabel.getHeight(), Image.SCALE_SMOOTH);
            refLabel.setOpaque(false);
            refLabel.setIcon(new ImageIcon(imagenEscalada));
            refLabel.repaint();
        } catch (Exception e) {
            System.err.println("⚠️ Error cargando imagen: " + apariencia);
        }
    }

    public JLabel getRefLabel() {
        return refLabel;
    }

    // 🔹 Getters y setters
    public String getApariencia() { return apariencia; }
    public int getVida() { return vida; }
    public int getGolpesPorSegundo() { return golpesPorSegundo; }
    public int getNivel() { return nivel; }
    public int getCampos() { return campos; }
    public int getNivelDeAparicion() { return nivelDeAparicion; }
    public int getAlcance() { return alcance; }
    public fPrincipal getRefPantalla() { return refPantalla; }

    public void setVida(int vida) { this.vida = vida; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public void subirNivel() {
        this.nivel++;
        // Mejoras
    }

    public void recibirGolpe(int golpe) {
        this.vida = Math.max(this.vida - golpe, 0);
    }

    public void resetearVida() {
        this.vida = this.vidaMaxima;
    }

    public boolean estaDestruido() {
        return this.vida <= 0;
    }
}
