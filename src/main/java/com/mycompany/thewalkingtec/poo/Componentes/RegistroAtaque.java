package com.mycompany.thewalkingtec.poo.Componentes;
/**
 *
 * @author kyup
 */
public class RegistroAtaque {
    private String atacante;
    private String objetivo;
    private int danio;
    private int vidaObjetivoAntes;
    private int vidaObjetivoDespues;

    public RegistroAtaque(String atacante, String objetivo, int danio, int vidaObjetivoAntes, int vidaObjetivoDespues) {
        this.atacante = atacante;
        this.objetivo = objetivo;
        this.danio = danio;
        this.vidaObjetivoAntes = vidaObjetivoAntes;
        this.vidaObjetivoDespues = vidaObjetivoDespues;
    }
    
    public String getAtacante() { return atacante; }
    public String getObjetivo() { return objetivo; }
    public int getDanio() { return danio; }
    public int getVidaObjetivoAntes() { return vidaObjetivoAntes; }
    public int getVidaObjetivoDespues() { return vidaObjetivoDespues; }

    @Override
    public String toString() {
        return atacante + " → " + objetivo + 
               " (" + danio + " daño, " + vidaObjetivoAntes + " → " + vidaObjetivoDespues + ")";
    }
}
