package sahachan.prac.ttoproj.security.service;

import sahachan.prac.ttoproj.security.controller.JwtAuthenticationRequest;
import sahachan.prac.ttoproj.security.entity.User;

public interface UserService {
    User findByUsername(String username);
    User addUser(User user);

    User getUser(Long id);
}
