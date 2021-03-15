package csvTest;

import iosRead.iosRead;
import multiLayer2.Neural_network;

import java.util.ArrayList;

public class Test_1 {


    public static void main(String[] args) {
        ArrayList<double[]> data = iosRead.readCSV("/heart.csv");
        ArrayList<double[]> data_class = iosRead.readCSV("/heart_class.csv");


        int[][] neuronsNum = { {6, 6, 6, 6, 1}, {0, 0, 0, 0, 0} };

        Neural_network nn = new Neural_network(13, 5, neuronsNum, 0.3);

        double err = 999;
        int count = 0;
        while (err > 0.001) {
            double en = 0;
            for (int i = 0; i < 100; i++) {
                en += nn.trainNeuralNetwork(data.get(i), data_class.get(i));
                // System.out.println(en);
            }
            err = en/100;
            System.out.println(err);
            count++;
        }

        System.out.println("");
        System.out.println("veces: " + count);
    }
}
