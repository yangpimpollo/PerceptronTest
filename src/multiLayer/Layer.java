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
    private double[][] wT;
    private double[] da;
    private double[] delta;
    private boolean forward=false;
    private boolean backward=false;

    public Layer(int inputsNum, int neuronNum){
        this.inputsNum=inputsNum;
        this.neuronNum=neuronNum;
        this.w=w;
        this.b=b;
        this.z=z;
        this.a=a;
        this.wT=wT;
        this.da=da;
        this.delta=delta;

        w = new double[neuronNum][inputsNum];
        b = new double[neuronNum];
        z = new double[neuronNum];
        a = new double[neuronNum];

        wT = new double[inputsNum][neuronNum];
        da = new double[neuronNum];
        delta = new double[neuronNum];

        for (int i=0; i<neuronNum; i++){
            layerNeuron.add(new Neuron(inputsNum));
            w[i] = layerNeuron.get(i).getWeights();
            b[i] = layerNeuron.get(i).getBias();
        }
        wT = Transpose(w);
    }

    public void forwardLayer(double[] inputs){
        forward=true;
        a=sigmoid(z_calulate(inputs));
        da=sigmoid_Derivative(a);
    }

    public void backwardLayer(double[] pre_delta, double[][] pre_wT){
        backward=true;
        for (int j=0; j<neuronNum; j++){
            for (int i=0; i<inputsNum; i++){
                delta[j]+=pre_delta[i] * pre_wT[j][i];
            }
            delta[j]*= da[j];
        }
    }

    public double[] z_calulate(double[] inputs) {
        for (int i=0; i<neuronNum; i++){
            z[i]=Hadamard(inputsNum, inputs, w[i], b[i]);
        }
        return z;
    }

    public double[] sigmoid(double[] z){
        double[] sigmoid = new double[z.length];
        for (int i=0; i<neuronNum; i++){
            sigmoid[i]=1/(1+Math.exp(-z[i]));
        }
        return sigmoid;
    }

    private double Hadamard(int length,double[] matrixA, double[] matrixB, double bias){
        double singleZ = 0;
        for (int i=0; i<length; i++){
            singleZ+=matrixA[i]*matrixB[i];
        }
        singleZ+=bias;
        return singleZ;
    }

    private double[][] Transpose(double[][] matrix){
        double[][] matrixT = new double[matrix[0].length][matrix.length];
        for(int j=0; j<matrix.length; j++){
            for(int i=0; i<matrix[0].length; i++){
                matrixT[i][j] = matrix[j][i];
            }
        }
        return matrixT;
    }

    private double[] sigmoid_Derivative(double[] a){
        double[] sigmoid_Derivative = new double[a.length];
        for (int i=0; i<a.length; i++){
            sigmoid_Derivative[i]=a[i]*(1-a[i]);
        }
        return sigmoid_Derivative;
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
        //---------------
        /*System.out.println("\n--------  weightsT_matrix  ");
        for (int j=0; j<inputsNum; j++){
            System.out.println();
            for (int i=0; i<neuronNum; i++){
                System.out.println("    wT"+j+i+": "+wT[j][i]);
            }
        }*/
        //---------------
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
        //-----------------------
        System.out.println("\n--------  delta  ");
        for (int i=0; i<neuronNum; i++){
            System.out.println("    delta"+i+": "+delta[i]);
        }
        //-----------------------
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

    public double[][] getWeightsMatrix() { return w; }
    public double[] getBiasMatrix() { return b; }
    public double[] getZMatrix() { return z=(forward)? z:null; }
    public double[] getAMatrix() { return a=(forward)? a:null; }

    public double[][] getWeightsT_Matrix() { return wT; }
    public double[] getA_derivative() { return da; }
    public double[] getDelta() { return delta; }

    public ArrayList<Neuron> getLayerNeuron() {
        return layerNeuron;
    }


}
