import java.util.Arrays;

public class Main {
    public static int[] selectionSort(int[] nArray){
        for (int i = 0; i < nArray.length - 1; i++) {
            for (int j = i + 1; j < nArray.length; j++) {
                if(nArray[j] < nArray[i]){
                    int aux = nArray[i];
                    nArray[i] = nArray[j];
                    nArray[j] = aux;
                }
            }
        }
        return nArray;
    }

    public static int[] selectionSortOptimized(int[] nArray){
        for (int i = 0; i < nArray.length - 1; i++) {
            int posAux = i;
            for (int j = i + 1; j < nArray.length; j++) {
                if(nArray[j] < nArray[i] && nArray[j] < nArray[posAux]){
                    posAux = j;
                }
            }
            int aux = nArray[i];
            nArray[i] = nArray[posAux];
            nArray[posAux] = aux;
        }
        return nArray;
    }

    public static int[] bubbleSort(int[] nArray){
        for (int i = 0; i < nArray.length - 1; i++) {
            for (int j = 0; j < nArray.length - 1; j++) {
                if(nArray[j] > nArray[j + 1]){
                    int aux = nArray[j];
                    nArray[j] = nArray[j + 1];
                    nArray[j + 1] = aux;
                }
            }
        }
        return null;
    }

    public static Integer binarySearch(int[] nArray, int number){
        int a = 0;
        int b = nArray.length - 1;

        int middlePos;
        while(a < b){
            middlePos = (a + b) / 2;
            if(nArray[middlePos] == number){
                return middlePos;
            } else if(nArray[middlePos] < number){
                a = middlePos + 1;
            } else {
                b = middlePos - 1;
            }
        }
        return -1;
    }

    public static int[] insertionSort(int[] nArray){

        for (int i = 1; i < nArray.length; i++) {
            int x = nArray[i];
            int j = i - 1;

            while(j >= 0 && nArray[j] > x){
                nArray[j+1] = nArray[j];
                j--;
            }
            nArray[j + 1] = x;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nArray = {4, 2, 5, 3, 1, 6, 8, 7, 9, 10, 13, 12, 11, 13};
        System.out.println("Não ordenada");

        System.out.println(Arrays.toString(nArray));

        // selectionSort(nArray);
        // selectionSortOptimized(nArray);
        insertionSort(nArray);

        System.out.println();
        System.out.println("Ordenada");

        System.out.println(Arrays.toString(nArray));

        System.out.println();
        System.out.println("Existe o numero 3? ");

        System.out.println("R= " + binarySearch(nArray,13));
    }
}
