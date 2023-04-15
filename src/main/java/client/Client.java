package client;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.IOException;

public class Client {
    public static void generate() throws IOException {
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("POST", "https://api.cohere.ai/v1/generate")
                .setHeader("accept", "application/json")
                .setHeader("content-type", "application/json")
                .setBody("{\"max_tokens\":20,\"return_likelihoods\":\"NONE\",\"truncate\":\"END\",\"prompt\":\"Once upon a time in a magical land called\"}")
                .execute()
                .toCompletableFuture()
                .thenAccept(System.out::println)
                .join();

        client.close();
    }
}
