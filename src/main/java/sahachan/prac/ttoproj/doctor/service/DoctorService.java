package sahachan.prac.ttoproj.doctor.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sahachan.prac.ttoproj.comment.entity.Comment;
import sahachan.prac.ttoproj.comment.entity.CommentRequest;
import sahachan.prac.ttoproj.patient.entity.Patient;

import java.util.List;

public interface DoctorService {
    List<Patient> getPatientInCare(Long id);
    Page<Patient> getPatientInCare(Long id, PageRequest pageRequest);
    Patient addComment(CommentRequest comment);
}
