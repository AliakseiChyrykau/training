package ru.mail.L_chr93.service;

import java.util.List;

import ru.mail.L_chr93.domain.User;

public interface UserService {

    User findById(Long id) throws ServiceException;

    User findByLoginAndPassword(String login, String password) throws ServiceException;

    List<User> findAll() throws ServiceException;

    void save(User user) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
