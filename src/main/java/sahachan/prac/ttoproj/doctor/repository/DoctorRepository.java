package sahachan.prac.ttoproj.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sahachan.prac.ttoproj.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
