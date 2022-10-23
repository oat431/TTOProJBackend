package sahachan.prac.ttoproj.doctor.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sahachan.prac.ttoproj.doctor.entity.Doctor;

import java.util.List;

public interface DoctorDao {
    Doctor getDoctor(Long id);
    Doctor addDoctor(Doctor doctor);

    List<Doctor> getAllDoctor();
    Page<Doctor> getAllDoctor(PageRequest pageRequest);
}
