/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.PanelJuego.paneljuego;
import Vista.ventana_principal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rental Servicios
 */
public class Control_Pagina_Principal implements ActionListener{

    ventana_principal aux;

    public Control_Pagina_Principal(ventana_principal aux) {
        this.aux = aux;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==aux.getBoton()){
        
            paneljuego mostrar= new paneljuego();
            
            aux.getC().add(mostrar, BorderLayout.CENTER);
            aux.getC().remove(aux.getpPrincipal());
            
        }
    }
    
}
