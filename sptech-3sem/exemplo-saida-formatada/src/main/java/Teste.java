public class Teste {
    public static void main(String[] args) {

        Aluno aluno01 = new Aluno(234, "Bob da Silva", 8.4, 3);
        Aluno aluno02 = new Aluno(235, "Xampson Sousa", 6.7, 1);

        System.out.printf("%-6S| %-15S | %6S | %6S", "ra", "nome", "nota", "faltas\n");
        System.out.printf("%06d| %-15s | %6.2f | %6d", aluno01.getRa(), aluno01.getNome(), aluno01.getNotaFinal(), aluno01.getQtdFaltas());
    }
}
