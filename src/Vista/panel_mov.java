/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author Rental Servicios
 */
public class panel_mov  extends JPanel{
    
     //instancia a la pelota en posicion (X,Y) => (0,0)
    private Movimiento mov = new Movimiento(0,0);
    private Timer timer;

    //Constructor
    public panel_mov(Dimension d) {
        this.setSize(d);
        this.setPreferredSize(d);
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(new Color(0,0,0));
        this.setOpaque(false);
        mov.LimitesXY(getWidth(), getHeight());
        //para la animación
        timer = new Timer(16, new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                mov.move();
                repaint();
            }
        });
    }

    
    //Controla el inicio y fin de la animación
    public void animar(boolean turnOnOff) {
        if (turnOnOff) {
            mov.setVelocidadXY();
            timer.start();
        } else {
            timer.stop();
        }
    }

    //pinta la animación
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        mov.dibujar(g);
    }

    
}
