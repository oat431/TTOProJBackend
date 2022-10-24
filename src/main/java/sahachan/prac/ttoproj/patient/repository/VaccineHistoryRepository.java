package sahachan.prac.ttoproj.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sahachan.prac.ttoproj.patient.entity.VaccineHistory;

public interface VaccineHistoryRepository extends JpaRepository<VaccineHistory, Long> {
}
