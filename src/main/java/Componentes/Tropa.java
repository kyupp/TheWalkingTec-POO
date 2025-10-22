/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import com.mycompany.thewalkingtec.poo.Componente;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mathiasviquez
 */
public class Tropa extends Componente {
    
    private int ataquePorUnidad;
    //boolean isAttacking = false;

    public Tropa(JLabel refLabel, fPrincipal refPantalla, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, ImageIcon apariencia) {
        super(refLabel, refPantalla, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
    }
    
    public int atacar(){
        return ataquePorUnidad;
    }

    
    
    
    
}
