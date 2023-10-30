package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class DetalleVentaDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM detalleventa";
    
    private static final String SQL_INSERT = "INSERT INTO detalleventa(id_venta, id_produ, cant_detven, monto_detven) "
                                             + "values (?, ?, ?, ?)";
    
    private static final String SQL_DELETE = "DELETE FROM detalleventa WHERE id_venta = ?";
    
    public List<DetalleVenta> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetalleVenta detalleventa;
        List<DetalleVenta> detalleventas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVenta= rs.getInt("id_venta");
                int idProducto = rs.getInt("id_produ");
                int cantidad = rs.getInt("cant_detven");
                double monto = rs.getDouble("monto_detven");

                detalleventa = new DetalleVenta(idVenta, idProducto, cantidad, monto);

                detalleventas.add(detalleventa);
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

        return detalleventas;
    }
    
    public int insertar(DetalleVenta detalleventa){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, detalleventa.getIdVenta());
            stmt.setInt(2, detalleventa.getIdProducto());
            stmt.setInt(3, detalleventa.getCantidad());
            stmt.setDouble(4, detalleventa.getMonto());
            registros = stmt.executeUpdate(); // para insert, update o delete
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        
        return registros;
    }
    
     public void delete (DetalleVenta detalleventa){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, detalleventa.getIdVenta());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
    
}
