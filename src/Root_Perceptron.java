


public class Root_Perceptron {

    private static Root_Perceptron root;
    private double w1, b, n;
    private static double[][] data = { {9,3},
                                       {1,1},
                                       {16,4},
                                       {4,2},
                                       {25,5},
                                       {49,7},
                                       {36,6},
                                       {64,8} };


    public Root_Perceptron(double w1, double b, double n){
        this.w1=w1;
        this.b=b;
        this.n=n;
        System.out.println("Hello World !...Root");
    }

    // ---- Natural Functions ---------------------------------
    public double trainNeuron(double[][] data){
        double error = 0;
        for(int i=0; i<data.length; i++){
            double a = runNeuron(data[i][0]);
            error += 0.5*Math.pow(data[i][1]-a, 2);
            System.out.println("---------------------------------");
            System.out.println("  w1: "+w1);
            //System.out.println("  w2: "+w2);
            System.out.println("bias: "+b);
            System.out.println("case "+data[i][0]+": "+a);
            //System.out.println("error : "+error);
            updateError(a, data[i][1], data[i][0]);
        }
        return error/8;
    }
    public double runNeuron(double x1){
        return Identity(z_calulate(x1));
    }
    private double z_calulate(double x1){
        return w1*x1+b;
    }
    private double Identity(double z){
        return z;
    }
    private void updateError(double a, double d, double x1){
        w1-=(a-d)*x1*n;
        b -=(a-d)*1*n;
    }

    public static void main(String[] args) {
        root = new Root_Perceptron(0.5, 0.2, 0.8);
        /*for(int i=0; i<1050; i++){
            and.trainNeuron(data);
        }*/
        double err=999;
        int count=0;
        while (err>0.01){
            err=root.trainNeuron(data);
            count++;
        }
        System.out.println("veces: "+count);
        //System.out.println(and.runNeuron(1,3));
    }
}
