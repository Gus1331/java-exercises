public class Carta {
    private Simbolo simbolo;
    private Naipe naipe;

    public Carta(Simbolo simbolo, Naipe naipe) {
        this.simbolo = simbolo;
        this.naipe = naipe;
    }

    // getters and setters

    public Simbolo getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(Simbolo simbolo) {
        this.simbolo = simbolo;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "simbolo='" + simbolo + '\'' +
                ", naipe=" + naipe +
                '}';
    }
}
