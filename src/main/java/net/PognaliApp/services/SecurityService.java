package net.PognaliApp.services;

/**
 * Service for Security.
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
