package multiLayer;

public class Main {

    public static void main(String[] args) {
        int[] neuronsNum={3,2};
        double[] input0= {3, 8};

        Neural_network nn=new Neural_network(2,2, neuronsNum);
        nn.getNeuralNetworkInfo();

        //nn.getNeuronInfo(0,2);
        nn.runNeuralNetwork(input0);
        nn.getLayerInfo(0);
        nn.getLayerInfo(1);

        //Neuron n = new Neuron(2);
        //n.getNeuronInfo();
        /*Layer l = new Layer(1,2);
        l.runLayer(input0);
        l.getLayerInfo();
        l.getNeuronInfo(5);
        l.getNeuronInfo(1);*/

    }
}

/*
        test 2
         public static void main(String[] args) {
        int[] neuronsNum={3,2};
        double[] input0= {3, 8};


        Neural_network nn=new Neural_network(2,2, neuronsNum);

        System.out.println("-------------------------------------------");
        System.out.println("--layer 0");
        //System.out.println("bias0: "+nn.getAll_Layers().get(0).getLayerNeuron().get(0).getBias());
        //System.out.println("bias1: "+nn.getAll_Layers().get(0).getLayerNeuron().get(1).getBias());
        //System.out.println("bias2: "+nn.getAll_Layers().get(0).getLayerNeuron().get(2).getBias());
        //System.out.println("--------------------------");
        for (int i=0; i<nn.getAll_Layers().get(0).getNeuronNum(); i++){
        System.out.println("bias"+i+": "+nn.getAll_Layers().get(0).getBiasMatrix()[i]);
        }
        System.out.println("--------------------------");
        for (int j=0; j< nn.getAll_Layers().get(0).getNeuronNum(); j++){
        System.out.println();
        for (int i=0; i< nn.getAll_Layers().get(0).getInputsNum(); i++){
        System.out.println("-"+nn.getAll_Layers().get(0).getWeightsMatrix()[j][i]);
        }
        }

        System.out.println("-------------------------------------------");
        System.out.println("--layer 1");

        for (int i=0; i<nn.getAll_Layers().get(1).getNeuronNum(); i++){
        System.out.println("bias"+i+": "+nn.getAll_Layers().get(1).getBiasMatrix()[i]);
        }
        System.out.println("--------------------------");
        for (int j=0; j< nn.getAll_Layers().get(1).getNeuronNum(); j++){
        System.out.println();
        for (int i=0; i< nn.getAll_Layers().get(1).getInputsNum(); i++){
        System.out.println("-"+nn.getAll_Layers().get(1).getWeightsMatrix()[j][i]);
        }
        }

        nn.runNeuron(input0);
        System.out.println("-------------------------------------------");
        System.out.println("-- Z_layer 0");
        for (int i=0; i<nn.getAll_Layers().get(0).getNeuronNum(); i++){
        System.out.println("z0-"+i+": "+nn.getAll_Layers().get(0).getZMatrix()[i]);
        }
        System.out.println("-------------------------------------------");
        System.out.println("-- Z_layer 1");
        for (int i=0; i<nn.getAll_Layers().get(1).getNeuronNum(); i++){
        System.out.println("z1-"+i+": "+nn.getAll_Layers().get(1).getZMatrix()[i]);
        }
        }
 */
/*
        test 1
public static void main(String[] args) {

        Layer l=new Layer(2,3);
        System.out.println("bias1: "+l.getLayerNeuron().get(0).getBias());
        System.out.println("bias2: "+l.getLayerNeuron().get(1).getBias());
        System.out.println("bias3: "+l.getLayerNeuron().get(2).getBias());
        System.out.println("--------------------------");

        for (int j=0; j< l.getNeuronNum(); j++){
            System.out.println();
            for (int i=0; i< l.getInputsNum(); i++){
                System.out.println("-"+l.getWeightsMatrix()[j][i]);
            }
        }

        double[] input= {3.5, 8.2};


        System.out.println("--------------------------");
        for (int i=0; i<3; i++){
            System.out.println("z"+i+": "+l.z_calulate(input)[i]);
        }

        System.out.println("--------------------------");
        for (int i=0; i<3; i++){
            System.out.println("-z"+i+": "+l.getZMatrix()[i]);
        }

    }
 */