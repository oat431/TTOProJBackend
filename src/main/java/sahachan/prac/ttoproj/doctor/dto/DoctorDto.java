package sahachan.prac.ttoproj.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    Long id;
    String fullName;
    String hospital;
    String imageUrls;
}
