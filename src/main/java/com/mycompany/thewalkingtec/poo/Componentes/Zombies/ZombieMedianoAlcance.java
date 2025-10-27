package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author kyup
 */
public class ZombieMedianoAlcance extends Zombie {

    public ZombieMedianoAlcance(fPrincipal refPantalla,String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo,
                                int nivel, int campos, int nivelDeAparicion, int alcance, 
                                String apariencia, int velocidad) {

        super(refPantalla, nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, 
              nivelDeAparicion, alcance, apariencia, velocidad, false);
    }

    public void mover() {
        // se detiene cuando hay defensa en rango de alcance
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
