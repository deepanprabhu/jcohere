import com.google.gson.Gson;
import generate.GenerateRequest;
import generate.GenerateTextResponse;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

public class Test {
    public static void main(String[] args) throws Exception {
        GenerateRequest g = GenerateRequest.builder().max_tokens(5).return_likelihoods("ALL")
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
                    GenerateTextResponse generateResponse1 = new Gson().fromJson(response.getResponseBody().toString(), GenerateTextResponse.class);
                    System.out.println(generateResponse1.getGenerations().get(0).getText());
                })
                .join();

        client.close();
    }
}
