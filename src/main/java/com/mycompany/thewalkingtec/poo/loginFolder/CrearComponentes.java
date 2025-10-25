/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.thewalkingtec.poo.loginFolder;

import com.mycompany.thewalkingtec.poo.Componentes.Defensas.Defensa;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.DefensaAerea;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.DefensaAtaqueMultiple;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.DefensaBloque;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.DefensaContacto;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.DefensaImpacto;
import com.mycompany.thewalkingtec.poo.Componentes.Defensas.DefensaMedioAlcance;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.Zombie;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.ZombieAereo;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.ZombieChoque;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.ZombieContacto;
import com.mycompany.thewalkingtec.poo.Componentes.Zombies.ZombieMedianoAlcance;
import java.util.ArrayList;

/**
 *
 * @author mathiasviquez
 */
public class CrearComponentes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CrearComponentes.class.getName());
    
    private ArrayList<Zombie> listaDeZombies = new ArrayList<Zombie>();
    private ArrayList<Defensa> listaDeArmas = new ArrayList<Defensa>();
    private ArrayList<DefensaBloque> listaDeBloques = new ArrayList<DefensaBloque>();

    /**
     * Creates new form CrearComponentes
     */
    public CrearComponentes() {
        initComponents();
    }
    
    private void crearZombie(String name, int life, int type, int damage, int fields, int appearance, int range){
        
        Zombie newZombie;
        
        switch (type){
            case 1 -> {
                newZombie = new ZombieAereo();
            }
            case 2 -> {
                newZombie = new ZombieChoque();
            }
            case 3 -> {
                newZombie = new ZombieContacto();
            }
            default ->{
                newZombie = new ZombieMedianoAlcance();
            }
        }
        
        listaDeZombies.add(newZombie);
        System.out.println("Se agrego el zombieeeee: " + name + " :>>>>");
        
    }
    
    private void crearArma(String name, int life, int type, int damage, int fields, int appearance, int range){
        
        Defensa newArma;
        
        switch (type){
            case 1 -> {
                newArma = new DefensaAerea();
            }
            case 2 -> {
                newArma = new DefensaImpacto();
            }
            case 3 -> {
                newArma = new DefensaContacto();
            }
            case 4 -> {
                newArma = new DefensaMedioAlcance();
            }
            default -> {
                
                newArma = new DefensaAtaqueMultiple();
                
            }
        }
        
        listaDeArmas.add(newArma);
        System.out.println("Se agrego el armaaaaa: " + name + " :>>>>");
        
    }
    
    private void crearBloque(String name, int life, int fields ,int appearance){
        
        DefensaBloque newBloque = new DefensaBloque();
        
        listaDeBloques.add(newBloque);
        
        System.out.println("Se agrego el bloqueeee: " + name + " :>>>>");
        
    }
    
    private int comprobarTypeZombie(String type){
        
        return switch (type) {
            
            case "Aereos" -> 1;
                
            case "Choque" -> 2;
                
            case "De Contacto" -> 3;
                
            default -> 4;
        };
    }
    
    private int comprobarTypeArmas(String type){
        
        return switch (type) {
            
            case "Aereos" -> 1;
                
            case "Impacto" -> 2;
                
            case "De Contacto" -> 3;
                
            case "Mediano Alcance" -> 4;
                
            default -> 5;    
        };
    }
    
    private void obtenerDatosZombie(){
        
        String name = this.txtFldNameZombie.getText();
        
        int life = Integer.parseInt(this.txtFldLifeZombie.getText());
        
        int type = comprobarTypeZombie((String) this.cmbBxTypeZombie.getSelectedItem());
        
        int damage = Integer.parseInt(this.txtFldDamageZombie.getText());
        
        int fields = Integer.parseInt(this.txtFldFieldsZombie.getText());
        
        int appearance = Integer.parseInt(this.txtFldAppearanceZombie.getText());
        
        String rangeStr = this.txtFldRangeZombie.getText();
        
        if (rangeStr.equals("")){
            
            crearZombie(name, life, type, damage, fields, appearance, 0);
            
        } else{
            
            int range = Integer.parseInt(rangeStr);
            crearZombie(name, life, type, damage, fields, appearance, range);
            
        }
        
    }
    
    private void obtenerDatosArma(){
        
        String name = this.txtFldNameArmas.getText();
        
        int life = Integer.parseInt(this.txtFldLifeArmas.getText());
        
        int type = comprobarTypeArmas((String) this.cmbBxTypeArmas.getSelectedItem());
        
        int damage = Integer.parseInt(this.txtFldDamageArmas.getText());
        
        int fields = Integer.parseInt(this.txtFldFieldsArmas.getText());
        
        int appearance = Integer.parseInt(this.txtFldAppearanceArmas.getText());
        
        String rangeStr = this.txtFldRangeArmas.getText();
        
        if (rangeStr.equals("")){
            
            crearArma(name, life, type, damage, fields, appearance, 0);
            
        } else{
            
            int range = Integer.parseInt(rangeStr);
            crearArma(name, life, type, damage, fields, appearance, range);
            
        }
    }
    
    private void obtenerDatosBloque(){
        
        String name = this.txtFldNameBloques.getText();
        
        int life = Integer.parseInt(this.txtFldLifeBloques.getText());
        
        int fields = Integer.parseInt(this.txtFldFieldsBloques.getText());
        
        int appearance = Integer.parseInt(this.txtFldAppearanceBloques.getText());
        
        crearBloque(name, life, fields, appearance);
     
    }
    
    public boolean esUnaPalabra(String text){
        return text.matches("[a-zA-Z]+");
    }
    
    public boolean esUnNumero(String text){
        return text.matches("\\d+");
    }
    
    public int verificarVida(int tipo){
        String life;
        switch (tipo){
            case 1 -> {
                life = this.txtFldLifeZombie.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaLifeZombie.setText("Solo se permiten valores númericos para la vida");
            }
            case 2 -> {
                life = this.txtFldLifeArmas.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaLifeArma.setText("Solo se permiten valores númericos para la vida");
            }
            case 3 -> {
                life = this.txtFldLifeBloques.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaLifeBloques.setText("Solo se permiten valores númericos para la vida");
            }
        }
        return 1;
    } 
    
    public int verificarDanno(int tipo){
        String damage;
        switch (tipo){
            case 1 -> {
                damage = this.txtFldDamageZombie.getText();
                if (esUnNumero(damage)) return 0;
                this.txtFldAlertaDamageZombie.setText("Solo se permiten valores númericos para el daño");
            }
            case 2 -> {
                damage = this.txtFldDamageArmas.getText();
                if (esUnNumero(damage)) return 0;
                this.txtFldAlertaDamageArma.setText("Solo se permiten valores númericos para el daño");
            }
        }
        return 1;
    }
    
    public int verificarRango(int tipo){
        String range;
        switch (tipo){
            case 1 -> {
                range = this.txtFldRangeZombie.getText();
                if (esUnNumero(range) || range.equals("")) {
                    String opcion = (String) this.cmbBxTypeZombie.getSelectedItem();
                    if (opcion.equals("Choque") || range.equals("")) return 0;
                    this.txtFldAlertaRangeZombie.setText("Esta opción solo se permite para tipo impacto");
                    break;
                }
                this.txtFldAlertaRangeZombie.setText("Solo se permiten valores númericos para el rango");
            }
            case 2 -> {
                range = this.txtFldRangeArmas.getText();
                if (esUnNumero(range) || range.equals("")) {
                    String opcion = (String) this.cmbBxTypeArmas.getSelectedItem();
                    if (opcion.equals("Impacto") || range.equals("")) return 0;
                    this.txtFldAlertaRangeArma.setText("Esta opción solo se permite para tipo impacto");
                    break;
                }
                this.txtFldAlertaRangeArma.setText("Solo se permiten valores númericos para el rango");
            }
        }
        return 1;
    }
    
    public int verificarAparicion(int tipo){
        String life;
        switch (tipo){
            case 1 -> {
                life = this.txtFldAppearanceZombie.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaAppearanceZombie.setText("Solo se permiten valores númericos para la aparición");
            }
            case 2 -> {
                life = this.txtFldAppearanceArmas.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaAppearanceArma.setText("Solo se permiten valores númericos para la aparición");
            }
            case 3 -> {
                life = this.txtFldAppearanceBloques.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaAppearanceBloques.setText("Solo se permiten valores númericos para la aparición");
            }
        }
        return 1;
    }  
    
    public int verificarCampos(int tipo){
        String life;
        switch (tipo){
            case 1 -> {
                life = this.txtFldFieldsZombie.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaFieldsZombie.setText("Solo se permiten valores númericos para los campos");
            }
            case 2 -> {
                life = this.txtFldAppearanceArmas.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaFieldsArma.setText("Solo se permiten valores númericos para los campos");
            }
            case 3 -> {
                life = this.txtFldFieldsBloques.getText();
                if (esUnNumero(life)) return 0;
                this.txtFldAlertaFieldsBloques.setText("Solo se permiten valores númericos para los campos");
            }
        }
        return 1;
    } 
    
    public int verificarDatos(int tipo){
        int contador = 0;
        int verificaciones = 1;
        
        
        switch (tipo){
            case 1 -> {
                switch (verificaciones){
                    case 1:
                        contador += verificarVida(tipo);
                        verificaciones++;
                    case 2:
                        contador += verificarDanno(tipo);
                        verificaciones++;
                    case 3:
                        contador += verificarRango(tipo);
                        verificaciones++;
                    case 4:
                        contador += verificarAparicion(tipo);
                        verificaciones++;
                    case 5:
                        contador += verificarCampos(tipo);
                }
            }
            case 2 -> {
                switch (verificaciones){
                    case 1:
                        contador += verificarVida(tipo);
                        verificaciones++;
                    case 2:
                        contador += verificarDanno(tipo);
                        verificaciones++;
                    case 3:
                        contador += verificarRango(tipo);
                        verificaciones++;
                    case 4:
                        contador += verificarAparicion(tipo);
                        verificaciones++;
                    case 5:
                        contador += verificarCampos(tipo);
                }                
            }
            case 3 -> {
                switch (verificaciones){
                    case 1:
                        contador += verificarVida(tipo);
                        verificaciones++;
                    case 2:
                        contador += verificarAparicion(tipo);
                        verificaciones++;
                    case 3:
                        contador += verificarCampos(tipo);
                }                
            }
        }
        
        return contador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        tbdPnCrearComponente = new javax.swing.JTabbedPane();
        pnlZombie = new javax.swing.JPanel();
        lblNameZombie = new javax.swing.JLabel();
        txtFldNameZombie = new javax.swing.JTextField();
        txtFldAlertaNameZombie = new javax.swing.JTextField();
        lblZombieImageOutput1 = new javax.swing.JLabel();
        lblImageZombie1 = new javax.swing.JLabel();
        txtFldImageZombie1 = new javax.swing.JTextField();
        txtFldAlertaImageZombie1 = new javax.swing.JTextField();
        lblImageZombie2 = new javax.swing.JLabel();
        txtFldImageZombie2 = new javax.swing.JTextField();
        txtFldAlertaImageZombie2 = new javax.swing.JTextField();
        lblLifeZombie = new javax.swing.JLabel();
        txtFldLifeZombie = new javax.swing.JTextField();
        txtFldAlertaLifeZombie = new javax.swing.JTextField();
        lblTypeZombie = new javax.swing.JLabel();
        cmbBxTypeZombie = new javax.swing.JComboBox<>();
        lblDamageZombie = new javax.swing.JLabel();
        txtFldDamageZombie = new javax.swing.JTextField();
        txtFldAlertaDamageZombie = new javax.swing.JTextField();
        lblZombieImageOutput2 = new javax.swing.JLabel();
        lblFieldsZombie = new javax.swing.JLabel();
        txtFldFieldsZombie = new javax.swing.JTextField();
        txtFldAlertaFieldsZombie = new javax.swing.JTextField();
        lblAppearanceZombie = new javax.swing.JLabel();
        txtFldAppearanceZombie = new javax.swing.JTextField();
        txtFldAlertaAppearanceZombie = new javax.swing.JTextField();
        lblRangeZombie = new javax.swing.JLabel();
        txtFldRangeZombie = new javax.swing.JTextField();
        txtFldAlertaRangeZombie = new javax.swing.JTextField();
        btnCrearZombie = new javax.swing.JButton();
        pnlBloque = new javax.swing.JPanel();
        lblNameBloques = new javax.swing.JLabel();
        txtFldNameBloques = new javax.swing.JTextField();
        txtFldAlertaNameBloques = new javax.swing.JTextField();
        lblBloquesImageOutput1 = new javax.swing.JLabel();
        lblImageBloques1 = new javax.swing.JLabel();
        txtFldImageBloques1 = new javax.swing.JTextField();
        txtFldAlertaImageBloques1 = new javax.swing.JTextField();
        lblImageBloques2 = new javax.swing.JLabel();
        txtFldImageBloques2 = new javax.swing.JTextField();
        txtFldAlertaImageBloques2 = new javax.swing.JTextField();
        lblLifeBloques = new javax.swing.JLabel();
        txtFldLifeBloques = new javax.swing.JTextField();
        txtFldAlertaLifeBloques = new javax.swing.JTextField();
        lblBloquesImageOutput2 = new javax.swing.JLabel();
        lblFieldsBloques = new javax.swing.JLabel();
        txtFldFieldsBloques = new javax.swing.JTextField();
        txtFldAlertaFieldsBloques = new javax.swing.JTextField();
        lblAppearanceBloques = new javax.swing.JLabel();
        txtFldAppearanceBloques = new javax.swing.JTextField();
        txtFldAlertaAppearanceBloques = new javax.swing.JTextField();
        btnCrearBloques = new javax.swing.JButton();
        pnlArmas = new javax.swing.JPanel();
        lblArmasImageOutput1 = new javax.swing.JLabel();
        lblImageArmas1 = new javax.swing.JLabel();
        lblImageArmas2 = new javax.swing.JLabel();
        lblNameArmas = new javax.swing.JLabel();
        lblLifeArmas = new javax.swing.JLabel();
        lblTypeArmas = new javax.swing.JLabel();
        lblDamageArmas = new javax.swing.JLabel();
        lblFieldsArmas = new javax.swing.JLabel();
        lblAppearanceArmas = new javax.swing.JLabel();
        lblRangeArmas = new javax.swing.JLabel();
        txtFldImageArmas1 = new javax.swing.JTextField();
        txtFldImageArmas2 = new javax.swing.JTextField();
        txtFldDamageArmas = new javax.swing.JTextField();
        txtFldLifeArmas = new javax.swing.JTextField();
        txtFldFieldsArmas = new javax.swing.JTextField();
        txtFldAppearanceArmas = new javax.swing.JTextField();
        txtFldRangeArmas = new javax.swing.JTextField();
        txtFldNameArmas = new javax.swing.JTextField();
        cmbBxTypeArmas = new javax.swing.JComboBox<>();
        lblArmasImageOutput2 = new javax.swing.JLabel();
        btnCrearArmas = new javax.swing.JButton();
        txtFldAlertaNameArma = new javax.swing.JTextField();
        txtFldAlertaImageArma1 = new javax.swing.JTextField();
        txtFldAlertaImageArma2 = new javax.swing.JTextField();
        txtFldAlertaLifeArma = new javax.swing.JTextField();
        txtFldAlertaDamageArma = new javax.swing.JTextField();
        txtFldAlertaFieldsArma = new javax.swing.JTextField();
        txtFldAlertaAppearanceArma = new javax.swing.JTextField();
        txtFldAlertaRangeArma = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbdPnCrearComponente.setBackground(new java.awt.Color(153, 153, 255));
        tbdPnCrearComponente.setOpaque(true);

        pnlZombie.setBackground(new java.awt.Color(204, 204, 204));

        lblNameZombie.setBackground(new java.awt.Color(102, 102, 102));
        lblNameZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblNameZombie.setForeground(new java.awt.Color(204, 204, 255));
        lblNameZombie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameZombie.setText("Name:");
        lblNameZombie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNameZombie.setOpaque(true);

        txtFldNameZombie.setBackground(new java.awt.Color(153, 153, 153));
        txtFldNameZombie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFldNameZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldNameZombieActionPerformed(evt);
            }
        });

        txtFldAlertaNameZombie.setEditable(false);
        txtFldAlertaNameZombie.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaNameZombie.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaNameZombie.setText("Este zombie ya se encuentra almacenado");
        txtFldAlertaNameZombie.setBorder(null);

        lblZombieImageOutput1.setBackground(new java.awt.Color(204, 204, 255));
        lblZombieImageOutput1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblZombieImageOutput1.setOpaque(true);

        lblImageZombie1.setBackground(new java.awt.Color(102, 102, 102));
        lblImageZombie1.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblImageZombie1.setForeground(new java.awt.Color(255, 255, 255));
        lblImageZombie1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageZombie1.setText("Imagen 1:");
        lblImageZombie1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImageZombie1.setOpaque(true);

        txtFldImageZombie1.setBackground(new java.awt.Color(153, 153, 153));
        txtFldImageZombie1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaImageZombie1.setEditable(false);
        txtFldAlertaImageZombie1.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaImageZombie1.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaImageZombie1.setText("Imagen no encontrada");
        txtFldAlertaImageZombie1.setBorder(null);

        lblImageZombie2.setBackground(new java.awt.Color(102, 102, 102));
        lblImageZombie2.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblImageZombie2.setForeground(new java.awt.Color(255, 255, 255));
        lblImageZombie2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageZombie2.setText("Imagen 2:");
        lblImageZombie2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImageZombie2.setOpaque(true);

        txtFldImageZombie2.setBackground(new java.awt.Color(153, 153, 153));
        txtFldImageZombie2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaImageZombie2.setEditable(false);
        txtFldAlertaImageZombie2.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaImageZombie2.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaImageZombie2.setText("Imagen no encontrada");
        txtFldAlertaImageZombie2.setBorder(null);

        lblLifeZombie.setBackground(new java.awt.Color(102, 102, 102));
        lblLifeZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblLifeZombie.setForeground(new java.awt.Color(255, 255, 255));
        lblLifeZombie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLifeZombie.setText("Life:");
        lblLifeZombie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblLifeZombie.setOpaque(true);

        txtFldLifeZombie.setBackground(new java.awt.Color(153, 153, 153));
        txtFldLifeZombie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaLifeZombie.setEditable(false);
        txtFldAlertaLifeZombie.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaLifeZombie.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaLifeZombie.setBorder(null);
        txtFldAlertaLifeZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldAlertaLifeZombieActionPerformed(evt);
            }
        });

        lblTypeZombie.setBackground(new java.awt.Color(102, 102, 102));
        lblTypeZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblTypeZombie.setForeground(new java.awt.Color(255, 255, 255));
        lblTypeZombie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTypeZombie.setText("Type:");
        lblTypeZombie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTypeZombie.setOpaque(true);

        cmbBxTypeZombie.setBackground(new java.awt.Color(153, 153, 153));
        cmbBxTypeZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        cmbBxTypeZombie.setForeground(new java.awt.Color(255, 255, 255));
        cmbBxTypeZombie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "De Contacto", "Mediano Alcance", "Aereos", "Choque" }));
        cmbBxTypeZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBxTypeZombieActionPerformed(evt);
            }
        });

        lblDamageZombie.setBackground(new java.awt.Color(102, 102, 102));
        lblDamageZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblDamageZombie.setForeground(new java.awt.Color(255, 255, 255));
        lblDamageZombie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDamageZombie.setText("Damage:");
        lblDamageZombie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDamageZombie.setOpaque(true);

        txtFldDamageZombie.setBackground(new java.awt.Color(153, 153, 153));
        txtFldDamageZombie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaDamageZombie.setEditable(false);
        txtFldAlertaDamageZombie.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaDamageZombie.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaDamageZombie.setBorder(null);
        txtFldAlertaDamageZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldAlertaDamageZombieActionPerformed(evt);
            }
        });

        lblZombieImageOutput2.setBackground(new java.awt.Color(204, 204, 255));
        lblZombieImageOutput2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblZombieImageOutput2.setOpaque(true);

        lblFieldsZombie.setBackground(new java.awt.Color(102, 102, 102));
        lblFieldsZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblFieldsZombie.setForeground(new java.awt.Color(255, 255, 255));
        lblFieldsZombie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFieldsZombie.setText("Fields:");
        lblFieldsZombie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFieldsZombie.setOpaque(true);

        txtFldFieldsZombie.setBackground(new java.awt.Color(153, 153, 153));
        txtFldFieldsZombie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaFieldsZombie.setEditable(false);
        txtFldAlertaFieldsZombie.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaFieldsZombie.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaFieldsZombie.setBorder(null);

        lblAppearanceZombie.setBackground(new java.awt.Color(102, 102, 102));
        lblAppearanceZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblAppearanceZombie.setForeground(new java.awt.Color(255, 255, 255));
        lblAppearanceZombie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppearanceZombie.setText("Appearance:");
        lblAppearanceZombie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAppearanceZombie.setOpaque(true);

        txtFldAppearanceZombie.setBackground(new java.awt.Color(153, 153, 153));
        txtFldAppearanceZombie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaAppearanceZombie.setEditable(false);
        txtFldAlertaAppearanceZombie.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaAppearanceZombie.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaAppearanceZombie.setBorder(null);

        lblRangeZombie.setBackground(new java.awt.Color(102, 102, 102));
        lblRangeZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblRangeZombie.setForeground(new java.awt.Color(255, 255, 255));
        lblRangeZombie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRangeZombie.setText("Range:");
        lblRangeZombie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRangeZombie.setOpaque(true);

        txtFldRangeZombie.setBackground(new java.awt.Color(153, 153, 153));
        txtFldRangeZombie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaRangeZombie.setEditable(false);
        txtFldAlertaRangeZombie.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaRangeZombie.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaRangeZombie.setBorder(null);

        btnCrearZombie.setBackground(new java.awt.Color(102, 102, 102));
        btnCrearZombie.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btnCrearZombie.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearZombie.setText("Crear");
        btnCrearZombie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearZombieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlZombieLayout = new javax.swing.GroupLayout(pnlZombie);
        pnlZombie.setLayout(pnlZombieLayout);
        pnlZombieLayout.setHorizontalGroup(
            pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlZombieLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblNameZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldAlertaNameZombie)
                    .addComponent(txtFldNameZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(pnlZombieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblZombieImageOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblZombieImageOutput2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlZombieLayout.createSequentialGroup()
                        .addComponent(lblImageZombie1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFldImageZombie1)
                        .addGap(75, 75, 75))
                    .addGroup(pnlZombieLayout.createSequentialGroup()
                        .addComponent(txtFldAlertaImageZombie1)
                        .addContainerGap())
                    .addGroup(pnlZombieLayout.createSequentialGroup()
                        .addComponent(lblImageZombie2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldImageZombie2)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlZombieLayout.createSequentialGroup()
                        .addComponent(txtFldAlertaImageZombie2)
                        .addContainerGap())
                    .addGroup(pnlZombieLayout.createSequentialGroup()
                        .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFldAlertaRangeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlZombieLayout.createSequentialGroup()
                                .addComponent(lblFieldsZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldFieldsZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFldAlertaDamageZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlZombieLayout.createSequentialGroup()
                                .addComponent(lblDamageZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFldDamageZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlZombieLayout.createSequentialGroup()
                                .addComponent(lblTypeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbBxTypeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFldAlertaLifeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlZombieLayout.createSequentialGroup()
                                .addComponent(lblLifeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldLifeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlZombieLayout.createSequentialGroup()
                                .addComponent(lblAppearanceZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFldAppearanceZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlZombieLayout.createSequentialGroup()
                                .addComponent(lblRangeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldRangeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFldAlertaFieldsZombie, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                            .addComponent(txtFldAlertaAppearanceZombie))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnlZombieLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnCrearZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlZombieLayout.setVerticalGroup(
            pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlZombieLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameZombie)
                    .addComponent(txtFldNameZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFldAlertaNameZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlZombieLayout.createSequentialGroup()
                        .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblImageZombie1)
                            .addComponent(txtFldImageZombie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldAlertaImageZombie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImageZombie2)
                            .addComponent(txtFldImageZombie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldAlertaImageZombie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLifeZombie)
                            .addComponent(txtFldLifeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblZombieImageOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(txtFldAlertaLifeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBxTypeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTypeZombie))
                .addGap(17, 17, 17)
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDamageZombie)
                    .addComponent(txtFldDamageZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlZombieLayout.createSequentialGroup()
                        .addComponent(txtFldAlertaDamageZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFieldsZombie)
                            .addComponent(txtFldFieldsZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldAlertaFieldsZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppearanceZombie)
                            .addComponent(txtFldAppearanceZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblZombieImageOutput2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFldAlertaAppearanceZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRangeZombie)
                    .addComponent(txtFldRangeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFldAlertaRangeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnCrearZombie)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tbdPnCrearComponente.addTab("Zombie", pnlZombie);

        pnlBloque.setBackground(new java.awt.Color(204, 204, 204));

        lblNameBloques.setBackground(new java.awt.Color(102, 102, 102));
        lblNameBloques.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblNameBloques.setForeground(new java.awt.Color(204, 204, 255));
        lblNameBloques.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameBloques.setText("Name:");
        lblNameBloques.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNameBloques.setOpaque(true);

        txtFldNameBloques.setBackground(new java.awt.Color(153, 153, 153));
        txtFldNameBloques.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFldNameBloques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldNameBloquesActionPerformed(evt);
            }
        });

        txtFldAlertaNameBloques.setEditable(false);
        txtFldAlertaNameBloques.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaNameBloques.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaNameBloques.setText("Este bloque ya se encuentra almacenado");
        txtFldAlertaNameBloques.setBorder(null);
        txtFldAlertaNameBloques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldAlertaNameBloquesActionPerformed(evt);
            }
        });

        lblBloquesImageOutput1.setBackground(new java.awt.Color(204, 204, 255));
        lblBloquesImageOutput1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBloquesImageOutput1.setOpaque(true);

        lblImageBloques1.setBackground(new java.awt.Color(102, 102, 102));
        lblImageBloques1.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblImageBloques1.setForeground(new java.awt.Color(255, 255, 255));
        lblImageBloques1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageBloques1.setText("Imagen 1:");
        lblImageBloques1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImageBloques1.setOpaque(true);

        txtFldImageBloques1.setBackground(new java.awt.Color(153, 153, 153));
        txtFldImageBloques1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaImageBloques1.setEditable(false);
        txtFldAlertaImageBloques1.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaImageBloques1.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaImageBloques1.setText("Imagen no encontrada");
        txtFldAlertaImageBloques1.setBorder(null);

        lblImageBloques2.setBackground(new java.awt.Color(102, 102, 102));
        lblImageBloques2.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblImageBloques2.setForeground(new java.awt.Color(255, 255, 255));
        lblImageBloques2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageBloques2.setText("Imagen 2:");
        lblImageBloques2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImageBloques2.setOpaque(true);

        txtFldImageBloques2.setBackground(new java.awt.Color(153, 153, 153));
        txtFldImageBloques2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaImageBloques2.setEditable(false);
        txtFldAlertaImageBloques2.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaImageBloques2.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaImageBloques2.setText("Imagen no encontrada");
        txtFldAlertaImageBloques2.setBorder(null);

        lblLifeBloques.setBackground(new java.awt.Color(102, 102, 102));
        lblLifeBloques.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblLifeBloques.setForeground(new java.awt.Color(255, 255, 255));
        lblLifeBloques.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLifeBloques.setText("Life:");
        lblLifeBloques.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblLifeBloques.setOpaque(true);

        txtFldLifeBloques.setBackground(new java.awt.Color(153, 153, 153));
        txtFldLifeBloques.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaLifeBloques.setEditable(false);
        txtFldAlertaLifeBloques.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaLifeBloques.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaLifeBloques.setBorder(null);
        txtFldAlertaLifeBloques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldAlertaLifeBloquesActionPerformed(evt);
            }
        });

        lblBloquesImageOutput2.setBackground(new java.awt.Color(204, 204, 255));
        lblBloquesImageOutput2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBloquesImageOutput2.setOpaque(true);

        lblFieldsBloques.setBackground(new java.awt.Color(102, 102, 102));
        lblFieldsBloques.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblFieldsBloques.setForeground(new java.awt.Color(255, 255, 255));
        lblFieldsBloques.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFieldsBloques.setText("Fields:");
        lblFieldsBloques.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFieldsBloques.setOpaque(true);

        txtFldFieldsBloques.setBackground(new java.awt.Color(153, 153, 153));
        txtFldFieldsBloques.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaFieldsBloques.setEditable(false);
        txtFldAlertaFieldsBloques.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaFieldsBloques.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaFieldsBloques.setBorder(null);

        lblAppearanceBloques.setBackground(new java.awt.Color(102, 102, 102));
        lblAppearanceBloques.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblAppearanceBloques.setForeground(new java.awt.Color(255, 255, 255));
        lblAppearanceBloques.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppearanceBloques.setText("Appearance:");
        lblAppearanceBloques.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAppearanceBloques.setOpaque(true);

        txtFldAppearanceBloques.setBackground(new java.awt.Color(153, 153, 153));
        txtFldAppearanceBloques.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAlertaAppearanceBloques.setEditable(false);
        txtFldAlertaAppearanceBloques.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaAppearanceBloques.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaAppearanceBloques.setBorder(null);

        btnCrearBloques.setBackground(new java.awt.Color(102, 102, 102));
        btnCrearBloques.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btnCrearBloques.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearBloques.setText("Crear");
        btnCrearBloques.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearBloques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBloquesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBloqueLayout = new javax.swing.GroupLayout(pnlBloque);
        pnlBloque.setLayout(pnlBloqueLayout);
        pnlBloqueLayout.setHorizontalGroup(
            pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBloqueLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblNameBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldAlertaNameBloques)
                    .addComponent(txtFldNameBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(pnlBloqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBloquesImageOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBloquesImageOutput2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBloqueLayout.createSequentialGroup()
                        .addComponent(lblImageBloques1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFldImageBloques1)
                        .addGap(75, 75, 75))
                    .addGroup(pnlBloqueLayout.createSequentialGroup()
                        .addComponent(txtFldAlertaImageBloques1)
                        .addContainerGap())
                    .addGroup(pnlBloqueLayout.createSequentialGroup()
                        .addComponent(lblImageBloques2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldImageBloques2)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBloqueLayout.createSequentialGroup()
                        .addComponent(txtFldAlertaImageBloques2)
                        .addContainerGap())
                    .addGroup(pnlBloqueLayout.createSequentialGroup()
                        .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFldAlertaLifeBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBloqueLayout.createSequentialGroup()
                                .addComponent(lblLifeBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldLifeBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBloqueLayout.createSequentialGroup()
                                .addComponent(lblAppearanceBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFldAppearanceBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFldAlertaFieldsBloques, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                            .addComponent(txtFldAlertaAppearanceBloques)
                            .addGroup(pnlBloqueLayout.createSequentialGroup()
                                .addComponent(lblFieldsBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldFieldsBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnlBloqueLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(btnCrearBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBloqueLayout.setVerticalGroup(
            pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBloqueLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameBloques)
                    .addComponent(txtFldNameBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFldAlertaNameBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBloqueLayout.createSequentialGroup()
                        .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblImageBloques1)
                            .addComponent(txtFldImageBloques1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldAlertaImageBloques1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImageBloques2)
                            .addComponent(txtFldImageBloques2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldAlertaImageBloques2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLifeBloques)
                            .addComponent(txtFldLifeBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblBloquesImageOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(txtFldAlertaLifeBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlBloqueLayout.createSequentialGroup()
                        .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFieldsBloques)
                            .addComponent(txtFldFieldsBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtFldAlertaFieldsBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBloqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppearanceBloques)
                            .addComponent(txtFldAppearanceBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblBloquesImageOutput2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFldAlertaAppearanceBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnCrearBloques)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tbdPnCrearComponente.addTab("Bloques", pnlBloque);

        pnlArmas.setBackground(new java.awt.Color(204, 204, 204));

        lblArmasImageOutput1.setBackground(new java.awt.Color(204, 204, 255));
        lblArmasImageOutput1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblArmasImageOutput1.setOpaque(true);

        lblImageArmas1.setBackground(new java.awt.Color(102, 102, 102));
        lblImageArmas1.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblImageArmas1.setForeground(new java.awt.Color(255, 255, 255));
        lblImageArmas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageArmas1.setText("Imagen 1:");
        lblImageArmas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImageArmas1.setOpaque(true);

        lblImageArmas2.setBackground(new java.awt.Color(102, 102, 102));
        lblImageArmas2.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblImageArmas2.setForeground(new java.awt.Color(255, 255, 255));
        lblImageArmas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageArmas2.setText("Imagen 2:");
        lblImageArmas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImageArmas2.setOpaque(true);

        lblNameArmas.setBackground(new java.awt.Color(102, 102, 102));
        lblNameArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblNameArmas.setForeground(new java.awt.Color(204, 204, 255));
        lblNameArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameArmas.setText("Name:");
        lblNameArmas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNameArmas.setOpaque(true);

        lblLifeArmas.setBackground(new java.awt.Color(102, 102, 102));
        lblLifeArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblLifeArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblLifeArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLifeArmas.setText("Life:");
        lblLifeArmas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblLifeArmas.setOpaque(true);

        lblTypeArmas.setBackground(new java.awt.Color(102, 102, 102));
        lblTypeArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblTypeArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblTypeArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTypeArmas.setText("Type:");
        lblTypeArmas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTypeArmas.setOpaque(true);

        lblDamageArmas.setBackground(new java.awt.Color(102, 102, 102));
        lblDamageArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblDamageArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblDamageArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDamageArmas.setText("Damage:");
        lblDamageArmas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDamageArmas.setOpaque(true);

        lblFieldsArmas.setBackground(new java.awt.Color(102, 102, 102));
        lblFieldsArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblFieldsArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblFieldsArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFieldsArmas.setText("Fields:");
        lblFieldsArmas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFieldsArmas.setOpaque(true);

        lblAppearanceArmas.setBackground(new java.awt.Color(102, 102, 102));
        lblAppearanceArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblAppearanceArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblAppearanceArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppearanceArmas.setText("Appearance:");
        lblAppearanceArmas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAppearanceArmas.setOpaque(true);

        lblRangeArmas.setBackground(new java.awt.Color(102, 102, 102));
        lblRangeArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        lblRangeArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblRangeArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRangeArmas.setText("Range:");
        lblRangeArmas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRangeArmas.setOpaque(true);

        txtFldImageArmas1.setBackground(new java.awt.Color(153, 153, 153));
        txtFldImageArmas1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldImageArmas2.setBackground(new java.awt.Color(153, 153, 153));
        txtFldImageArmas2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldDamageArmas.setBackground(new java.awt.Color(153, 153, 153));
        txtFldDamageArmas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldLifeArmas.setBackground(new java.awt.Color(153, 153, 153));
        txtFldLifeArmas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldFieldsArmas.setBackground(new java.awt.Color(153, 153, 153));
        txtFldFieldsArmas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldAppearanceArmas.setBackground(new java.awt.Color(153, 153, 153));
        txtFldAppearanceArmas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldRangeArmas.setBackground(new java.awt.Color(153, 153, 153));
        txtFldRangeArmas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFldNameArmas.setBackground(new java.awt.Color(153, 153, 153));
        txtFldNameArmas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFldNameArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldNameArmasActionPerformed(evt);
            }
        });

        cmbBxTypeArmas.setBackground(new java.awt.Color(153, 153, 153));
        cmbBxTypeArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        cmbBxTypeArmas.setForeground(new java.awt.Color(255, 255, 255));
        cmbBxTypeArmas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "De Contacto", "Mediano Alcance", "Aereos", "Impacto", "Ataque Multiple" }));
        cmbBxTypeArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBxTypeArmasActionPerformed(evt);
            }
        });

        lblArmasImageOutput2.setBackground(new java.awt.Color(204, 204, 255));
        lblArmasImageOutput2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblArmasImageOutput2.setOpaque(true);

        btnCrearArmas.setBackground(new java.awt.Color(102, 102, 102));
        btnCrearArmas.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btnCrearArmas.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearArmas.setText("Crear");
        btnCrearArmas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearArmasActionPerformed(evt);
            }
        });

        txtFldAlertaNameArma.setEditable(false);
        txtFldAlertaNameArma.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaNameArma.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaNameArma.setText("Esta arma ya se encuentra almacenada");
        txtFldAlertaNameArma.setBorder(null);

        txtFldAlertaImageArma1.setEditable(false);
        txtFldAlertaImageArma1.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaImageArma1.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaImageArma1.setText("Imagen no encontrada");
        txtFldAlertaImageArma1.setBorder(null);

        txtFldAlertaImageArma2.setEditable(false);
        txtFldAlertaImageArma2.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaImageArma2.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaImageArma2.setText("Imagen no encontrada");
        txtFldAlertaImageArma2.setBorder(null);

        txtFldAlertaLifeArma.setEditable(false);
        txtFldAlertaLifeArma.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaLifeArma.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaLifeArma.setBorder(null);
        txtFldAlertaLifeArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldAlertaLifeArmaActionPerformed(evt);
            }
        });

        txtFldAlertaDamageArma.setEditable(false);
        txtFldAlertaDamageArma.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaDamageArma.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaDamageArma.setBorder(null);
        txtFldAlertaDamageArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldAlertaDamageArmaActionPerformed(evt);
            }
        });

        txtFldAlertaFieldsArma.setEditable(false);
        txtFldAlertaFieldsArma.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaFieldsArma.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaFieldsArma.setBorder(null);

        txtFldAlertaAppearanceArma.setEditable(false);
        txtFldAlertaAppearanceArma.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaAppearanceArma.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaAppearanceArma.setBorder(null);

        txtFldAlertaRangeArma.setEditable(false);
        txtFldAlertaRangeArma.setBackground(new java.awt.Color(204, 204, 204));
        txtFldAlertaRangeArma.setForeground(new java.awt.Color(204, 0, 0));
        txtFldAlertaRangeArma.setBorder(null);

        javax.swing.GroupLayout pnlArmasLayout = new javax.swing.GroupLayout(pnlArmas);
        pnlArmas.setLayout(pnlArmasLayout);
        pnlArmasLayout.setHorizontalGroup(
            pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArmasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblNameArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldAlertaNameArma)
                    .addComponent(txtFldNameArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(pnlArmasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblArmasImageOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArmasImageOutput2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlArmasLayout.createSequentialGroup()
                        .addComponent(lblImageArmas1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFldImageArmas1)
                        .addGap(75, 75, 75))
                    .addGroup(pnlArmasLayout.createSequentialGroup()
                        .addComponent(txtFldAlertaImageArma1)
                        .addContainerGap())
                    .addGroup(pnlArmasLayout.createSequentialGroup()
                        .addComponent(lblImageArmas2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldImageArmas2)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlArmasLayout.createSequentialGroup()
                        .addComponent(txtFldAlertaImageArma2)
                        .addContainerGap())
                    .addGroup(pnlArmasLayout.createSequentialGroup()
                        .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFldAlertaRangeArma, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlArmasLayout.createSequentialGroup()
                                .addComponent(lblFieldsArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldFieldsArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFldAlertaDamageArma, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlArmasLayout.createSequentialGroup()
                                .addComponent(lblDamageArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFldDamageArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlArmasLayout.createSequentialGroup()
                                .addComponent(lblTypeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbBxTypeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFldAlertaLifeArma, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlArmasLayout.createSequentialGroup()
                                .addComponent(lblLifeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldLifeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlArmasLayout.createSequentialGroup()
                                .addComponent(lblAppearanceArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFldAppearanceArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlArmasLayout.createSequentialGroup()
                                .addComponent(lblRangeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldRangeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFldAlertaFieldsArma, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                            .addComponent(txtFldAlertaAppearanceArma))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnlArmasLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnCrearArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlArmasLayout.setVerticalGroup(
            pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArmasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameArmas)
                    .addComponent(txtFldNameArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFldAlertaNameArma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlArmasLayout.createSequentialGroup()
                        .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblImageArmas1)
                            .addComponent(txtFldImageArmas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldAlertaImageArma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImageArmas2)
                            .addComponent(txtFldImageArmas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldAlertaImageArma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLifeArmas)
                            .addComponent(txtFldLifeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblArmasImageOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(txtFldAlertaLifeArma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBxTypeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTypeArmas))
                .addGap(17, 17, 17)
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDamageArmas)
                    .addComponent(txtFldDamageArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlArmasLayout.createSequentialGroup()
                        .addComponent(txtFldAlertaDamageArma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFieldsArmas)
                            .addComponent(txtFldFieldsArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldAlertaFieldsArma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppearanceArmas)
                            .addComponent(txtFldAppearanceArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblArmasImageOutput2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFldAlertaAppearanceArma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRangeArmas)
                    .addComponent(txtFldRangeArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFldAlertaRangeArma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnCrearArmas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbdPnCrearComponente.addTab("Armas", pnlArmas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbdPnCrearComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 464, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbdPnCrearComponente)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBxTypeArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBxTypeArmasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBxTypeArmasActionPerformed

    private void txtFldNameArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldNameArmasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldNameArmasActionPerformed

    private void txtFldAlertaLifeArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldAlertaLifeArmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldAlertaLifeArmaActionPerformed

    private void txtFldAlertaDamageArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldAlertaDamageArmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldAlertaDamageArmaActionPerformed

    private void txtFldNameZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldNameZombieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldNameZombieActionPerformed

    private void txtFldAlertaLifeZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldAlertaLifeZombieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldAlertaLifeZombieActionPerformed

    private void cmbBxTypeZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBxTypeZombieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBxTypeZombieActionPerformed

    private void txtFldAlertaDamageZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldAlertaDamageZombieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldAlertaDamageZombieActionPerformed

    private void txtFldNameBloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldNameBloquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldNameBloquesActionPerformed

    private void txtFldAlertaLifeBloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldAlertaLifeBloquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldAlertaLifeBloquesActionPerformed

    private void btnCrearArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearArmasActionPerformed
        
        this.txtFldAlertaAppearanceArma.setText("");
        this.txtFldAlertaDamageArma.setText("");
        this.txtFldAlertaFieldsArma.setText("");
        this.txtFldAlertaLifeArma.setText("");
        this.txtFldAlertaImageArma1.setText("");
        this.txtFldAlertaImageArma2.setText("");
        this.txtFldAlertaNameArma.setText("");
        this.txtFldAlertaRangeArma.setText("");
        
        if (verificarDatos(2) == 0){
            obtenerDatosArma();
        } else{
            System.out.println("NO SE PUDOOO INGRESAR EL ARMAAA :<<<");
        }
    }//GEN-LAST:event_btnCrearArmasActionPerformed

    private void btnCrearZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearZombieActionPerformed
        
        this.txtFldAlertaAppearanceZombie.setText("");
        this.txtFldAlertaDamageZombie.setText("");
        this.txtFldAlertaFieldsZombie.setText("");
        this.txtFldAlertaLifeZombie.setText("");
        this.txtFldAlertaImageZombie1.setText("");
        this.txtFldAlertaImageZombie2.setText("");
        this.txtFldAlertaNameZombie.setText("");
        this.txtFldAlertaRangeZombie.setText("");        
        
        if (verificarDatos(1) == 0){
            obtenerDatosZombie();
        } else{
            System.out.println("NO SE PUDOOOO INGRESAR EL ZOMBIEEE :<");
        }
    }//GEN-LAST:event_btnCrearZombieActionPerformed

    private void btnCrearBloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBloquesActionPerformed
        
        this.txtFldAlertaAppearanceBloques.setText("");
        this.txtFldAlertaFieldsBloques.setText("");
        this.txtFldAlertaLifeBloques.setText("");
        this.txtFldAlertaImageBloques1.setText("");
        this.txtFldAlertaImageBloques2.setText("");
        this.txtFldAlertaNameBloques.setText("");      
        
        if (verificarDatos(3) == 0){
            obtenerDatosBloque();
        } else{
            System.out.println("NO SE PUDOOOO INGRESAR EL BLOQUEEEE :<");
        }
    }//GEN-LAST:event_btnCrearBloquesActionPerformed

    private void txtFldAlertaNameBloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldAlertaNameBloquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldAlertaNameBloquesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CrearComponentes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearArmas;
    private javax.swing.JButton btnCrearBloques;
    private javax.swing.JButton btnCrearZombie;
    private javax.swing.JComboBox<String> cmbBxTypeArmas;
    private javax.swing.JComboBox<String> cmbBxTypeZombie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAppearanceArmas;
    private javax.swing.JLabel lblAppearanceBloques;
    private javax.swing.JLabel lblAppearanceZombie;
    private javax.swing.JLabel lblArmasImageOutput1;
    private javax.swing.JLabel lblArmasImageOutput2;
    private javax.swing.JLabel lblBloquesImageOutput1;
    private javax.swing.JLabel lblBloquesImageOutput2;
    private javax.swing.JLabel lblDamageArmas;
    private javax.swing.JLabel lblDamageZombie;
    private javax.swing.JLabel lblFieldsArmas;
    private javax.swing.JLabel lblFieldsBloques;
    private javax.swing.JLabel lblFieldsZombie;
    private javax.swing.JLabel lblImageArmas1;
    private javax.swing.JLabel lblImageArmas2;
    private javax.swing.JLabel lblImageBloques1;
    private javax.swing.JLabel lblImageBloques2;
    private javax.swing.JLabel lblImageZombie1;
    private javax.swing.JLabel lblImageZombie2;
    private javax.swing.JLabel lblLifeArmas;
    private javax.swing.JLabel lblLifeBloques;
    private javax.swing.JLabel lblLifeZombie;
    private javax.swing.JLabel lblNameArmas;
    private javax.swing.JLabel lblNameBloques;
    private javax.swing.JLabel lblNameZombie;
    private javax.swing.JLabel lblRangeArmas;
    private javax.swing.JLabel lblRangeZombie;
    private javax.swing.JLabel lblTypeArmas;
    private javax.swing.JLabel lblTypeZombie;
    private javax.swing.JLabel lblZombieImageOutput1;
    private javax.swing.JLabel lblZombieImageOutput2;
    private javax.swing.JPanel pnlArmas;
    private javax.swing.JPanel pnlBloque;
    private javax.swing.JPanel pnlZombie;
    private javax.swing.JTabbedPane tbdPnCrearComponente;
    private javax.swing.JTextField txtFldAlertaAppearanceArma;
    private javax.swing.JTextField txtFldAlertaAppearanceBloques;
    private javax.swing.JTextField txtFldAlertaAppearanceZombie;
    private javax.swing.JTextField txtFldAlertaDamageArma;
    private javax.swing.JTextField txtFldAlertaDamageZombie;
    private javax.swing.JTextField txtFldAlertaFieldsArma;
    private javax.swing.JTextField txtFldAlertaFieldsBloques;
    private javax.swing.JTextField txtFldAlertaFieldsZombie;
    private javax.swing.JTextField txtFldAlertaImageArma1;
    private javax.swing.JTextField txtFldAlertaImageArma2;
    private javax.swing.JTextField txtFldAlertaImageBloques1;
    private javax.swing.JTextField txtFldAlertaImageBloques2;
    private javax.swing.JTextField txtFldAlertaImageZombie1;
    private javax.swing.JTextField txtFldAlertaImageZombie2;
    private javax.swing.JTextField txtFldAlertaLifeArma;
    private javax.swing.JTextField txtFldAlertaLifeBloques;
    private javax.swing.JTextField txtFldAlertaLifeZombie;
    private javax.swing.JTextField txtFldAlertaNameArma;
    private javax.swing.JTextField txtFldAlertaNameBloques;
    private javax.swing.JTextField txtFldAlertaNameZombie;
    private javax.swing.JTextField txtFldAlertaRangeArma;
    private javax.swing.JTextField txtFldAlertaRangeZombie;
    private javax.swing.JTextField txtFldAppearanceArmas;
    private javax.swing.JTextField txtFldAppearanceBloques;
    private javax.swing.JTextField txtFldAppearanceZombie;
    private javax.swing.JTextField txtFldDamageArmas;
    private javax.swing.JTextField txtFldDamageZombie;
    private javax.swing.JTextField txtFldFieldsArmas;
    private javax.swing.JTextField txtFldFieldsBloques;
    private javax.swing.JTextField txtFldFieldsZombie;
    private javax.swing.JTextField txtFldImageArmas1;
    private javax.swing.JTextField txtFldImageArmas2;
    private javax.swing.JTextField txtFldImageBloques1;
    private javax.swing.JTextField txtFldImageBloques2;
    private javax.swing.JTextField txtFldImageZombie1;
    private javax.swing.JTextField txtFldImageZombie2;
    private javax.swing.JTextField txtFldLifeArmas;
    private javax.swing.JTextField txtFldLifeBloques;
    private javax.swing.JTextField txtFldLifeZombie;
    private javax.swing.JTextField txtFldNameArmas;
    private javax.swing.JTextField txtFldNameBloques;
    private javax.swing.JTextField txtFldNameZombie;
    private javax.swing.JTextField txtFldRangeArmas;
    private javax.swing.JTextField txtFldRangeZombie;
    // End of variables declaration//GEN-END:variables
}
