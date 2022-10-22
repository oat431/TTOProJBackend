package sahachan.prac.ttoproj.security.dao;

import sahachan.prac.ttoproj.security.entity.User;

public interface UserDao {
    User findByUsername(String username);
    User addUser(User user);
}
