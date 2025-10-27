/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author kyup
 */
public class DefensaBloque extends Defensa {

    public DefensaBloque() {
    }

    public DefensaBloque(String nombre, int vida, int campos, int nivelDeAparicion) {
        super(nombre, vida, 0, campos, nivelDeAparicion, 0);
    }
    
    public DefensaBloque(fPrincipal refPantalla,String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla,  nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
    }
    
}
