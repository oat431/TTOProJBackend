package sahachan.prac.ttoproj.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.patient.entity.VaccineHistoryRequest;
import sahachan.prac.ttoproj.security.entity.User;
import sahachan.prac.ttoproj.vaccine.entity.Vaccine;

import java.util.List;

public interface AdminService {
    Patient verifyAsPatient(Long id);
    Doctor verifyAsDoctor(Long id, String hospital);
    Patient addVaccineHistory(Long id, List<VaccineHistoryRequest> history);
    Patient addDoctorToPatient(Long patientID, Long doctorID);
    List<User> getAllUser();
    Page<User> getAllUser(PageRequest pageRequest);
    List<User> getUnEnabledUser();
    Page<User> getUnEnabledUser(PageRequest pageRequest);
    List<Patient> getAllPatient();
    Page<Patient> getAllPatient(PageRequest pageRequest);
    List<Doctor> getAllDoctor();
    Page<Doctor> getAllDoctor(PageRequest pageRequest);
    User getUser(Long id);
    List<Vaccine> getAllVaccine();
}
