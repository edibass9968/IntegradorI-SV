package vistas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo1.*;

public class agregarServicio extends javax.swing.JFrame {

    DefaultTableModel modelo;

    List<Servicio> listaServicios;
    ServicioDAO2 serviciodao = new ServicioDAO2();
    List<TipoMascota> listaTipoMascota;
    TipoMascotaDAO mascotaDAO = new TipoMascotaDAO();
    
    private String name;
    private double price;
TableRowSorter trs;
    private DetalleServicio detalleServicio;

    public agregarServicio() {
        initComponents();
        PropiedadesIniciales();
        llenarDatos();
    }

    private void llenarDatos() {

        // Propiedades
        PropiedadesTablaProducto();

        //Recorrer el array de productos
        String tipoMascota = "";
        for (Servicio servicio : listaServicios) {
            int codigo = servicio.getId();
            String descripcion = servicio.getDescripcion();
            double precio = servicio.getPrecio();
            int idTipomas = servicio.getId_tipo();
            for(TipoMascota tipo : listaTipoMascota){
                if(tipo.getIdMascota() == idTipomas){
                    tipoMascota = tipo.getNombre();
                }
            }
            

            modelo.addRow(new Object[]{codigo, descripcion, precio, tipoMascota});
        }

        jtblProducto.setModel(modelo);
    }

    private void PropiedadesIniciales() {
        jtxtDescripcion.setEditable(false);
        jtxtPrecio.setEditable(false);
        jtxtTipoMascota.setEditable(false);
        
        // Lista de servicios
        listaServicios = serviciodao.seleccionar();
        listaTipoMascota = mascotaDAO.seleccionar();
    }

    private void PropiedadesTablaProducto() {
        String titulos[] = {"Codigo Servicio", "Descripción", "Precio", "Tipo de Mascota"};

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedor = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProducto = new javax.swing.JTable();
        jlblRegistrar = new javax.swing.JLabel();
        jtxtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtTipoMascota = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Servicio");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        jPanelContenedor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Nombre:");
        jPanelContenedor.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 50, 70, 20));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarKeyTyped(evt);
            }
        });
        jPanelContenedor.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 200, -1));

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtblProducto.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        jtblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Servicio", "Descripción", "Precio", "Tipo Mascota"
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

        jPanelContenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 170));

        jlblRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON REGISTRAR.png"))); // NOI18N
        jlblRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblRegistrarMouseClicked(evt);
            }
        });
        jPanelContenedor.add(jlblRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 170, 70));

        jtxtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelContenedor.add(jtxtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 230, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descripción");
        jPanelContenedor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, -1));

        jtxtPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelContenedor.add(jtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Precio");
        jPanelContenedor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 60, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("SERVICIOS");
        jPanelContenedor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tipo Mascota");
        jPanelContenedor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, -1));

        jtxtTipoMascota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelContenedor.add(jtxtTipoMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 230, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 658));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 658));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 658));
        jPanelContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 440));

        getContentPane().add(jPanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblProductoMouseClicked
        // Opcion elegida de la tabla
        int opcion = jtblProducto.rowAtPoint(evt.getPoint()); // Comienza desde 0 el indice
        // Recopilar datos de la tabla
        String nombre = String.valueOf(jtblProducto.getValueAt(opcion, 1));
        double precio = Double.parseDouble(jtblProducto.getValueAt(opcion, 2).toString());
        String tipoMascota = String.valueOf(jtblProducto.getValueAt(opcion, 3));
        // Datos a mostrar en los txt
        jtxtDescripcion.setText(nombre);
        jtxtPrecio.setText("" + precio);
        jtxtTipoMascota.setText(tipoMascota);
    }//GEN-LAST:event_jtblProductoMouseClicked

    private void jlblRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblRegistrarMouseClicked

        int opcion = jtblProducto.getSelectedRow(); // Comienza desde el 0 el indice
        
        if(opcion < 0 ) {
            JOptionPane.showMessageDialog(null, "Seleccione un servicio de la tabla");         
        }
        else{
            int idServicio= listaServicios.get(opcion).getId();
            double precio = listaServicios.get(opcion).getPrecio();
            String descripcion = listaServicios.get(opcion).getDescripcion();
            
            VentanaVenta.llenarVenta(idServicio, precio, descripcion, "Servicio");

            this.dispose();
            
        }
    }//GEN-LAST:event_jlblRegistrarMouseClicked

    private void jtblProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblProductoMousePressed
    }//GEN-LAST:event_jtblProductoMousePressed

    private void txt_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyTyped
        txt_buscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txt_buscar.getText(), 0, 1));

            }

        });
        trs = new TableRowSorter(modelo);
        jtblProducto.setRowSorter(trs);
    }//GEN-LAST:event_txt_buscarKeyTyped

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel jlblRegistrar;
    private javax.swing.JTable jtblProducto;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtPrecio;
    private javax.swing.JTextField jtxtTipoMascota;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
