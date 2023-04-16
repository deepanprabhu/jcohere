package generate;

import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import java.util.function.Consumer;

public class Generate {
    public static final String APPLICATION_JSON = "application/json";
    public static final String api = "generate";
    public static final String BEARER_TOKEN = "Bearer EYDw0tRskgBoj1zMGePk14hzch9TVLu1Zw7iND19";

    public static void hit(Consumer<String> consu) throws Exception {
        GenerateRequest g = GenerateRequest.builder().max_tokens(5).return_likelihoods("GENERATION")
                .num_generations(1)
                .truncate("END")
                .prompt("Once upon a time in a magical land called")
                .build();

        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("POST", String.format("https://api.cohere.ai/v1/%s", api))
                .setHeader("accept", APPLICATION_JSON)
                .setHeader("content-type", APPLICATION_JSON)
                .setHeader("authorization", BEARER_TOKEN)
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
