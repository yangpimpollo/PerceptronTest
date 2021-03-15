package iosRead;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class imgMain extends JFrame {

    private JPanel p0;
    private BufferedImage imagen = imgRead.loadImg("/nn.png");
    private BufferedImage gray_imagen = imgRead.grayScale("/nn.png");

    public imgMain(){
        //f0 = new JFrame();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("imgMain");
        setSize(800,400);
        setLocationRelativeTo(null);

        p0 = new JPanel();
        //p0.setSize(800, 400);
        add(p0);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        g.drawImage(imagen, 0, 0, 400, 400, null);
        g.drawImage(gray_imagen, 400, 0, 400, 400, null);
        /*g.setColor( Color.blue );
        g.fillRect( 50,50,100,340 );
        g.drawLine(100, 100, 200, 200);*/
    }

    public static void main(String args[]){
        imgMain m = new imgMain();

    }
}
