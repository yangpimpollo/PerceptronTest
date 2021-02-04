package multiLayer;

import java.util.ArrayList;

public class Neural_network {

    private ArrayList<Layer> all_Layers = new ArrayList<Layer>();

    public Neural_network(int input0_Num, int layersNum, int[] neuronsNum){

        for (int i=0; i<layersNum; i++){
            int in0=(i==0)? input0_Num:neuronsNum[i-1];
            all_Layers.add(new Layer( in0, neuronsNum[i]));
        }
    }
    public double runNeuron(){
        return 0;
    }
}
