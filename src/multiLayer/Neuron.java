package multiLayer;

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

    public double[] getWeights() {
        return w;
    }

    public double getBias() {
        return b;
    }

    public void getNeuronInfo(){
        System.out.println("------------------  neural_info  -------------------------\n");
        System.out.println("     b: "+b);
        for (int i=0; i<inputsNum; i++){
            System.out.println("    w"+i+": "+w[i]);
        }
        System.out.println("\n----------------------------------------------------------");
    }
}
