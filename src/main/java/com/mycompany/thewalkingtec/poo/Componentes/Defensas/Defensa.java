/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.Zombie;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author mathiasviquez
 */
public class Defensa extends Componente {

    private int ataquePorUnidad;
    private boolean isRunning = true;
    private boolean isPause = false;

    public Defensa(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla, nombre, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
        this.ataquePorUnidad = ataquePorUnidad;
    }

    public int atacar() {
        return ataquePorUnidad;
    }

    public Componente clonar(fPrincipal refPantalla) {
        return new Defensa(
                refPantalla,
                super.getNombre(),
                this.getAtaquePorUnidad(),
                this.getVida(),
                this.getGolpesPorSegundo(),
                this.getNivel(),
                this.getCampos(),
                this.getNivelDeAparicion(),
                this.getAlcance(),
                this.getApariencia()
        );
    }

    @Override
    public void run() {
        while (isRunning && !super.estaDestruido()) {
            try {
                if (isPause) {
                    Thread.sleep(200);
                    continue;
                }

                // Buscar zombie más cercano
                Zombie objetivo = null;
                double menorDistancia = Double.MAX_VALUE;

                for (Zombie zombieActual : super.getRefPantalla().getAtacantes()) {
                    if (zombieActual == null) {
                        continue;
                    }
                    if (zombieActual.estaDestruido()) {
                        continue;
                    }

                    double distancia = zombieActual.getRefLabel().getLocation()
                            .distance(super.getRefLabel().getLocation());

                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        objetivo = zombieActual;
                    }
                }

                // Si hay zombie dentro del alcance, atacarlo
                if (objetivo != null && menorDistancia <= (super.getAlcance() * 30)) {
                    int vidaAntes = objetivo.getVida();
                    objetivo.recibirGolpe(this.atacar(), this);  // 
                    int vidaDespues = objetivo.getVida();

                    registrarAtaque(objetivo, this.atacar(), vidaAntes, vidaDespues);

                    System.out.println(getNombre() + " atacó a " + objetivo.getNombre());

                    // Ritmo de ataque controlado
                    Thread.sleep(1000 / Math.max(1, super.getGolpesPorSegundo()));

                } else {
                    // Si no hay enemigos cerca, espera un poco
                    Thread.sleep(300);
                }

            } catch (InterruptedException e) {
                System.out.println(getNombre() + " interrumpida.");
            }
        }

        // Si la defensa muere, detener su ejecución
        setStop();
    }
    
    //Setters y Getters
    public void setPause() {
        this.isPause = !this.isPause;
    }

    public void setStop() {
        this.isRunning = false;
        this.isPause = false;
    }

    public boolean isPause() {
        return isPause;
    }

    public int getAtaquePorUnidad() {
        return ataquePorUnidad;
    }

}
