public class ExemploMatriz {
    public static void printarMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if(i == 0){
                for (int j = 0; j < matriz.length; j++) {
                    System.out.print("+-----");
                }
                System.out.println("+");
            }

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matriz1 = new int[3][4];
        int[][] matriz2 = new int[3][4];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matriz1[i][j] = (int) (Math.random() * 100);
                matriz2[i][j] = (int) (Math.random() * 100);
            }
        }
    }
}
