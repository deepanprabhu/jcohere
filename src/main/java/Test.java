import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

public class Test {
    public static void main(String[] args) throws Exception {
        GenerateText g = GenerateText.builder().max_tokens(40).return_likelihoods("NONE")
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
                .thenAccept(System.out::println)
                .join();

        client.close();
    }
}
