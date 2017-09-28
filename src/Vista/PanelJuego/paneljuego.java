/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.PanelJuego;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Rental Servicios
 */
public class paneljuego extends JPanel{
    
    JPanel Retos, Contador, header, volver;
    JButton bVolver;
    JLabel lHeader, lContador, lRetos;
    
    public paneljuego(){
    
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setBackground(new Color(100,125,255));
        
        
    }
    
    public void llenar_panel(){
        
       retos();
       
       this.add(Retos);
    
    }
    
    public void retos(){
        
        JLabel titulo=new JLabel("Tu Reto Es:");
        
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Tahoma", 2, 14));
        
        lRetos=new JLabel("REto Elegido(Este es el esquema)");
        lRetos.setForeground(Color.white);
        lRetos.setFont(new Font("Tahoma", 2, 40));
        
        Retos=new JPanel(new FlowLayout());
        
        Retos.add(titulo);
        Retos.add(lRetos);
    }
}
