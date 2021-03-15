package iosRead;

import multiLayer2.Layer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class iosRead {

    public static ArrayList<double[]> readCSV(final String path){
        //String text="";
        ArrayList<double[]>data = new ArrayList<double[]>();
        //double[][] data;

        InputStream inputbytes = ClassLoader.class.getResourceAsStream(path);
        BufferedReader lector = new BufferedReader(new InputStreamReader(inputbytes));

        String line;

        try {
            int j=-1;
            while((line=lector.readLine()) != null) {
                if(j>=0) {
                    String[] row = line.split(",");
                    data.add(new double[row.length]);
                    for (int i = 0; i < row.length; i++) {
                        data.get(j)[i] = Double.parseDouble(row[i]);
                    }
                }
                j++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(inputbytes != null){
                    inputbytes.close();
                }
                if(lector != null){
                    lector.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return data;
    }
}
