package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class TipoMascotaDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM tipomascota";
    
    public List<TipoMascota> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoMascota tipomascota;
        List<TipoMascota> tipoMascotas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTipoMascota = rs.getInt("id_tipomas");
                String nombre = rs.getString("nom_tipomas");

                tipomascota = new TipoMascota(idTipoMascota, nombre);

                tipoMascotas.add(tipomascota);
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

        return tipoMascotas;
    }
    
}
