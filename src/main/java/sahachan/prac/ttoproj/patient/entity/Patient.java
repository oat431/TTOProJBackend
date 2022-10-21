package sahachan.prac.ttoproj.patient.entity;

import lombok.*;
import sahachan.prac.ttoproj.security.entity.User;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    @OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
    User user;
}
