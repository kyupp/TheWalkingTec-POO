/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Point;
import static java.lang.Thread.sleep;

/**
 *
 * @author mathiasviquez
 */
public class Defensa extends Componente {

    private int ataquePorUnidad;
    private boolean isRunning = true;
    private boolean isPause = false;
    //boolean isAttacking = false;

    public Defensa() {
    }

    public Defensa( String nombre, int vida, int ataquePorUnidad ,int campos, int nivelDeAparicion, int alcance, String apariencia) {
        super(nombre, vida, campos, nivelDeAparicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
    }
    
    

    public Defensa(fPrincipal refPantalla, String nombre ,int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla, nombre, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
    }

    public int atacar() {
        return ataquePorUnidad;
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        return new Defensa(
                refPantalla,
                super.getNombre(),
                this.getGolpesPorSegundo(), // o el atributo correspondiente de ataquePorUnidad
                this.getVida(),
                this.getGolpesPorSegundo(),
                this.getNivel(),
                this.getCampos(),
                this.getNivelDeAparicion(),
                this.getAlcance(),
                this.getApariencia()
        );
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
                System.out.println("Eject defense");
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
