/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUD {

    int r;
    PreparedStatement ps;
    Connection con;
    conexion cn = new conexion();

    ResultSet rs;

    public int actualizarStock(int cant, int idpr) {
        String sql = "update producto set STOCK_PRODU=? where ID_PRODU=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, idpr);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Producto listarID(int id) {
        Producto p = new Producto();
        String sql = "select * from producto where ID_PRODU=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setStock(rs.getInt(3));
                p.setPrecio(rs.getDouble(4));

            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public List Listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "select * from producto";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setStock(rs.getInt(3));
                p.setPrecio(rs.getDouble(4));

                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into producto(NOM_PRODU,STOCK_PRODU,PRECIO_PRODU)values(?,?,?)";
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
        String sql = "update producto set NOM_PRODU=?,STOCK_PRODU=?,PRECIO_PRODU=?"
                + "where ID_PRODU=?";
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
        String sql = "delete from producto where ID_PRODU=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
