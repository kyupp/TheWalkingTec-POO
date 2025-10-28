package com.mycompany.thewalkingtec.poo.Componentes.Defensas;

import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author kyup
 */
public class DefensaBloque extends Defensa {
    public DefensaBloque() {
    }

    public DefensaBloque(String nombre, int vida, int campos, int nivelDeAparicion, String apariencia) {
        super(nombre, vida, 0, campos, nivelDeAparicion, 0, apariencia);
    }
    
    public DefensaBloque(fPrincipal refPantalla,String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo, int nivel, int campos, int nivelDeApaicion, int alcance, String apariencia) {
        super(refPantalla,  nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos, nivelDeApaicion, alcance, apariencia);
    }
  
    @Override
    public void run() {
        while (!estaDestruido()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}
