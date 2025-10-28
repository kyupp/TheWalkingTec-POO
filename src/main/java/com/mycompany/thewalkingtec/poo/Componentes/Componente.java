/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.Componentes;

import com.mycompany.thewalkingtec.poo.fPrincipal;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author kyup
 */

public abstract class Componente extends Thread {

    //  Atributos principales
    private static int contadorDefensas = 1;
    private static int contadorZombies = 1;
    private static int contadorReliquias = 1;

    private String nombre;
    private int vidaMaxima;
    private int vida;
    private int golpesPorSegundo;
    private int nivel;
    private int campos;
    private int nivelDeAparicion;
    private int alcance;
    private String apariencia;
    private String id;
    private Point posicionMatriz;
    private boolean estaDestruido;

    private ArrayList<RegistroAtaque> registroAtaques = new ArrayList<>();
    private ArrayList<RegistroAtaque> registroAtaquesRecibidos = new ArrayList<>();

    private JLabel refLabel;
    private fPrincipal refPantalla;

    //  Constructor base
    public Componente() {}

    public Componente(String nombre, int vida, int campos, int nivelDeAparicion, int alcance, String apariencia) {
        this.nombre = nombre;
        this.vida = vida;
        this.campos = campos;
        this.nivelDeAparicion = nivelDeAparicion;
        this.alcance = alcance;
        this.apariencia = apariencia;
    }
    
    

    public Componente(fPrincipal refPantalla, String nombre, int vida, int golpesPorSegundo, int nivel,
                      int campos, int nivelDeAparicion, int alcance, String apariencia) {
        this.refLabel = null;
        this.refPantalla = refPantalla;
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.golpesPorSegundo = golpesPorSegundo;
        this.nivel = nivel;
        this.campos = campos;
        this.nivelDeAparicion = nivelDeAparicion;
        this.alcance = alcance;
        this.apariencia = apariencia;

        // Asignar ID según tipo
        if (this instanceof com.mycompany.thewalkingtec.poo.Componentes.Defensas.Defensa)
            this.id = "D" + (contadorDefensas++);
        else if (this instanceof com.mycompany.thewalkingtec.poo.Componentes.Zombies.Zombie)
            this.id = "Z" + (contadorZombies++);
        else if (this instanceof com.mycompany.thewalkingtec.poo.Componentes.ReliquiaDeLaVida)
            this.id = "R" + (contadorReliquias++);
        
        estaDestruido = false;
    }

    //  Métodos para reiniciar los contadores entre partidas
    public static void resetearContadores() {
        contadorDefensas = 1;
        contadorZombies = 1;
        contadorReliquias = 1;
    }

    public void setRefPantalla(fPrincipal refPantalla) {
        this.refPantalla = refPantalla;
    }
    
    

    // Getters y setters
    public String getApariencia() {
        return apariencia;
    }
    
    //  Registro de ataques
    public void registrarAtaque(Componente objetivo, int danio, int vidaAntes, int vidaDespues) {
        registroAtaques.add(new RegistroAtaque(
                this.nombre + " [" + this.id + "]",
                objetivo.nombre + " [" + objetivo.id + "]",
                danio, vidaAntes, vidaDespues
        ));
    }

    public void registrarAtaqueRecibido(Componente atacante, int danio, int vidaAntes, int vidaDespues) {
        registroAtaquesRecibidos.add(new RegistroAtaque(
                atacante.nombre + " [" + atacante.id + "]",
                this.nombre + " [" + this.id + "]",
                danio, vidaAntes, vidaDespues
        ));
    }

    //  Cuando recibe daño
    public void recibirGolpe(int golpe, Componente atacante) {
        int vidaAntes = this.vida;
        this.vida = Math.max(0, this.vida - Math.abs(golpe));
        int vidaDespues = this.vida;

        if (atacante != null) {
            atacante.registrarAtaque(this, Math.abs(golpe), vidaAntes, vidaDespues);
            this.registrarAtaqueRecibido(atacante, Math.abs(golpe), vidaAntes, vidaDespues);
        }

        if (this.vida <= 0) {
            marcarDestruido();
            this.refPantalla.actualizarContadores();
        }
    }

    private void marcarDestruido() {
        this.estaDestruido = true;
        // Todas las actualizaciones de UI deben ejecutarse en el EDT
        SwingUtilities.invokeLater(() -> {
            try {
                if (getRefLabel() != null) {
                    getRefLabel().setVisible(false);
                }
            } catch (Exception ex) {
                // ignorar
            }
            try {
                // Notificar al frame que compruebe fin de juego y actualice contadores (EDT)
                if (getRefPantalla() != null) {
                    getRefPantalla().actualizarContadores();
                    getRefPantalla().comprobarPerder();
                }
            } catch (Exception ex) {
                // ignorar
            }
        });
    }

    //  Mostrar información básica
    public void mostrarInformacion() {
        JDialog dialogo = new JDialog();
        dialogo.setTitle("Información de " + nombre);
        dialogo.setSize(380, 340);
        dialogo.setLocationRelativeTo(null);
        dialogo.setModal(false);
        dialogo.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre: " + nombre);
        lblNombre.setBounds(15, 10, 340, 20);
        dialogo.add(lblNombre);

        JLabel lblId = new JLabel("ID: " + id);
        lblId.setBounds(15, 35, 340, 20);
        dialogo.add(lblId);

        JLabel lblVida = new JLabel("Vida: " + vida + " / " + vidaMaxima);
        lblVida.setBounds(15, 60, 340, 20);
        dialogo.add(lblVida);

        if (posicionMatriz != null) {
            JLabel lblCoord = new JLabel("Matriz: (" + posicionMatriz.x + ", " + posicionMatriz.y + ")");
            lblCoord.setBounds(15, 85, 340, 20);
            dialogo.add(lblCoord);
        }

        String texto = " ATAQUES REALIZADOS:\n";
        texto += registroAtaques.isEmpty() ? "   Ninguno.\n" : "";
        for (RegistroAtaque r : registroAtaques)
            texto += "   " + r.toString() + "\n";

        texto += "\n ATAQUES RECIBIDOS:\n";
        texto += registroAtaquesRecibidos.isEmpty() ? "   Ninguno.\n" : "";
        for (RegistroAtaque r : registroAtaquesRecibidos)
            texto += "   " + r.toString() + "\n";

        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        area.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 11));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(15, 120, 340, 160);
        dialogo.add(scroll);

        dialogo.setVisible(true);
    }

    //  Imagen
    public void setRefLabel(JLabel refLabel) {
        this.refLabel = refLabel;
        try {
            ImageIcon icono = new ImageIcon(
                    new ImageIcon(getClass().getResource(apariencia))
                            .getImage().getScaledInstance(refLabel.getWidth(), refLabel.getHeight(), Image.SCALE_DEFAULT)
            );
            refLabel.setIcon(icono);
            refLabel.setOpaque(false);
        } catch (Exception e) {
            System.err.println("Error cargando imagen: " + apariencia);
        }

        refLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarInformacion();
            }
        });
    }

    //  Getters & Setters
    public String getCompId() { 
        return id; 
    }
    public String getNombre() { 
        return nombre; }
    public int getVida() { return vida; 
    }
    public int getGolpesPorSegundo() {
        return golpesPorSegundo; 
    }
    public int getAlcance() { 
        return alcance; 
    }
    public Point getPosicionMatriz() {
        return posicionMatriz;
    }
    public void setPosicionMatriz(Point p) {
        this.posicionMatriz = p; 
    }
    public boolean estaDestruido() {
        return vida <= 0; 
    }
    public String getApariencia() { 
        return apariencia;
    }
    public JLabel getRefLabel() {
        return refLabel;
    }
    public fPrincipal getRefPantalla() {
        return refPantalla;
    }
   
    public abstract Componente clonar(fPrincipal refPantalla);

    public int getNivel() {
        return nivel;
    }

    public int getCampos() {
        return campos;
    }

    public int getNivelDeAparicion() {
        return nivelDeAparicion;
    }

    public void setRefPantalla(fPrincipal refPantalla) {
        this.refPantalla = refPantalla;
    }

    public void setVida(int vida) {
        this.vidaMaxima = vida;
        this.vida = vida;
    }
}