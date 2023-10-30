
package modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MascotaDAO implements CRUD {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
       public Mascota listarID(String nombre){
        Mascota m=new Mascota();
        String sql="select * from mascota where NOM_MASCO=?";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            while (rs.next()) {                
                m.setId1(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setGenero(rs.getString(3));
                m.setRaza(rs.getString(4));
                m.setId_clien(rs.getInt(5));
                m.setId_tipomas(rs.getInt(6));
                
            }
        } catch (Exception e) {
        }
        return m;
    }
    
    @Override
    public List Listar() {
        List<Mascota> lista=new ArrayList<>();
        String sql="select * from mascota";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Mascota masco=new Mascota();
                masco.setId1(rs.getInt(1));
                masco.setNombre(rs.getString(2));
                masco.setGenero(rs.getString(3));
                masco.setRaza(rs.getString(4));
                masco.setId_clien(rs.getInt(5));
                masco.setId_tipomas(rs.getInt(6));
                
                lista.add(masco);
            }
        } catch (Exception e) {
        }
        return lista;
    }

  @Override
    public int add(Object[] o) {
        int r=0;
        String sql="insert into mascota(NOM_MASCO,GENE_MASCO,RAZA_MASCO,ID_CLIEN,ID_TIPOMAS)values(?,?,?,?,?)";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int Actualizar(Object[] o) {
        int r=0;
        String sql="update mascota set NOM_MASCO=?,GENE_MASCO=?,RAZA_MASCO=?,ID_CLIEN=?,ID_TIPOMAS=?"
                + "where ID_MASCO=?";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void Eliminar(int id1) {
        String sql="delete from mascota where ID_MASCO=?";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id1);
            ps.executeUpdate();
        } catch (Exception e) {
        }   
    }
    
    
    
}
