package sahachan.prac.ttoproj.vaccine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDto {
    String fullName;
    String codeName;
}
