/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.TipoMascota;
import modelo.TipoMascotaDAO;
/**
 *
 * @author JOSE
 */
public class TipoDeMascotaForm extends javax.swing.JInternalFrame {
    TipoMascotaDAO tipdao = new TipoMascotaDAO();
    TipoMascota tip = new TipoMascota();
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter trs;
    int id;

    public TipoDeMascotaForm() {
        initComponents();
  TransparenciaBoton();
        Listar();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnActualizar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBuscartipo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("TIPO DE MASCOTA");
        setPreferredSize(new java.awt.Dimension(624, 342));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 20, 40));

        btnActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON MODIFICAR.png"))); // NOI18N
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 150, 70));

        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON ELIMINAR.png"))); // NOI18N
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 150, 60));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 20, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("TIPO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 20));

        txtBuscartipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscartipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscartipoKeyTyped(evt);
            }
        });
        getContentPane().add(txtBuscartipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 20, 186, -1));

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE DEL TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 64, 380, 149));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON REGISTRAR.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 160, 60));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON NUEVO.png"))); // NOI18N
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 140, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed
    public void TransparenciaBoton() {
        btnNuevo.setOpaque(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setBorderPainted(false);
        btnAgregar.setOpaque(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setBorderPainted(false);
        btnActualizar1.setOpaque(false);
        btnActualizar1.setContentAreaFilled(false);
        btnActualizar1.setBorderPainted(false);
        btnEliminar1.setOpaque(false);
        btnEliminar1.setContentAreaFilled(false);
        btnEliminar1.setBorderPainted(false);
    }
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregar();
        limpiarTabla();
        Listar();
        nuevo();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscartipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscartipoKeyTyped
        // TODO add your handling code here:
        txtBuscartipo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent se) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscartipo.getText(),1));

            }

        });
        trs= new TableRowSorter(modelo);
        Tabla.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscartipoKeyTyped

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        // TODO add your handling code here:
        int fila = Tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        } else {
            id = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
            String nombre = Tabla.getValueAt(fila, 1).toString();
           

            txtNombre.setText(nombre);

        }
    }//GEN-LAST:event_TablaMouseClicked

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
        eliminar();
        limpiarTabla();
        Listar();
        nuevo();
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        // TODO add your handling code here:
        actualizar();
        limpiarTabla();
        Listar();
        nuevo();
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
       txtNombre.setText(txtNombre.getText().toUpperCase());
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
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

        if (txtNombre.getText().length() >= 25) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

     void Listar() {
        List<TipoMascota> lista = tipdao.Listar();
        modelo = (DefaultTableModel) this.Tabla.getModel();
        Object[] ob = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            
            modelo.addRow(ob);
        }
        Tabla.setModel(modelo);
    }

    void eliminar() {
        int fila = Tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        } else {
            tipdao.Eliminar(id);
        }
    }
    void nuevo() {
        txtNombre.setText(""); 
        txtNombre.requestFocus();
        
    }
    void actualizar() {
        int fila = Tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        } else {
            String nombre = txtNombre.getText();
          
        
            Object[] obj = new Object[2];
            obj[0] = nombre;

            obj[1] = id;
            tipdao.Actualizar(obj);
        }
    }
    void agregar() {
        String nombre = txtNombre.getText();
        
        
        Object[] ob = new Object[2];
        ob[0] = nombre;
        
        tipdao.add(ob);
    }
 
    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscartipo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
