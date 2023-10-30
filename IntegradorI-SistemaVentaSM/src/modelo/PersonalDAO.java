package modelo;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class PersonalDAO {
    
    // Consultas SQL SELECT
    
    private static final String SQL_SELECT = "SELECT * FROM personal";
    
    private static final String SQL_INSERT = "INSERT INTO personal(nom_perso, ape_perso, dni_perso, direc_perso, email_perso, fono_perso, usu_perso, "
                                             + "pass_perso, id_tipoper) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE personal set nom_perso = ?, ape_perso = ?, dni_perso = ?, direc_perso = ?, email_perso = ?, "
                                             + "fono_perso = ?, usu_perso = ?, pass_perso = ?, id_tipoper = ? WHERE id_perso = ?";
    private static final String SQL_UPDATE_DATOSPERSONALES = "UPDATE personal set nom_perso = ?, ape_perso = ?, dni_perso = ?, direc_perso = ?, email_perso = ?, "
                                             + "fono_perso = ?, usu_perso = ?, pass_perso = ? WHERE id_perso = ?";
    private static final String SQL_DELETE = "DELETE FROM personal WHERE id_perso = ?";
    
    public List<Personal> seleccionarLogin() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Personal personal;
        List<Personal> personales = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_perso");
                String nombre = rs.getString("nom_perso");
                String apellido = rs.getString("ape_perso");
                String dni = rs.getString("dni_perso");
                String direccion = rs.getString("direc_perso");
                String email = rs.getString("email_perso");
                String telefono = rs.getString("fono_perso");
                String usuario = rs.getString("usu_perso");
                String password = rs.getString("pass_perso");

                personal = new Personal(idPersona, nombre, apellido, dni, direccion, email, telefono, usuario, password);

                personales.add(personal);
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

        return personales;
    }    
    
    public List<Personal> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Personal personal;
        List<Personal> personales = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_perso");
                String nombre = rs.getString("nom_perso");
                String apellido = rs.getString("ape_perso");
                String dni = rs.getString("dni_perso");
                String direccion = rs.getString("direc_perso");
                String email = rs.getString("email_perso");
                String telefono = rs.getString("fono_perso");
                String usuario = rs.getString("usu_perso");
                String password = rs.getString("pass_perso");
                int idTipoPer = rs.getInt("id_tipoper");

                personal = new Personal(idPersona, nombre, apellido, dni, direccion, email, telefono, usuario, password, idTipoPer);

                personales.add(personal);
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

        return personales;
    }
    
    public int insertar(Personal personal){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, personal.getNomPerso());
            stmt.setString(2, personal.getApePerso());
            stmt.setString(3, personal.getDniPerso());
            stmt.setString(4, personal.getDirecPerso());
            stmt.setString(5, personal.getEmailPerso());
            stmt.setString(6, personal.getFonoPerso());
            stmt.setString(7, personal.getUsuPerso());
            stmt.setString(8, personal.getPassPerso());
            stmt.setInt(9, personal.getIdTipoPer());
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
    
    public void update (Personal personal){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, personal.getNomPerso());
            stmt.setString(2, personal.getApePerso());
            stmt.setString(3, personal.getDniPerso());
            stmt.setString(4, personal.getDirecPerso());
            stmt.setString(5, personal.getEmailPerso());
            stmt.setString(6, personal.getFonoPerso());
            stmt.setString(7, personal.getUsuPerso());
            stmt.setString(8, personal.getPassPerso());
            stmt.setInt(9, personal.getIdTipoPer());
            stmt.setInt(10, personal.getIdPerso());
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
    
    public void updateDatosPersonales (Personal personal){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_DATOSPERSONALES);
            stmt.setString(1, personal.getNomPerso());
            stmt.setString(2, personal.getApePerso());
            stmt.setString(3, personal.getDniPerso());
            stmt.setString(4, personal.getDirecPerso());
            stmt.setString(5, personal.getEmailPerso());
            stmt.setString(6, personal.getFonoPerso());
            stmt.setString(7, personal.getUsuPerso());
            stmt.setString(8, personal.getPassPerso());
            stmt.setInt(9, personal.getIdPerso());
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
    
    public void delete (Personal personal){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, personal.getIdPerso());
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
