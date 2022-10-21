package sahachan.prac.ttoproj.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sahachan.prac.ttoproj.security.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
