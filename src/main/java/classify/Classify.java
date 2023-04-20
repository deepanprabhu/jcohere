package classify;

import client.Client;
import com.google.gson.Gson;
import embed.EmbedRequest;

import java.util.Arrays;
import java.util.HashSet;

public class Classify {
    public static final String APPLICATION_JSON = "application/json";
    public static final String api = "classify";
    public static final String BEARER_TOKEN = "Bearer";

    public static void main(String[] args) throws Exception {
        ClassifyRequest.Example example1 = new ClassifyRequest.Example();
        example1.setLabel("Spam");
        example1.setText("Dermatologists don't like her!");

        ClassifyRequest.Example example2 = new ClassifyRequest.Example();
        example2.setText("Weekly sync notes");
        example2.setLabel("Not Spam");

        ClassifyRequest.Example example3 = new ClassifyRequest.Example();
        example3.setLabel("Spam");
        example3.setText("Please help me?");

        ClassifyRequest.Example example4 = new ClassifyRequest.Example();
        example4.setText("Your parcel will be delivered today");
        example4.setLabel("Not Spam");

        ClassifyRequest classifyRequest = ClassifyRequest.builder()
                .inputs(new HashSet<>(Arrays.asList("Confirm your email address", "hey i need u to send some $")))
                .examples(new HashSet<>(Arrays.asList(example1, example2, example3, example4)))
                .truncate("END")
                .build();

        Client.hit(api, BEARER_TOKEN, classifyRequest, (str)-> {
            ClassifyResponse classifyResponse = new Gson().fromJson(str, ClassifyResponse.class);
            System.out.println(classifyResponse.getId());
        });
    }
}
