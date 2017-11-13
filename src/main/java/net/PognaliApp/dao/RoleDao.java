package net.PognaliApp.dao;

import net.PognaliApp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JpaRepository for {@link Role}'s pages.
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
