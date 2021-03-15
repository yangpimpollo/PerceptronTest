package multiLayer2;

import java.util.Random;

public class Neuron {

    private Random ran = new Random();

    private int inputsNum;
    private double[] w;
    private double b;

    public Neuron(int inputsNum){
        this.inputsNum=inputsNum;

        w = new double[inputsNum];
        b = ran.nextDouble();
        for (int i=0; i<inputsNum; i++){
            w[i]=ran.nextDouble();
        }
    }

    public double[] getWeights() { return w; }
    public double getBias() {
        return b;
    }

}

