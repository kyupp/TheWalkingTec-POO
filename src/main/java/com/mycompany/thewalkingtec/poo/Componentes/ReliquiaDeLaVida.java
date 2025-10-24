/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.DefensaContacto;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mathiasviquez
 */
public class ReliquiaDeLaVida extends Componente {
    
    public ReliquiaDeLaVida(fPrincipal refPantalla, int vida, String apariencia) {
        super(refPantalla, vida, 0, 1, 1, 1, 0, apariencia);
    }
    
    public void destruirReliquia() {
        // Aquí podrías notificar al juego que la partida termina
        System.out.println("La Reliquia de la Vida ha sido destruida. Fin del juego.");
    }
    
    @Override
    public void run() {
        // Podría monitorear su estado o animaciones especiales
        while (getVida() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
        destruirReliquia();
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
    // Crea una nueva ReliquiaDeLaVida con la misma vida y apariencia
    return new ReliquiaDeLaVida(
        refPantalla,      // referencia a la pantalla
        this.getVida(),   // vida actual o vida máxima según quieras
        this.getApariencia()
    );
}
}
