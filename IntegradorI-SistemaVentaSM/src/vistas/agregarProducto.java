package vistas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo1.DetalleVenta;
import modelo1.Producto;

public class agregarProducto extends javax.swing.JFrame {

    DefaultTableModel modelo;

    List<Producto> listaProductos;
    
    private String name;
    private double price;
    TableRowSorter trs;

    private DetalleVenta detalleventa;

    public agregarProducto() {
        initComponents();
        PropiedadesIniciales();
        llenarDatos();
        num(jtxtCantidad);
    }

    private void llenarDatos() {

        // Propiedades
        PropiedadesTablaProducto();

        //Recorrer el array de productos
        for (Producto producto : listaProductos) {
            int codigo = producto.getId();
            String nombre = producto.getNom();
            int stock = producto.getStock();
            double precio = producto.getPrecio();

            modelo.addRow(new Object[]{codigo, nombre, stock, precio});
        }

        jtblProducto.setModel(modelo);
    }

    private void PropiedadesIniciales() {
        jtxtNombre.setEditable(false);
        jtxtStock.setEditable(false);
        jtxtPrecio.setEditable(false);
        jtxtTotal.setEditable(false);
        
        // Lista de productos
        listaProductos = VentanaVenta.productos;
    }

    private void PropiedadesTablaProducto() {
        String titulos[] = {"Codigo Producto", "Nombre", "Stock", "Precio"};

        // Modelo de tabla - para que no pueda editar el usuario en la tabla
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {

                if (column == 4) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        modelo.setRowCount(0);
    }

    public void num(JTextField dato) {
        dato.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
                if (c == '.' && jtxtCantidad.getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jlblRegistrar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtTotal = new javax.swing.JTextField();
        txt_buscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Producto");
        setMinimumSize(new java.awt.Dimension(620, 440));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtblProducto.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        jtblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre", "Stock", "Precio"
            }
        ));
        jtblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblProductoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblProductoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblProducto);

        jPanelContenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 590, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cantidad");
        jPanelContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 70, 30));

        jlblRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON REGISTRAR.png"))); // NOI18N
        jlblRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblRegistrarMouseClicked(evt);
            }
        });
        jPanelContenedor.add(jlblRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Nombre:");
        jPanelContenedor.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jtxtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCantidadKeyReleased(evt);
            }
        });
        jPanelContenedor.add(jtxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 70, -1));

        jtxtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelContenedor.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 310, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");
        jPanelContenedor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 60, 30));

        jtxtStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelContenedor.add(jtxtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 60, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Stock");
        jPanelContenedor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 50, 30));

        jtxtPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPrecioActionPerformed(evt);
            }
        });
        jPanelContenedor.add(jtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 80, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Precio");
        jPanelContenedor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 50, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("PRODUCTOS");
        jPanelContenedor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Total");
        jPanelContenedor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, 30));

        jtxtTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelContenedor.add(jtxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 60, -1));

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarKeyTyped(evt);
            }
        });
        jPanelContenedor.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 200, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        jPanelContenedor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        jPanelContenedor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblProductoMouseClicked
        // Opcion elegida de la tabla
        int opcion = jtblProducto.rowAtPoint(evt.getPoint()); // Comienza desde 0 el indice
        // Recopilar datos de la tabla
        String nombre = String.valueOf(jtblProducto.getValueAt(opcion, 1));
        int stock = Integer.parseInt(jtblProducto.getValueAt(opcion, 2).toString());
        double precio = Double.parseDouble(jtblProducto.getValueAt(opcion, 3).toString());;
        // Datos a mostrar en los txt
        jtxtNombre.setText(nombre);
        jtxtStock.setText("" + stock);
        jtxtPrecio.setText("" + precio);
    }//GEN-LAST:event_jtblProductoMouseClicked

    private void jlblRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblRegistrarMouseClicked

        int cantidad, diferencia;
        int stock;

        try {
            cantidad = Integer.parseInt(jtxtCantidad.getText());
            stock = Integer.parseInt(jtxtStock.getText());
            diferencia = stock - cantidad;
        } catch (NumberFormatException n) {
            cantidad = 0;
            diferencia = -1;
        }

        // Condicionales para validar la compra
        if (jtxtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla");
        } else if (jtxtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad a comprar");
        } else if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero");
        } else if (diferencia < 0) {
            JOptionPane.showMessageDialog(null, "Cantidad excede al stock");
        } else {
            // Opcion elegida de la tabla
            int opcion = jtblProducto.getSelectedRow(); // Comienza desde el 0 el indice
            // Actualizar la lista de productos
            VentanaVenta.productos.get(opcion).setStock(diferencia);
            // Recopilar datos
            int idVenta = VentanaVenta.ID;
            int idProducto = Integer.parseInt(jtblProducto.getValueAt(opcion, 0).toString());
            double monto = Double.parseDouble(jtblProducto.getValueAt(opcion, 3).toString()) * cantidad;
            monto = (double)Math.round(monto*100)/100;
            name = String.valueOf(jtblProducto.getValueAt(opcion, 1));
            price = Double.parseDouble(jtblProducto.getValueAt(opcion, 3).toString());
            detalleventa = new DetalleVenta(idVenta, idProducto, cantidad, monto);
            VentanaVenta.llenarVenta(detalleventa, name, price, "Producto");

            this.dispose();
        }
    }//GEN-LAST:event_jlblRegistrarMouseClicked

    private void jtxtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCantidadKeyPressed

    }//GEN-LAST:event_jtxtCantidadKeyPressed

    private void jtxtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCantidadKeyReleased
        try {
            double total = Double.parseDouble(jtxtCantidad.getText()) * Double.parseDouble(jtxtPrecio.getText());
            total = (double)Math.round(total*100)/100;
            jtxtTotal.setText("" + total);
        } catch (NumberFormatException n) {
            jtxtTotal.setText("-");
        }

    }//GEN-LAST:event_jtxtCantidadKeyReleased

    private void jtblProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblProductoMousePressed
    }//GEN-LAST:event_jtblProductoMousePressed

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
        jtblProducto.setRowSorter(trs);
    }//GEN-LAST:event_txt_buscarKeyTyped

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jtxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPrecioActionPerformed

    /**
     * @param args the command line arguments
     */
    

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
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel jlblRegistrar;
    private javax.swing.JTable jtblProducto;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPrecio;
    private javax.swing.JTextField jtxtStock;
    private javax.swing.JTextField jtxtTotal;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
