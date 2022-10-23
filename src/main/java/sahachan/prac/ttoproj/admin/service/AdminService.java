package sahachan.prac.ttoproj.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.security.entity.User;

import java.util.List;

public interface AdminService {
    Patient verifyAsPatient(Long id);
    Doctor verifyAsDoctor(Long id, String hospital);

    List<User> getAllUser();
    Page<User> getAllUser(PageRequest pageRequest);
    List<Patient> getAllPatient();
    Page<Patient> getAllPatient(PageRequest pageRequest);
    List<Doctor> getAllDoctor();
    Page<Doctor> getAllDoctor(PageRequest pageRequest);

    User getUser(Long id);
}
