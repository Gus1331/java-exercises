package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedException {
    public static void main(String[] args) {
        try{
            lerArquivo();
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public static void lerArquivo() throws FileNotFoundException{
            FileReader file = new FileReader("pesoa.csv");
    }
}
