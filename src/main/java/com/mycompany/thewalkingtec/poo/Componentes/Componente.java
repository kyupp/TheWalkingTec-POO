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
public class Componente extends Thread{
    
    private int vidaMaxima;
    private int vida;
    private int golpesPorSegundo;
    private int nivel;
    private int campos;
    private int nivelDeApaicion;
    private int alcance;
    private String apariencia;
    private JLabel refLabel;
    private fPrincipal refPantalla;

    public Componente() {
    }

    public Componente(fPrincipal refPantalla, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        this.refLabel = null;
        this.refPantalla = refPantalla;
        this.vida = vida;
        this.golpesPorSegundo = golpesPorSegundo;
        this.nivel = nivel;
        this.campos = campos;
        this.nivelDeApaicion = nivelDeApaicion;
        this.alcance = alcance;
        this.apariencia = apariencia;
        this.vidaMaxima = vida;
        
    }

       public JLabel getRefLabel() {
        return refLabel;
    }

    public void setRefLabel(JLabel refLabel) {
        this.refLabel = refLabel;
        // Cargar imagen del árbol y asignarla al label
         ImageIcon iconoOriginal = new ImageIcon(new ImageIcon(getClass().getResource(apariencia)).getImage().getScaledInstance(refLabel.getWidth(), refLabel.getHeight(), 0));
         refLabel.setOpaque(false);
         refLabel.setIcon(iconoOriginal);
         refLabel.repaint();
    }   

    public String getApariencia() {
        return apariencia;
    }
    
    public int getVida() {
        return vida;
    }

    public int getGolpesPorSegundo() {
        return golpesPorSegundo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getCampos() {
        return campos;
    }

    public int getNivelDeApaicion() {
        return nivelDeApaicion;
    }

    public int getAlcance() {
        return alcance;
    }
    
    public void subirNivel(){
        this.nivel++;
    }
    
    public void recibirGolpe(int golpe){
        
        if (this.vida >= golpe){
            
            this.vida = this.vida - golpe;
            
        }else if (this.vida < golpe && this.vida > 0){
            
            this.vida = 0;
        }
    }
    
    public void resetearVida(){
        this.vida = this.vidaMaxima;
    }
    
    
    
}
