package vistas;

import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
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

public class Principal_Empleado extends javax.swing.JFrame {

    public Principal_Empleado() {
        initComponents();
        
        this.setSize(new Dimension(1800, 1000));
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Pricipal - VETERINARIA SAN MARTIN");
    }

    private final Connection connection = conexion.conectar();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        VentanaPrincipal_Empleado = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuGenerarVenta = new javax.swing.JMenuItem();
        mnuCliente = new javax.swing.JMenu();
        MenuCliente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        MenuTipo = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/general2.png"))); // NOI18N

        VentanaPrincipal_Empleado.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout VentanaPrincipal_EmpleadoLayout = new javax.swing.GroupLayout(VentanaPrincipal_Empleado);
        VentanaPrincipal_Empleado.setLayout(VentanaPrincipal_EmpleadoLayout);
        VentanaPrincipal_EmpleadoLayout.setHorizontalGroup(
            VentanaPrincipal_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, Short.MAX_VALUE)
        );
        VentanaPrincipal_EmpleadoLayout.setVerticalGroup(
            VentanaPrincipal_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaPrincipal_EmpleadoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N
        jMenu1.setText("Menu");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/informacion-personal.png"))); // NOI18N
        jMenuItem3.setText("DATOS DEL PERSONAL");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perfil-del-usuario.png"))); // NOI18N
        jMenuItem4.setText("CERRAR SESIÓN");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarSesion(evt);
            }
        });
        jMenu1.add(jMenuItem4);

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

        jMenuBar1.add(mnuCliente);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/veterinario.png"))); // NOI18N
        jMenu4.setText("SERVICIOS");

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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrincipal_Empleado)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrincipal_Empleado, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGenerarVentaActionPerformed
        VentanaVenta vf = new VentanaVenta();
        CentrarVentana(vf);
    }//GEN-LAST:event_MenuGenerarVentaActionPerformed

    private void MenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClienteActionPerformed
        ClienteForm cf = new ClienteForm();
        CentrarVentana(cf);
    }//GEN-LAST:event_MenuClienteActionPerformed
//private Connection connection=new conexion().conectar();
    private void MenuTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTipoActionPerformed
        // TODO add your handling code here:
        TipoDeMascotaForm tipo = new TipoDeMascotaForm();
        CentrarVentana(tipo);
    }//GEN-LAST:event_MenuTipoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        VentanaDatosPersonalesEmpleado emple = new VentanaDatosPersonalesEmpleado();
        CentrarVentana(emple);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemCerrarSesion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesion
        // TODO add your handling code here:
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItemCerrarSesion

    void CentrarVentana(JInternalFrame frame) {
        VentanaPrincipal_Empleado.add(frame);
        Dimension dimension = VentanaPrincipal_Empleado.getSize();
        Dimension Dframe = frame.getSize();
        frame.setLocation((dimension.width - Dframe.height) / 2,
                (dimension.height - Dframe.width) / 12);
        frame.show();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCliente;
    private javax.swing.JMenuItem MenuGenerarVenta;
    private javax.swing.JCheckBoxMenuItem MenuTipo;
    public static javax.swing.JDesktopPane VentanaPrincipal_Empleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu mnuCliente;
    // End of variables declaration//GEN-END:variables
}
