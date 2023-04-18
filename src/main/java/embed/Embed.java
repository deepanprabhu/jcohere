package embed;

import client.Client;
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

        Client.hit(api, BEARER_TOKEN, embedRequest, (str)-> {
            System.out.println(str);
        });
    }
}
