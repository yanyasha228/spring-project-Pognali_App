package net.PognaliApp.services;

import net.PognaliApp.models.User;
/**
 * Service for validation Email.
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */

public interface CheckMailService {
    void sendCheckMessage(User userForm);
}
