/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import javax.swing.ImageIcon;

/**
 *
 * @author mathiasviquez
 */
public class impacto extends Contacto{
    
    int areaDeAfecto;
    
    public impacto(int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, ImageIcon apariencia,int areaDeAfecto) {
        super(ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.areaDeAfecto = areaDeAfecto;
    }
    
}


