package classify;

import lombok.Getter;

import java.util.Map;
import java.util.Set;

@Getter
public class ClassifyResponse {
    private String id;
    private Set<Classification> classifications;
    public static class Classification {
        private String id;
        private String input;
        private String prediction;
        private Float confidence;
        private Map<String, Map<String, Float>> labels;
    }
}
