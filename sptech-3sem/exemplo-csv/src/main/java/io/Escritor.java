package io;

import java.io.*;

public class Escritor {

    public static void main(String[] args) {


        try (
                OutputStream file = new FileOutputStream("filme.csv");

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(file));
        ) {
            String patternHeader = "%s;%s;%s";
            writer.write(patternHeader.formatted("Nome", "Valor", "éBom"));

            String pattern = "\n%s;%d;%b";
            writer.write(pattern.formatted("limda minha vida yasmin", 99990, true));

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {

        }

    }
}
