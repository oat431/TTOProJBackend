package sahachan.prac.ttoproj.patient.entity;

import lombok.*;
import sahachan.prac.ttoproj.vaccine.entity.Vaccine;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccineHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    Date vaccineDate;
    @ManyToOne
    Vaccine vaccine;
    @ManyToOne(fetch = FetchType.LAZY)
    Patient patient;
}
