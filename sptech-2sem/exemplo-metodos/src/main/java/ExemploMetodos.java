import java.util.ArrayList;
import java.util.List;

public class ExemploMetodos {
    public static void main(String[] args) {

//        List<String> frutas = new ArrayList<>();
//        frutas.add("laranja");
//        frutas.add("Carambola");
//        frutas.add("Goiaba");
//        frutas.add("Kiwi");
//
//        for( int i = 0; i < frutas.size(); i++){
//            System.out.println(frutas.get(i));
//        }

//        String frutaPesquisa = "goiaba";
//
//        Boolean existeFruta = false;
//
//        for(int i = 0; i < frutas.size(); i++){
//            if(frutaPesquisa.equals(frutas.get(i))){
//                existeFruta = true;
//            };
//        }
//
//
//        System.out.println();
//
        List<String> nomes = new ArrayList<>();

        nomes.add("Gus");
        nomes.add("Gio");
        nomes.add("ZLS");
//
//        for( int i = 0; i < nomes.size(); i++){
//            System.out.println(nomes.get(i));
//        }
//
//        String nomePesquisa = "Gus";
//
//        Boolean existeNome = false;
//
//        for(int i = 0; i < nomes.size(); i++){
//            if(nomePesquisa.equals(nomes.get(i))){
//                existeNome = true;
//            };
//        }
//
//
//        if (existeFruta){
//            System.out.println("Existe fruta");
//        } else {
//            System.out.println("Não existe o nome");
//        }
//
//        if(existeNome){
//            System.out.println("Existe nome");
//        } else {
//            System.out.println("Não existe a fruta");
//        }

        Utilitaria utilitaria = new Utilitaria();

        utilitaria.exibirMensagem();
        utilitaria.somar(12, 1);

        utilitaria.exibirLista(nomes);
        System.out.println(utilitaria.busca(nomes, "Gus"));
    }
}
