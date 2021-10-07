package ru.mail.L_chr93.service.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.mail.L_chr93.dao.DaoException;
import ru.mail.L_chr93.dao.UserDao;
import ru.mail.L_chr93.domain.User;
import ru.mail.L_chr93.service.ServiceException;
import ru.mail.L_chr93.service.UserService;

public class UserServiceImpl extends BaseService implements UserService {

	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
	
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws ServiceException {
        User user = null;
		try {
			user = userDao.readByLoginAndPassword(login, password);
		} catch (DaoException e) {
			e.printStackTrace();
		}
        return user;
    }

    @Override
    public List<User> findAll() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(User user) throws ServiceException {
        try {
            getTransaction().start();
            
            if (user.getId() != null) {
                User storedUser = userDao.read(user.getId());
                
                if (storedUser != null) {
                    userDao.update(user);
                }
                
            } else {
                Long id = userDao.create(user);
                user.setId(id);
            }
            
           getTransaction().commit();
        } catch (DaoException e) {
            
            try {
                getTransaction().rollback();
            } catch (ServiceException e1) {}
            
            throw new ServiceException(e);
        } catch (ServiceException e) {
            try {
                getTransaction().rollback();
            } catch (ServiceException e1) {}
            throw e;
        }

    }

    @Override
    public void delete(Long id) throws ServiceException {
        // TODO Auto-generated method stub

    }

}
