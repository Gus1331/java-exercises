package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Gus", 9.5, 10.0);
        AlunoPos alunoPos1 = new AlunoPos("God Gus", 10.0, 10.0, 7.13);


        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(alunoPos1);

        for(Aluno aluno : alunos){
            System.out.println(aluno);
        }
    }
}
