package sahachan.prac.ttoproj.admin.controller;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sahachan.prac.ttoproj.admin.service.AdminService;
import sahachan.prac.ttoproj.doctor.service.DoctorService;
import sahachan.prac.ttoproj.patient.entity.VaccineHistoryRequest;
import sahachan.prac.ttoproj.patient.service.PatientService;
import sahachan.prac.ttoproj.security.entity.User;
import sahachan.prac.ttoproj.security.service.UserService;
import sahachan.prac.ttoproj.util.ProjectMapper;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    final AdminService adminService;
    final UserService userService;
    final DoctorService doctorService;
    final PatientService patientService;


    @PostMapping("/verify/patient/{id}")
    public ResponseEntity<?> verifyAsPatient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(adminService.verifyAsPatient(id));
    }

    @PostMapping("/verify/doctor/{id}")
    public ResponseEntity<?> verifyAsDoctor(@PathVariable("id") Long id,@RequestBody Hospital hospital) {
        return ResponseEntity.ok(adminService.verifyAsDoctor(id, hospital.getHospital()));
    }

    @GetMapping("/patients")
    public ResponseEntity<?> getPatients() {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(adminService.getAllPatient()));
    }

    @GetMapping("/doctors")
    public ResponseEntity<?> getDoctors() {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getDoctorDto(adminService.getAllDoctor()));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getUserDto(adminService.getAllUser()));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if(user.getAdmin() != null) {
            return ResponseEntity.ok(ProjectMapper.INSTANCE.getUserDto(adminService.getUser(id)));
        }
        if(user.getDoctor() != null) {
            return ResponseEntity.ok(ProjectMapper.INSTANCE.getDoctorDto(doctorService.getDoctor(user.getDoctor().getId())));
        }
        if(user.getPatient() != null) {
            return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(patientService.getPatient(user.getPatient().getId())));
        }
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getUserDto(adminService.getUser(id)));
    }

    @PostMapping("/assign-doctor")
    public ResponseEntity<?> assignDoctor(@RequestBody AssignDoctorRequest request) {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(adminService.addDoctorToPatient(request.getPatientID(), request.getDoctorID())));
    }

    @PostMapping("/add-vaccine-history")
    public ResponseEntity<?> addVaccineHistory(@RequestBody AddVaccineHistoryRequest request) {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(adminService.addVaccineHistory(request.getPatientID(), request.getHistory())));
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Hospital {
    String hospital;
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class AssignDoctorRequest {
    Long patientID;
    Long doctorID;
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class AddVaccineHistoryRequest {
    Long patientID;
    List<VaccineHistoryRequest> history;
}
