import java.util.Random;

public class Xor_Perceptron0 {

    private Random ran = new Random();
    private static Xor_Perceptron0 xor;
    private static final double n = 0.3;
    private double l0_b[], l1_b[];
    private double l0_w[][], l1_w[][];
    private double l0_wT[][], l1_wT[][];
    private double l0_z[], l1_z[];
    private double l0_a[], l1_a[];
    private double l0_da[], l1_da[];
    private double l0_delta[], l1_delta[];
    private double l0_error[], l1_error[];

    private double input[];
    private static double error;

    public Xor_Perceptron0() {
        l0_b = new double[2];
        l0_b = rand(l0_b);
        l1_b = new double[1];
        l1_b = rand(l1_b);

        l0_w = new double[2][2];
        l0_w[0] = rand(l0_w[0]);
        l0_w[1] = rand(l0_w[1]);
        l0_wT = Transpose(l0_w);
        l1_w = new double[1][2];
        l1_w[0] = rand(l1_w[0]);
        l1_wT = Transpose(l1_w);

    }

    public void forward(double[] inputs) {
        input = inputs;
        l0_z = new double[2];
        l0_a = new double[2];
        l0_da = new double[2];

        l0_z[0] = l0_w[0][0] * inputs[0] + l0_w[0][1] * inputs[1] + l0_b[0];
        l0_z[1] = l0_w[1][0] * inputs[0] + l0_w[1][1] * inputs[1] + l0_b[1];

        l0_a[0] = 1 / (1 + Math.exp(-l0_z[0]));
        l0_a[1] = 1 / (1 + Math.exp(-l0_z[1]));

        l0_da[0] = l0_a[0] * (1 - l0_a[0]);
        l0_da[1] = l0_a[1] * (1 - l0_a[1]);

        l1_z = new double[1];
        l1_a = new double[1];
        l1_da = new double[1];

        l1_z[0] = l1_w[0][0] * l0_a[0] + l1_w[0][1] * l0_a[1] + l1_b[0];

        l1_a[0] = 1 / (1 + Math.exp(-l1_z[0]));

        l1_da[0] = l1_a[0] * (1 - l1_a[0]);

        error = 0;
        /*
         * System.out.println("----------------"); System.out.println("   a0: " +
         * l0_a[0]); System.out.println("   a1: " + l0_a[1]);
         * System.out.println("   af: " + l1_a[0]);
         */

    }

    public void backward(double data) {

        l1_delta = new double[1];
        l1_delta[0] = 2 * (l1_a[0] - data) * l1_da[0];

        l0_delta = new double[2];
        l0_delta[0] = l1_delta[0] * l1_wT[0][0] * l0_da[0];
        l0_delta[1] = l1_delta[0] * l1_wT[1][0] * l0_da[1];

        error = Math.pow((l1_a[0] - data), 2);

    }

    public void update() {
        l1_b[0] -= n * l1_delta[0];
        l1_w[0][0] -= n * l1_delta[0] * l0_a[0];
        l1_w[0][1] -= n * l1_delta[0] * l0_a[1];

        l0_b[0] -= n * l0_delta[0];
        l0_b[1] -= n * l0_delta[1];

        l0_w[0][0] -= n * l0_delta[0] * input[0];
        l0_w[0][1] -= n * l0_delta[0] * input[1];
        l0_w[1][0] -= n * l0_delta[1] * input[0];
        l0_w[1][1] -= n * l0_delta[1] * input[1];
    }

    public static void main(String[] args) {

        double[][] input = { { 1, 1 }, { 1, 0 }, { 0, 1 }, { 0, 0 } };
        double[] output = { 0, 1, 1, 0 };

        xor = new Xor_Perceptron0();
        xor.infoo();

        error = 999;
        while (error > 0.01) {
            double errorTotal = 0;
            for (int i = 0; i < 4; i++) {
                xor.forward(input[i]);
                xor.backward(output[i]);
                xor.update();
                int out = (xor.getOutput() > 0.5) ? 1 : 0;
                // System.out.println(" case" + i + ": " + out);

                // System.out.println(error);
                errorTotal += error;

            }
            error = errorTotal / 4;
            System.out.println(error);
        }
        // xor.infoo();

    }

    // ----------------------tools----------------
    private double[] rand(double[] matrix) {
        double[] rand = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rand[i] = ran.nextDouble();
        }
        return rand;
    }

    public double[][] Transpose(double[][] matrix) {
        double[][] matrixT = new double[matrix[0].length][matrix.length];
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrixT[i][j] = matrix[j][i];
            }
        }
        return matrixT;
    }

    // ----------------------infoo----------------
    private void infoo() {
        System.out.println("----------------");
        System.out.println("   b0_0: " + l0_b[0]);
        System.out.println("   b0_1: " + l0_b[1]);

        System.out.println("\n      w0_00: " + l0_w[0][0]);
        System.out.println("      w0_01: " + l0_w[0][1]);
        System.out.println("\n      w0_10: " + l0_w[1][0]);
        System.out.println("      w0_11: " + l0_w[1][1]);

        System.out.println("\n   b1_0: " + l1_b[0]);

        System.out.println("\n      w1_00: " + l1_w[0][0]);
        System.out.println("      w1_01: " + l1_w[0][1]);

        /*
         * System.out.println("\n\n      wT0_00: "+l0_wT[0][0]);
         * System.out.println("      wT0_01: "+l0_wT[0][1]);
         * System.out.println("\n      wT0_10: "+l0_wT[1][0]);
         * System.out.println("      wT0_11: "+l0_wT[1][1]);
         * System.out.println("\n      wT1_00: "+l1_wT[0][0]);
         * System.out.println("\n      wT1_01: "+l1_wT[1][0]);
         */

        System.out.println("----------------");
    }
    // -------------------------------------------

    public double getOutput() {
        return l1_a[0];
    }
}