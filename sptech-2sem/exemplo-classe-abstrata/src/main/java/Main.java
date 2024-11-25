public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        Carro carro = new Carro(
                "Giu",
                "Fiat",
                60_000.0,
                2024,
                0.6,
                false);

        carro.exbirRelarioDeRevisao();

        Bicicleta bike = new Bicicleta(
                "Manoel",
                "Caloi",
                4_000.0,
                2020,
                0.3,
                150.0
        );
    }
}
