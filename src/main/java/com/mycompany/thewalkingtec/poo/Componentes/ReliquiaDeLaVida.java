package com.mycompany.thewalkingtec.poo.Componentes;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.fPrincipal;

/**
 *
 * @author mathiasviquez
 */
public class ReliquiaDeLaVida extends Componente {
    private boolean isRunning = true;
    private boolean isPause = false;
    public ReliquiaDeLaVida(fPrincipal refPantalla, String nombre, int vida, String apariencia) {
        super(refPantalla, nombre, vida, 0, 1, 1, 0, 0, apariencia);
    }

    public void destruirReliquia() {
        System.out.println("La Reliquia de la Vida ha sido destruida. Fin del juego.");
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
        destruirReliquia();
    }

    @Override
    public Componente clonar(fPrincipal refPantalla) {
        return new ReliquiaDeLaVida(
                refPantalla, // referencia a la pantalla
                super.getNombre(),
                this.getVida(), // vida actual
                this.getApariencia()
        );
        
    }
    
    public void setPause() {
        this.isPause = !this.isPause;
    }

    public void setStop() {
        this.isRunning = false;
        this.isPause = false;
    }

    public boolean isPause() {
        return isPause;
    }
    
    
}
