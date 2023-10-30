package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class ProductoDAO2 {
    
    private static final String SQL_SELECT = "SELECT * FROM producto";
    
    private static final String SQL_INSERT = "INSERT INTO producto(nom_produ, stock_produ, precio_produ) "
                                             + "values (?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE producto set nom_produ = ?, stock_produ = ?, precio_produ = ? "
                                             + " WHERE id_produ = ?";
    
    private static final String SQL_DELETE = "DELETE FROM producto WHERE id_produ = ?";
    
    public List<Producto> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto;
        List<Producto> productos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("id_produ");
                String nombre = rs.getString("nom_produ");
                int stock = rs.getInt("stock_produ");
                double precio = rs.getDouble("precio_produ");

                producto = new Producto(idProducto, nombre, stock, precio);

                productos.add(producto);
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

        return productos;
    }
    
    public int insertar(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNom());
            stmt.setInt(2, producto.getStock());
            stmt.setDouble(3, producto.getPrecio());
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
    
    public void update (Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNom());
            stmt.setInt(2, producto.getStock());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getId());
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
    
    public void delete (Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getId());
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
