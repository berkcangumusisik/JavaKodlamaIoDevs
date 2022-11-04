package kodlama.io.kodlamaioDevs.business.concretes;

import kodlama.io.kodlamaioDevs.business.abstracts.TechnologyService;
import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.responses.technologyresponses.GetAllTechnologyResponse;
import kodlama.io.kodlamaioDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlamaioDevs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.kodlamaioDevs.entities.concretes.ProgrammingLanguage;
import kodlama.io.kodlamaioDevs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager  implements TechnologyService {

    private TechnologyRepository technologyRepository;
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public TechnologyManager(TechnologyRepository technologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
        this.technologyRepository = technologyRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> responses = new ArrayList<>();
        for (Technology technology: technologies) {
            GetAllTechnologyResponse response = new GetAllTechnologyResponse();

            response.setName(technology.getName());
            response.setLanguageName(technology.getProgrammingLanguage().getName());

            responses.add(response);
        }
        return responses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createTechnologyRequest.getProgrammingLanguageId()).get();
        technology.setName(createTechnologyRequest.getName());
        technology.setProgrammingLanguage(programmingLanguage);
        technologyRepository.save(technology);




    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        technologyRepository.deleteById(deleteTechnologyRequest.getId());

    }

    @Override
    public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technology = technologyRepository.findById(id).get();
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateTechnologyRequest.getProgrammingLanguageId()).get();
        technology.setName(updateTechnologyRequest.getName());
        technology.setProgrammingLanguage(programmingLanguage);
        technologyRepository.save(technology);
    }

}
