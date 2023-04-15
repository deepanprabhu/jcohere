import com.google.gson.Gson;
import generate.Generate;
import generate.GenerateLikelihoodResponse;
import generate.GenerateRequest;
import generate.GenerateTextResponse;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

public class Test {
    public static void main(String[] args) throws Exception {
        Generate.hit((response) -> {
            GenerateLikelihoodResponse generateTextResponse = new Gson().fromJson(response, GenerateLikelihoodResponse.class);
            System.out.println(generateTextResponse.getGenerations().get(0).getText());
        });
    }
}
