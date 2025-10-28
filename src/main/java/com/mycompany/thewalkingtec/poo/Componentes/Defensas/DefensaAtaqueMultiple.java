/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.Componentes.Zombies.Zombie;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author mathiasviquez
 */
public class DefensaAtaqueMultiple extends DefensaMedioAlcance{
    private int cantidadAtaques = 3;

    public DefensaAtaqueMultiple() {
    }

    public DefensaAtaqueMultiple(String nombre, int vida, int ataquePorUnidad, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        super(nombre, vida, ataquePorUnidad, campos, nivelDeAparicion, alcance, apariencia);
    }
    
    public DefensaAtaqueMultiple(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        super(refPantalla, nombre ,ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeAparicion, alcance, apariencia);
    }
    
    @Override
    public void run() {
        while (!estaDestruido()) {
            try {
                if (isPause()) { Thread.sleep(200); continue; }

                int atacados = 0;
                for (Zombie zombie : getRefPantalla().getAtacantes()) {
                    if (zombie == null || zombie.estaDestruido()) continue;

                    double distancia = getRefLabel().getLocation().distance(zombie.getRefLabel().getLocation());
                    if (distancia <= getAlcance() * 30) {
                        zombie.recibirGolpe(getAtaquePorUnidad(), this);
                        atacados++;
                        if (atacados >= cantidadAtaques) break;
                    }
                }

                if (atacados > 0) {
                    Thread.sleep(1000 / Math.max(1, getGolpesPorSegundo()));
                } else {
                    Thread.sleep(300);
                }

            } catch (InterruptedException e) { break; }
        }
    }
    
}
