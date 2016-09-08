/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.*;
    
public class Conexao {

    public Connection con = null;

    public Connection conectar() throws ClassNotFoundException, SQLException, Exception {

        String url = "jdbc:postgresql://localhost:5432/pizzaria";
        String username = "raphael";
        String passwd = "admin";
        
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url,username, passwd);

        return con;
    }

    public Connection desconectar() throws SQLException, Exception {

        con.close();

        return con;
    }
}
