/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author mathiasviquez
 */
public class Defensa extends Componente {
    
    private int ataquePorUnidad;
    //boolean isAttacking = false;

    public Defensa(fPrincipal refPantalla, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
    }
    
    public int atacar(){
        return ataquePorUnidad;
    }
}
