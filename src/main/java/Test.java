import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

public class Test {
    public static void main(String[] args) throws Exception {
        Generate g = Generate.builder().max_tokens(20).return_likelihoods("NONE")
                .truncate("END")
                .prompt("Once upon a time in a magical land called")
                .build();
        System.out.println(g.toJson());


        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("POST", "https://api.cohere.ai/v1/generate")
                .setHeader("accept", "application/json")
                .setHeader("content-type", "application/json")
                .setBody(g.toJson())
                .execute()
                .toCompletableFuture()
                .thenAccept(System.out::println)
                .join();

        client.close();
    }
}
