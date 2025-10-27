/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author mathiasviquez
 */
public class DefensaContacto extends Defensa{

    public DefensaContacto() {
    }

    public DefensaContacto(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla, nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
    }

}
