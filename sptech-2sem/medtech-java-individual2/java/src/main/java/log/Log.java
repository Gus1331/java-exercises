package log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    private static SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private String mensagem;
    private Class classe;
    private String porcentagem;
    private LogLevel logLevel;
    private HardwareType hardwareType;

    public Log(String mensagem, String porcentagem, LogLevel logLevel, HardwareType hardwareType) {
        this.mensagem = mensagem;
        this.porcentagem = porcentagem;
        this.logLevel = logLevel;
        this.hardwareType = hardwareType;
    }

    public Log (Class classe, String mensagem, LogLevel logLevel){
        this.classe = classe;
        this.mensagem = mensagem;
        this.logLevel = logLevel;
    }

    public String gerarTextoLog(){
    return formato.format(new Date()) + "\n"+
            logLevel +
            " Classe:"
            + classe +
            "\nMensagem: "+ mensagem;
    }
    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public HardwareType getHardwareType() {
        return hardwareType;
    }

    public void setHardwareType(HardwareType hardwareType) {
        this.hardwareType = hardwareType;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPorcentagem() {
        return this.porcentagem;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public String toString() {
        return formato.format(new Date()) +
                ", mensagem='" + mensagem + '\'' +
                ", porcentagem='" + porcentagem + '\'' +
                ", logLevel=" + logLevel +
                ", hardwareType=" + hardwareType;
    }
}


