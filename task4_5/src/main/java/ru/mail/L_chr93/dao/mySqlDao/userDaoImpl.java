package ru.mail.L_chr93.dao.mySqlDao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.mail.L_chr93.dao.DaoException;
import ru.mail.L_chr93.dao.UserDao;
import ru.mail.L_chr93.domain.Role;
import ru.mail.L_chr93.domain.User;
import ru.mail.L_chr93.service.serviceImpl.UserServiceImpl;
import ru.mail.L_chr93.util.daoUtil.JdbcDaoUtil;
import ru.mail.L_chr93.util.daoUtil.RowMap;

public class userDaoImpl extends JdbcDaoUtil implements UserDao{
    
	private static final Logger log = LogManager.getLogger(userDaoImpl.class);
	
    private RowMap<User> rowMap = new RowMap<User>() {

        @Override
        public User rowMap(ResultSet rs) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("Id"));
            user.setName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
            user.setLogin(rs.getString("Login"));
            user.setPassword(rs.getString("Password"));
            user.setRole(Role.values()[rs.getInt("Role_id") - 1]);
            return user;
        }
    };

	@Override
	public Long create(User user) throws DaoException {
	    String sql = "INSERT INTO users(Login, password, FirstName, LastName, Role_id) VALUES(?,?,?,?,?)";
        String sql2 = "SELECT AUTO_INCREMENT from information_schema.tables where table_name = 'users'";
        Long id = null;
        
        id = getId(sql2);
        
        update(sql, user.getLogin(), user.getPassword()
                , user.getName(), user.getLastName(), user.getRole().ordinal() + 1);
        
        return id;
	}

	@Override
	public User read(Long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> userList() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readByLoginAndPassword(String login, String password) throws DaoException {
		String sql = "SELECT * FROM users WHERE Login LIKE ? AND Password = ?";
		User user = selectOne(sql, rowMap, login, password);
		return user;
	}

}
