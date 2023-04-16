package client;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import util.AbstractRequest;

import java.io.IOException;
import java.util.function.Consumer;

public class Client {
    public static final String APPLICATION_JSON = "application/json";

    public static void hit(String api, String BEARER_TOKEN, AbstractRequest abstractRequest, Consumer<String> consu) throws IOException {
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("POST", String.format("https://api.cohere.ai/v1/%s", api))
                .setHeader("accept", APPLICATION_JSON)
                .setHeader("content-type", APPLICATION_JSON)
                .setHeader("authorization", BEARER_TOKEN)
                .setBody(abstractRequest.toJson())
                .execute()
                .toCompletableFuture()
                .thenAccept((response) -> {
                    consu.accept(response.getResponseBody());
                })
                .join();

        client.close();
    }
}