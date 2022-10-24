package sahachan.prac.ttoproj.patient.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sahachan.prac.ttoproj.patient.entity.Patient;

import java.util.List;

public interface PatientDao {
    Patient getPatient(Long id);
    Patient updatePatient(Patient patient);

    Patient addPatient(Patient patient);

    List<Patient> getAllPatient();

    Page<Patient> getAllPatient(PageRequest pageRequest);
}
