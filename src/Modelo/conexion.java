/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rental Servicios
 */
public class conexion {
    
    private String BD="C:\\Users\\Rental Servicios\\Documents\\QueComienceElJuego\\src\\Modelo\\retos.db";
    private Connection conexion;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst=null;
    
    public void connect(){
 try {
      Class.forName("org.sqlite.JDBC");
      conexion = DriverManager.getConnection("jdbc:sqlite:"+BD);
      st=conexion.createStatement();
     if (conexion!=null) {
         System.out.println("Conectado");
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
 public void IngresarDatos (String sent){
      try{
        
        st=conexion.createStatement();  
        st.executeUpdate(sent); 
               
        JOptionPane.showMessageDialog(null, "Registro Exitoso","Exito!",JOptionPane.INFORMATION_MESSAGE);
      }
      catch (SQLException e){
          JOptionPane.showMessageDialog(null, "Error en la insercion, por favor verifique\n"+e, "ERROR", JOptionPane.ERROR_MESSAGE);
          System.out.println(e);
      }
      finally {
          close();
      }
  }
 
 public void EliminarDatos (String sent){
      try{
        st=conexion.createStatement(); //Conexion del netbean al servidor 
        st.executeUpdate(sent); 
      }
      catch (SQLException e){
          System.out.println(e);
      }
      finally {close();}
  }
 
 public void ModificarDatos (String sent){
      try{
        st=conexion.createStatement(); //Conexion del netbean al servidor 
        st.executeUpdate(sent); 
        System.out.println("Operacion realizada");
      }
      catch (SQLException e){
          System.out.println(e);
      }
      finally {close();}
   }
   
       public ResultSet ConsultarDatos (String sent){
      try{
        st=conexion.createStatement(); //Conexion del netbean al servidor 
        rs=st.executeQuery(sent); //Devuelve, consulta interna en la base de datos
        System.out.println("Operacion realizada");
      }
      catch (SQLException e){
          System.out.println(e);
      }
      finally {return rs;}
  }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }
 
       
}
