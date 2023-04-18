package generate;

import client.Client;
import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.IOException;
import java.util.function.Consumer;

public class Generate {
    public static final String APPLICATION_JSON = "application/json";
    public static final String api = "generate";
    public static final String BEARER_TOKEN = "Bearer EYDw0tRskgBoj1zMGePk14hzch9TVLu1Zw7iND19";

    public static void main(String[] args) throws IOException {
        GenerateRequest generateRequest = GenerateRequest.builder().max_tokens(5).return_likelihoods("GENERATION")
                .num_generations(1)
                .truncate("END")
                .prompt("Once upon a time in a magical land called")
                .build();

        Client.hit(api, BEARER_TOKEN, generateRequest, (str) -> {
            System.out.println(str);
        });
    }
}
