package sahachan.prac.ttoproj.doctor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sahachan.prac.ttoproj.comment.dao.CommentDao;
import sahachan.prac.ttoproj.comment.entity.Comment;
import sahachan.prac.ttoproj.comment.entity.CommentRequest;
import sahachan.prac.ttoproj.doctor.dao.DoctorDao;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.patient.dao.PatientDao;
import sahachan.prac.ttoproj.patient.entity.Patient;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    final DoctorDao doctorDao;
    final PatientDao patientDao;
    final CommentDao commentDao;

    @Override
    public List<Patient> getPatientInCare(Long id) {
        Doctor doctor = doctorDao.getDoctor(id);
        return doctorDao.getPatientInCare(doctor);
    }

    @Override
    public Page<Patient> getPatientInCare(Long id, PageRequest pageRequest) {
        Doctor doctor = doctorDao.getDoctor(id);
        return doctorDao.getPatientInCare(doctor, pageRequest);
    }

    @Override
    public Patient addComment(CommentRequest comment) {
        Patient patient = patientDao.getPatient(comment.getPatientId());
        Doctor doctor = doctorDao.getDoctor(comment.getDoctorId());
        Comment com = Comment.builder()
                .content(comment.getContent())
                .to(patient)
                .by(doctor)
                .createWhen(Timestamp.valueOf(LocalDateTime.now()))
                .updateAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        commentDao.addComment(com);
        return patient;
    }
}
