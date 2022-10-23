package sahachan.prac.ttoproj.admin.controller;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sahachan.prac.ttoproj.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    final AdminService adminService;


    @PostMapping("/verify/patient/{id}")
    public ResponseEntity<?> verifyAsPatient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(adminService.verifyAsPatient(id));
    }

    @PostMapping("/verify/doctor/{id}")
    public ResponseEntity<?> verifyAsDoctor(@PathVariable("id") Long id,@RequestBody Hospital hospital) {
        return ResponseEntity.ok(adminService.verifyAsDoctor(id, hospital.getHospital()));
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Hospital {
    String hospital;
}
