/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.IVolador;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author kyup
 */
public class ZombieAereo extends Zombie implements IVolador{

    public ZombieAereo(fPrincipal refPantalla, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeAparicion, int alcance, String apariencia, int velocidad, boolean volador) {
        super(refPantalla, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeAparicion, alcance, apariencia, velocidad, volador);
    }

    @Override
    public void volar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void buscarObjetivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
