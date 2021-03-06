package multiLayer;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class Neural_network {

    private ArrayList<Layer> all_Layers = new ArrayList<Layer>();
    private int layersNum;

    public Neural_network(int input0_Num, int layersNum, int[] neuronsNum){
        this.layersNum=layersNum;

        for (int i=0; i<layersNum; i++){
            int in0=(i==0)? input0_Num:neuronsNum[i-1];
            all_Layers.add(new Layer( in0, neuronsNum[i]));
        }
    }
    public void forwardNeuralNetwork(double[] input0){
        for (int i=0; i<layersNum; i++){
            double[] preInputs=(i==0)? input0:all_Layers.get(i-1).getAMatrix();
            all_Layers.get(i).forwardLayer(preInputs);
        }
    }

    public void backwardNeuralNetwork(double[] data){
        double[] Lastdelta = new double[all_Layers.get(layersNum-1).getNeuronNum()];
        for(int i=0; i<all_Layers.get(layersNum-1).getNeuronNum(); i++){
            Lastdelta[i]=data[i]-all_Layers.get(layersNum-1).getAMatrix()[i];
        }
        for (int i=layersNum-2; i>=0; i--){
            double[][] pre_wT=all_Layers.get(i+1).getWeightsT_Matrix();
            double[] pre_delta=(i==layersNum-2)? Lastdelta:all_Layers.get(i+1).getDelta();
            all_Layers.get(i).backwardLayer(pre_delta, pre_wT);
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

    public void getNeuronInfo(int layer, int neuron){
        System.out.println("------------------  layer"+layer+"    --------------------");
        try {
            all_Layers.get(layer).getNeuronInfo(neuron);
        }catch (IndexOutOfBoundsException e){
            System.out.println("     the neuron does not exist ! ");
        }
    }

    public ArrayList<Layer> getAll_Layers() {
        return all_Layers;
    }
}
