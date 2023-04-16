package embed;

import com.google.gson.annotations.SerializedName;
import generate.GenerateLikelihoodResponse;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class EmbedResponse {
    private String id;
    private Set<String> texts;
    private Meta meta;
    private Set<Set<Float>> embeddings;


    @Getter
    public static class ApiVersion {
        private String version;
        private Boolean is_deprecated;
        private Boolean is_experimental;
    }

    @Getter
    public static class Meta {
        @SerializedName("api_version")
        private ApiVersion apiVersion;
        private Set<String> warnings;
    }
}
