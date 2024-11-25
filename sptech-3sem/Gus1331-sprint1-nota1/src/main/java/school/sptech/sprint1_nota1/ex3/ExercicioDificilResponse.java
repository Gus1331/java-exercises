package school.sptech.sprint1_nota1.ex3;

public class ExercicioDificilResponse {
    private int enesimoTermo;
    private int soma;

    public ExercicioDificilResponse(int n) {
        int n1 = 0;
        int n2 = 0;
        int helper;
        int soma = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0){
                n1 = 1;
                n2 = 1;
                soma = 2;
            } else if (i > 1){
                helper = n2;
                n2 = n1 + n2;
                n1 = helper;

                soma += n2;
            }

        }

        if(n == 1){
            soma--;
        }

        this.enesimoTermo = n2;
        this.soma = soma;
    }

    public int getEnesimoTermo() {
        return enesimoTermo;
    }

    public int getSoma() {
        return soma;
    }
}
