package vistas;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo1.*;

// 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.conexion;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static vistas.VentanaVenta.ID;
import static vistas.VentanaVenta.detalleServicio;
import static vistas.VentanaVenta.detalleServicios;
import static vistas.VentanaVenta.detalleventas;
import static vistas.VentanaVenta.eiv;
import static vistas.VentanaVenta.eivs;
import static vistas.VentanaVenta.jtblVenta;
import static vistas.VentanaVenta.modelo2;
import static vistas.VentanaVenta.productos;
import static vistas.VentanaVenta.sufijoP;
import static vistas.VentanaVenta.sufijoS;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class VentanaVenta extends javax.swing.JInternalFrame {
    // Para listar los clientes y mascotas

    List<Cliente> clientes;
    List<Mascota> mascotas;
    ClienteDAO clientedao = new ClienteDAO();
    MascotaDAO mascotadao = new MascotaDAO();

    // Para el frame de Producto
    public static List<Producto> productos;
    public static List<DetalleVenta> detalleventas = new ArrayList<>();
    ProductoDAO2 productodao = new ProductoDAO2();
    VentaDAO ventadao = new VentaDAO();

    // Para el frame Servicio
    public static List<DetalleServicio> detalleServicios = new ArrayList<>();
    public static DetalleServicio detalleServicio;

    // Para eliminar item de VentanaVenta_1
    public static List<EliminarItemVenta> eivs = new ArrayList<>();
    public static EliminarItemVenta eiv;
    public static int sufijoP;
    public static int sufijoS;

    // Modelos de tabla
    DefaultTableModel modelo1;                                     // Modelo tabla cliente
    public static DefaultTableModel modelo2;                      // Modelo tabla venta

    // ID de venta que se registra para los frames agregar producto y servicio
    public static int ID;

    // Personal que esta ejecutando la venta
    int idPersonal = 3;

    // Total de ventas;
    private static double montoTotal;
    private Connection connection;

    public VentanaVenta() {
        initComponents();
        InicioTotal();
        
    }

    private void InicioTotal() {
        llenarDatos(); // Llenar la tabla de clientes
        PropiedadInicio(); // txt sin editar y lista de productos
        DesactivarBoton(); // desactivar botones
        SetCodigoVenta(); // Setear el idVenta
        InicioTablaVenta(); // Setear la tabla Venta
        montoTotal = 0;
        sufijoP = 0;
        sufijoS = 0;
    }

    private void SetCodigoVenta() {
        ID = ventadao.SeleccionarID() + 1;
        jtxtCodigoVenta.setText("" + ID);
    }

    private void llenarDatos() {
        // Llenar la tabla con la base de datos        
        clientes = clientedao.Seleccionar();
        mascotas = mascotadao.Seleccionar();

        // Propiedades iniciales de la tabla
        InicioTablaCliente();

        // Recorrer el array
        for (int i = 0; i < clientes.size(); i++) {
            String codigo = String.valueOf(clientes.get(i).getIdCliente());
            String nomMascota = mascotas.get(i).getNombre();
            String dueño = clientes.get(i).getNombre() + " " + clientes.get(i).getApellido();
            String dni = clientes.get(i).getDNI();

            modelo1.addRow(new Object[]{codigo, nomMascota, dueño, dni});
        }

        jtblCliente.setModel(modelo1);

    }

    private void PropiedadInicio() {
        // txt sin editar
        jtxtCodigoVenta.setEditable(false);
        jtxtCliente.setEditable(false);
        jtxtMascota.setEditable(false);
        jtxtTotal.setEditable(false);

        // Inicio de productos
        productos = productodao.seleccionar();
    }

    private void InicioTablaCliente() {
        String titulos[] = {"Codigo Historial", "Mascota", "Dueño", "DNI"};

        // Modelo de tabla - para que no pueda editar el usuario en la tabla
        modelo1 = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {

                if (column == 4) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        modelo1.setRowCount(0);
    }

    private void InicioTablaVenta() {
        String titulos[] = {"Tipo", "Descripción", "Cantidad", "Precio", "Monto"};

        // Modelo de tabla - para que no pueda editar el usuario en la tabla
        modelo2 = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {

                if (column == 5) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        modelo2.setRowCount(0);

        jtblVenta.setModel(modelo2);
    }

    private void BusquedaTabla(int i) {

        // Brindado datos a la tabla;
        String codigo = String.valueOf(clientes.get(i).getIdCliente());
        String nomMascota = mascotas.get(i).getNombre();
        String dueño = clientes.get(i).getNombre() + " " + clientes.get(i).getApellido();
        String dni = clientes.get(i).getDNI();

        modelo1.addRow(new Object[]{codigo, nomMascota, dueño, dni});
        jtblCliente.setModel(modelo1);
    }

    public static void llenarVenta(DetalleVenta dv, String name, double price, String tipo) {
        eiv = new EliminarItemVenta(sufijoP++, "P");
        eivs.add(eiv);

        detalleventas.add(dv);

        String descripcion = name;
        double precio = price;
        int cantidad = dv.getCantidad();
        double monto = dv.getMonto();

        modelo2.addRow(new Object[]{tipo, descripcion, cantidad, precio, monto});

        jtblVenta.setModel(modelo2);

        montoTotal += monto;
        jtxtTotal.setText("" + montoTotal);
    }

    public static void llenarVenta(int idServicio, double precio, String descripcion, String tipo) {
        eiv = new EliminarItemVenta(sufijoS++, "S");
        eivs.add(eiv);
        // Opcion elegida de la tabla
        int opcion = jtblCliente.getSelectedRow();
        //System.out.println(opcion);
        // Dato del ID
        int idMascota = Integer.parseInt(jtblCliente.getValueAt(opcion, 0).toString());
        // agregando detalle de Servicio
        detalleServicio = new DetalleServicio(ID, idMascota, idServicio);
        detalleServicios.add(detalleServicio);
        // Datos para la tabla
        String nombre = descripcion;
        double price = precio;
        int cantidad = 1;

        modelo2.addRow(new Object[]{tipo, nombre, cantidad, price, price});

        jtblVenta.setModel(modelo2);

        montoTotal += price;
        jtxtTotal.setText("" + montoTotal);

    }

    private void ActivarBoton() {
        jlblBotonProducto.setEnabled(true);
        jlblBotonServicio.setEnabled(true);
        jlblBotonEliminar.setEnabled(true);
        jlblBotonFacturar.setEnabled(true);
        jButton1.setEnabled(true);
    }

    private void DesactivarBoton() {
        jlblBotonProducto.setEnabled(false);
        jlblBotonServicio.setEnabled(false);
        jlblBotonEliminar.setEnabled(false);
        jlblBotonFacturar.setEnabled(false);
        jButton1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtxtCodigoVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblCliente = new javax.swing.JTable();
        jlblBotonFacturar = new javax.swing.JLabel();
        jtxtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtCliente = new javax.swing.JTextField();
        jtxtMascota = new javax.swing.JTextField();
        jtxtBusqueda = new javax.swing.JTextField();
        jlblBotonServicio = new javax.swing.JLabel();
        jlblLupa = new javax.swing.JLabel();
        jlblBotonEliminar = new javax.swing.JLabel();
        jlblBotonProducto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbxCategoria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblVenta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("VENTAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Categoría");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/terminal-de-punto-de-venta.png"))); // NOI18N
        jButton1.setText("Boleta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 542, -1, -1));

        jtxtCodigoVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCodigoVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtCodigoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mascota");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));

        jtblCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Historial", "Mascota", "Dueño", "DNI"
            }
        ));
        jtblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 709, 180));

        jlblBotonFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/punto-de-venta.png"))); // NOI18N
        jlblBotonFacturar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblBotonFacturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBotonFacturarMouseClicked(evt);
            }
        });
        getContentPane().add(jlblBotonFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 531, -1, -1));

        jtxtTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jtxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 495, 168, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Total");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 498, 36, -1));

        jtxtCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jtxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 186, -1));

        jtxtMascota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jtxtMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 168, -1));

        jtxtBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtBusqueda.setPreferredSize(new java.awt.Dimension(6, 28));
        getContentPane().add(jtxtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 30, 210, -1));

        jlblBotonServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON REGISTRAR SERVICIOS.png"))); // NOI18N
        jlblBotonServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblBotonServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBotonServicioMouseClicked(evt);
            }
        });
        getContentPane().add(jlblBotonServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, -1, -1));

        jlblLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        jlblLupa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblLupa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblLupaMouseClicked(evt);
            }
        });
        getContentPane().add(jlblLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, 30));

        jlblBotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON ELIMINAR.png"))); // NOI18N
        jlblBotonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblBotonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBotonEliminarMouseClicked(evt);
            }
        });
        getContentPane().add(jlblBotonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, -1, -1));

        jlblBotonProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOTON REGISTRAR PRODUCTOS.png"))); // NOI18N
        jlblBotonProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblBotonProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBotonProductoMouseClicked(evt);
            }
        });
        getContentPane().add(jlblBotonProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        jcbxCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mascota", "Dueño" }));
        jcbxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jcbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 94, 40));

        jtblVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Descripción", "Cantidad", "Precio", "Monto"
            }
        ));
        jScrollPane2.setViewportView(jtblVenta);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 338, 709, 139));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Codigo Venta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -24, 820, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlblLupaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblLupaMouseClicked

        int opcion = jcbxCategoria.getSelectedIndex(); // Indice comienza desde 0
        String busqueda = jtxtBusqueda.getText(); // 0 -> mascota y 1 -> dueño

        Pattern regex = Pattern.compile("\\b" + Pattern.quote(busqueda) + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher match;

        // Propiedades de la tabla
        if (opcion == 0) {
            InicioTablaCliente();
            for (int i = 0; i < mascotas.size(); i++) {
                String nomMascota = mascotas.get(i).getNombre();
                match = regex.matcher(nomMascota);
                if (match.find()) {
                    //System.out.println(nomMascota);
                    BusquedaTabla(i);
                }
            }
        } else {
            InicioTablaCliente();
            for (int i = 0; i < clientes.size(); i++) {
                String nombre = clientes.get(i).getNombre() + " " + clientes.get(i).getApellido();
                match = regex.matcher(nombre);
                if (match.find()) {
                    //System.out.println(nombre);
                    BusquedaTabla(i);
                }
            }
        }
    }//GEN-LAST:event_jlblLupaMouseClicked

    private void jtblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblClienteMouseClicked
        // Opcion elegida de la tabla
        int opcion = jtblCliente.rowAtPoint(evt.getPoint());
        // Dato a muestrear con DNI
        String dni = String.valueOf(jtblCliente.getValueAt(opcion, 3));
        // Datos a mostrar en los txt
        String dueño = "";
        String nomMascota = "";

        for (int i = 0; i < clientes.size(); i++) {
            if (dni.equalsIgnoreCase(clientes.get(i).getDNI())) {
                dueño = clientes.get(i).getNombre() + " " + clientes.get(i).getApellido();
                nomMascota = mascotas.get(i).getNombre();
            }
        }
        jtxtCliente.setText(dueño);
        jtxtMascota.setText(nomMascota);

        ActivarBoton();
    }//GEN-LAST:event_jtblClienteMouseClicked

    private void jlblBotonServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBotonServicioMouseClicked
 agregarServicio aServicio = new agregarServicio();
aServicio.setVisible(true);
    }//GEN-LAST:event_jlblBotonServicioMouseClicked

    private void jlblBotonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBotonEliminarMouseClicked
        // Obtener la fila que se desea eliminar
        int opcion = jtblVenta.getSelectedRow();
        int dialog = JOptionPane.YES_NO_OPTION;
        // result = 0 acepta eliminar

        // Extraer datos
        /*String decripcion = String.valueOf(jtblVenta.getValueAt(opcion, 1));
        int cantidad = Integer.parseInt(jtblVenta.getValueAt(opcion, 2).toString());*/
        if (opcion >= 0) {
            int result = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto o servicio?", "Eliminar Venta", dialog);
            String categoria = eivs.get(opcion).getTipo();
            if (categoria.equals("S") && result == 0) {

                /*for (int i = 0; i < detalleServicios.size(); i++) {
                    System.out.println(detalleServicios.get(i).getIdServicio());
                }*/
                double monto = Double.parseDouble(jtblVenta.getValueAt(opcion, 4).toString());
                montoTotal -= monto;
                montoTotal = (double) Math.round(montoTotal * 100) / 100;
                jtxtTotal.setText("" + montoTotal);
                DefaultTableModel modelo = (DefaultTableModel) jtblVenta.getModel();
                modelo.removeRow(opcion);
                detalleServicios.remove(eivs.get(opcion).getSufijo());
                JOptionPane.showMessageDialog(null, "Eliminado correctamente");
            } else if (categoria.equals("P") && result == 0) {
                String name = String.valueOf(jtblVenta.getValueAt(opcion, 1));
                int cantidad = Integer.parseInt(jtblVenta.getValueAt(opcion, 2).toString());
                detalleventas.remove(eivs.get(opcion).getSufijo()); // Remueve el productos de detalle venta
                // Encontrar y restaurar la cantidad de producto
                for (Producto product : productos) {
                    if (product.getNom().equals(name)) {
                        product.setStock(product.getStock() + cantidad);
                    }
                }

                double monto = Double.parseDouble(jtblVenta.getValueAt(opcion, 4).toString());
                montoTotal -= monto;
                montoTotal = (double) Math.round(montoTotal * 100) / 100;
                jtxtTotal.setText("" + montoTotal);
                DefaultTableModel modelo = (DefaultTableModel) jtblVenta.getModel();
                modelo.removeRow(opcion);
                JOptionPane.showMessageDialog(null, "Eliminado correctamente");
                //System.out.println(detalleventas.size());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione el servicio o producto a eliminar");
        }
    }//GEN-LAST:event_jlblBotonEliminarMouseClicked

    private void jlblBotonFacturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBotonFacturarMouseClicked
        // Aqui van los DAO de detalles venta y servicio como el de venta
        DetalleVentaDAO dvdao = new DetalleVentaDAO();
        DetalleServicioDAO dsdao = new DetalleServicioDAO();

        // Se prepara el mensaje a mostrar para eliminar
        int dialog = JOptionPane.YES_NO_OPTION;
        //int result = JOptionPane.showConfirmDialog(null, "¿Desea facturar la venta?", "Facturar Venta", dialog);

        // Fecha del día de factura
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

        // Se consulta si ya se ha ralizada alguna compra de producto o servicio
        DefaultTableModel modelo = (DefaultTableModel) jtblVenta.getModel();
        int ventas = modelo.getRowCount();
        //System.out.println(ventas);

        // Confirmando si hay elementos para facturar
        if (ventas > 0) {
            int result = JOptionPane.showConfirmDialog(null, "¿Desea facturar la venta?", "Facturar Venta", dialog);
            if (result == 0) { // Se consulta si de verdad desea facturar

                // Registrar Venta
                int opcion = jtblCliente.getSelectedRow();
                int idCliente = Integer.parseInt(jtblCliente.getValueAt(opcion, 0).toString()); // Obtener idCliente
                Venta venta = new Venta(ID, fecha, montoTotal, idPersonal, idCliente); // Registrando Venta;
                ventadao.insertar(venta);

                //Registrar detalleventa
                for (DetalleVenta dv : detalleventas) {
                    dvdao.insertar(dv);
                }
                //registrar detalleservicio
                for (DetalleServicio ds : detalleServicios) {
                    dsdao.insertar(ds);
                }
                // Actualizando productos
                for (Producto prod : productos) {
                    productodao.update(prod);
                }
                InicioTotal();
                jtxtCliente.setText("");
                jtxtMascota.setText("");
                jtxtTotal.setText("");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero tiene que insertar un producto o servicio");
        }

    }//GEN-LAST:event_jlblBotonFacturarMouseClicked

    private void jlblBotonProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBotonProductoMouseClicked
       
 agregarProducto aServicio = new agregarProducto();
aServicio.setVisible(true);
    }//GEN-LAST:event_jlblBotonProductoMouseClicked
    private final Connection connection1 = conexion.conectar();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      generarBoletaPDF();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtxtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCodigoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCodigoVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbxCategoria;
    private javax.swing.JLabel jlblBotonEliminar;
    private javax.swing.JLabel jlblBotonFacturar;
    private javax.swing.JLabel jlblBotonProducto;
    private javax.swing.JLabel jlblBotonServicio;
    private javax.swing.JLabel jlblLupa;
    private static javax.swing.JTable jtblCliente;
    public static javax.swing.JTable jtblVenta;
    private javax.swing.JTextField jtxtBusqueda;
    private javax.swing.JTextField jtxtCliente;
    private javax.swing.JTextField jtxtCodigoVenta;
    private javax.swing.JTextField jtxtMascota;
    public static javax.swing.JTextField jtxtTotal;
    // End of variables declaration//GEN-END:variables
private void generarBoletaPDF() {
    Document document = new Document();
    try {
        // Ruta donde deseas guardar el archivo PDF
        String pdfFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\IntegradorI-SistemaVentaSM\\src\\PDF/archivo.pdf";
        
        PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
        
        document.open();

      // Agregar encabezado u otros contenidos antes de la tabla
document.add(new Paragraph("Veterinaria San Martin"));
document.add(new Paragraph("\n"));
document.add(new Paragraph("Fecha: " + getCurrentDate())); // Puedes personalizar esta parte

// Agregar la tabla con la información de jtblVenta
document.add(new Paragraph("Detalle de la venta:"));
document.add(new Paragraph("\n"));

// Crear una tabla en el documento PDF
PdfPTable table = new PdfPTable(5); // 5 columnas para tipo, descripción, cantidad, precio y monto

// Encabezados de la tabla
table.addCell("Tipo");
table.addCell("Descripción");
table.addCell("Cantidad");
table.addCell("Precio");
table.addCell("Monto");

        // Agregar filas de datos desde la tabla jtblVenta
        DefaultTableModel model = (DefaultTableModel) jtblVenta.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String tipo = model.getValueAt(i, 0).toString();
            String descripcion = model.getValueAt(i, 1).toString();
            String cantidad = model.getValueAt(i, 2).toString();
            String precio = model.getValueAt(i, 3).toString();
            String monto = model.getValueAt(i, 4).toString();

            table.addCell(tipo);
            table.addCell(descripcion);
            table.addCell(cantidad);
            table.addCell(precio);
            table.addCell(monto);
        }

        document.add(table); // Agregar la tabla al documento

        // Calcular y agregar el monto total
        double montoTotal = calcularMontoTotal();
document.add(new Paragraph("\n"));
        document.add(new Paragraph("Monto Total a Pagar: " + montoTotal + " Soles"));

        document.close();
        
        // Abre el archivo PDF después de generarlo
        Desktop.getDesktop().open(new File(pdfFilePath));
    } catch (DocumentException | IOException e) {
        e.printStackTrace();
    }
}

// Función para calcular el monto total a partir de la tabla jtblVenta
private double calcularMontoTotal() {
    double montoTotal = 0;
    DefaultTableModel model = (DefaultTableModel) jtblVenta.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        double monto = Double.parseDouble(model.getValueAt(i, 4).toString());
        montoTotal += monto;
    }
    return montoTotal;
}

// Función para obtener la fecha actual (puedes personalizarla según tus necesidades)
private String getCurrentDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    return sdf.format(new Date());
}

}
