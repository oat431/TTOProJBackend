package sahachan.prac.ttoproj.doctor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.doctor.repository.DoctorRepository;

import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao{
    @Autowired
    DoctorRepository doctorRepository;

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
}
