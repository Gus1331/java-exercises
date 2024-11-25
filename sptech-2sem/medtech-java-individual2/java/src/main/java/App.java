import Comunicacao.Slack;
import org.json.JSONObject;

import java.io.IOException;

public class App {
    public static void main(String[] args)throws IOException,InterruptedException {
        JSONObject json = new JSONObject();

        json.put("text","\uD83D\uDEA8 SUA MÁQUINA ESTÁ COM PROBLEMA \uD83D\uDEA8");
        Slack.enviarMensagem(json);
    }
}
