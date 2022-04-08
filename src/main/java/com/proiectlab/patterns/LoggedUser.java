package com.proiectlab.patterns;

import com.proiectlab.entity.Users;

public class LoggedUser {

    private Users user = null;
    private static LoggedUser loggedUser = null;

    public static LoggedUser getInstance() {

        if (loggedUser == null) {
            loggedUser = new LoggedUser();
        }

        return loggedUser;
    }

    private LoggedUser() {
    }

    public void setLoggedUser(Users user) {
        this.user = user;
    }

    public Users getLoggedUser() {
        return user;
    }
}
