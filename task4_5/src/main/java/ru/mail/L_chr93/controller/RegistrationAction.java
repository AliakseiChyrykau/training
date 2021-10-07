package ru.mail.L_chr93.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.mail.L_chr93.domain.Role;
import ru.mail.L_chr93.domain.User;
import ru.mail.L_chr93.service.ServiceException;
import ru.mail.L_chr93.service.UserService;
import ru.mail.L_chr93.util.daoUtil.ServiceFactoryException;

public class RegistrationAction extends Action {

    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        User user = getUser(req);

        try {
            UserService service = getServiceFactory().getUserService();
            service.save(user);
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            session.setAttribute("roleTagUrl", user.getRole().getUrl());
            return new Forward("/index", false);
        } catch (ServiceFactoryException | ServiceException e) {
            throw new ServletException(e);
        }
    }
    
    private User getUser(HttpServletRequest req) {
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setLastName(req.getParameter("lastName"));
        user.setRole(Role.CUSTOMER);
        return user;
    }
    
}

