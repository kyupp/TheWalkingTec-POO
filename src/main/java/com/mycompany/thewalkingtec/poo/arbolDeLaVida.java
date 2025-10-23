/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mathiasviquez
 */
public class arbolDeLaVida extends Componente{
    
    private JLabel refLabel;
    private fPrincipal refPantalla;
    int vida = 1;
    
    public arbolDeLaVida(fPrincipal refPantalla, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void morir(){
        refLabel.setBackground(Color.black);
        this.refLabel.setForeground(Color.white);
        this.refLabel.setText("R.I.P");
    }
    
    
}
