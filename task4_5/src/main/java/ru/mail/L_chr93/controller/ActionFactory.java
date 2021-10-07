package ru.mail.L_chr93.controller;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;

public class ActionFactory {
	
	private static Map<String, Class<? extends Action>> actions = new HashMap<>();

	static {
		actions.put("/", MainAction.class);
		actions.put("/index", MainAction.class);
		actions.put("/login", LoginAction.class);
		actions.put("/logout", LogoutAction.class);
		actions.put("/setLanguage", LanguageAction.class);
		actions.put("/registrationPerform", RegistrationAction.class);
	}

	@SuppressWarnings("deprecation")
	public static Action getAction(String url) throws ServletException {
		Class<?> action = actions.get(url);
		if (action != null) {
			try {
				return (Action) action.newInstance();
			} catch (InstantiationException | IllegalAccessException | NullPointerException e) {
				throw new ServletException(e);
			}
		} else {
			return null;
		}
	}
}
