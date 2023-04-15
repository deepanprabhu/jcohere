import client.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.Set;

@Getter
@Builder
public class Generate {
    //required
    private String prompt;

    //optional
    private String model;
    private String preset;
    private int num_generations;
    private float temperature;
    private float frequency_penalty;
    private float presence_penalty;
    @Singular
    private Set<String> end_sequences;
    @Singular
    private Set<String> stop_sequences;
    private String return_likelihoods;
    private Object logit_bias;
    private String truncate;
    private int k;
    private float p;
    private int max_tokens;

    public String toJson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(this);
    }
}
