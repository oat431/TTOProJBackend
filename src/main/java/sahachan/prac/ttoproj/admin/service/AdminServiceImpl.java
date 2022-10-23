package sahachan.prac.ttoproj.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sahachan.prac.ttoproj.doctor.dao.DoctorDao;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.patient.dao.PatientDao;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.security.dao.AuthorityDao;
import sahachan.prac.ttoproj.security.dao.UserDao;
import sahachan.prac.ttoproj.security.entity.Authority;
import sahachan.prac.ttoproj.security.entity.AuthorityName;
import sahachan.prac.ttoproj.security.entity.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    final UserDao userDao;
    final PatientDao patientDao;
    final DoctorDao doctorDao;
    final AuthorityDao authorityDao;

    private User getUserDetail(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public Patient verifyAsPatient(Long id) {
        Authority rolePatient = Authority.builder().name(AuthorityName.ROLE_PATIENT).build();
        authorityDao.addAuthority(rolePatient);
        User user = getUserDetail(id);
        Patient patient = new Patient();
        patientDao.addPatient(patient);
        user.setAuthorities(new ArrayList<>());
        user.getAuthorities().add(rolePatient);
        user.setEnabled(true);
        user.setPatient(patient);
        userDao.updateUser(user);
        return patient;
    }

    @Override
    public Doctor verifyAsDoctor(Long id, String hospital) {
        Authority roleDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        authorityDao.addAuthority(roleDoctor);
        User user = getUserDetail(id);
        Doctor doctor = Doctor.builder()
                .hospital(hospital)
                .build();
        doctorDao.addDoctor(doctor);
        user.setAuthorities(new ArrayList<>());
        user.getAuthorities().add(roleDoctor);
        user.setEnabled(true);
        user.setDoctor(doctor);
        userDao.updateUser(user);
        return doctor;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public Page<User> getAllUser(PageRequest pageRequest) {
        return userDao.getAllUser(pageRequest);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientDao.getAllPatient();
    }

    @Override
    public Page<Patient> getAllPatient(PageRequest pageRequest) {
        return patientDao.getAllPatient(pageRequest);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return null;
    }

    @Override
    public Page<Doctor> getAllDoctor(PageRequest pageRequest) {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
