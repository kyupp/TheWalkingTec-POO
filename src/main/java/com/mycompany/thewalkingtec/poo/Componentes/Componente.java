/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes;

import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Componente extends Thread {

    // 🔹 Atributos principales
    private String nombre;
    private int vidaMaxima;
    private int vida;
    private int golpesPorSegundo;
    private int nivel;
    private int campos;
    private int nivelDeAparicion;
    private int alcance;
    private String apariencia;
    private boolean isRunning = true;
    private boolean isPause = false;

    // 🔹 Referencias a la interfaz
    private JLabel refLabel;
    private fPrincipal refPantalla;

    // 🔹 Constructores
    public Componente() {
    }

    public Componente(String nombre, int vida, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        this.nombre = nombre;
        this.vida = vida;
        this.campos = campos;
        this.nivelDeAparicion = nivelDeAparicion;
        this.alcance = alcance;
        this.apariencia = apariencia;
    }
    
    

    public Componente(fPrincipal refPantalla, String nombre, int vida, int golpesPorSegundo, int nivel,
            int campos, int nivelDeAparicion, int alcance, String apariencia) {
        this.refLabel = null;
        this.refPantalla = refPantalla;
        this.nombre = nombre;
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
            ImageIcon iconoOriginal = new ImageIcon(new ImageIcon(getClass().getResource(apariencia)).getImage().getScaledInstance(refLabel.getWidth(), refLabel.getHeight(), Image.SCALE_DEFAULT));
            refLabel.setIcon(iconoOriginal);
            refLabel.setOpaque(false);
        } catch (Exception e) {
            System.err.println(" Error cargando imagen: " + apariencia);
        }
    }

    public JLabel getRefLabel() {
        return refLabel;
    }

    public void setRefPantalla(fPrincipal refPantalla) {
        this.refPantalla = refPantalla;
    }
    
    

    // 🔹 Getters y setters
    public String getApariencia() {
        return apariencia;
    }

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGolpesPorSegundo() {
        return golpesPorSegundo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getCampos() {
        return campos;
    }

    public int getNivelDeAparicion() {
        return nivelDeAparicion;
    }

    public int getAlcance() {
        return alcance;
    }

    public fPrincipal getRefPantalla() {
        return refPantalla;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

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

    public abstract Componente clonar(fPrincipal refPantalla);

    public void setPause() {
        this.isPause = !this.isPause;
    }

    public void setStop() {
        this.isRunning = false;
        this.isPause = false;
    }
}
