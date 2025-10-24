/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author kyup
 */
public class ZombieChoque extends Zombie {

    private int radioExplosion;

    public ZombieChoque(fPrincipal refPantalla, int ataquePorUnidad, int vida, int golpesPorSegundo,
                        int nivel, int campos, int nivelDeAparicion, int alcance, 
                        String apariencia, int velocidad, int radioExplosion) {

        super(refPantalla, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, 
              nivelDeAparicion, alcance, apariencia, velocidad, false);
        this.radioExplosion = radioExplosion;
    }

    @Override
    public void mover() {
        // busca objetivo y al colisionar se destruye
    }

    public void explotar() {
        // aplicar daño en el radio de explosión
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
