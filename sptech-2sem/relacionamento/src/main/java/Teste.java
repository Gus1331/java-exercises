public class Teste {
    public static void main(String[] args) {

        Contato c1 = new Contato("zyxwvu", "1100000000");
        Contato c2 = new Contato ("abcdef", "1100000000");
        Contato c3 = new Contato ("alfa", "1100000000");

        Grupo g1 = new Grupo("Grupo de trabalho");
        Grupo g2 = new Grupo("Amigos");

        g1.adicionar(c1);
        g1.adicionar(c2);

        g2.adicionar(c3);

        g1.remover(c2);

        System.out.println(g1.toString());
    }
}
