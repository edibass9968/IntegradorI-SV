package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class MascotaDAO {
    
    // Consultas SQL SELECT
    
    private static final String SQL_SELECT = "SELECT * FROM mascota";
    
    private static final String SQL_INSERT = "INSERT INTO mascota(nom_masco, gene_masco, raza_masco, id_clien, id_tipomas "
                                             + "values (?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE mascota set nom_masco = ?, gene_masco = ?, raza_masco = ?, id_clien = ?, id_tipomas = ? "
                                             + " WHERE id_masco = ?";

    private static final String SQL_DELETE = "DELETE FROM mascota WHERE id_masco = ?";
    
    public List<Mascota> Seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Mascota mascota;
        List<Mascota> mascotas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idMascota = rs.getInt("id_masco");
                String nombre = rs.getString("nom_masco");
                String genero = rs.getString("gene_masco");
                String raza = rs.getString("raza_masco");
                int idCliente = rs.getInt("id_clien");
                int idTipoMas = rs.getInt("id_tipomas");

                mascota = new Mascota(idMascota, nombre, genero, raza, idCliente, idTipoMas);

                mascotas.add(mascota);
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

        return mascotas;
    }
    
    public int insertar(Mascota mascota){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getGenero());
            stmt.setString(3, mascota.getRaza());
            stmt.setInt(4, mascota.getIdCliente());
            stmt.setInt(5, mascota.getIdTipoMas());
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
    
    public void update (Mascota mascota){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getGenero());
            stmt.setString(3, mascota.getRaza());
            stmt.setInt(4, mascota.getIdCliente());
            stmt.setInt(5, mascota.getIdTipoMas());
            stmt.setInt(6, mascota.getIdMascota());
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
    
    public void delete (Mascota mascota){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, mascota.getIdMascota());
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
