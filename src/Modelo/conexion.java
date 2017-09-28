/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rental Servicios
 */
public class conexion {
    
   // String url="C:\\Users\\Rental Servicios\\bd1.db";
    Connection conexion;
    
    public void connect(){
 try {
      Class.forName("org.sqlite.JDBC");
      conexion = DriverManager.getConnection("jdbc:sqlite:bd1.db");
     if (conexion!=null) {
         System.out.println("ConectadO");
     }
 }catch (SQLException ex) {
     System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
 }      catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 public void close(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
 }        
}
