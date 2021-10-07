package ru.mail.L_chr93.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.mail.L_chr93.util.daoUtil.ServiceFactory;
import ru.mail.L_chr93.util.daoUtil.ServiceFactoryImpl;

@WebServlet("*.html")
public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF8");
		String url = req.getRequestURI();
		String context = req.getContextPath();
		int postfixIndex = url.lastIndexOf(".html");
		if (postfixIndex != -1) {
			url = url.substring(context.length(), postfixIndex);
		} else {
			url = url.substring(context.length());
		}
		Action action = ActionFactory.getAction(url);
		Forward forward = null;
		if (action != null) {
			try (ServiceFactory factory = getServiceFactory()) {
				action.setServiceFactory(factory);
				forward = action.execute(req, res);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		if (forward != null && forward.isRedirect()) {
			res.sendRedirect(context + forward.getUrl());
		} else {
			if (forward != null && forward.getUrl() != null) {
				url = forward.getUrl();
			}
			req.getRequestDispatcher("/WEB-INF/jsp" + url + ".jsp").forward(req, res);
		}
	}

	private ServiceFactory getServiceFactory() {
		return new ServiceFactoryImpl();
	}

}
