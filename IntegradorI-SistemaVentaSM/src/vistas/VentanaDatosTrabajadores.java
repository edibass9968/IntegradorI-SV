package vistas;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import modelo.PersonalDAO;
import modelo.Personal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaDatosTrabajadores extends javax.swing.JInternalFrame {

    List<Personal> personal;
    PersonalDAO personaldao = new PersonalDAO();
    DefaultTableModel modelo;

    public VentanaDatosTrabajadores() {
        initComponents();
        llenarDatos();
        PropiedadInicio();
    }

    private void PropiedadInicio() {
        jlblBtnModifique.setEnabled(false);
        jlblBtnElimine.setEnabled(false);
        jlblBtnRegistre.setEnabled(false);
    }

    private void llenarDatos() {
        // Cargando los registros de la base de datos
        personal = personaldao.seleccionar();

        // Inicio de tabla
        InicioTabla();

        // recorriendo el array;
        for (Personal persona : personal) {
            String nombre = persona.getNomPerso() + " " + persona.getApePerso();
            String dni = persona.getDniPerso();
            String tipo = (persona.getIdTipoPer() == 1) ? "Administrador" : "Empleado";

            modelo.addRow(new Object[]{nombre, dni, tipo});
        }

        jtblPersonal.setModel(modelo);
    }

    private void InicioTabla() {
        String titulos[] = {"Nombre Completo", "DNI", "Tipo de Personal"};

        // Modelo de tabla - para que no pueda editar el usuario en la tabla
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {

                if (column == 3) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        modelo.setRowCount(0);
    }

    private void BusquedaTabla(Personal person) {

        // Recorriendo el array;
        String nombre = person.getNomPerso() + " " + person.getApePerso();
        String dni = person.getDniPerso();
        String tipo = (person.getIdTipoPer() == 1) ? "Administrador" : "Empleado";

        modelo.addRow(new Object[]{nombre, dni, tipo});

        jtblPersonal.setModel(modelo);
    }

    private void TextsBlanco() {
        jtxtNombre.setText("");
        jtxtApellidos.setText("");
        jtxtDNI.setText("");
        jtxtDireccion.setText("");
        jtxtEmail.setText("");
        jtxtTelefono.setText("");
        jtxtUsuario.setText("");
        jtxtPassword.setText("");
        jcbxTipo.setSelectedIndex(0);
    }

    private Personal RecogerDatos() {
        String nombre = jtxtNombre.getText();
        String apellido = jtxtApellidos.getText();
        String dni = jtxtDNI.getText();
        String direccion = jtxtDireccion.getText();
        String email = jtxtEmail.getText();
        String telefono = jtxtTelefono.getText();
        String usuario = jtxtUsuario.getText();
        String password = jtxtPassword.getText();
        int tipo = jcbxTipo.getSelectedIndex() + 1;

        Personal persona = new Personal(nombre, apellido, dni, direccion, email, telefono, usuario, password, tipo);

        return persona;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPersonal = new javax.swing.JTable();
        jlblNombre1 = new javax.swing.JLabel();
        jcbxCategoria = new javax.swing.JComboBox<>();
        jtxtBusqueda = new javax.swing.JTextField();
        jlblNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbxTipo = new javax.swing.JComboBox<>();
        jtxtUsuario = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jtxtApellidos = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JTextField();
        jtxtTelefono = new javax.swing.JTextField();
        jtxtDireccion = new javax.swing.JTextField();
        jtxtDNI = new javax.swing.JTextField();
        jlblLupa = new javax.swing.JLabel();
        jlblBtnNuevo = new javax.swing.JLabel();
        jlblBtnRegistre = new javax.swing.JLabel();
        jlblBtnModifique = new javax.swing.JLabel();
        jlblBtnElimine = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("TRABAJADORES");
        setMinimumSize(new java.awt.Dimension(800, 652));
        setPreferredSize(new java.awt.Dimension(800, 652));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblPersonal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Completo", "DNI", "Tipo de Personal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtblPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblPersonal);
        if (jtblPersonal.getColumnModel().getColumnCount() > 0) {
            jtblPersonal.getColumnModel().getColumn(0).setResizable(false);
            jtblPersonal.getColumnModel().getColumn(1).setResizable(false);
            jtblPersonal.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 58, 741, 200));

        jlblNombre1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblNombre1.setForeground(new java.awt.Color(0, 0, 0));
        jlblNombre1.setText("Categoría");
        jPanel1.add(jlblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 12, -1, -1));

        jcbxCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Datos Personales", "DNI" }));
        jPanel1.add(jcbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 7, 152, -1));

        jtxtBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jtxtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 8, 126, -1));

        jlblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblNombre.setForeground(new java.awt.Color(0, 0, 0));
        jlblNombre.setText("Nombres");
        jPanel1.add(jlblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellidos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Usuario");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tipo Personal");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, -1, -1));

        jcbxTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));
        jPanel1.add(jcbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 160, -1));

        jtxtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 160, -1));

        jtxtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jtxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 160, -1));

        jtxtApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtApellidosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtApellidosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtApellidosKeyTyped(evt);
            }
        });
        jPanel1.add(jtxtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 160, -1));

        jtxtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreActionPerformed(evt);
            }
        });
        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DNI");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Dirección");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Telefono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

        jtxtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jtxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 160, -1));

        jtxtTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(jtxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 160, -1));

        jtxtDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 160, -1));

        jtxtDNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDNIKeyTyped(evt);
            }
        });
        jPanel1.add(jtxtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 160, -1));

        jlblLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        jlblLupa.setAlignmentX(0.5F);
        jlblLupa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblLupa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblLupaMouseClicked(evt);
            }
        });
        jPanel1.add(jlblLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, 29));

        jlblBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON NUEVO.png"))); // NOI18N
        jlblBtnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblBtnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBtnNuevoMouseClicked(evt);
            }
        });
        jPanel1.add(jlblBtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, 50));

        jlblBtnRegistre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON REGISTRAR.png"))); // NOI18N
        jlblBtnRegistre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblBtnRegistre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBtnRegistreMouseClicked(evt);
            }
        });
        jPanel1.add(jlblBtnRegistre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 160, 50));

        jlblBtnModifique.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON MODIFICAR.png"))); // NOI18N
        jlblBtnModifique.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblBtnModifique.setMaximumSize(new java.awt.Dimension(162, 56));
        jlblBtnModifique.setMinimumSize(new java.awt.Dimension(162, 56));
        jlblBtnModifique.setPreferredSize(new java.awt.Dimension(162, 56));
        jlblBtnModifique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBtnModifiqueMouseClicked(evt);
            }
        });
        jPanel1.add(jlblBtnModifique, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, -1, 50));

        jlblBtnElimine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON ELIMINAR.png"))); // NOI18N
        jlblBtnElimine.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblBtnElimine.setMaximumSize(new java.awt.Dimension(162, 56));
        jlblBtnElimine.setMinimumSize(new java.awt.Dimension(162, 56));
        jlblBtnElimine.setPreferredSize(new java.awt.Dimension(162, 56));
        jlblBtnElimine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBtnElimineMouseClicked(evt);
            }
        });
        jPanel1.add(jlblBtnElimine, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, 150, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        // Llenar la tabla de datos 
        llenarDatos();
    }//GEN-LAST:event_formMouseClicked

    private void jlblBtnElimineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBtnElimineMouseClicked
        // TODO add your handling code here:
        // Obtener los datos de los texts y recogiendo datos

        Personal persona = RecogerDatos();
        // Comprobando registro
        for (Personal person : personal) {
            if (person.getDniPerso().equalsIgnoreCase(persona.getDniPerso())) {
                persona.setIdPerso(person.getIdPerso());
            }
        }

        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario?", "Eliminar usuario", dialog);
        if (result == 0) {
            personaldao.delete(persona);
            llenarDatos();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }
    }//GEN-LAST:event_jlblBtnElimineMouseClicked

    private void jlblBtnModifiqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBtnModifiqueMouseClicked

        // Obtener los datos de los texts y recogiendo datos
        Personal persona = RecogerDatos();
        // Comprobando registro
        for (Personal person : personal) {
            if (person.getDniPerso().equalsIgnoreCase(persona.getDniPerso())) {
                persona.setIdPerso(person.getIdPerso());
            }
        }

        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea modificar el usuario?", "Modificar usuario", dialog);
        if (result == 0) {
            personaldao.update(persona);
            llenarDatos();
            JOptionPane.showMessageDialog(null, "Modificado correctamente");
        }
    }//GEN-LAST:event_jlblBtnModifiqueMouseClicked

    private void jlblBtnRegistreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBtnRegistreMouseClicked

        // Recoger los datos de los text field y creando objeto
        Personal persona = RecogerDatos();

        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea registrar el usuario?", "Registro de usuario", dialog);
        if (result == 0) {
            int bandera = personaldao.insertar(persona);
            llenarDatos();
            if (bandera > 0) {
                JOptionPane.showMessageDialog(null, "Registrado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "DNI o USUARIO ya existen");
            }
        }

    }//GEN-LAST:event_jlblBtnRegistreMouseClicked

    private void jlblBtnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBtnNuevoMouseClicked
        // TODO add your handling code here:
        TextsBlanco();
        jlblBtnRegistre.setEnabled(true);
        jlblBtnModifique.setEnabled(false);
        jlblBtnElimine.setEnabled(false);

        jtxtNombre.requestFocus();
    }//GEN-LAST:event_jlblBtnNuevoMouseClicked

    private void jlblLupaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblLupaMouseClicked

        // Recoger el texto de busqueda
        String busqueda = jtxtBusqueda.getText();
        int categoria = jcbxCategoria.getSelectedIndex(); // Comienza de 0

        //escapar y agregar limites de palabra completa - case-insensitive
        Pattern regex = Pattern.compile("\\b" + Pattern.quote(busqueda) + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher match;

        // Categoria 0 : Datos personales y 1 : DNI
        if (categoria == 0) {
            InicioTabla();
            for (Personal person : personal) {
                String nombre = person.getNomPerso() + " " + person.getApePerso();
                match = regex.matcher(nombre);
                if (match.find()) {
                    System.out.println(nombre);
                    BusquedaTabla(person);
                }
            }
        } else {
            InicioTabla();
            for (Personal person : personal) {
                String dni = person.getDniPerso();
                if (dni.contains(busqueda)) {
                    BusquedaTabla(person);
                }
            }
        }
    }//GEN-LAST:event_jlblLupaMouseClicked

    private void jtxtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDNIKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        //EL 8 ES LA CANTIDAD MAX. DE CARÁCTERES PERMITIDOS
        if (jtxtDNI.getText().trim().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtDNIKeyTyped

    private void jtxtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDireccionKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jtxtDireccionKeyTyped

    private void jtxtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTelefonoKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        //Limite para poder ingresar max. 9 dígitos
        if (jtxtTelefono.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtTelefonoKeyTyped

    private void jtxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyTyped
        // TODO add your handling code here:
        Character letra = evt.getKeyChar();
        char numero = evt.getKeyChar();

        if (Character.isLetter(letra) || (evt.getKeyChar() == KeyEvent.VK_SPACE)
            || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (evt.getKeyChar() == KeyEvent.VK_MINUS)
            || !(evt.getKeyChar() == KeyEvent.VK_PAGE_DOWN)) {
            evt.setKeyChar(Character.toUpperCase(letra));
        } else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if (Character.isDigit(numero)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if (jtxtNombre.getText().length() >= 25) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_jtxtNombreKeyTyped

    private void jtxtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyReleased
        // TODO add your handling code here:
        jtxtNombre.setText(jtxtNombre.getText().toUpperCase());
    }//GEN-LAST:event_jtxtNombreKeyReleased

    private void jtxtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidosKeyTyped
        // TODO add your handling code here:
        Character letra = evt.getKeyChar();
        char numero = evt.getKeyChar();

        if (Character.isLetter(letra) || (evt.getKeyChar() == KeyEvent.VK_SPACE)
            || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (evt.getKeyChar() == KeyEvent.VK_MINUS)
            || !(evt.getKeyChar() == KeyEvent.VK_PAGE_DOWN)) {
            evt.setKeyChar(Character.toUpperCase(letra));
        } else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if (Character.isDigit(numero)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if (jtxtApellidos.getText().length() >= 25) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_jtxtApellidosKeyTyped

    private void jtxtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidosKeyReleased
        // TODO add your handling code here:
        jtxtApellidos.setText(jtxtApellidos.getText().toUpperCase());
    }//GEN-LAST:event_jtxtApellidosKeyReleased

    private void jtxtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtApellidosKeyPressed

    private void jtxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtUsuarioActionPerformed

    private void jtblPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblPersonalMouseClicked

        // Opcion elegida de la tabla
        int opcion = jtblPersonal.rowAtPoint(evt.getPoint());
        // Dato a muestrear con DNI
        String dni = String.valueOf(jtblPersonal.getValueAt(opcion, 1));

        for (Personal person : personal) {
            if (dni.equalsIgnoreCase(person.getDniPerso())) {
                // Setear los valores en los textfield
                jtxtNombre.setText(person.getNomPerso());
                jtxtApellidos.setText(person.getApePerso());
                jtxtDNI.setText(person.getDniPerso());
                jtxtDireccion.setText(person.getDirecPerso());
                jtxtEmail.setText(person.getEmailPerso());
                jtxtTelefono.setText(person.getFonoPerso());
                jtxtUsuario.setText(person.getUsuPerso());
                jtxtPassword.setText(person.getPassPerso());
                jcbxTipo.setSelectedIndex(person.getIdTipoPer() - 1);
            }
        }

        jlblBtnModifique.setEnabled(true);
        jlblBtnElimine.setEnabled(true);
        jlblBtnRegistre.setEnabled(false);
    }//GEN-LAST:event_jtblPersonalMouseClicked

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbxCategoria;
    private javax.swing.JComboBox<String> jcbxTipo;
    private javax.swing.JLabel jlblBtnElimine;
    private javax.swing.JLabel jlblBtnModifique;
    private javax.swing.JLabel jlblBtnNuevo;
    private javax.swing.JLabel jlblBtnRegistre;
    private javax.swing.JLabel jlblLupa;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblNombre1;
    private javax.swing.JTable jtblPersonal;
    private javax.swing.JTextField jtxtApellidos;
    private javax.swing.JTextField jtxtBusqueda;
    private javax.swing.JTextField jtxtDNI;
    private javax.swing.JTextField jtxtDireccion;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPassword;
    private javax.swing.JTextField jtxtTelefono;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}
