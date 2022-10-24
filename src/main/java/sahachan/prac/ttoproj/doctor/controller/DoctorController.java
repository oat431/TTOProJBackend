package sahachan.prac.ttoproj.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sahachan.prac.ttoproj.comment.entity.CommentRequest;
import sahachan.prac.ttoproj.doctor.service.DoctorService;
import sahachan.prac.ttoproj.util.ProjectMapper;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/{id}/patients")
    public ResponseEntity<?> getPatientInCare(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(doctorService.getPatientInCare(id)));
    }

    @PostMapping("/comment")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest comment) {
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getPatientDto(doctorService.addComment(comment)));
    }

}
