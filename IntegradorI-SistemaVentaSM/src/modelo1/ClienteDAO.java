package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class ClienteDAO {
    
    // Consultas SQL SELECT
    
    private static final String SQL_SELECT = "SELECT * FROM cliente";
    
    private static final String SQL_INSERT = "INSERT INTO cliente(nom_clien, ape_clien, dni_clien, direc_clien, email_clien, fono_clien "
                                             + "values (?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE cliente set nom_clien = ?, ape_clien = ?, dni_clien = ?, direc_clien = ?, email_clien = ?, "
                                             + "fono_clien = ? WHERE id_clien = ?";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_clien = ?";
    
    public List<Cliente> Seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_clien");
                String nombre = rs.getString("nom_clien");
                String apellido = rs.getString("ape_clien");
                String dni = rs.getString("dni_clien");
                String direccion = rs.getString("direc_clien");
                String email = rs.getString("email_clien");
                String telefono = rs.getString("fono_clien");

                cliente = new Cliente(idCliente, nombre, apellido, dni, direccion, email, telefono);

                clientes.add(cliente);
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

        return clientes;
    }
    
    public int insertar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getDNI());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getTelefono());
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
    
    public void update (Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getDNI());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getTelefono());
            stmt.setInt(7, cliente.getIdCliente());
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
    
    public void delete (Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());
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
