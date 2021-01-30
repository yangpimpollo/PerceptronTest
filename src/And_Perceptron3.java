

public class And_Perceptron3 {

    private static And_Perceptron3 and;
    private double w1, w2, b, n;
    private static double[][] data = { {1,1,1},
                                       {1,0,0},
                                       {0,1,0},
                                       {0,0,0} };

    public And_Perceptron3(double w1, double w2, double b, double n){
        this.w1=w1;
        this.w2=w2;
        this.b=b;
        this.n=n;
        System.out.println("Hello World !3");
    }

    // ---- Natural Functions ---------------------------------
    public void trainNeuron(double[][] data){
        for(int i=0; i<4; i++){
            double a = runNeuron(data[i][0],data[i][1]);
            System.out.println("---------------------------------");
            System.out.println("  w1: "+w1);
            System.out.println("  w2: "+w2);
            System.out.println("bias: "+b);
            System.out.println("case "+i+": "+a);
            updateError(a, data[i][2], data[i][0], data[i][1]);
        }
    }

    public double runNeuron(double x1, double x2){
        return sigmoid(z_calulate(x1, x2));
    }

    // ---- Operative Functions ---------------------------------
    public void forwardPass(double[][] data){

    }
    public void backwardPass(double[][] data){

    }

    // ---- tools ---------------------------------
    private double z_calulate(double x1, double x2){
        return w1*x1+w2*x2+b;
    }
    private double sigmoid(double z){
        return 1/(1+Math.exp(-z));
    }
    private void updateError(double a, double d, double x1, double x2){
        w1-=(a-d)*a*(1-a)*x1*n;
        w2-=(a-d)*a*(1-a)*x2*n;
        b -=(a-d)*a*(1-a)*1*n;
    }

    public static void main(String[] args) {
        and = new And_Perceptron3(0.5, 0.2, 0.8, 2);
        for(int i=0; i<150; i++){
            and.trainNeuron(data);
        }

        //System.out.println(and.runNeuron(1,3));
    }
}
