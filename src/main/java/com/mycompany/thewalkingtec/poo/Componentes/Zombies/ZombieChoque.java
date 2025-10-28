package com.mycompany.thewalkingtec.poo.Componentes.Zombies;

import com.mycompany.thewalkingtec.poo.Componentes.Componente;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.Defensa;
import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Point;

/**
 *
 * @author kyup
 */
public class ZombieChoque extends Zombie {

    private int radioExplosion;
    private boolean isRunning = true;
    private boolean isPause = false;

    public ZombieChoque() {
    }

    public ZombieChoque(String nombre, int vida, int ataquePorUnidad, int campos, int nivelDeAparicion, int alcance, int velocidad, String apariencia) {
        super(nombre, vida, ataquePorUnidad, campos, nivelDeAparicion, alcance, velocidad, false, apariencia);
        
        this.radioExplosion = alcance;
    }
    
    

    public ZombieChoque(fPrincipal refPantalla, String nombre, int ataquePorUnidad, int vida, int golpesPorSegundo,
            int nivel, int campos, int nivelDeAparicion, int alcance,
            String apariencia, int velocidad, int radioExplosion) {

        super(refPantalla, nombre, ataquePorUnidad, vida, golpesPorSegundo, nivel, campos,
                nivelDeAparicion, alcance, apariencia, velocidad, false);
        this.radioExplosion = radioExplosion;
    }

    @Override
    public void setPause() {
        this.isPause = !this.isPause;
        super.setPause();
    }

    @Override
    public void setStop() {
        this.isRunning = false;
        this.isPause = false;
        super.setStop();
    }

    public void explotar() {
        try {
            fPrincipal pantalla = getRefPantalla();
            if (pantalla == null) {
                return;
            }

            Point centro = getRefLabel() != null ? getRefLabel().getLocation() : getPosicionMatriz() == null ? null : pantalla.getTerreno()[getPosicionMatriz().x][getPosicionMatriz().y].getPosicion();
            if (centro == null) {
                return;
            }

            double radioPx = radioExplosion * 30.0;

            // Daño a defensas
            for (Defensa defensa : pantalla.getEjercito()) {
                if (defensa == null || defensa.estaDestruido()) {
                    continue;
                }
                if (defensa.getRefLabel() == null) {
                    continue;
                }
                double d = centro.distance(defensa.getRefLabel().getLocation());
                if (d <= radioPx) {
                    // Aplicar daño suficiente para destruir
                    defensa.recibirGolpe(defensa.getVida(), this);
                    System.out.println(getNombre() + " explotó y dañó a " + defensa.getNombre());
                }
            }

            // Daño a la reliquia si está en el radio
            if (pantalla.getObjetivo() != null && pantalla.getObjetivo().getRefLabel() != null) {
                double dRel = centro.distance(pantalla.getObjetivo().getRefLabel().getLocation());
                if (dRel <= radioPx) {
                    pantalla.getObjetivo().recibirGolpe(pantalla.getObjetivo().getVida(), this);
                    System.out.println(getNombre() + " explotó y dañó la Reliquia.");
                }
            }

            // Autodestrucción del propio zombie
            this.recibirGolpe(this.getVida(), this);

        } catch (Exception ex) {
            System.out.println("Error en explotar(): " + ex.getMessage());
        }
    }

    @Override
    public void run() {

        int paso = 10; // píxeles que avanza
        // Ejecutar mientras esté en ejecución y no esté destruido
        while (isRunning && !this.estaDestruido()) {
            try {
                // respetar pausa (usa el flag del padre si existe)
                if (super.isPause()) {
                    Thread.sleep(200);
                    continue;
                }
                // asegurarse de tener referencias válidas antes de operar
                if (super.getRefLabel() == null || super.getRefPantalla() == null) {
                    Thread.sleep(200);
                    continue;
                }

                // Buscar defensa más cercana
                Defensa defensaCercana = null;
                double menorDistancia = Double.MAX_VALUE;

                for (Defensa defensaActual : super.getRefPantalla().getEjercito()) {
                    if (defensaActual == null || defensaActual.estaDestruido()) {
                        continue;
                    }

                    if (defensaActual.getRefLabel() == null) {
                        continue;
                    }
                    double distancia = super.getRefLabel().getLocation().distance(defensaActual.getRefLabel().getLocation());

                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        defensaCercana = defensaActual;
                    }
                }

                // Si llega a una defensa por contacto, explotar
                if (defensaCercana != null && menorDistancia <= super.getAlcance() * 30) {
                    explotar();
                    break;
                }
                // Si llega a la reliquia, explotar sobre ella
                Point objetivo = super.getRefPantalla().getObjetivoLocation();
                Point actual = super.getRefLabel().getLocation();
                if (objetivo == null) {
                    Thread.sleep(200);
                    continue;
                }
                double distanciaReliquia = actual.distance(objetivo);
                if (distanciaReliquia <= super.getAlcance() * 30) {
                    explotar();
                    break;
                }

                // Movimiento hacia la reliquia
                int x = actual.x;
                int y = actual.y;

                if (x < objetivo.x) {
                    x += paso;
                } else if (x > objetivo.x) {
                    x -= paso;
                }

                if (y < objetivo.y) {
                    y += paso;
                } else if (y > objetivo.y) {
                    y -= paso;
                }

                super.getRefPantalla().mover(super.getRefLabel(), x, y);

                // Delay según velocidad
                int delay = 1500 / Math.max(1, this.getVelocidad() + 1);
                Thread.sleep(delay);

            } catch (InterruptedException ex) {
                System.out.println(getNombre() + " interrumpido.");
                break;
            } catch (Exception ex) {
                System.out.println("Error en ZombieChoque.run: " + ex.getMessage());
                break;
            }
        }
    }

    @Override
    public Componente clonar(fPrincipal refPantalla
    ) {
        return new ZombieChoque(
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
                this.radioExplosion
        );
    }
}
