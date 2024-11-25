public class Main {
    public static void main(String[] args) {
        int[] vetor = {1, 5, 3, 1, 5, 7, 3, 7, 6, 45, 34, 34, 34, 34, 34, 23, 32, 2, 2, 43, 5, 26, 32, 32, 432, 352};

        mergeSort(vetor,0,vetor.length);
        // quickSort(vetor, 0, vetor.length - 1);

        for (int n : vetor) {
            System.out.print(" " + n + " -");
        }

    }

    public static void quickSort(int[] v, int indInicio, int indFim) {
        int i = indInicio;
        int j = indFim;
        int pivo = v[(indInicio + indFim) / 2];
        while (i <= j) {
            while (i < indFim && v[i] < pivo) {
                i++;
            }
            while (j > indInicio && v[i] > pivo) {
                j--;
            }
            if (i <= j) {
                int x = v[i];
                v[i] = v[j];
                v[j] = x;
                i++;
                j--;
            }
        }
        if (indInicio < j) {
            quickSort(v, indInicio, j);
        } else if (i < indFim) {
            quickSort(v, i, indFim);
        }
    }

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim - 1) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio, fim);
            intercala(vetor, inicio, meio, fim);
        }
    }

    public static void intercala(int[] vetor, int inicio, int meio, int fim) {
        int i;
        int j;
        int k;
        int[] w = new int[fim - inicio];

        i = inicio;
        j = meio;
        k = 0;

        while (i < meio && j < fim) {
            if (vetor[i] <= vetor[j]) {
                w[k++] = vetor[i++];
            } else {
                w[k++] = vetor[j++];
            }
        }
        while (i < meio) {
            w[k++] = vetor[i++];
        }
        while (j < fim) {
            w[k++] = vetor[j++];
        }
        for (i = inicio; i < fim; i++) {
            vetor[i] = w[i - inicio];
        }
    }
}
