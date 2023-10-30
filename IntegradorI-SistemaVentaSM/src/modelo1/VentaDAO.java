package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class VentaDAO {
    
     // Consultas SQL SELECT
    
    private static final String SQL_SELECT_MAXID = "SELECT MAX(id_venta) FROM venta";
    
    private static final String SQL_SELECT = "SELECT * FROM venta";
    
    private static final String SQL_INSERT = "INSERT INTO venta(fecha_venta, total_venta, id_perso, id_clien) "
                                             + "values (?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE venta set fecha_venta = ?, total_venta = ?, id_perso = ?, id_clien = ? "
                                             + "WHERE id_venta = ?";

    private static final String SQL_DELETE = "DELETE FROM venta WHERE id_venta = ?";
    
    public int SeleccionarID(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int ID = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MAXID);
            rs = stmt.executeQuery();
            if(rs.next()){
                ID = rs.getInt(1);
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
        return ID;
    }
    
    public List<Venta> Seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Venta venta;
        List<Venta> ventas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVenta = rs.getInt("id_venta");
                String fecha = rs.getString("fecha_venta");
                double total = rs.getDouble("total_venta");
                int idPersonal = rs.getInt("id_perso");
                int idCliente = rs.getInt("id_clien");

                venta = new Venta(idVenta, fecha, idVenta, idPersonal, idCliente);

                ventas.add(venta);
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

        return ventas;
    }
    
    public int insertar(Venta venta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, venta.getFecha());
            stmt.setDouble(2, venta.getTotalVenta());
            stmt.setInt(3, venta.getIdPersonal());
            stmt.setInt(4, venta.getIdCliente());
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
    
    public void update (Venta venta){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, venta.getFecha());
            stmt.setDouble(2, venta.getTotalVenta());
            stmt.setInt(3, venta.getIdPersonal());
            stmt.setInt(4, venta.getIdCliente());
            stmt.setInt(5, venta.getIdVenta());
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
    
    public void delete (Venta venta){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, venta.getIdVenta());
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
