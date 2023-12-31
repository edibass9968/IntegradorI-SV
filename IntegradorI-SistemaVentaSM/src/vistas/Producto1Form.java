/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Producto;
import modelo.ProductoDAO;

public class Producto1Form extends javax.swing.JInternalFrame {

    ProductoDAO dao = new ProductoDAO();
    Producto cl = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    TableRowSorter trs;

    DefaultTableModel modelo = new DefaultTableModel();
    int id;
    double precio;

    /**
     * Creates new form productos
     */
    public Producto1Form() {

        initComponents();
        TransparenciaBoton();
        Listar();

    }

    void Listar() {
        List<Producto> lista = dao.Listar();
        modelo = (DefaultTableModel) this.Tabla2.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNom();
            ob[2] = lista.get(i).getStock();
            ob[3] = lista.get(i).getPrecio();

            modelo.addRow(ob);
        }
        Tabla2.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("REGISTRAR PRODUCTOS");
        setToolTipText("");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 273, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("PRECIO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 273, -1, -1));

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 273, 99, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("STOCK:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 273, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON ELIMINAR.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 315, 140, 60));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 273, 231, -1));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON MODIFICAR.png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 315, 150, 60));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON NUEVO.png"))); // NOI18N
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 136, 50));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON REGISTRAR.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 150, 50));

        jScrollPane1.setViewportBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "STOCK", "PRECIO"
            }
        ));
        Tabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 60, 698, 205));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PRODUCTO:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 273, -1, -1));

        txt_buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarKeyTyped(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 25, 430, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("BUSCAR PRODUCTO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 28, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void TransparenciaBoton() {
        btnNuevo.setOpaque(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setBorderPainted(false);
        btnAgregar.setOpaque(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setBorderPainted(false);
        btnActualizar.setOpaque(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setBorderPainted(false);
        btnEliminar.setOpaque(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setBorderPainted(false);
    }
    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        // TODO add your handling code here:
        txt_buscar.setText(txt_buscar.getText().toUpperCase());
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void txt_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyTyped
        // TODO add your handling code here:
        txt_buscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txt_buscar.getText(), 0, 1));

            }

        });
        trs = new TableRowSorter(modelo);
        Tabla2.setRowSorter(trs);

    }//GEN-LAST:event_txt_buscarKeyTyped

    private void Tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla2MouseClicked
        // TODO add your handling code here:
        int fila = Tabla2.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        } else {
            id = Integer.parseInt(Tabla2.getValueAt(fila, 0).toString());
            String nom = Tabla2.getValueAt(fila, 1).toString();
            String stock = Tabla2.getValueAt(fila, 2).toString();
            String precio = Tabla2.getValueAt(fila, 3).toString();
            txtNombre.setText(nom);
            txtStock.setText(stock);
            txtPrecio.setText(precio);

        }
    }//GEN-LAST:event_Tabla2MouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
        limpiarTabla();
        Listar();
        nuevo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
        limpiarTabla();
        Listar();

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregar();
        limpiarTabla();
        Listar();
        nuevo();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        txtNombre.setText(txtNombre.getText().toUpperCase());
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped
    void agregar() {
        String nom = txtNombre.getText();
        precio = Double.parseDouble(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());
        modelo = (DefaultTableModel) Tabla2.getModel();
        ArrayList lista = new ArrayList();
        if (stock > 0 && precio > 0) {
            lista.add(id);
            lista.add(nom);
            lista.add(stock);
            lista.add(precio);

            Object[] ob = new Object[4];
            ob[0] = nom;
            ob[1] = stock;
            ob[2] = precio;
            dao.add(ob);
            JOptionPane.showMessageDialog(this, "VALOR INGRESADO CON ÉXITO");
        } else {
            JOptionPane.showMessageDialog(this, "EL VALOR INGRESADO NO ES VÁLIDO");
            JOptionPane.showMessageDialog(this, "POR FAVOR INGRESAR UN NUEVO VALOR");
            JOptionPane.showMessageDialog(this, "¡GRACIAS!");
        }
    }

    void actualizar() {
        int fila = Tabla2.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        } else {
            String nom = txtNombre.getText();
            int stock = Integer.parseInt(txtStock.getText());
            precio = Double.parseDouble(txtPrecio.getText());
            modelo = (DefaultTableModel) Tabla2.getModel();
            ArrayList lista = new ArrayList();
            if (stock > 0 && precio > 0) {
                lista.add(id);
                lista.add(nom);
                lista.add(stock);
                lista.add(precio);

                Object[] obj = new Object[5];
                obj[0] = nom;
                obj[1] = stock;
                obj[2] = precio;
                obj[3] = id;
                dao.Actualizar(obj);
                JOptionPane.showMessageDialog(this, "VALOR INGRESADO CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(this, "EL VALOR INGRESADO NO ES VÁLIDO");
                JOptionPane.showMessageDialog(this, "POR FAVOR INGRESAR UN NUEVO VALOR");
                JOptionPane.showMessageDialog(this, "¡GRACIAS!");
            }
        }
    }

    void eliminar() {
        int fila = Tabla2.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        } else {
            dao.Eliminar(id);
        }
    }

    void nuevo() {
        txtNombre.setText("");
        txtStock.setText("");
        txtPrecio.setText("");

        txtNombre.requestFocus();

    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla2;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
