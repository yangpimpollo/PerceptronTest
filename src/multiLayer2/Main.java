package multiLayer2;

public class Main {

    private static double[][] data_in = { {1,1},
                                          {1,0},
                                          {0,1},
                                          {0,0} };
    private static double[][] data_out= { {1}, {0}, {0}, {0}};

    //-----------
    private static double[][] data_in2 = { {1,1} };
    private static double[][] data_out2= { {1} };
    //-----------

    public static void main(String[] args) {
        int[] neuronsNum={1};
        //double[] input0={1,2};
        //double[] data={0.8};

        Neural_network nn=new Neural_network(2,1, neuronsNum, 0.3);
        /*nn.getAll_Layers().get(0).getInfo2();
        double ee=nn.trainNeuralNetwork(data_in[0], data_out[0]);
        System.out.println("----------------------------------------------");
        System.out.println("error"+ee);
        nn.getLayerInfo(0);
        ee=nn.trainNeuralNetwork(data_in[0], data_out[0]);
        System.out.println("----------------------------------------------");
        System.out.println("error"+ee);
        nn.getLayerInfo(0);*/





        double err=999;
        int count=0;
    	while (err>0.01){
    	    double en=0;
    	    for(int i=0; i<4; i++){
                en+= nn.trainNeuralNetwork(data_in[i], data_out[i]);
            }
        	err=en/4;///4;
            System.out.println(err);
       		count++;
    	}
        System.out.println("");
        System.out.println("veces: "+count);
    }
}

/*
        nn.forwardNeuralNetwork(input0);
        nn.backwardNeuralNetwork(data);
        nn.getNeuralNetworkInfo();
        nn.getLayerInfo(0);
        nn.getLayerInfo(1);
        nn.updateParameters();
 */


/*Layer l = new Layer(3, 5);
        l.forwardLayer(input0);
        l.getLayerInfo();*/