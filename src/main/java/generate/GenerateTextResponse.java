package generate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class GenerateTextResponse {
    private String id;
    private List<GenerationText> generations;
    private String prompt;

    @Getter
    @Setter
    public static class GenerationText {
        private String id;
        private String text;

        public GenerationText(String id, String text) {
            this.id = id;
            this.text = text;
        }
    }
}