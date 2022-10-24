package sahachan.prac.ttoproj.doctor.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.doctor.repository.DoctorRepository;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.patient.repository.PatientRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoctorDaoImpl implements DoctorDao{
    final DoctorRepository doctorRepository;
    final PatientRepository patientRepository;

    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Page<Doctor> getAllDoctor(PageRequest pageRequest) {
        return doctorRepository.findAll(pageRequest);
    }

    @Override
    public List<Patient> getPatientInCare(Doctor doctor) {
        return patientRepository.findAllByDoctor(doctor);
    }

    @Override
    public Page<Patient> getPatientInCare(Doctor doctor, PageRequest pageRequest) {
        return patientRepository.findAllByDoctor(doctor, pageRequest);
    }
}
