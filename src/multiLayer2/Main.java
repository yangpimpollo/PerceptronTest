package multiLayer2;

public class Main {

    private static double[][] data_in = { { 1, 1 }, { 1, 0 }, { 0, 1 }, { 0, 0 } };
    private static double[][] data_out = { { 1 }, { 0 }, { 0 }, { 0 } };

    // -----------
    private static double[][] data_in2 = { { 1, 1 } };
    private static double[][] data_out2 = { { 1 } };

    private static double[][] data_in3 = { { 1, 1 }, { 1, 0 }, { 0, 1 }, { 0, 0 } };
    private static double[][] data_out3 = { { 0, 1 }, { 1, 1 }, { 1, 1 }, { 0, 1 } };

    // -----------

    public static void main(String[] args) {
        int[][] neuronsNum = { {3, 3, 2}, {0, 0, 0} };
        // double[] input0={1,2};
        // double[] data={0.8};

        Neural_network nn = new Neural_network(2, 3, neuronsNum, 0.3);
        /*
         * nn.getAll_Layers().get(0).getInfo2(); double
         * ee=nn.trainNeuralNetwork(data_in[0], data_out[0]);
         * System.out.println("----------------------------------------------");
         * System.out.println("error"+ee); nn.getLayerInfo(0);
         * ee=nn.trainNeuralNetwork(data_in[0], data_out[0]);
         * System.out.println("----------------------------------------------");
         * System.out.println("error"+ee); nn.getLayerInfo(0);
         */

        double err = 999;
        int count = 0;
        while (err > 0.001) {
            double en = 0;
            for (int i = 0; i < 4; i++) {
                en += nn.trainNeuralNetwork(data_in3[i], data_out3[i]);
                // System.out.println(en);
            }
            err = en / 4;/// 4;
            System.out.println(err);
            count++;
        }
        System.out.println("");
        System.out.println("veces: " + count);
        System.out.println("\n-----------------------------------------\n");
        nn.runNeuralNetwork(data_in3[0]);
        System.out.println("------------------------------");
        nn.runNeuralNetwork(data_in3[1]);
        System.out.println("------------------------------");
        nn.runNeuralNetwork(data_in3[2]);
        System.out.println("------------------------------");
        nn.runNeuralNetwork(data_in3[3]);
    }
}

/*
 * nn.forwardNeuralNetwork(input0); nn.backwardNeuralNetwork(data);
 * nn.getNeuralNetworkInfo(); nn.getLayerInfo(0); nn.getLayerInfo(1);
 * nn.updateParameters();
 */

/*
 * Layer l = new Layer(3, 5); l.forwardLayer(input0); l.getLayerInfo();
 */