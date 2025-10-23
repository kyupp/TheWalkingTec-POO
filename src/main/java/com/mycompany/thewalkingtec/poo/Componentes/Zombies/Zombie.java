/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.Defensa;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mathiasviquez
 */
public abstract class Zombie extends Componente{
    
    
    private int ataquePorUnidad;
    private int velocidad;
    private boolean volador;

    public Zombie(fPrincipal refPantalla, int ataquePorUnidad, int vida, int golpesPorSegundo, 
                  int nivel, int campos, int nivelDeAparicion, int alcance, 
                  String apariencia, int velocidad, boolean volador) {

        super(refPantalla, vida, golpesPorSegundo, nivel, campos, nivelDeAparicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
        this.velocidad = velocidad;
        this.volador = volador;
    }

    public int getAtaquePorUnidad() {
        return ataquePorUnidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean isVolador() {
        return volador;
    }

    public void mover() {
        // comportamiento genérico de movimiento
    }

    public int atacar() {
        return ataquePorUnidad;
    }
}

