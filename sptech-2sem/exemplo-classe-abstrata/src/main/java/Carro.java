public class Carro  extends Veiculo{

    private Double nivelOleo;

    private Boolean possuiStep;

    //constructor


    public Carro(String proprietario, String fabricante, Double valor, Integer anoFabricacao, Double nivelOleo, Boolean possuiStep) {
        super(proprietario, fabricante, valor, anoFabricacao);
        this.nivelOleo = nivelOleo;
        this.possuiStep = possuiStep;
    }

    // outros metodos
    public void exbirRelarioDeRevisao(){
        if(this.nivelOleo < 0.5){
            System.out.println("Precisa trocar o oleo");
        } else {
            System.out.println("Nivel de oleo ta ok");
        }
        if(this.possuiStep){
            System.out.println("Tem step");
        } else {
            System.out.println("Põe step");
        }
    }

    // getters and setters

    public Double getNivelOleo() {
        return nivelOleo;
    }

    public void setNivelOleo(Double nivelOle0) {
        this.nivelOleo = nivelOle0;
    }

    public Boolean getPossuiStep() {
        return possuiStep;
    }

    public void setPossuiStep(Boolean possuiStep) {
        this.possuiStep = possuiStep;
    }
}
