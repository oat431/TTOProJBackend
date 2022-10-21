package sahachan.prac.ttoproj.patient.entity;

import lombok.*;
import sahachan.prac.ttoproj.comment.entity.Comment;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.security.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Builder.Default
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    List<VaccineHistory> vaccineHistories = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "to",cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    Doctor doctor;
}
