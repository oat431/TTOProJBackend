package sahachan.prac.ttoproj.patient.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.patient.repository.PatientRepository;

import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> getAllPatient(PageRequest pageRequest) {
        return patientRepository.findAll(pageRequest);
    }
}
