public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);

        lista.add(10);
        lista.add(11);
        lista.add(6);
        lista.add(62);
        lista.add(6);

        lista.print();

        lista.remove(0);
        System.out.println(lista.find(10));
        System.out.println(lista.find(6));

        lista.removeByContent(6);
        System.out.println(lista.find(6));

    }
}
