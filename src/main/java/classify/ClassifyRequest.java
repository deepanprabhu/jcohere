package classify;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Getter;
import util.AbstractRequest;

import java.util.Set;

@Getter
@Builder
public class ClassifyRequest extends AbstractRequest {
    private Set<String> inputs;
    private Set<Example> examples;
    private String model;
    private String truncate;
    private String preset;

    public static class Example {
        private String text;
        private String label;
    }

    public String toJson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(this);
    }
}
