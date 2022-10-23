package sahachan.prac.ttoproj.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sahachan.prac.ttoproj.vaccine.dto.VaccineDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccineHistoryDto {
    VaccineDto vaccine;
    String vaccineDate;
}
