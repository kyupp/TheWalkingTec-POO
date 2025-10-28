/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.Defensa;
import com.mycompany.thewalkingtec.poo.Componentes.IVolador;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.Zombie;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Point;

/**
 *
 * @author mathiasviquez
 */
public class DefensaAerea extends Defensa implements IVolador{
    private boolean isRunning = true;
    private boolean isPause = false;
    public DefensaAerea() {
    }

    public DefensaAerea(String nombre, int vida, int ataquePorUnidad, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        super(nombre, vida, ataquePorUnidad, campos, nivelDeAparicion, alcance, apariencia);
    }

    public DefensaAerea(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        super(refPantalla, nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeAparicion, alcance, apariencia);
    }

    @Override
    public void buscarObjetivo() {
        // Verifica debajo
        for (Zombie zombie : getRefPantalla().getAtacantes()) {
            if (zombie == null || zombie.estaDestruido()) {
                continue;
            }

            double distancia = getRefLabel().getLocation().distance(zombie.getRefLabel().getLocation());
            if (distancia <= 10) {
                atacarZombie(zombie);
                break;
            }
        }
    }

    @Override
    public void setPause() {
        this.isPause = !this.isPause;
        super.setPause(); // También pausar el padre
    }

    @Override
    public void setStop() {
        this.isRunning = false;
        this.isPause = false;
        super.setStop();
    }

    @Override
    public void run() {
        int paso = 15;
        System.out.println("DefensaAerea " + getNombre() + " iniciada!");

        while (isRunning && !estaDestruido()) {
            try {
                if (isPause|| super.isPause()) {
                    Thread.sleep(200);
                    continue;
                }

                if (estaDestruido()) {
                    break;
                }

                // Buscar zombie más cercano
                Zombie zombieCercano = null;
                double menorDistancia = Double.MAX_VALUE;

                for (Zombie zombie : getRefPantalla().getAtacantes()) {
                    if (zombie == null || zombie.estaDestruido()) {
                        continue;
                    }

                    double distancia = getRefLabel().getLocation().distance(zombie.getRefLabel().getLocation());
                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        zombieCercano = zombie;
                    }
                }

                // Si encuentra un zombie
                if (zombieCercano != null) {
                    Point posActual = getRefLabel().getLocation();
                    Point posZombie = zombieCercano.getRefLabel().getLocation();

                    // Si está en rango, atacar
                    if (menorDistancia <= getAlcance() * 30) {
                        atacarZombie(zombieCercano);
                        Thread.sleep(1000 / Math.max(1, getGolpesPorSegundo()));
                        continue;
                    }

                    // moverse hacia el objetivo
                    int x = posActual.x;
                    int y = posActual.y;

                    if (x < posZombie.x) {
                        x += Math.min(paso, posZombie.x - x);
                    } else if (x > posZombie.x) {
                        x -= Math.min(paso, x - posZombie.x);
                    }

                    if (y < posZombie.y) {
                        y += Math.min(paso, posZombie.y - y);
                    } else if (y > posZombie.y) {
                        y -= Math.min(paso, y - posZombie.y);
                    }
                    
                    x = Math.max(60, Math.min(x, 690)); // 750 - 60 = 690
                    y = Math.max(60, Math.min(y, 690));

                    // Mover defensa aérea
                    final int finalX = x;
                    final int finalY = y;
                    
                    // Usar el helper del frame para actualizar posición y matriz correctamente (se ejecuta en EDT)
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        try {
                            getRefPantalla().moverDefensaAerea(this, finalX, finalY);
                        } catch (Exception ex) {
                            System.out.println("Error moviendo DefensaAerea en EDT: " + ex.getMessage());
                        }
                    });
                    
                    System.out.println(getNombre() + " voló hacia (" + x + ", " + y + ") buscando a " + zombieCercano.getNombre());

                    Thread.sleep(800); // Movimiento más fluido
                } else {
                    // Si no hay zombie, esperar
                    Thread.sleep(200);
                }

            } catch (InterruptedException e) {
                System.out.println(getNombre() + " interrumpida");
                break;
            } catch (Exception e) {
                System.out.println("Error en DefensaAerea: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        System.out.println(getNombre() + " detenida.");
    }

    private void atacarZombie(Zombie zombie) {
        if (zombie == null || zombie.estaDestruido()) {
            return;
        }

        int vidaAntes = zombie.getVida();
        zombie.recibirGolpe(getAtaquePorUnidad(), this);
        int vidaDespues = zombie.getVida();

        registrarAtaque(zombie, getAtaquePorUnidad(), vidaAntes, vidaDespues);
        System.out.println(getNombre() + " atacó desde el aire a " + zombie.getNombre());
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        // Asegura que al clonar vuelva a ser DefensaAerea (no la clase base)
        return new DefensaAerea(
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
}
