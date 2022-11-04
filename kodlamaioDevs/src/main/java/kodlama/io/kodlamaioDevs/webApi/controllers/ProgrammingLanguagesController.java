package kodlama.io.kodlamaioDevs.webApi.controllers;

import kodlama.io.kodlamaioDevs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlamaioDevs.business.responses.programminglanguageresponses.GetAllProgrammingLanguageResponse;
import kodlama.io.kodlamaioDevs.business.responses.programminglanguageresponses.GetByIdProgrammingLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguageResponse> getAll(){
            return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingLanguageResponse getById(int id){
        return programmingLanguageService.getById(id);
    }

    @PostMapping
    public void add( CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        this.programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest){
        programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }

    @PutMapping("/{id}")
    public void updateById(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        programmingLanguageService.update(id,updateProgrammingLanguageRequest);
    }
}
