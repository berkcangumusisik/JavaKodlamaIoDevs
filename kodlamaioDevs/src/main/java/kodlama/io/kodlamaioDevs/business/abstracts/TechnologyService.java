package kodlama.io.kodlamaioDevs.business.abstracts;

import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.responses.technologyresponses.GetAllTechnologyResponse;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologyResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest);
    void delete(DeleteTechnologyRequest deleteTechnologyRequest);
    void update(int id, UpdateTechnologyRequest updateTechnologyRequest);

}
