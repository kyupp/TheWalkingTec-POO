package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.Componentes.Zombies.Zombie;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author mathiasviquez
 */
public class DefensaContacto extends Defensa {

    public DefensaContacto(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        super(refPantalla, nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeAparicion, alcance, apariencia);
    }

    @Override
    public void run() {
        while (!estaDestruido()) {
            try {
                if (isPause()) {
                    Thread.sleep(200);
                    continue;
                }

                Zombie objetivo = null;
                double menorDistancia = Double.MAX_VALUE;

                for (Zombie zombie : getRefPantalla().getAtacantes()) {
                    if (zombie == null || zombie.estaDestruido()) {
                        continue;
                    }
                    double distancia = getRefLabel().getLocation().distance(zombie.getRefLabel().getLocation());
                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        objetivo = zombie;
                    }
                }

                // Solo ataca si el zombie está a la purita par
                if (objetivo != null && menorDistancia <= 30) {
                    objetivo.recibirGolpe(getAtaquePorUnidad(), this);
                    Thread.sleep(1000 / Math.max(1, getGolpesPorSegundo()));
                } else {
                    Thread.sleep(250);
                }

            } catch (InterruptedException e) {
                break;
            }
        }
    }

}
