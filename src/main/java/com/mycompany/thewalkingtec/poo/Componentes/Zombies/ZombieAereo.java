package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.IAtaque;
import com.mycompany.thewalkingtec.poo.Componentes.IVolador;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Point;

/**
 *
 * @author kyup
 */
public class ZombieAereo extends Zombie implements IVolador, IAtaque{

    public ZombieAereo() {
    }

    public ZombieAereo(String nombre, int vida, int ataquePorUnidad, int campos, int nivelDeAparicion, int alcance, int velocidad, String apariencia) {
        super(nombre, vida, ataquePorUnidad, campos, nivelDeAparicion, alcance, velocidad, true, apariencia);
    }

    public ZombieAereo(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeAparicion, int alcance, String apariencia, int velocidad, boolean volador) {
        super(refPantalla, nombre ,ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeAparicion, alcance, apariencia, velocidad, volador);
    }

    @Override
    public void buscarObjetivo() {
        if (getRefPantalla() == null || getRefLabel() == null || getRefPantalla().getObjetivo() == null) {
            return;
        }
        Point objetivo = getRefPantalla().getObjetivoLocation();
        double distancia = getRefLabel().getLocation().distance(objetivo);
        if (distancia <= getAlcance() * 30) {
            getRefPantalla().getObjetivo().recibirGolpe(this.getAtaquePorUnidad(), this);
        }
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        return new ZombieAereo(
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
                this.getVelocidad(),
                true
        );
    }
    
}
