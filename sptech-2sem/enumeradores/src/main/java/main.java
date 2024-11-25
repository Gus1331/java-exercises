public class main {
    public static void main(String[] args) {
        Carta c1 = new Carta(Simbolo.REI, Naipe.ESPADAS);
        Carta c2 = new Carta(Simbolo.DOIS, Naipe.COPAS);

        System.out.println();

        for(Naipe n : Naipe.values()){ // itera cada enum
            System.out.println(n);
        }
    }
}
