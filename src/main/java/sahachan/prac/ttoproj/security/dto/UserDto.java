package sahachan.prac.ttoproj.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sahachan.prac.ttoproj.security.entity.Authority;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    Long id;
    String username;
    String firstname;
    String lastname;
    String gender;
    String homeTown;
    String email;
    String birthday;
    List<String> authorities;
}
