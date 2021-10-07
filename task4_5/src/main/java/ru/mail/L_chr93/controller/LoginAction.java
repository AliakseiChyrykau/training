package ru.mail.L_chr93.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.mail.L_chr93.domain.User;
import ru.mail.L_chr93.service.ServiceException;
import ru.mail.L_chr93.service.UserService;
import ru.mail.L_chr93.util.daoUtil.ServiceFactoryException;

public class LoginAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null && password != null) {
            try {
                UserService service = getServiceFactory().getUserService();
                User user = service.findByLoginAndPassword(login, password);
                if (user != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("currentUser", user);
                    session.setAttribute("roleTagUrl", user.getRole().getUrl());
                    return new Forward("/index", false);
                } else {
                    return new Forward("/login.html?message=login.message.incorrect.password");
                }
            } catch (ServiceFactoryException | ServiceException e) {
                throw new ServletException(e);
            }
        } else {
            return null;
        }
    }
}
