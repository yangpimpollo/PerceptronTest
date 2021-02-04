package multiLayer;

import java.util.Random;

public class Neuron {

    private double[] w;
    private double b;
    private Random ran = new Random();

    public Neuron(int inputsNum){
        w = new double[inputsNum];
        b = ran.nextDouble();
        for (int i=0; i<inputsNum; i++){
            w[i]=ran.nextDouble();
        }
    }

    public double[] getWeights() {
        return w;
    }

    public double getBias() {
        return b;
    }
}
