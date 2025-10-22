/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import com.mycompany.thewalkingtec.poo.Componente;
import javax.swing.ImageIcon;

/**
 *
 * @author mathiasviquez
 */
public class Arma extends Componente{
    
    Tropa tipo;

    public Arma(Tropa tipo, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, ImageIcon apariencia) {
        super(vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.tipo = tipo;
    }
    
    
}
