package multiLayer2;

import multiLayer.Neuron;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class Layer {

    private Tools operative = new Tools();
    private ArrayList<Neuron> layerNeuron = new ArrayList<Neuron>();
    private int inputsNum;
    private int neuronNum;
    private double[][] w;
    private double[][] wT;
    private double[] b;

    private double[] inputs;
    private double[] z;
    private double[] a;
    private double[] da;
    private double[] delta;
    private double[] error;private boolean forward=false;

    public Layer(int inputsNum, int neuronNum){
        this.inputsNum=inputsNum;
        this.neuronNum=neuronNum;

        initLayer();

    }

    private void initLayer(){

        w = new double[neuronNum][inputsNum];
        wT = new double[inputsNum][neuronNum];
        b = new double[neuronNum];

        for (int i=0; i<neuronNum; i++){
            layerNeuron.add(new Neuron(inputsNum));
            w[i] = layerNeuron.get(i).getWeights();
            b[i] = layerNeuron.get(i).getBias();
        }
        wT = operative.Transpose(w);
    }

    public void forwardLayer(double[] inputs){
        this.inputs = inputs;
        z = new double[neuronNum];
        a = new double[neuronNum];
        da = new double[neuronNum];

        z=operative.z_calulate(inputs, w, b);
        a=operative.sigmoid(z);
        da=operative.sigmoid_Derivative(a);getInfo2();
    }

    public void backwardLayer(double[] error){
        delta = new double[neuronNum];
        for (int i=0; i<neuronNum; i++){
            delta[i]=error[i] * da[i];
        }
        computeLayerError();
    }

    public void updateLayerParameters(double n){
        for (int j=0; j<neuronNum; j++){
            b[j]-=n*delta[j];
            for (int i=0; i<inputsNum; i++){
                w[j][i]-=n*delta[j]*inputs[i];
            }
        }
    }

    private void computeLayerError(){
        error = new double[inputsNum];
        for (int j=0; j<inputsNum; j++){
            for (int i=0; i<neuronNum; i++){
                error[j] += delta[i]*wT[j][i];
            }
        }
    }

    //---------------------------------------
    public void getInfo2(){
        //System.out.println("------------------  layer_info  --------------------------\n");
        //System.out.println("          inputsNum:  "+inputsNum);
        //System.out.println("          neuronNum:  "+neuronNum);
        //System.out.println("\n--------  bias_matrix  \n");
        for (int i=0; i<neuronNum; i++){
            System.out.println("     b"+i+": "+b[i]);
        }
        //System.out.println("\n--------  weights_matrix  ");
        for (int j=0; j<neuronNum; j++){
            //System.out.println();
            for (int i=0; i<inputsNum; i++){
                System.out.println("    w"+j+i+": "+w[j][i]);
            }
        }
    }
    //---------------------------------------

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
        System.out.println("\n--------  weightsT_matrix  ");
        for (int j=0; j<inputsNum; j++){
            System.out.println();
            for (int i=0; i<neuronNum; i++){
                System.out.println("    wT"+j+i+": "+wT[j][i]);
            }
        }
        //---------------
        System.out.println("\n--------  z_weightedSum_matrix  \n");
        //if(forward){
            for (int i=0; i<neuronNum; i++){
                System.out.println("     z"+i+": "+z[i]);
            }
        //}else{
            //System.out.println("     error:  still not propagate forward ! ");
        //}
        System.out.println("\n--------  a_output_matrix  \n");
        //if(forward){
            for (int i=0; i<neuronNum; i++){
                System.out.println("     a"+i+": "+a[i]);
            }
        //}else{
            //System.out.println("     error:  still not propagate forward ! ");
        //}
        //-----------------------
        System.out.println("\n--------  da_matrix  \n");
        //if(forward){
            for (int i=0; i<neuronNum; i++){
                System.out.println("     da"+i+": "+da[i]);
            }
        //}else{
            //System.out.println("     error:  still not propagate forward ! ");
        //}
        System.out.println("\n--------  delta  ");
        //if(forward){
        for (int i=0; i<neuronNum; i++){
            System.out.println("    delta"+i+": "+delta[i]);
        }
        //}else{
            //System.out.println("     error:  still not propagate forward ! ");
        //}
        System.out.println("\n--------  error  ");
        //if(forward){
        for (int i=0; i<inputsNum; i++){
            System.out.println("    error"+i+": "+error[i]);
        }
        //}else{
           // System.out.println("     error:  still not propagate forward ! ");
        //}
        //-----------------------
        System.out.println("\n----------------------------------------------------------");
    }

    public int getInputsNum() { return inputsNum; }
    public int getNeuronNum() { return neuronNum; }

    public double[][] getWeightsMatrix() { return w; }
    public double[][] getWeightsT_Matrix() { return wT; }
    public double[] getBiasMatrix() { return b; }

    public double[] getZMatrix() { return z; }
    public double[] getAMatrix() { return a; }


    public double[] getA_derivative() { return da; }
    public double[] getDelta() { return delta; }
    public double[] getError() { return error; }

    public ArrayList<Neuron> getLayerNeuron() {
        return layerNeuron;
    }

}
