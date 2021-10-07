package ru.mail.L_chr93.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.mail.L_chr93.domain.User;

public class MainAction extends Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null) {
            User user = (User)session.getAttribute("currentUser");
            if(user != null) {
                switch(user.getRole()) {
                case ADMIN:
                case MANAGER:
                case DEVELOPER:
                case CUSTOMER:
                    return new Forward("/index", false);
                default:
                    return new Forward("/login.html");
                }
            } else {
                return new Forward("/login.html");
            }
        } else {
            return new Forward("/login.html");
        }
    }
}
