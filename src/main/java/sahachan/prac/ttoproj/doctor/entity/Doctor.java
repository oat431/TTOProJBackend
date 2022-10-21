package sahachan.prac.ttoproj.doctor.entity;

import lombok.*;
import sahachan.prac.ttoproj.security.entity.User;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    @OneToOne(mappedBy = "doctor",cascade = CascadeType.ALL)
    User user;
}
