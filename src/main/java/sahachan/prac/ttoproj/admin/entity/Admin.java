package sahachan.prac.ttoproj.admin.entity;

import lombok.*;
import sahachan.prac.ttoproj.security.entity.User;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    @OneToOne(mappedBy = "admin",cascade = CascadeType.ALL)
    User user;
}
