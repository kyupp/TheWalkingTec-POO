/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes;

import com.mycompany.thewalkingtec.poo.Componente;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mathiasviquez
 */
public class Zombie extends Componente{
    
    
    Tropa tipo;

    public Zombie(JLabel refLabel, fPrincipal refPantalla, Tropa tipo, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, ImageIcon apariencia) {
        super( refLabel, refPantalla, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.tipo = tipo;
    }
    
    
}
