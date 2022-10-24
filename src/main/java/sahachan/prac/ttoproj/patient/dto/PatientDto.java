package sahachan.prac.ttoproj.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sahachan.prac.ttoproj.comment.dto.CommentDto;
import sahachan.prac.ttoproj.doctor.dto.DoctorDto;
import sahachan.prac.ttoproj.security.dto.UserDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    Long id;
    UserDto user;
    DoctorDto doctor;
    List<VaccineHistoryDto> vaccineHistories;
    List<CommentDto> comments;
}
