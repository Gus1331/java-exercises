import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) {
        List<Filme> filmes = new ArrayList<>();
        Filme f1 = new Filme(1,"Shrek 1", 10.0, 2000);
        Filme f2 = new Filme(2,"Shrek 2", 10.0, 2001);
        Filme f3 = new Filme(3,"Shrek 3", 3.0, 2002);
        Filme f4 = new Filme(4,"Shrek para sempre", 8.0, 2003);

        filmes.add(f1);
        filmes.add(f2);
        filmes.add(f3);
        filmes.add(f4);


        List<Filme> filmesFiltrados = filmes.stream().filter(item -> item.getNota() >=  8).toList();

        for (Filme f : filmesFiltrados){
            System.out.println(f);
        }


        System.out.println("Agora os ruins =>");
        filmes.stream().filter(item -> item.getNota() < 5).map(item -> item.getTitulo()).forEach(item -> System.out.println(item));

        Double somaDasNotas = filmes.stream().mapToDouble(item -> item.getNota()).sum();
    }
}
