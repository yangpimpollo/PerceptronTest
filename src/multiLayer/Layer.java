package multiLayer;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

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
        this.a=a;

        w = new double[neuronNum][inputsNum];
        b = new double[neuronNum];
        z = new double[neuronNum];
        a = new double[neuronNum];

        for (int i=0; i<neuronNum; i++){
            layerNeuron.add(new Neuron(inputsNum));
            w[i] = layerNeuron.get(i).getWeights();
            b[i] = layerNeuron.get(i).getBias();
        }
    }

    public void runLayer(double[] inputs){
        forward=true;
        sigmoid(z_calulate(inputs));
        //return a;
    }

    public double[] z_calulate(double[] inputs) {
        for (int i=0; i<neuronNum; i++){
            z[i]=Hadamard(inputsNum, inputs, w[i], b[i]);
        }
        return z;
    }

    public double[] sigmoid(double[] z){
        for (int i=0; i<neuronNum; i++){
            a[i]=1/(1+Math.exp(-z[i]));
        }
        return a;
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
        //System.out.println("------------------  layer_info  --------------------------\n");
        System.out.println("          inputsNum:  "+inputsNum);
        System.out.println("          neuronNum:  "+neuronNum);
        System.out.println("\n--------  bias_matrix  \n");
        for (int i=0; i<neuronNum; i++){
            System.out.println("     b"+i+": "+b[i]);
        }
        System.out.println("\n--------  weights_matrix  ");
        for (int j=0; j<neuronNum; j++){
            System.out.println();
            for (int i=0; i<inputsNum; i++){
                System.out.println("    w"+j+i+": "+w[j][i]);
            }
        }
        System.out.println("\n--------  z_weightedSum_matrix  \n");
        if(forward){
            for (int i=0; i<neuronNum; i++){
                System.out.println("     z"+i+": "+z[i]);
            }
        }else{
            System.out.println("     error:  still not propagate forward ! ");
        }
        System.out.println("\n--------  a_output_matrix  \n");
        if(forward){
            for (int i=0; i<neuronNum; i++){
                System.out.println("     a"+i+": "+a[i]);
            }
        }else{
            System.out.println("     error:  still not propagate forward ! ");
        }
        System.out.println("\n----------------------------------------------------------");
    }

    public void getNeuronInfo(int neuron){
        System.out.println("------------------  neuron"+neuron+"  info ---------------\n");
        try {
            layerNeuron.get(neuron).getNeuronInfo();
        }catch (IndexOutOfBoundsException e){
            System.out.println("     the neuron does not exist ! ");
        }
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
    public double[] getAMatrix() { return a=(forward)? a:null; }

    public ArrayList<Neuron> getLayerNeuron() {
        return layerNeuron;
    }


}
