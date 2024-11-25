public class Main {
    public static void main(String[] args) {
        Pet pet1 = new Pet("Garfield");
        Pet repet = new Pet("Yasmin");

        PetShop petShop1 = new PetShop("Pet amigu", 100.0);
        PetShop petShop2 = new PetShop("amigo's pet", 60.0);

        System.out.println(String.format("""
                Nome: %s
                Banhos tomados: %d
                Valor gasto em petshops: %.2f
                """, pet1.getNome(), pet1.getQtdBanhosTomados(), pet1.getValorGastoEmPetshops()
        ));

        petShop1.darBanho(pet1);
        petShop2.darBanho((repet));

        System.out.println(String.format("""
                Nome: %s
                Banhos tomados: %d
                Valor gasto em petshops: %.2f
                """, pet1.getNome(), pet1.getQtdBanhosTomados(), pet1.getValorGastoEmPetshops()
        ));

        System.out.println(petShop1);
    }
}