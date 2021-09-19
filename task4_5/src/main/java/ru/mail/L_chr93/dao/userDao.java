package ru.mail.L_chr93.dao;

import java.util.List;

import ru.mail.L_chr93.domain.User;

public interface userDao extends Dao<User> {
    
    List<User> userList() throws DaoException;
    User readByLoginAndPassword(String login, String password) throws DaoException;
}
