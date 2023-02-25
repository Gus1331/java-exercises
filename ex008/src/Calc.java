public class Calc {
            //  Sobrecarga:
            // Dependendo do numero de parametros e tipo do parametro, o metodo irá funcionar de forma diferente
    public static void area(double n1){
        System.out.println("A área do quadrado é igual: " + (n1 * n1));
    }

    public static void area(double n1, double n2){
        System.out.println("A área do retângulo é igual: " + (n1 * n2));
    }

    public static void area(float base, float topo, float altura){
        System.out.println("A área do trapézio é igual: " + ((base * topo) * altura));
    }

}
