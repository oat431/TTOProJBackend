package sahachan.prac.ttoproj.security.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sahachan.prac.ttoproj.security.entity.User;
import sahachan.prac.ttoproj.security.repository.UserRepository;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
