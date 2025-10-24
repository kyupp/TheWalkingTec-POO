/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.Defensa;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import javax.swing.JLabel;

/**
 *
 * @author kyup
 */
public class ZombieContacto extends Zombie {

    public ZombieContacto(fPrincipal refPantalla, String nombre ,int ataquePorUnidad, int vida, int golpesPorSegundo,
                          int nivel, int campos, int nivelDeAparicion, int alcance, 
                          String apariencia, int velocidad) {

        super(refPantalla, nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, 
              nivelDeAparicion, alcance, apariencia, velocidad, false);
    }

    @Override
    public void mover() {
        // lógica para moverse hacia una defensa
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}