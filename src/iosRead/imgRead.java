package iosRead;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imgRead {

    public static BufferedImage loadImg(final String path){
        BufferedImage imagen = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        try {
            imagen = ImageIO.read(imgRead.class.getResource(path));
            /*ancho = imagen.getWidth();
            alto = imagen.getHeight();
            cuadrosCatalogo = new Cuadro[ancho * alto];
            pixeles = new int[ancho * alto];
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagen;
    }

    public static BufferedImage grayScale(final String path){
        BufferedImage imagen = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        BufferedImage imagen2 = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);


        try {
            imagen = ImageIO.read(imgRead.class.getResource(path));
            int w=imagen.getWidth();
            int h=imagen.getHeight();
            int pixeles[];

            pixeles = imagen.getRGB(0, 0, w, h, null, 0, 400);
            //System.out.println(pixeles[800]);
            for(int i=0; i<160000; i++){
                //rgb = 65536 * r + 256 * g + b;
                Color c = new Color(pixeles[i]);

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();


                //int y = (int) (0.299*r+ 0.587*g + 0.144*b);//System.out.println(y);
                int y = (int) ((r+g+b)/3);
                int rgb = 65793 * y;

                pixeles[i] = rgb;
            }
            System.out.println(pixeles[800]);
            //endImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            //WritableRaster raster = (WritableRaster) imagen2.getData();
            //raster.setPixels(0,0,w,h,pixeles);
            imagen2.setRGB(0, 0, w, h, pixeles, 0, w);

            //imagen2.getRaster().setPixels(0, 0, w, h, pixeles);

            /*ancho = imagen.getWidth();
            alto = imagen.getHeight();
            cuadrosCatalogo = new Cuadro[ancho * alto];
            pixeles = new int[ancho * alto];
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);*/
        } catch (IOException e) {
            e.printStackTrace();
        }



        return imagen2;
    }
}
