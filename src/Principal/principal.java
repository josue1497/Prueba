
package Principal;

import Modelo.conexion;
import Vista.ventana_principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class principal {

    
    public static void main(String[] args) {
        
        
        //ventana_principal ver=new ventana_principal();
         /*try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:bd1.db");
             System.out.println("Conectado");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos");
        }*/
        
        conexion con=new conexion();
        con.connect();
        con.close();
        
        /*int numero;
        
        numero=(int)(Math.random()*9)+1;
        System.out.println(numero);*/
        
    }
    
}
