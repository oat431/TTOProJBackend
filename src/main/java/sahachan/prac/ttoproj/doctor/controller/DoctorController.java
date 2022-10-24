package sahachan.prac.ttoproj.doctor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sahachan.prac.ttoproj.comment.entity.CommentRequest;
import sahachan.prac.ttoproj.doctor.service.DoctorService;
import sahachan.prac.ttoproj.patient.service.PatientService;
import sahachan.prac.ttoproj.util.ProjectMapper;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    final DoctorService doctorService;
    final PatientService patientService;



    @GetMapping("/{id}/patients")
    public ResponseEntity<?> getPatientInCare(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(doctorService.getPatientInCare(id)));
    }

    @GetMapping("/{id}/patients/{patientId}")
    public ResponseEntity<?> getPatientInCareById(@PathVariable("id") Long id, @PathVariable("patientId") Long patientId) {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(patientService.getPatient(patientId)));
    }

    @PostMapping("/comment")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest comment) {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(doctorService.addComment(comment)));
    }

}
