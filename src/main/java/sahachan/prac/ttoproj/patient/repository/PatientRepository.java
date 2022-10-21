package sahachan.prac.ttoproj.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sahachan.prac.ttoproj.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
