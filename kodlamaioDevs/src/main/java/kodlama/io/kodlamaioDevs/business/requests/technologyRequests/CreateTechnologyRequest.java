package kodlama.io.kodlamaioDevs.business.requests.technologyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateTechnologyRequest {
    private String name;
    private int programmingLanguageId;
}
