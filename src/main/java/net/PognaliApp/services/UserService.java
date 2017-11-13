package net.PognaliApp.services;

import net.PognaliApp.models.User;

/**
 * Service class for {@link User}
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findByEmail(String email);
}
