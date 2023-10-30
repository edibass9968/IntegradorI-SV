package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class ServicioDAO2 {
     private static final String SQL_SELECT = "SELECT * FROM servicio";
    
    private static final String SQL_INSERT = "INSERT INTO servicio(desc_servi, precio_servi, id_tipomas) "
                                             + "values (?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE servicio set desc_servi = ?, precio_servi = ?, id_tipomas = ? "
                                             + " WHERE id_servi = ?";
    
    private static final String SQL_DELETE = "DELETE FROM servicio WHERE id_servi = ?";
    
    public List<Servicio> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio servicio;
        List<Servicio> servicios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idServicio = rs.getInt("id_servi");
                String nombre = rs.getString("desc_servi");
                double precio = rs.getDouble("precio_servi");
                int idTipoMas = rs.getInt("id_tipomas");

                servicio = new Servicio(idServicio, nombre, precio, idTipoMas);

                servicios.add(servicio);
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

        return servicios;
    }
    
    public int insertar(Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, servicio.getDescripcion());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setInt(3, servicio.getId_tipo());
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
    
    public void update (Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, servicio.getDescripcion());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setInt(3, servicio.getId_tipo());
            stmt.setInt(4, servicio.getId());
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
    
    public void delete (Servicio servicio){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, servicio.getId());
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
