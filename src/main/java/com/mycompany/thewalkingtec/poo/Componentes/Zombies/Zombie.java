/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.Defensa;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Point;
import static java.lang.Thread.sleep;

/**
 *
 * @author mathiasviquez
 */
public abstract class Zombie extends Componente {

    private int ataquePorUnidad;
    private int velocidad;
    private boolean volador;
    private boolean isRunning = true;
    private boolean isPause = false;

    public Zombie(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo,
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

    public void setAtaquePorUnidad(int ataquePorUnidad) {
        this.ataquePorUnidad = ataquePorUnidad;
    }

    public boolean isVolador() {
        return volador;
    }

    public int atacar() {
        return ataquePorUnidad;
    }

    @Override
    public void run() {
        int paso = 10; // píxeles que avanza

        while (isRunning && !this.estaDestruido()) {
            {
                try {
                    if (isPause) {
                        Thread.sleep(200);
                        continue;
                    }

                    // Si el zombie muere, detener el hilo
                    if (super.estaDestruido()) {
                        setStop();
                        break;
                    }

                    //  Buscar defensa más cercana
                    Defensa defensaCercana = null;
                    double menorDistancia = Double.MAX_VALUE;

                    for (Defensa defensaActual : super.getRefPantalla().getEjercito()) {
                        if (defensaActual == null) {
                            continue;
                        }
                        if (defensaActual.estaDestruido()) {
                            continue;
                        }

                        double distancia = super.getRefLabel().getLocation()
                                .distance(defensaActual.getRefLabel().getLocation());

                        if (distancia < menorDistancia) {
                            menorDistancia = distancia;
                            defensaCercana = defensaActual;
                        }
                    }

                    //  Si hay defensa cerca y está dentro del alcance, atacarla
                    if (defensaCercana != null && menorDistancia <= super.getAlcance() * 30) {
                        defensaCercana.recibirGolpe(this.getAtaquePorUnidad(), this);
                        System.out.println(getNombre() + " atacó a " + defensaCercana.getNombre());
                        Thread.sleep(super.getGolpesPorSegundo() * 1000);

                        // Si la defensa murió, dejar de atacarla y continuar caminando
                        if (defensaCercana.estaDestruido()) {
                            defensaCercana = null;
                        }

                        continue; // no moverse mientras ataca
                    }

                    //  Si no hay defensa cerca, moverse hacia la reliquia
                    Point objetivo = super.getRefPantalla().getObjetivoLocation();
                    Point actual = super.getRefLabel().getLocation();

                    int x = actual.x;
                    int y = actual.y;

                    if (x < objetivo.x) {
                        x += paso;
                    } else if (x > objetivo.x) {
                        x -= paso;
                    }

                    if (y < objetivo.y) {
                        y += paso;
                    } else if (y > objetivo.y) {
                        y -= paso;
                    }

                    // Mover zombie en el terreno
                    super.getRefPantalla().moverZombie(super.getRefLabel(), x, y);
                    System.out.println(getNombre() + " se mueve hacia (" + x + ", " + y + ")");


                    // Verificar si ya está cerca de la reliquia
                    double distanciaReliquia = actual.distance(objetivo);
                    if (distanciaReliquia <= super.getAlcance() * 30) {
                        super.getRefPantalla().getObjetivo().recibirGolpe(this.getAtaquePorUnidad(), this);
                        System.out.println(getNombre() + " atacó la reliquia");
                        Thread.sleep(super.getGolpesPorSegundo() * 1000);
                        continue;
                    }

                    // Delay del movimiento (según velocidad del zombie)
                    int delay = 1500 / Math.max(1, velocidad + 1);
                    Thread.sleep(delay);

                } catch (InterruptedException e) {
                    System.out.println("Zombie interrumpido");
                }
            }
        }
    }

    @Override
    public abstract Componente clonar(fPrincipal refPantalla);

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

}
