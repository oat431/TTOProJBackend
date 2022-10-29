package sahachan.prac.ttoproj.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    Long id;
    Long doctorID;
    Long patientID;
    Long adminID;
    String username;
    String firstname;
    String lastname;
    String gender;
    String homeTown;
    String email;
    String birthDate;
    String imageUrls;
    List<String> authorities;
}
