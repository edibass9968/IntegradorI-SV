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

public class TipoMascotaDAO implements CRUD {

    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
public TipoMascota listarID(String nombre) {
        TipoMascota tipo = new TipoMascota();
        String sql = "select * from tipomascota where NOM_TIPOMAS=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                

            }
        } catch (Exception e) {
        }
        return tipo;
    }

    @Override
    public List Listar() {
        List<TipoMascota> lista = new ArrayList<>();
        String sql = "select * from tipomascota";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoMascota tipom = new TipoMascota();
                tipom.setId(rs.getInt(1));
                tipom.setNombre(rs.getString(2));
               
                lista.add(tipom);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into tipomascota(NOM_TIPOMAS)values(?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int Actualizar(Object[] o) {
        int r = 0;
        String sql = "update tipomascota set NOM_TIPOMAS=?"
                + "where ID_TIPOMAS=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void Eliminar(int id) {
        String sql = "delete from tipomascota where ID_TIPOMAS=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
