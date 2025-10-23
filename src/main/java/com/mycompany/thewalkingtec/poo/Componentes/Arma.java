/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes;

import com.mycompany.thewalkingtec.poo.fPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mathiasviquez
 */
public class Arma extends Tropa{
    
    Tropa tipo;

    public Arma(fPrincipal refPantalla, Tropa tipo, int golpesPorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla, golpesPorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.tipo = tipo;
    }
    
    
}
