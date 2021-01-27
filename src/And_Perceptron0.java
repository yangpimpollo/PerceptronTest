

public class And_Perceptron0 {

    private static double w1, w2, b;

    public static double neuron(double x1, double x2, double w1, double w2, double b){
        return x1*w1+x2*w2+b;
    }
    public static double activation(double z){
        return z = (z>0)? 1:0;
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        boolean sw=false;int i=0;
        while (!sw){
            sw=true;

            w1=Math.random()-Math.random();
            w2=Math.random()-Math.random();
            b=Math.random()-Math.random();

            System.out.println("---------------------------------");
            System.out.println(w1);
            System.out.println(w2);
            System.out.println(b);
            System.out.println("E1:1 E2:1 : "+activation(neuron(1,1, w1, w2, b)));
            System.out.println("E1:0 E2:0 : "+activation(neuron(1,0, w1, w2, b)));
            System.out.println("E0:1 E2:0 : "+activation(neuron(0,1, w1, w2, b)));
            System.out.println("E0:0 E2:0 : "+activation(neuron(0,0, w1, w2, b)));


            if(activation(neuron(1,1, w1, w2, b)) != 1){
                sw=false;
            }
            if(activation(neuron(1,0, w1, w2, b)) != 0){
                sw=false;
            }
            if(activation(neuron(0,1, w1, w2, b)) != 0){
                sw=false;
            }
            if(activation(neuron(0,0, w1, w2, b)) != 1){
                sw=false;
            }

            i++;
        }

        System.out.println("intentos: "+i);
    }
}
