package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LogManager {

    public static void salvarLog(Log log, int id) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("logs.txt", true))) {
            bw.write("ID %d. ".formatted(id));
            bw.newLine();

            bw.write(log.toString());
            bw.newLine();

            bw.newLine();
            bw.write("----------------------------------------");
            bw.newLine();
        } catch (IOException e) {
            System.out.print("Erro: " + e.getMessage());
        }
    }
    public static void salvarLog(Log log) {

        String diretorio = "logs";
        LocalDate dataAtual = LocalDate.now();
        String dataFormatada = dataAtual.format(DateTimeFormatter.BASIC_ISO_DATE);
        String nomeArquivo = dataFormatada + "_log.txt";

        Path caminhoArquivo = Paths.get(diretorio, nomeArquivo);

        try {
            Files.createDirectories(caminhoArquivo.getParent());
        } catch (IOException e) {
            System.err.println("Erro ao criar diretório: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo.toFile(), true))) {
            bw.newLine();

            bw.write(log.gerarTextoLog());
            bw.newLine();

            bw.newLine();
            bw.write("----------------------------------------");
            bw.newLine();
        } catch (IOException e) {
            System.out.print("Erro: " + e.getMessage());
        }
    }
}
