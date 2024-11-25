public class Main {
    public static void main(String[] args) {
        Pilha p = new Pilha(10);


        p.push(10);
        p.push(11);
        p.push(12);
        p.push(13);

        System.out.println(p.pop());
        System.out.println(p.pop());
        p.push(15);
        System.out.println(p.pop());
    }
}
