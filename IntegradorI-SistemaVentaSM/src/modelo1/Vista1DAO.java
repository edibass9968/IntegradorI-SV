package modelo1;

import Conexion1.Conexion2;
import static Conexion1.Conexion2.*;
import java.sql.*;
import java.util.*;

public class Vista1DAO {
    
    private static final String SQL_VISTA = "select `veterinaria_db`.`venta`.`ID_VENTA` AS `id_venta`,`veterinaria_db`.`cliente`.`NOM_CLIEN` AS `nom_clien`,"
            + "`veterinaria_db`.`cliente`.`APE_CLIEN` AS `ape_clien`,`veterinaria_db`.`cliente`.`DNI_CLIEN` AS `dni_clien`,"
            + "`veterinaria_db`.`venta`.`FECHA_VENTA` AS `fecha_venta` from (`veterinaria_db`.`venta` join `veterinaria_db`.`cliente`"
            + " on(`veterinaria_db`.`venta`.`ID_CLIEN` = `veterinaria_db`.`cliente`.`ID_CLIEN`))";
    
    public List<Vista1> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vista1 vista;
        List<Vista1> vistas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_VISTA);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVenta= rs.getInt("id_venta");
                String nombre = rs.getString("nom_clien");
                String apellido = rs.getString("ape_clien");
                String dni = rs.getString("dni_clien");
                String fecha = rs.getString("fecha_venta");

                vista = new Vista1(idVenta, nombre, apellido, dni, fecha);

                vistas.add(vista);
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

        return vistas;
    }
    
}
