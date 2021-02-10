package multiLayer2;

import java.util.ArrayList;

public class Neural_network {

    private ArrayList<Layer> all_Layers = new ArrayList<Layer>();
    private double n;
    private int input0_Num;
    private int output1_Num;
    private int layersNum;
    private int[] neuronsNum;

    private double[] outputMatrix;
    private double[] errorMatrix;
    private double total_Error;

    public Neural_network(int input0_Num, int layersNum, int[] neuronsNum, double n){
        this.input0_Num=input0_Num;
        this.layersNum=layersNum;
        this.neuronsNum=neuronsNum;
        this.n=n;

        initNeural_network();
    }

    private void initNeural_network(){
        for (int i=0; i<layersNum; i++){
            int in0=(i==0)? input0_Num:neuronsNum[i-1];
            all_Layers.add(new Layer( in0, neuronsNum[i]));
        }
        output1_Num=neuronsNum[layersNum-1];
    }

    public double trainNeuralNetwork(double[] input, double[] data){
        forwardNeuralNetwork(input);
        backwardNeuralNetwork(data);
        updateParameters();
        return total_Error;
    }

    public void forwardNeuralNetwork(double[] input0){
        for (int i=0; i<layersNum; i++){
            double[] preInputs=(i==0)? input0:all_Layers.get(i-1).getAMatrix();
            all_Layers.get(i).forwardLayer(preInputs);
        }

    }

    public void backwardNeuralNetwork(double[] data){
        computeError(data);
        double[] Error= errorMatrix;
        for (int i=layersNum-1; i>=0; i--){
            all_Layers.get(i).backwardLayer(Error);
            Error=all_Layers.get(i).getError();
        }
    }

    public void updateParameters(){
        for (int i=0; i<layersNum; i++){
            all_Layers.get(i).updateLayerParameters(n);
        }
    }

    private void computeError(double[] data){
        outputMatrix = new double[output1_Num];
        errorMatrix = new double[output1_Num];
        outputMatrix = all_Layers.get(layersNum-1).getAMatrix();

        for (int i=0; i<output1_Num; i++){
            errorMatrix[i]=outputMatrix[i]-data[i];
            total_Error+= 0.5*Math.pow(errorMatrix[i],2);
        }

    }

    public void getNeuralNetworkInfo(){
        System.out.println("------------------  NeuralNetwork_info  --------------------------\n");
        for (int i=0; i<layersNum; i++){
            System.out.println("       layer"+i+" :   "+all_Layers.get(i).getNeuronNum()+" neurons");
        }
        System.out.println("\n------------------------------------------------------------------");
    }
    public void getLayerInfo(int layer){
        System.out.println("------------------  layer"+layer+"  info ---------------");
        try {
            all_Layers.get(layer).getLayerInfo();
        }catch (IndexOutOfBoundsException e){
            System.out.println("     the layer does not exist ! ");
        }
    }
    public ArrayList<Layer> getAll_Layers() {
        return all_Layers;
    }
}
