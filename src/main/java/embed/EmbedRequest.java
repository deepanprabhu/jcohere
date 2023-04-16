package embed;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.Set;

/**
 * This endpoint generates realistic text conditioned on a given input.
 */
@Getter
@Builder
public class EmbedRequest {
    //required
    private Set<String> texts;

    //optional
    private String model;
    private String truncate;


    public String toJson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(this);
    }
}
