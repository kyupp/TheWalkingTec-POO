/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Point;
import static java.lang.Thread.sleep;

/**
 *
 * @author mathiasviquez
 */
public abstract class Zombie extends Componente{
    
    
    private int ataquePorUnidad;
    private int velocidad;
    private boolean volador;
    private boolean isRunning = true;
    private boolean isPause = false;

    public Zombie() {
    }

    public Zombie(String nombre, int vida, int ataquePorUnidad ,int campos, int nivelDeAparicion, int alcance, int velocidad, boolean volador, String apariencia) {
        super(nombre, vida, campos, nivelDeAparicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
        this.velocidad = velocidad;
        this.volador = volador;
    }

    public Zombie(fPrincipal refPantalla,String nombre,  int ataquePorUnidad, int vida, int golpesPorSegundo, 
                  int nivel, int campos, int nivelDeAparicion, int alcance, 
                  String apariencia, int velocidad, boolean volador) {

        super(refPantalla, nombre, vida, golpesPorSegundo, nivel, campos, nivelDeAparicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
        this.velocidad = velocidad;
        this.volador = volador;
    }

    public int getAtaquePorUnidad() {
        return ataquePorUnidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean isVolador() {
        return volador;
    }

    public void mover() {
        // comportamiento genérico de movimiento
    }

    public int atacar() {
        return ataquePorUnidad;
    }
    
    public void run() {

        while (isRunning) {
            try {
                //1. Esperar velocidad milisegundos
                sleep(1000);
                //2. Mover el label aleatoriamente: Determinar la posición: donde está el objetivo para determinar a donde debo ir
                Point puntoObjetivo = super.getRefPantalla().getObjetivoLocation();
                Point puntoActual = super.getRefLabel().getLocation();
                int x = puntoActual.x;
                int y = puntoActual.y;
                //Desplaza a la derecha       
                if (x < puntoObjetivo.x) {
                    x += 20;
                    //Desplaza a la izquierda  
                } else if (x > puntoObjetivo.x) {
                    x -= 20;
                }

                //Desplaza para abajo  
                if (y < puntoObjetivo.y) {
                    y += 20;
                    //Desplaza para arriba 
                } else if (y > puntoObjetivo.y) {
                    y -= 20;
                }

                //4. Atacar TODO: Ataquen por proximidad, también que reciban ataque por proximidad
                //atacar(refPantalla.getObjetivo());
                super.getRefPantalla().moverZombie(super.getRefLabel(), x, y);
                System.out.println("Eject");
                while (isPause) {
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        //System.getLogger(Soldado.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
            } catch (InterruptedException ex) {
                System.getLogger(Componente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
        
    public void setPause() {
        this.isPause = !this.isPause;
    }

    public void setStop() {
        this.isRunning = false;
        this.isPause = false;
    }
    
    public boolean isPause(){
        return isPause;
    }
    
}

