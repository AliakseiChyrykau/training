package ru.mail.L_chr93.util.daoUtil;

import java.sql.Connection;

import ru.mail.L_chr93.dao.UserDao;
import ru.mail.L_chr93.service.Transaction;
import ru.mail.L_chr93.service.UserService;

public interface ServiceFactory extends AutoCloseable {

	UserService getUserService() throws ServiceFactoryException;

    Transaction getTransaction() throws ServiceFactoryException;

    UserDao getUserDao() throws ServiceFactoryException;

    Connection getConnection() throws ServiceFactoryException;
    
}
