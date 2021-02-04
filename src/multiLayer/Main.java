package multiLayer;

public class Main {

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

    }
}
