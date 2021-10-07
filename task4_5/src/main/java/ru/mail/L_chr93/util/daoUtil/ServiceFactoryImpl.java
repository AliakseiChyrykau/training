package ru.mail.L_chr93.util.daoUtil;

import java.sql.Connection;
import java.sql.SQLException;

import ru.mail.L_chr93.connectionPool.ConnectionPool;
import ru.mail.L_chr93.dao.UserDao;
import ru.mail.L_chr93.dao.mySqlDao.userDaoImpl;
import ru.mail.L_chr93.service.Transaction;
import ru.mail.L_chr93.service.UserService;
import ru.mail.L_chr93.service.serviceImpl.TransactionImpl;
import ru.mail.L_chr93.service.serviceImpl.UserServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory{
    
    Connection connection = null;

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserService getUserService() throws ServiceFactoryException {
	    UserServiceImpl userService = new UserServiceImpl();
        userService.setTransaction(getTransaction());
        userService.setUserDao(getUserDao());
        return userService;
	}

	@Override
	public Transaction getTransaction() throws ServiceFactoryException {
	    TransactionImpl transaction = new TransactionImpl();
        transaction.setConnection(getConnection());
        return transaction;
	}

	@Override
	public UserDao getUserDao() throws ServiceFactoryException {
		userDaoImpl userDao = new userDaoImpl();
		userDao.setConnection(getConnection());
		return userDao;
	}

	@Override
	public Connection getConnection() throws ServiceFactoryException {
		ConnectionPool pool = ConnectionPool.getInstance();
	    
	    if (connection == null) {
			connection = pool.getConnection();
		}
		return connection;
	}

}
