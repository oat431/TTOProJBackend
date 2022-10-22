package sahachan.prac.ttoproj.comment.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.patient.entity.Patient;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String content;

    @ManyToOne
    Doctor by;

    @ManyToOne
    Patient to;

    @CreatedDate
    Date createWhen;

    @LastModifiedDate
    Date updateAt;
}
