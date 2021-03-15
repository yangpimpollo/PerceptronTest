package multiLayer2;

public class Tools {

    public static double[][] Transpose(double[][] matrix){
        double[][] matrixT = new double[matrix[0].length][matrix.length];
        for(int j=0; j<matrix.length; j++){
            for(int i=0; i<matrix[0].length; i++){
                matrixT[i][j] = matrix[j][i];
            }
        }
        return matrixT;
    }

    public static double[] z_calulate(double[] inputs, double[][] w, double[] b) {
        double z[] = new double[b.length];
        for (int i=0; i< b.length; i++){
            z[i]=Hadamard(inputs.length, inputs, w[i], b[i]);
        }
        return z;
    }

    private static double Hadamard(int length,double[] matrixA, double[] matrixB, double bias){
        double singleZ = 0;
        for (int i=0; i<length; i++){
            singleZ+=matrixA[i]*matrixB[i];
        }
        singleZ+=bias;
        return singleZ;
    }

    public static double[] sigmoid(double[] z){
        double[] sigmoid = new double[z.length];
        for (int i=0; i< z.length; i++){
            sigmoid[i]=1/(1+Math.exp(-z[i]));
        }
        return sigmoid;
    }

    public static double[] sigmoid_Derivative(double[] a){
        double[] sigmoid_Derivative = new double[a.length];
        for (int i=0; i<a.length; i++){
            sigmoid_Derivative[i]=a[i]*(1-a[i]);
        }
        return sigmoid_Derivative;
    }

    public static double[] identity(double[] z){
        return z;
    }

    public static double[] identity_Derivative(double[] a){
        double[] identity_Derivative = new double[a.length];
        for(int i=0; i<a.length; i++){
            identity_Derivative[i]=1;
        }
        return identity_Derivative;
    }

    public static double[] binaryStep(double[] z){
        double[] binaryStep = new double[z.length];
        for(int i=0; i<z.length; i++){
            binaryStep[i]=(z[i]<0)? 0:1;
        }
        return binaryStep;
    }

    public static double[] binaryStep_Derivative(double[] a){
        double[] binaryStep_Derivative = new double[a.length];
        for(int i=0; i<a.length; i++){
            binaryStep_Derivative[i]=0;
        }
        return binaryStep_Derivative;
    }

    public static double[] ReLu(double[] z){
        double[] ReLu = new double[z.length];
        for(int i=0; i<z.length; i++){
            ReLu[i]=(z[i]<0)? 0:z[i];
        }
        return ReLu;
    }

    public static double[] ReLu_Derivative(double[] a){
        double[] ReLu_Derivative = new double[a.length];
        for(int i=0; i<a.length; i++){
            ReLu_Derivative[i]=(a[i]<0)? 0:1;
        }
        return ReLu_Derivative;
    }

    public static double[] Activation_function(double[] z, int function){
        double[] a = new double[z.length];
        switch(function) {
            case 0: a=sigmoid(z);break;
            case 1: a=identity(z);break;
            case 2: a=binaryStep(z);break;
            case 3: a=ReLu(z);break;
        }
        return a;
    }

    public static double[] Activation_Derivative(double[] a, int function){
        double[] da = new double[a.length];
        switch(function) {
            case 0: da=sigmoid_Derivative(a);break;
            case 1: da=identity_Derivative(a);break;
            case 2: da=binaryStep_Derivative(a);break;
            case 3: da=ReLu_Derivative(a);break;
        }
        return da;
    }
}
