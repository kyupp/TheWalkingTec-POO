/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.Zombie;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.util.ArrayList;

/**
 *
 * @author mathiasviquez
 */
public class DefensaImpacto extends Defensa{
    private boolean haExplotado = false;
  
    public DefensaImpacto() {
    }

    public DefensaImpacto(String nombre, int vida, int ataquePorUnidad, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        super(nombre, vida, ataquePorUnidad, campos, nivelDeAparicion, alcance, apariencia);
    }
    
    public DefensaImpacto(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla, nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
    }

    @Override
    public void run() {
        while (!estaDestruido() && !haExplotado) {
            try {
                if (isPause()) {
                    Thread.sleep(200);
                    continue;
                }

                // Detectar zombies cercanos
                ArrayList<Zombie> zombies = getRefPantalla().getAtacantes();
                for (Zombie zombie : zombies) {
                    if (zombie == null || zombie.estaDestruido()) continue;

                    double distancia = getRefLabel().getLocation()
                            .distance(zombie.getRefLabel().getLocation());

                    // Si un zombie entra en el rango de la mina
                    if (distancia <= getAlcance() * 30) {
                        explotar(zombies);
                        break;
                    }
                }

                Thread.sleep(300);

            } catch (InterruptedException e) {
                System.out.println(getNombre() + " interrumpida.");
            }
        }
    }

   
     //Explota y daña a todos los zombies en el radio de alcance.
   
    private void explotar(ArrayList<Zombie> zombies) {
        haExplotado = true;

        System.out.println(getNombre() + " ha explotado 💥");

        for (Zombie zombie : zombies) {
            if (zombie == null || zombie.estaDestruido()) continue;

            double distancia = getRefLabel().getLocation()
                    .distance(zombie.getRefLabel().getLocation());

            if (distancia <= getAlcance() * 30) {
                int vidaAntes = zombie.getVida();
                zombie.recibirGolpe(getAtaquePorUnidad(), this);
                int vidaDespues = zombie.getVida();

                registrarAtaque(zombie, getAtaquePorUnidad(), vidaAntes, vidaDespues);
                System.out.println(getNombre() + " dañó a " + zombie.getNombre() + " (" + vidaAntes + " ->" + vidaDespues + ")");
            }
        }

        // La mina se autodestruye
        setVida(0);
        getRefLabel().setIcon(null);
        getRefLabel().setOpaque(true);
        getRefLabel().setBackground(new java.awt.Color(150, 0, 0)); // rojo oscuro = explotada
        getRefLabel().setText("x");
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        return new DefensaImpacto(refPantalla, getNombre(), getAtaquePorUnidad(),
                getVida(), getGolpesPorSegundo(), getNivel(),
                getCampos(), getNivelDeAparicion(), getAlcance(), getApariencia());
    }
}