package sahachan.prac.ttoproj.vaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sahachan.prac.ttoproj.vaccine.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
