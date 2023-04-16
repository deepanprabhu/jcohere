package embed;

import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Embed {
    public static final String APPLICATION_JSON = "application/json";
    public static final String api = "embed";
    public static final String BEARER_TOKEN = "Bearer EYDw0tRskgBoj1zMGePk14hzch9TVLu1Zw7iND19";

    public static void main(String[] args) throws Exception {
        EmbedRequest embedRequest = EmbedRequest
                .builder()
                .texts(new HashSet<>(Arrays.asList("hello", "goodbye")))
                .truncate("END")
                .build();

        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("POST", String.format("https://api.cohere.ai/v1/%s", api))
                .setHeader("accept", APPLICATION_JSON)
                .setHeader("content-type", APPLICATION_JSON)
                .setHeader("authorization", BEARER_TOKEN)
                .setBody(embedRequest.toJson())
                .execute()
                .toCompletableFuture()
                .thenAccept((response)-> {
                    System.out.println(response.toString());
                    EmbedResponse embedResponse = new Gson().fromJson(response.getResponseBody().toString(), EmbedResponse.class);
                    System.out.println(embedResponse.getMeta().getApiVersion().getVersion());
                })
                .join();

        client.close();
    }
}
