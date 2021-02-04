package multiLayer;

import java.util.ArrayList;

public class Layer {

    private ArrayList<Neuron> layerNeuron = new ArrayList<Neuron>();
    private int inputsNum;
    private int neuronNum;
    private double[][] w;
    private double[] b;
    private double[] z;
    private double[] a;
    private boolean forward=false;

    public Layer(int inputsNum, int neuronNum){
        this.inputsNum=inputsNum;
        this.neuronNum=neuronNum;
        this.w=w;
        this.b=b;
        this.z=z;

        w = new double[neuronNum][inputsNum];
        b = new double[neuronNum];
        z = new double[neuronNum];

        for (int i=0; i<neuronNum; i++){
            layerNeuron.add(new Neuron(inputsNum));
            w[i] = layerNeuron.get(i).getWeights();
            b[i] = layerNeuron.get(i).getBias();
        }
    }

    public double[] z_calulate(double[] inputs) {
        forward=true;
        for (int i=0; i<neuronNum; i++){
            z[i]=Hadamard(inputsNum, inputs, w[i], b[i]);
        }
        return z;
    }

    private double Hadamard(int length,double[] matrixA, double[] matrixB, double bias){
        double singleZ = 0;
        for (int i=0; i<length; i++){
            singleZ+=matrixA[i]*matrixB[i];
        }
        singleZ+=bias;
        return singleZ;
    }

    public void getLayerInfo(){

    }

    public int getInputsNum() { return inputsNum; }
    public int getNeuronNum() { return neuronNum; }

    public double[][] getWeightsMatrix() {
        return w;
    }
    public double[] getBiasMatrix() {
        return b;
    }
    public double[] getZMatrix() { return z=(forward)? z:null; }

    public ArrayList<Neuron> getLayerNeuron() {
        return layerNeuron;
    }


}
