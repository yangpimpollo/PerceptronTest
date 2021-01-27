


public class And_Perceptron1 {

    private float x1,x2;
    private static float w1 = -0.5f;
    private static float w2 = -0.3f;
    private static float b = 0.2f;
    private static float n = 2f;
    private static float[][] data = { {1,1,1},
                                      {1,0,0},
                                      {0,1,0},
                                      {0,0,0} };

    private static float Z_calulate(float x1, float x2){
        float z = w1*x1+w2*x2+b;
        return z;
    }
    private static float sigmoid(float z){
        float sigmoid = (float) (1/(1+Math.exp(-z)));
        return sigmoid;
    }
    private static void update(float a){
        w1-=a*(1-a)*(a-1)*1*n;
        w2-=a*(1-a)*(a-1)*0*n;
        b-=a*(1-a)*(a-1)*1*n;
    }
    private static void forward(){
        float a=0;
        System.out.println(sigmoid(Z_calulate(1,0)));
        for(int i=0;i<10;i++){
        a = sigmoid(Z_calulate(1,1));
            System.out.println(a);
        update(a);}
        System.out.println(a);
        //System.out.println(sigmoid(Z_calulate(1,1)));
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //System.out.println(sigmoid(Z_calulate(1,1)));
        //System.out.println((1/(1+Math.exp(-1))));

        forward();
        /*while (true){

        }*/

    }
}
