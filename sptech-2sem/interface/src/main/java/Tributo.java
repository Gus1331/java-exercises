import java.util.ArrayList;
import java.util.List;

public class Tributo implements Tributavel{
    private List<Tributavel> tributaveis;

    public Tributo() {
        this.tributaveis = new ArrayList<>();
    }

    @Override
    public Double getValorAtributo() {
        return 0.0;
    }

    public void adicionaTributavel(Tributavel t){
        this.tributaveis.add(t);
    }

    public Double calculaTotalTributo(){
        Double total = 0d;
        for(Tributavel t : this.tributaveis){
            total += t.getValorAtributo();
        }
        return total;
    }

    public void exibeTodos(){
        for(Tributavel t : this.tributaveis){
            System.out.println(t.toString());
        }
        System.out.println(this.calculaTotalTributo() + "total");
    }
}
