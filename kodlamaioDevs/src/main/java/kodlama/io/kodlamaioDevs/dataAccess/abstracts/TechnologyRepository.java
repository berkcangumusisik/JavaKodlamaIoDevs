package kodlama.io.kodlamaioDevs.dataAccess.abstracts;

import kodlama.io.kodlamaioDevs.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
