package kodlama.io.kodlamaioDevs.business.concretes;

import kodlama.io.kodlamaioDevs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.responses.programminglanguageresponses.GetAllProgrammingLanguageResponse;
import kodlama.io.kodlamaioDevs.business.responses.programminglanguageresponses.GetByIdProgrammingLanguageResponse;
import kodlama.io.kodlamaioDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlamaioDevs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private ProgrammingLanguageRepository programmingLanguageRepository;
    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<>();

        for(ProgrammingLanguage programmingLanguage : programmingLanguages){
            GetAllProgrammingLanguageResponse response = new GetAllProgrammingLanguageResponse();
            response.setName(programmingLanguage.getName());

            programmingLanguageResponses.add(response);
        }

        return programmingLanguageResponses;
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
        GetByIdProgrammingLanguageResponse response = new GetByIdProgrammingLanguageResponse();
        response.setName(programmingLanguage.getName());
        return response;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        if(programmingLanguageExistValidator(createProgrammingLanguageRequest) && programmingLanguageNameValidator(createProgrammingLanguageRequest)){
            ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();

            programmingLanguage.setName(createProgrammingLanguageRequest.getName());

            programmingLanguageRepository.save(programmingLanguage);

        }
    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
        programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
    }

    @Override
    public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        if(!updateProgrammingLanguageRequest.getName().isEmpty()){
            ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
            programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
            programmingLanguageRepository.save(programmingLanguage);
        }
    }
    public boolean programmingLanguageNameValidator(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        if(createProgrammingLanguageRequest.getName().isEmpty())
            System.out.println("Programlama ismi boş  olamaz");
        return !createProgrammingLanguageRequest.getName().isEmpty();

    }

    public boolean programmingLanguageExistValidator(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {

        for (ProgrammingLanguage tempProgrammingLanguage : programmingLanguageRepository.findAll()) {
            if (tempProgrammingLanguage.getName().equalsIgnoreCase(createProgrammingLanguageRequest.getName())) {

                System.out.println("Programlama dili zaten mevcut");
                return false;

            }
        }

        return true;

    }
}
