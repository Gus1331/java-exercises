package Comunicacao;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Slack {
    private static HttpClient cliente = HttpClient.newHttpClient();
    private static final String url = "https://hooks.slack.com/services/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";

    public static void enviarMensagem(JSONObject content) throws IOException,InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("accept","application/jason")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();


        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("status: %s",response.statusCode()));
        System.out.println(String.format("response: %s",response.body()));
    }
}
