package iosRead;

import java.util.ArrayList;

public class iosMain {

    public static void main(String[] args) {


        ArrayList<double[]> data =iosRead.readCSV("/ff.csv");

        for (int j=0; j<data.size(); j++){
            System.out.println("\n");
            for (int i=0; i<data.get(0).length; i++){
                System.out.print("  #"+data.get(j)[i]);
            }
        }
    }
}
