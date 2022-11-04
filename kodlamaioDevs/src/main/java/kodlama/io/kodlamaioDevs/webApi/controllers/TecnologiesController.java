package kodlama.io.kodlamaioDevs.webApi.controllers;

import kodlama.io.kodlamaioDevs.business.abstracts.TechnologyService;
import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.kodlamaioDevs.business.responses.technologyresponses.GetAllTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TecnologiesController {
    TechnologyService technologyService;

    @Autowired
    public TecnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }

    @PostMapping
    public void add(CreateTechnologyRequest createTechnologyRequest){
        this.technologyService.add(createTechnologyRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(DeleteTechnologyRequest deleteTechnologyRequest){
        this.technologyService.delete(deleteTechnologyRequest);
    }

    @PutMapping("/{id}")
    public void updateById(int id, UpdateTechnologyRequest updateTechnologyRequest){
        this.technologyService.update(id,updateTechnologyRequest);
    }
}
