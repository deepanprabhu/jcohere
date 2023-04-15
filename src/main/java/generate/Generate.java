package generate;

import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import java.util.function.Consumer;

public class Generate {
    public static void hit(Consumer<String> consu) throws Exception {
        GenerateRequest g = GenerateRequest.builder().max_tokens(5).return_likelihoods("GENERATION")
                .num_generations(1)
                .truncate("END")
                .prompt("Once upon a time in a magical land called")
                .build();

        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("POST", "https://api.cohere.ai/v1/generate")
                .setHeader("accept", "application/json")
                .setHeader("content-type", "application/json")
                .setHeader("authorization", String.format("Bearer %s","EYDw0tRskgBoj1zMGePk14hzch9TVLu1Zw7iND19"))
                .setBody(g.toJson())
                .execute()
                .toCompletableFuture()
                .thenAccept((response) -> {
                    consu.accept(response.getResponseBody());
                })
                .join();

        client.close();
    }
}
