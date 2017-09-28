/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Rental Servicios
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * 
 * @author Josue
 */
public class Movimiento {

    private Image imagen;
    //Coordenadas de la pelota
    private int X;
    private int Y;

    private int velocidad_X;
    private int velocidad_Y;

    private int limite_izquierda=0;
    private int limite_derecha;
    private int limite_superior=0;
    private int limite_inferior;

     public Movimiento(int x, int y) {
        //coordenadas iniciales
        this.X = x; this.Y = y;
        //imagen de la pelota
        imagen = new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage();
    }

    //dado las dimensiones del contendor JPanel
   public void LimitesXY(int width, int height) {
        limite_derecha  = width  - imagen.getWidth(null);
        limite_inferior = height - imagen.getHeight(null);
    }

   //recalcula variables para dar la sensacion de movimiento
   public void move() {
        //nueva posicion
        X += velocidad_X;
        Y += velocidad_Y;
        //controla que la pelota no salga de los limites del contenedor
        if (X < this.limite_izquierda) {
            X = 0;
            velocidad_X = -velocidad_X;
        } else if (X > limite_derecha) {
            X = limite_derecha;
            velocidad_X = -velocidad_X;
        }
        if (Y < this.limite_superior) {
            Y = 0;
            velocidad_Y = -velocidad_Y;

        } else if (Y > limite_inferior) {
            Y =  limite_inferior;
            velocidad_Y = -velocidad_Y;
        }
    }

    public void setVelocidadXY(){
        velocidad_X = getNumberRandom(4);
        velocidad_Y = getNumberRandom(5);
    }

    public void dibujar(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(imagen, X, Y, null);
    }

    //devuelve un número aleatorio entre 1 y MAX
    private int getNumberRandom(int Max){
        return (int) (Math.random()*Max+1);
    }
}
