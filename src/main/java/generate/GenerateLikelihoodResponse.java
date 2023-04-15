package generate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Data
public class GenerateLikelihoodResponse {
    private String id;
    private List<GenerationTextWithLikelihood> generations;

    @Getter
    @Setter
    public static class GenerationTextWithLikelihood {
        private String id;
        private String text;

        private Float likelihood;

        private List<TokenLikelihood> tokenLikelihoods;

        private List<Meta> metas;

        public static class Meta {
            private List<ApiVersion> apiVersions;
            private Set<String> warnings;
        }

        public static class ApiVersion {
            private String version;
            private Boolean is_deprecated;
            private Boolean is_experimental;
        }
        @Getter
        public static class TokenLikelihood {
            private String token;
            private double likelihood;
        }

        public GenerationTextWithLikelihood(String id, String text) {
            this.id = id;
            this.text = text;
        }

    }
}