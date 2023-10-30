package vistas;

import java.awt.Dimension;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import modelo.conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    
        this.setSize(new Dimension(1800, 1000));
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Pricipal - VETERINARIA SAN MARTIN");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        VentanaPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenudatospersonales = new javax.swing.JMenuItem();
        jMenutrabajadores = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuGenerarVenta = new javax.swing.JMenuItem();
        mnuCliente = new javax.swing.JMenu();
        MenuCliente = new javax.swing.JMenuItem();
        MenuProducto = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        MenuServicios = new javax.swing.JCheckBoxMenuItem();
        MenuTipo = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ReporteClientes = new javax.swing.JCheckBoxMenuItem();
        REPORTEDEMASCOTAS = new javax.swing.JMenuItem();
        REPORTECLIENTESA = new javax.swing.JMenuItem();
        reporteDistri = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/general2.png"))); // NOI18N

        VentanaPrincipal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout VentanaPrincipalLayout = new javax.swing.GroupLayout(VentanaPrincipal);
        VentanaPrincipal.setLayout(VentanaPrincipalLayout);
        VentanaPrincipalLayout.setHorizontalGroup(
            VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, Short.MAX_VALUE)
        );
        VentanaPrincipalLayout.setVerticalGroup(
            VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        jMenu1.setText("Menu");

        jMenudatospersonales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/informacion-personal.png"))); // NOI18N
        jMenudatospersonales.setText("Datos Personales");
        jMenudatospersonales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenudatospersonales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenudatospersonalesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenudatospersonales);

        jMenutrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trabajar.png"))); // NOI18N
        jMenutrabajadores.setText("Trabajadores");
        jMenutrabajadores.setBorder(new javax.swing.border.MatteBorder(null));
        jMenutrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenutrabajadoresActionPerformed(evt);
            }
        });
        jMenu1.add(jMenutrabajadores);

        jMenuItem3.setBackground(new java.awt.Color(255, 204, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perfil-del-usuario.png"))); // NOI18N
        jMenuItem3.setText("Cerrar Sesión");
        jMenuItem3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuItem3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarSesion(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/apagar.png"))); // NOI18N
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/veterinario (3).png"))); // NOI18N
        jMenu2.setText("VENTAS");

        MenuGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/portapapeles.png"))); // NOI18N
        MenuGenerarVenta.setText("GenerarVenta");
        MenuGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGenerarVentaActionPerformed(evt);
            }
        });
        jMenu2.add(MenuGenerarVenta);

        jMenuBar1.add(jMenu2);

        mnuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/veterinario_1.png"))); // NOI18N
        mnuCliente.setText("MANTENIMIENTO");

        MenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perro_1.png"))); // NOI18N
        MenuCliente.setText("CLIENTE");
        MenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClienteActionPerformed(evt);
            }
        });
        mnuCliente.add(MenuCliente);

        MenuProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/juguete-para-mascotas.png"))); // NOI18N
        MenuProducto.setText("PRODUCTO");
        MenuProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProductoActionPerformed(evt);
            }
        });
        mnuCliente.add(MenuProducto);

        jMenuBar1.add(mnuCliente);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/veterinario.png"))); // NOI18N
        jMenu4.setText("SERVICIOS");

        MenuServicios.setSelected(true);
        MenuServicios.setText("SERVICIOS");
        MenuServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estetica.png"))); // NOI18N
        MenuServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuServiciosActionPerformed(evt);
            }
        });
        jMenu4.add(MenuServicios);

        MenuTipo.setSelected(true);
        MenuTipo.setText("TIPO DE MASCOTA");
        MenuTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/veterinario (2).png"))); // NOI18N
        MenuTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTipoActionPerformed(evt);
            }
        });
        jMenu4.add(MenuTipo);

        jMenuBar1.add(jMenu4);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/informe-medico.png"))); // NOI18N
        jMenu3.setText("REPORTES");

        ReporteClientes.setSelected(true);
        ReporteClientes.setText("REPORTE DE PRODUCTOS");
        ReporteClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuenco-para-mascotas.png"))); // NOI18N
        ReporteClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteClientesActionPerformed(evt);
            }
        });
        jMenu3.add(ReporteClientes);

        REPORTEDEMASCOTAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perro2.png"))); // NOI18N
        REPORTEDEMASCOTAS.setText("REPORTE DE MASCOTAS");
        REPORTEDEMASCOTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPORTEDEMASCOTASActionPerformed(evt);
            }
        });
        jMenu3.add(REPORTEDEMASCOTAS);

        REPORTECLIENTESA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perro_1.png"))); // NOI18N
        REPORTECLIENTESA.setText("REPORTE DE CLIENTES");
        REPORTECLIENTESA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPORTECLIENTESAActionPerformed(evt);
            }
        });
        jMenu3.add(REPORTECLIENTESA);

        reporteDistri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/distrito-electoral (1).png"))); // NOI18N
        reporteDistri.setText("REPORTE DE DISTRITOS");
        reporteDistri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteDistriActionPerformed(evt);
            }
        });
        jMenu3.add(reporteDistri);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void MenuGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGenerarVentaActionPerformed
        VentanaVenta vf = new VentanaVenta();
        CentrarVentana(vf);
    }//GEN-LAST:event_MenuGenerarVentaActionPerformed

    private void MenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClienteActionPerformed
        ClienteForm cf = new ClienteForm();
        CentrarVentana(cf);
    }//GEN-LAST:event_MenuClienteActionPerformed

    private void MenuProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProductoActionPerformed
        Producto1Form pf = new Producto1Form();
        CentrarVentana(pf);
    }//GEN-LAST:event_MenuProductoActionPerformed
    private Connection connection = new conexion().conectar();
    private void MenuTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTipoActionPerformed
        // TODO add your handling code here:
        TipoDeMascotaForm tipo = new TipoDeMascotaForm();
        CentrarVentana(tipo);
    }//GEN-LAST:event_MenuTipoActionPerformed

    private void REPORTEDEMASCOTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPORTEDEMASCOTASActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/REPORTE-MASCOTA.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("REPORTE DE MASCOTAS");
            view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_REPORTEDEMASCOTASActionPerformed

    private void REPORTECLIENTESAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPORTECLIENTESAActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/REPORTE-CLIENTE.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("REPORTE DE CLIENTES REGISTRADOS");
            view.setVisible(true);
        } catch (JRException e) {
        }
    }//GEN-LAST:event_REPORTECLIENTESAActionPerformed

    private void MenuServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuServiciosActionPerformed
        // TODO add your handling code here:
        ServiciosForm ser = new ServiciosForm();
        CentrarVentana(ser);
    }//GEN-LAST:event_MenuServiciosActionPerformed

    private void jMenudatospersonalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenudatospersonalesActionPerformed
        VentanaDatosPersonales ventanapersonal = new VentanaDatosPersonales();
        CentrarVentana(ventanapersonal);
    }//GEN-LAST:event_jMenudatospersonalesActionPerformed

    private void jMenutrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenutrabajadoresActionPerformed
        VentanaDatosTrabajadores vdt = new VentanaDatosTrabajadores();
        CentrarVentana(vdt);
    }//GEN-LAST:event_jMenutrabajadoresActionPerformed

    private void reporteDistriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteDistriActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/REPORTE-DISTRITO1.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("REPORTE DE LOS DISTRITOS REGISTRADOS");
            view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_reporteDistriActionPerformed

    private void ReporteClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteClientesActionPerformed
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/rpProductos.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("REPORTE DE PRODUCTOS");
            view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ReporteClientesActionPerformed

    private void jMenuItemCerrarSesion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesion
        // TODO add your handling code here:
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItemCerrarSesion

    void CentrarVentana(JInternalFrame frame) {
        VentanaPrincipal.add(frame);
        Dimension dimension = VentanaPrincipal.getSize();
        Dimension Dframe = frame.getSize();
        frame.setLocation((dimension.width - Dframe.height) / 2,
                (dimension.height - Dframe.width) / 12);
        frame.show();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCliente;
    private javax.swing.JMenuItem MenuGenerarVenta;
    private javax.swing.JMenuItem MenuProducto;
    private javax.swing.JCheckBoxMenuItem MenuServicios;
    private javax.swing.JCheckBoxMenuItem MenuTipo;
    private javax.swing.JMenuItem REPORTECLIENTESA;
    private javax.swing.JMenuItem REPORTEDEMASCOTAS;
    private javax.swing.JCheckBoxMenuItem ReporteClientes;
    public static javax.swing.JDesktopPane VentanaPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenudatospersonales;
    private javax.swing.JMenuItem jMenutrabajadores;
    private javax.swing.JMenu mnuCliente;
    private javax.swing.JMenuItem reporteDistri;
    // End of variables declaration//GEN-END:variables
}
