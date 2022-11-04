package kodlama.io.kodlamaioDevs.dataAccess.abstracts;

import kodlama.io.kodlamaioDevs.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {



}
