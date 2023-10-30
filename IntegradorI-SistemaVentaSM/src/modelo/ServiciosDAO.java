/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class ServiciosDAO implements CRUD{

    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public Servicios listarID(String descripcion) {
        Servicios ser = new Servicios();
        String sql = "select * from servicio where DESC_SERVI=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, descripcion);
            rs = ps.executeQuery();
            while (rs.next()) {
                ser.setId(rs.getInt(1));
                ser.setDescripcion(rs.getString(2));
                ser.setPrecio(rs.getDouble(3));
                ser.setId_tipo(rs.getInt(4));

            }
        } catch (Exception e) {
        }
        return ser;
    }

    @Override
    public List Listar() {
        List<Servicios> lista = new ArrayList<>();
        String sql = "select * from servicio";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servicios serv = new Servicios();
                serv.setId(rs.getInt(1));
                serv.setDescripcion(rs.getString(2));
                serv.setPrecio(rs.getDouble(3));
                serv.setId_tipo(rs.getInt(4));
                lista.add(serv);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into servicio(DESC_SERVI,PRECIO_SERVI,ID_TIPOMAS)values(?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);

            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int Actualizar(Object[] o) {
        int r = 0;
        String sql = "update servicio set DESC_SERVI=?,PRECIO_SERVI=?,ID_TIPOMAS=?"
                + "where ID_SERVI=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void Eliminar(int id) {
        String sql = "delete from servicio where ID_SERVI=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
