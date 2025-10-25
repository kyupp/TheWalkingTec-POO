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

    public Defensa() {
    }

    public Defensa(fPrincipal refPantalla, String nombre ,int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla, nombre, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
    }

    public int atacar() {
        return ataquePorUnidad;
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        return new Defensa(
                refPantalla,
                super.getNombre(),
                this.getGolpesPorSegundo(), // o el atributo correspondiente de ataquePorUnidad
                this.getVida(),
                this.getGolpesPorSegundo(),
                this.getNivel(),
                this.getCampos(),
                this.getNivelDeAparicion(),
                this.getAlcance(),
                this.getApariencia()
        );
    }
}
