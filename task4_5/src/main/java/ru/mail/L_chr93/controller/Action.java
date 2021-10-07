package ru.mail.L_chr93.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.mail.L_chr93.util.daoUtil.ServiceFactory;

public abstract class Action {
	
	private ServiceFactory serviceFactory;

	public final ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public final void setServiceFactory(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	abstract public Forward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
	
}
