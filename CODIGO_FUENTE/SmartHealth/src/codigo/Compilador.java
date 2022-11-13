package codigo;

import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private ArrayList<Production> identProdFun;
    private ArrayList<Production> identProdOp;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "SMARTH HEALTH";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".smhe");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identProdFun = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnEjecutar = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(188, 228, 233));
        rootPanel.setAlignmentX(0.0F);
        rootPanel.setAlignmentY(0.0F);

        buttonsFilePanel.setBackground(new java.awt.Color(155, 202, 212));
        buttonsFilePanel.setAlignmentX(0.0F);
        buttonsFilePanel.setAlignmentY(0.0F);

        btnAbrir.setBackground(new java.awt.Color(155, 202, 212));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrirArchivo.png"))); // NOI18N
        btnAbrir.setBorder(null);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(155, 202, 212));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoArchivo.png"))); // NOI18N
        btnNuevo.setBorder(null);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(155, 202, 212));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarArchivo.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setBackground(new java.awt.Color(155, 202, 212));
        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarComoArchivo.png"))); // NOI18N
        btnGuardarC.setBorder(null);
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnAbrir)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarC)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbrir)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC)
                    .addComponent(btnNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpCode.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jtpCode);

        panelButtonCompilerExecute.setBackground(new java.awt.Color(155, 202, 212));
        panelButtonCompilerExecute.setAlignmentX(0.0F);

        btnEjecutar.setBackground(new java.awt.Color(155, 202, 212));
        btnEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/correrArchivo.png"))); // NOI18N
        btnEjecutar.setBorder(null);
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        btnCompilar.setBackground(new java.awt.Color(155, 202, 212));
        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compilarArchivo.png"))); // NOI18N
        btnCompilar.setBorder(null);
        btnCompilar.setBorderPainted(false);
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjecutar)
                .addGap(18, 18, 18))
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        jLabel1.setBackground(new java.awt.Color(188, 228, 233));
        jLabel1.setFont(new java.awt.Font("Roboto Bk", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 64, 79));
        jLabel1.setText("Consola");

        jLabel3.setFont(new java.awt.Font("Roboto Bk", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 64, 79));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menuLogo.png"))); // NOI18N
        jLabel3.setText("Smarth Health");

        jPanel1.setBackground(new java.awt.Color(155, 202, 212));

        jLabel2.setFont(new java.awt.Font("Roboto Bk", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 64, 79));
        jLabel2.setText("Lexemas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(rootPanelLayout.createSequentialGroup()
                            .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel3)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);

        /* Mostrar gramáticas */
        gramatica.delete(new String[]{"ERROR", "ERROR_1", "ERROR_2", "ERROR_3"}, 1);//ELIMINACION Y RESALTO DE ERRORES

        //Aqui empezamos con las producciones
        /*agrupacion de valores*/
        gramatica.group("VALOR", "( Numero | Numero_Decimal | Texto | Caracter )", true);
        gramatica.group("TIPO_DATO", "( Int | Float | Logic | str | Char )", true);
        //gramatica.group("OPAR", "( VALOR | identificador )", true);

        /**
         * Operaciones Aritmeticas*
         */
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("OpAritmetico", "( VALOR | identificador ) Aritmetico ( VALOR | identificador ) ", true);
            gramatica.group("OpAritmetico", "(OpAritmetico | VALOR | identificador )+ Aritmetico (OpAritmetico | VALOR | identificador )+ ", true,identProdOp);
        });

        //Agrupacion de variables String
        //gramatica.group("VARIABLE","identificador Declare As str Asignacion Texto ",true);
        // Agrupacion de asignacion de variables
        gramatica.group("VARIABLE", "(identificador Declare As TIPO_DATO Asignacion (VALOR | OpAritmetico) ) |  "
                + "(identificador Asignacion (VALOR | OpAritmetico) ) | (identificador Declare As TIPO_DATO)", identProd);
        // gramatica.group("VARIABLE", "identificador Asignacion VALOR", identProd);
        // gramatica.group("VARIABLE", "identificador Declare As TIPO_DATO ", identProd);

        gramatica.group("VARIABLE", "identificador Declare As TIPO_DATO Asignacion  ", true, 2, " ERROR SINTACTICO {}: FALTA VALOR [#, %]");

        gramatica.finalLineColumn();

        gramatica.group("VARIABLE", "identificador  TIPO_DATO Asignacion VALOR ", 3, " ERROR SINTACTICO {}: FALTAN PALABRAS RESERVADAS DECLARE AS [#, %]");

        gramatica.initialLineColumn();

        //Ponerle sus errores a esta **********
        gramatica.group("EXP_REL", " (VALOR | identificador) Op_Relacional (VALOR | identificador) ", true, identProd);
        //Ponerle sus errores a esta **********

        /**
         * MUCHO OJO CUATE*
         *
         */
        /*Eliminacion de tipos de dato y operadores de asignacion*/
        gramatica.delete("VALOR", 4, "Error Sintactico {}: NUMERO FUERA DE ASIGNACION [#, %]");
        gramatica.delete("Asignacion", 5, "Error Sintactico {}: ASIGNACION DE VARIABLE INCORRECTA [#, %]");

        /* AGRUPACION PARA PARAMETROS */
        gramatica.group("VALOR", "identificador", true);
        gramatica.group("PARAMETROS", "( VALOR | Op_Booleano) (Coma (VALOR | Op_Booleano))*");

        /*AGRUPACION DE FUNCIONES =========================================*/
        gramatica.group("FUNCIONES", "( Ventilate | admit | EmptyRoom | Dispense "
                + " | Distance | DeviceControl | DriverLights | OpenDoor "
                + "| RegisterA | Exit )", true);

        //FUNCIONES_COMP identProdFun
        gramatica.group("FUNCIONES_COMP", "FUNCIONES Parentesis_a ( VALOR | PARAMETROS )+ Parentesis_c", true, identProdFun);

        gramatica.group("FUNCIONES_COMP", "FUNCIONES ", true, 6, ""
                + "ERROR SINTACTICO {}: FALTO CERRAR PARENTESIS DE LA FUNCION [#,%]");

        gramatica.finalLineColumn();
        gramatica.group("FUNCIONES_COMP", "FUNCIONES  ( VALOR | PARAMETROS )* Parentesis_c", true, 7, ""
                + "ERROR SINTACTICO {}: FALTO EL PARENTESIS DE LA FUNCION [#,%]");

        gramatica.group("FUNCIONES_COMP", "FUNCIONES  Parentesis_a Parentesis_c", true, 20, ""
                + "ERROR SINTACTICO {}: LAS FUNCIONES DEBEN LLEVAR PARAMETROS [#,%]");
        gramatica.initialLineColumn();

        /*AGRUPACION DE FUNCIONES =========================================*/
        //delete FUNCION 
        gramatica.delete("FUNCIONES", 8, "ERROR SINTACTICO {} LA FUNCION "
                + "NO ESTA DECLARADA CORRECTAMENTE [#,%]");

        /*Expresiones logicas*/
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EXPRESION_LOG", "(FUNCIONES_COMP | EXPRESION_LOG | EXP_REL) (Op_Logico (FUNCIONES_COMP | EXPRESION_LOG | EXP_REL))+");
            gramatica.group("EXPRESION_LOG", "Parentesis_a ( EXPRESION_LOG | FUNCIONES_COMP | EXP_REL) Parentesis_c");
        });

        //ELIMINACION DE OPERADORES LOGICOS******
        gramatica.initialLineColumn();
        gramatica.delete("Op_Logico", 9, "ERROR SINTACTICO {} LA OPERACION LOGICA NO ES VALIDA [#,%] ");

        /*Agrupacion de expresiones logicas como valor y parametro*/
        gramatica.group("VALOR", "EXPRESION_LOG");
        gramatica.group("PARAMETROS", "VALOR (Coma VALOR)*");

        /**
         * ESTRUCTURAS DE CONTROL*
         */
        gramatica.group("CICLOS", " ( Condition | For | While ) ");
        gramatica.group("CICLOS_COMP", "CICLOS  (VALOR | PARAMETROS)  ");
        gramatica.group("CICLOS_COMP", "CICLOS Parentesis_a (VALOR | PARAMETROS) Parentesis_c ");

        gramatica.delete("CICLOS", 10, "ERROR SINTACTICO {} EL CICLO NO ESTA BIEN DECLARADO [#,%]");

        gramatica.delete(new String[]{"Parentesis_a", "Parentesis_a"}, 17, "ERROR SINTACTICO {}: Los parentesis  no correspone a ninguna asignacion [#,%]");

        /**
         * PUNTOS Y COMAS *
         */
        gramatica.finalLineColumn();
        gramatica.group("VARIABLE_PC", "VARIABLE Punto_Coma", true);
        gramatica.group("VARIABLE_PC", "VARIABLE ", true, 11, "ERROR SINTACTICO {} FALTA PUNTO Y COMA [#,%]");

        gramatica.group("OpAritmetico_PC", "OpAritmetico Punto_Coma", true);
        gramatica.group("OpAritmetico_PC", "OpAritmetico ", true, 20, "ERROR SINTACTICO {} FALTA PUNTO Y COMA [#,%]");

        gramatica.group("FUNCIONES_COMP_PC", "FUNCIONES_COMP Punto_Coma", true);
        gramatica.group("FUNCIONES_COMP_PC", "FUNCIONES_COMP ", true, 12, "ERROR SINTACTICO {} FALTA PUNTO Y COMA [#,%]");

        gramatica.initialLineColumn();
        gramatica.delete("Punto_Coma", 13, "ERROR SINTACTICO {} PUNTO Y COMA NO ESTA AL FINAL DE UNA SENTENCIA VALIDA [#,%]");

        /**
         * BLOQUES DE CODIGO*
         */
        gramatica.group("SENTENCIAS", "(FUNCIONES_COMP_PC | VARIABLE_PC | OpAritmetico_PC) +");

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("CICLOS_COMP_LLAVES", "CICLOS_COMP Llave_a (SENTENCIAS)? Llave_c", true);
            gramatica.group("SENTENCIAS", "(SENTENCIAS | CICLOS_COMP_LLAVES )+", true);
        });

        /**
         * BLOQUES DE CODIGO INCOMPLETOS*
         */
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("CICLOS_COMP_LLAVES", "CICLOS_COMP  (SENTENCIAS)? Llave_c", true, 14,
                    "ERROR SINTACTICO {}: Falta la llave de apertura del bloque ' [] ' [#,%]");
            gramatica.finalLineColumn();

            gramatica.group("CICLOS_COMP_LLAVES", "CICLOS_COMP Llave_a (SENTENCIAS)? ", true, 15,
                    "ERROR SINTACTICO {}: Falta la llave de cierre del bloque ' [] ' [#,%]");
            gramatica.group("SENTENCIAS", "(SENTENCIAS | CICLOS_COMP_LLAVES )", true);

        });

        /**
         * ESTRUCTURA PRINCIPAL DEL ARCHIVO*
         */
        /**
         * **************ARREGLAR**********************
         */
        gramatica.group("BLOQUE", "(SENTENCIAS | CICLOS_COMP_LLAVES)+", true);

        gramatica.group("MAIN", "Atlas Begin Llave_a (BLOQUE)* Llave_c", true);
        /**
         * Preevenimos por si agregan llaves sin bloque de codigo*
         */
        gramatica.delete(new String[]{"Llave_a", "Llave_c"}, 16, "ERROR SINTACTICO {}: La/s llave [] no correspone a ningun bloque [#,%]");

        //gramatica.delete("SENTENCIAS",17,"ERROR SINTACTICO {}: NO ESTAS DENTRO DE ATLAS [#,%]");
        /**
         * **************ARREGLAR**********************
         */
        /**
         * MOSTRAR GRAMATICAS*
         */
        gramatica.show();
    }

    private void semanticAnalysis() {
        /** OPERACIONES ARITMETICAS
         * 
         **/
        
        
        /** ASIGNACION DE VARIABLES
         * 
         **/
        HashMap< String, String> identDataType = new HashMap<>();
        identDataType.put("int", "Numero");
        identDataType.put("str", "Texto");
        identDataType.put("logic", "Op_Booleano");
        identDataType.put("float", "Numero_Decimal");
        identDataType.put("char", "Caracter");
        for (Production id : identProd) {
            if (id.getName().equals("VARIABLE")) {
                /**
                 * Recupera el tipo de token de la declaracion, lo busca si se
                 * encuentra en el mapa de tipos y compara el tipo de dato de la
                 * asignacion para ver si encaja con el valor del mapa
                 */
                if (id.getSizeTokens() == 6) {
                    if (!identDataType.get(id.lexemeRank(3)).equals(id.lexicalCompRank(-1))) {
                        errors.add(new ErrorLSSL(1, "ERROR SEMANTICO {}: "
                                + "VALOR NO COMPATIBLE CON EL TIPO DE DATO [#, %]", id, true));
                    } else {
                        identificadores.put(id.lexemeRank(0), id.lexemeRank(-1));
                    }
                } else if (id.getSizeTokens() == 4) {
                    identificadores.put(id.lexemeRank(0), id.lexemeRank(-1));
                } else if (id.getSizeTokens() == 3) {
                    if (!identificadores.containsKey(id.lexemeRank(0))) {
                        errors.add(new ErrorLSSL(5, "ERROR SEMANTICO {}: "
                                + "VARIABLE NO DECLARADA ANTES DE ASIGNACION [#, %]", id, true));
                        break;
                    }
                    if (!identDataType.get(identificadores.get(id.lexemeRank(0))).equals(id.lexicalCompRank(-1))) {
                        errors.add(new ErrorLSSL(1, "ERROR SEMANTICO {}: "
                                + "VALOR NO COMPATIBLE CON EL TIPO DE DATO [#, %]", id, true));
                        break;
                    }
                    identificadores.put(id.lexemeRank(0), id.lexemeRank(-1));
                }

            }
        }// Recorrer asignacion de variables
        /**
         * Analisis Semantico de las Funciones *
         */
        HashMap<String, ArrayList> identFun = new HashMap<>();
        identFun.put("exit", parametrosFun("Op_Booleano"));
        identFun.put("admit", parametrosFun("Op_Booleano", "Coma", "identificador", "Coma", "identificador"));
        identFun.put("ventilate", parametrosFun("Op_Booleano", "Coma", "Op_Booleano", "Coma", "identificador"));
        identFun.put("emptyRoom", parametrosFun("Op_Booleano", "Coma", "identificador", "Coma", "Op_Booleano", "Coma", "Op_Booleano"));
        identFun.put("dispense", parametrosFun("identificador"));
        identFun.put("distance", parametrosFun("identificador"));
        identFun.put("deviceControl", parametrosFun("identificador", "Coma", "Op_Booleano", "Coma", "identificador"));
        identFun.put("driverLights", parametrosFun("identificador", "Coma", "identificador"));
        identFun.put("openDoor", parametrosFun("identificador", "Coma", "identificador"));
        identFun.put("registerA", parametrosFun("identificador"));

        for (Production id : identProdFun) {//RECORRER FUNCIONES EN EL ARREGLO FOR PRINCIPAL
            String keyHash = id.lexemeRank(0);

            if (identFun.get(keyHash) == null) { //Buscamos en el mapa de funciones si existe la funcion que tenemos en el codigo
                errors.add(new ErrorLSSL(2, "ERROR SEMANTICO {}: "
                        + "Funcion no es valida en el lenguaje [#, %]", id, true));
            } else {//existe la regla semantica para la funcion
                if (identFun.get(keyHash).size() != (id.getSizeTokens() - 3)) { //Cantidad de parametros incorrectos
                    errors.add(new ErrorLSSL(3, "ERROR SEMANTICO {}: "
                            + "Cantidad de parametros no admitidos (Mas o menos de los necesarios) [#, %] "
                            + "Estructura Valida" + identFun.get(keyHash), id, true));
                } else { // Cantidad de parametros correctos
                    int i = 2;
                    for (Object TokenID : identFun.get(keyHash)) { // recorrer tokens  verificar que encajan con la clave del HashMap

                        if (!TokenID.equals(id.lexicalCompRank(i))) { //Verificar si valor es valido para la funcion
                            errors.add(new ErrorLSSL(4, "ERROR SEMANTICO {}: "
                                    + "Valor en la funcion no corresponde [#, %]"
                                    + "Estructura Valida" + identFun.get(keyHash), id, true));
                            break;
                        } else if (id.lexicalCompRank(i).equals("identificador") && (identificadores.get(id.lexemeRank(i))) == null) {
                            errors.add(new ErrorLSSL(5, "ERROR SEMANTICO {}: "
                                    + "Identificador no ha sido declarado [#, %]", id, true));
                            break;
                        }//Bloque Else IF detecta si el identificador ya fue declarado
                        i++;
                    }// ** FOR recorrer tokens  verificar que encajan con la clave del HashMap
                }// Cantidad de parametros correctos

            }//bloque de codigo ELSE para determinar si la semantica de la funcion esta bien cuando si esta en el mapa
            //existe la regla semantica para la funcion 

        }//RECORRER FUNCIONES EN EL ARREGLO FOR PRINCIPAL

    }//Funcion de analisis Semantico

    public ArrayList<String> parametrosFun(String... args) {
        ArrayList<String> temp = new ArrayList<String>();
        for (String arg : args) {
            temp.add(arg);
        }
        return temp;

    }// FUNCION PARA AGREGAR PARAMETROS DIFETENTES DE CADA FUNCION

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identProdFun.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
