/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.Componentes.Defensas.Defensa;
import com.mycompany.thewalkingtec.poo.Componentes.IVolador;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.Zombie;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author mathiasviquez
 */
public class DefensaAerea extends Defensa implements IVolador{
    
    public DefensaAerea(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        super(refPantalla, nombre,ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeAparicion, alcance, apariencia);
    }

    @Override
    public void buscarObjetivo() {
        // Verifica debajo
        for (Zombie zombie : getRefPantalla().getAtacantes()) {
            if (zombie == null || zombie.estaDestruido()) continue;

            double distancia = getRefLabel().getLocation().distance(zombie.getRefLabel().getLocation());
            if (distancia <= 10) { // Por si esta debajo, pero no exacto
                atacarZombie(zombie);
                break;
            }
        }
    }

    private void atacarZombie(Zombie z) {
        int vidaAntes = z.getVida();
        z.recibirGolpe(getAtaquePorUnidad(), this);
        int vidaDespues = z.getVida();

        registrarAtaque(z, getAtaquePorUnidad(), vidaAntes, vidaDespues);
        System.out.println(getNombre() + " atacó desde el aire a " + z.getNombre());
    }

    @Override
    public void run() {
        while (!estaDestruido()) {
            try {
                if (isPause()) {
                    Thread.sleep(200);
                    continue;
                }

                buscarObjetivo(); // revisa si hay zombies debajo

                Thread.sleep(500 / Math.max(1, getGolpesPorSegundo()));

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
