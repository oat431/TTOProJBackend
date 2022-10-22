package sahachan.prac.ttoproj.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sahachan.prac.ttoproj.security.entity.Authority;
import sahachan.prac.ttoproj.security.repository.AuthorityRepository;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public Authority addAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }
}
