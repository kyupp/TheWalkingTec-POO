/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo;

import javax.swing.ImageIcon;

/**
 *
 * @author mathiasviquez
 */
public class Componente extends Thread{
    
    int vidaMaxima;
    
    int vida;
    int golpesPorSegundo;
    int nivel;
    int campos;
    int nivelDeApaicion;
    int alcance;
    ImageIcon apariencia;

    public Componente() {
    }

    public Componente(int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, ImageIcon apariencia) {
        this.vida = vida;
        this.golpesPorSegundo = golpesPorSegundo;
        this.nivel = nivel;
        this.campos = campos;
        this.nivelDeApaicion = nivelDeApaicion;
        this.alcance = alcance;
        this.apariencia = apariencia;
        
        this.vidaMaxima = vida;
        
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
