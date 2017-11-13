package net.PognaliApp.dao;

import net.PognaliApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 * JpaRepository for {@link User}'s pages.
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
