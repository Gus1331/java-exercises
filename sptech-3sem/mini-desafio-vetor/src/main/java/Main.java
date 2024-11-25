import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] t1 = {null, null, null, null, null, null, null, null, null, null};
        String[] t2 = {null, null, null, null, null, null, null, null, null, null};

        Boolean setupReady = false;

        while (!setupReady) {
            System.out.println("Cadastre um aluno:");
            Scanner sc = new Scanner(System.in);
            String aluno = sc.nextLine();

            System.out.println("A qual turma o aluno " + aluno + " pertence?");

            System.out.println("1 - T1");
            System.out.println("2 - T2");

            Integer turma = sc.nextInt();

            boolean sucessoCadastro = false;

            switch (turma) {
                case 1:
                    sucessoCadastro = cadastrarAlunoTurma(aluno, t1);
                    break;
                case 2:
                    sucessoCadastro = cadastrarAlunoTurma(aluno, t2);
                    break;
                default:
                    System.out.println("Turma inválida");
            }


            if (!sucessoCadastro) {
                System.out.println("Turma cheia cadastre em outra turma!");
            }


            System.out.println("Desenja continuar cadastrando alunos? s/n");
            Scanner sc2 = new Scanner(System.in);

            if (sc2.nextLine().equals("n")) {
                setupReady = true;
            }
            System.out.println("QTD T1: " + qtdAlunos(t1));
            System.out.println("QTD T2: " + qtdAlunos(t2));

            System.out.println(Arrays.toString(t1));
            System.out.println(Arrays.toString(t2));
        }
    }

    private static Integer qtdAlunos(String[] t) {
        Integer qtd = 0;
        for (int i = 0; i < t.length; i++) {
            if(t[i] != null){
                qtd++;
            }
        }
        return qtd;
    }

    private static boolean cadastrarAlunoTurma(String aluno, String[] t1) {
        Integer vagas = 0;
        boolean cadastrou = false;
        for (int i = 0; i < t1.length; i++) {
            if (t1[i] == null && !cadastrou) {
                t1[i] = aluno;
                cadastrou = true;
                vagas++;
            } else if (t1[i] == null) {
                vagas++;
            }
        }
        return vagas > 0 && cadastrou;
    }
}

