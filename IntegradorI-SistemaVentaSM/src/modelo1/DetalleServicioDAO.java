package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class DetalleServicioDAO {
    
     private static final String SQL_SELECT = "SELECT * FROM detalleservicio";
    
    private static final String SQL_INSERT = "INSERT INTO detalleservicio(id_venta, id_masco, id_servi) "
                                             + "values (?, ?, ?)";
    
    private static final String SQL_DELETE = "DELETE FROM detalleservicio WHERE id_venta = ?";
    
    public List<DetalleServicio> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetalleServicio detalleservicio;
        List<DetalleServicio> detalleservicios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVenta= rs.getInt("id_venta");
                int idMascota = rs.getInt("id_masco");
                int idServicio = rs.getInt("id_servi");

                detalleservicio = new DetalleServicio(idVenta, idMascota, idServicio);

                detalleservicios.add(detalleservicio);
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

        return detalleservicios;
    }
    
    public int insertar(DetalleServicio detalleservicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, detalleservicio.getIdVenta());
            stmt.setInt(2, detalleservicio.getIdMascota());
            stmt.setInt(3, detalleservicio.getIdServicio());
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
    
     public void delete (DetalleServicio detalleservicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, detalleservicio.getIdVenta());
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
