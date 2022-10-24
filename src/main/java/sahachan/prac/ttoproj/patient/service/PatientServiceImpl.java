package sahachan.prac.ttoproj.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sahachan.prac.ttoproj.patient.dao.PatientDao;
import sahachan.prac.ttoproj.patient.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientDao patientDao;

    @Override
    public Patient getPatient(Long id) {
        return patientDao.getPatient(id);
    }
}
