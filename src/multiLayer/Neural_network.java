package multiLayer;

import java.util.ArrayList;

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
    public void runNeuron(double[] input0){

        for (int i=0; i<layersNum; i++){
            double[] preInputs=(i==0)? input0:all_Layers.get(i-1).getZMatrix();
            all_Layers.get(i).z_calulate(preInputs);
        }
        //return 0;
    }

    public ArrayList<Layer> getAll_Layers() {
        return all_Layers;
    }
}
