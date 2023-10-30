package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;


public class VistaDetalleDAO {
    
    public List<VistaDetalle> SeleccionarVistaProducto(String idVenta) {
        String SQL_VISTAPRODUCTOS = "select producto.nom_produ, detalleventa.monto_detven from venta"
            + " inner join detalleventa on detalleventa.id_venta = venta.id_venta inner join producto"
            + " on producto.id_produ = detalleventa.id_produ where venta.id_venta = '" + idVenta + "'";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VistaDetalle vistadetalle;
        List<VistaDetalle> vistadetalles = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_VISTAPRODUCTOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String descripcion = rs.getString("nom_produ");
                double monto = rs.getDouble("monto_detven");

                vistadetalle = new VistaDetalle(descripcion, monto);

                vistadetalles.add(vistadetalle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion2.close(rs);
                Conexion2.close(stmt);
                Conexion2.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return vistadetalles;
    }
    
    public List<VistaDetalle> SeleccionarVistaServicio(String idVenta) {
        String SQL_VISTASERVICIOS = "select servicio.desc_servi, servicio.precio_servi from venta inner join"
                + " detalleservicio on detalleservicio.id_venta = venta.id_venta inner join servicio"
                + " on servicio.id_servi = detalleservicio.id_servi where venta.id_venta = '" + idVenta + "'";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VistaDetalle vistadetalle;
        List<VistaDetalle> vistadetalles = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_VISTASERVICIOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String descripcion = rs.getString("desc_servi");
                double monto = rs.getDouble("precio_servi");

                vistadetalle = new VistaDetalle(descripcion, monto);

                vistadetalles.add(vistadetalle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion2.close(rs);
                Conexion2.close(stmt);
                Conexion2.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return vistadetalles;
    }
}
