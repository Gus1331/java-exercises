package school.sptech;

public class GestaoPacientes {

    public static boolean alterarValorConsulta(Paciente[] pacientes, Integer id, Double valorNovo) {
        for (int i = 0; i < pacientes.length - 1; i++) {
            if(pacientes[i].getId().equals(id)){
                pacientes[i].setValorConsulta(valorNovo);
                return true;
            }
        }
        return false;
    }

    public static Double somaValorConsulta(Paciente[] pacientes) {
        Double res = 0.0;
        for (int i = 0; i < pacientes.length; i++) {
            res += pacientes[i].getValorConsulta();
        }
        return res;
    }

    public static void trocaPacientes(Paciente[] pacientes, Integer idPaciente01, Integer idPaciente02) {
        Paciente p01 = null;
        Integer positionP01 = null;
        Paciente p02 = null;
        Integer positionP02 = null;
        for (int i = 0; i < pacientes.length; i++) {
            if(pacientes[i].getId().equals(idPaciente01) ){
                p01 = pacientes[i];
                positionP01 = i;
            } else if(pacientes[i].getId().equals(idPaciente02)){
                p02 = pacientes[i];
                positionP02 = i;
            }
        }
        if(p01 != null && p02 != null){
            pacientes[positionP01] = p02;
            pacientes[positionP02] = p01;
        }
    }

    //Corrija o erro na ordenação abaixo:
    public static void ordenarPorIdade(Paciente[] pacientes) {
        for (int i = 0; i < pacientes.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < pacientes.length; j++) {
                if (pacientes[j].getIdade() < pacientes[indiceMenor].getIdade()) {
                    indiceMenor = j;
                }
            }
            Paciente aux = pacientes[i];
            pacientes[i] = pacientes[indiceMenor];
            pacientes[indiceMenor] = aux;
        }
    }

    //Corrija o erro na ordenação abaixo:
    public static void ordenarPorIdadeDecrescente(Paciente[] pacientes) {
        for (int i = 0; i < pacientes.length - 1; i++) {
            for (int j = i + 1; j < pacientes.length; j++) {
                if (pacientes[j].getIdade() > pacientes[i].getIdade()) {
                    Paciente aux = pacientes[i];
                    pacientes[i] = pacientes[j];
                    pacientes[j] = aux;
                }
            }
        }
    }

    //Complete o código da ordenação abaixo dentro do "if"
    public static void ordenarPorNomePaciente(Paciente[] pacientes) {
        for (int i = 0; i < pacientes.length - 1; i++) {
            for (int j = 1; j < pacientes.length - i; j++) {
                if (pacientes[j - 1].getNome().compareTo(pacientes[j].getNome()) > 0) {
                    Paciente aux = pacientes[j - 1];
                    pacientes[j - 1] = pacientes[j];
                    pacientes[j] = aux;
                }
            }
        }
    }

    //Exibe os itens do vetor
    //Já está pronto para usar no main se quiser testar :)
    public static void exibePacientes(Paciente[] pacientes) {
        for (int i = 0; i < pacientes.length; i++) {
            System.out.println(pacientes[i]);
        }
    }
}



/*

4. **ordenarPorIdade(Paciente[] pacientes):**
    - Corrija o algoritmo de ordenação para que ordene corretamente os pacientes pela idade em ordem crescente.

5. **ordenarPorIdadeDecrescente(Paciente[] pacientes) :**
    - O método está fazendo a ordenação crescente, **corrija** para que a ordenação dos pacientes seja feita pela idade em ordem **decrescente**.

6. **ordenarPorNomePaciente(Paciente[] pacientes) :**
    - Complete a lógica deste método para ordenar o vetor de pacientes em ordem alfabética crescente pelo nome do paciente.
    - Necessário completar apenas dentro do `if`, foi adicionado um comentário indicando onde deve ser completado.

### Dica:
- Para testar os métodos, você pode utilizar o método `exibePacientes(Paciente[] pacientes)` já fornecido, que exibe os detalhes dos pacientes no console.

 */