package sahachan.prac.ttoproj.doctor.entity;

import lombok.*;
import sahachan.prac.ttoproj.comment.entity.Comment;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.security.entity.User;

import javax.persistence.*;
import java.util.List;

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

    String hospital;

    @OneToOne(mappedBy = "doctor",cascade = CascadeType.ALL)
    User user;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    List<Patient> patients;

    @OneToMany(mappedBy = "by",cascade = CascadeType.ALL)
    List<Comment> comments;
}
