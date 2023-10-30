package Conexion1;

import java.sql.*;

public class Conexion2 {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/veterinaria_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
