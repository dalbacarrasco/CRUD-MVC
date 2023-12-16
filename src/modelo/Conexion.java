/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Conexion {
    private final String base = "producto";
    private final String user = "postgres";
    private final String password = "root";
    private final String url = "jdbc:postgresql://localhost:5432/producto";
    private Connection con = null;
    
    public Connection getConexion(){
        try{
            //Class.forName("com.postgresql.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.password);
        }catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
