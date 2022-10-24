package sahachan.prac.ttoproj.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sahachan.prac.ttoproj.patient.service.PatientService;
import sahachan.prac.ttoproj.util.ProjectMapper;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientData(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(patientService.getPatient(id)));
    }
}
