package multiLayer2;

public class Tools {

    public double[][] Transpose(double[][] matrix){
        double[][] matrixT = new double[matrix[0].length][matrix.length];
        for(int j=0; j<matrix.length; j++){
            for(int i=0; i<matrix[0].length; i++){
                matrixT[i][j] = matrix[j][i];
            }
        }
        return matrixT;
    }

    public double[] z_calulate(double[] inputs, double[][] w, double[] b) {
        double z[] = new double[b.length];
        for (int i=0; i< b.length; i++){
            z[i]=Hadamard(inputs.length, inputs, w[i], b[i]);
        }
        return z;
    }

    private double Hadamard(int length,double[] matrixA, double[] matrixB, double bias){
        double singleZ = 0;
        for (int i=0; i<length; i++){
            singleZ+=matrixA[i]*matrixB[i];
        }
        singleZ+=bias;
        return singleZ;
    }

    public double[] sigmoid(double[] z){
        double[] sigmoid = new double[z.length];
        for (int i=0; i< z.length; i++){
            sigmoid[i]=1/(1+Math.exp(-z[i]));
        }
        return sigmoid;
    }

    public double[] sigmoid_Derivative(double[] a){
        double[] sigmoid_Derivative = new double[a.length];
        for (int i=0; i<a.length; i++){
            sigmoid_Derivative[i]=a[i]*(1-a[i]);
        }
        return sigmoid_Derivative;
    }
}
