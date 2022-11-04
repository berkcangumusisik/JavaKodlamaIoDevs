package kodlama.io.kodlamaioDevs.business.abstracts;

import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.responses.programminglanguageresponses.GetAllProgrammingLanguageResponse;
import kodlama.io.kodlamaioDevs.business.responses.programminglanguageresponses.GetByIdProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguageResponse> getAll();
    GetByIdProgrammingLanguageResponse getById(int id);
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
    void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
    void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
}
