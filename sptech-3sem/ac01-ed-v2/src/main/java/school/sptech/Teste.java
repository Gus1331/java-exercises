package school.sptech;

public class Teste {

    public static void main(String[] args) {
        Paciente[] pacientes = {
                new Paciente(1001, "Leo", 150.42, 3),
                new Paciente(1002, "Ben", 100.21, 1),
                new Paciente(1003, "Mia", 560.32, 4),
                new Paciente(1004, "Dan", 299.90, 5),
                new Paciente(1005, "Tom", 175.67, 7),
                new Paciente(1006, "Ana", 470.80, 2),
        };

//        GestaoPacientes.exibePacientes(pacientes);
        System.out.println( ""+
        //GestaoPacientes.somaValorConsulta(pacientes)
                GestaoPacientes.alterarValorConsulta(pacientes,1001,100.0) +
                        pacientes[0].getValorConsulta()
        );
        System.out.println(150.42+100.21+560.32+299.90+175.67+470.80);
    }
}
// gg