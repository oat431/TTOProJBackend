package sahachan.prac.ttoproj.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sahachan.prac.ttoproj.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
