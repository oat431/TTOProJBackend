package sahachan.prac.ttoproj.security.repository;



import org.springframework.data.repository.CrudRepository;
import sahachan.prac.ttoproj.security.entity.Authority;
import sahachan.prac.ttoproj.security.entity.AuthorityName;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
