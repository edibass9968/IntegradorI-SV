package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO implements CRUD {

    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public Cliente listarID(String nombre) {
        Cliente c = new Cliente();
        String sql = "select * from cliente where NOM_CLIEN=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setTelefono(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public List Listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "select * from cliente";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente co = new Cliente();
                co.setId(rs.getInt(1));
                co.setNombre(rs.getString(2));
                co.setApellido(rs.getString(3));
                co.setDni(rs.getString(4));
                co.setDireccion(rs.getString(5));
                co.setEmail(rs.getString(6));
                co.setTelefono(rs.getString(7));
                lista.add(co);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into cliente(NOM_CLIEN,APE_CLIEN,DNI_CLIEN,DIREC_CLIEN,EMAIL_CLIEN,FONO_CLIEN)values(?,?,?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int Actualizar(Object[] o) {
        int r = 0;
        String sql = "update cliente set NOM_CLIEN=?,APE_CLIEN=?,DNI_CLIEN=?,DIREC_CLIEN=?,EMAIL_CLIEN=?,FONO_CLIEN=?"
                + "where ID_CLIEN=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void Eliminar(int id) {
        String sql = "delete from cliente where ID_CLIEN=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }



}
