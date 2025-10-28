package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.IAtaque;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author kyup
 */
public class ZombieContacto extends Zombie implements IAtaque{
  
    public ZombieContacto() {
    }

    public ZombieContacto(String nombre, int vida, int ataquePorUnidad, int campos, int nivelDeAparicion, int alcance, int velocidad, String apariencia) {
        super(nombre, vida, ataquePorUnidad, campos, nivelDeAparicion, alcance, velocidad, false, apariencia);
    }

    public ZombieContacto(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo,
            int nivel, int campos, int nivelDeAparicion, int alcance,
            String apariencia, int velocidad) {

        super(refPantalla, nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos,
                nivelDeAparicion, alcance, apariencia, velocidad, false);
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        return new ZombieContacto(
                refPantalla,
                this.getNombre(),
                this.getAtaquePorUnidad(),
                this.getVida(),
                this.getGolpesPorSegundo(),
                this.getNivel(),
                this.getCampos(),
                this.getNivelDeAparicion(),
                this.getAlcance(),
                this.getApariencia(),
                this.getVelocidad()
        );
    }
}
