package link.xuchen.springbootjpaintegration.service.impl;

import link.xuchen.springbootjpaintegration.dao.UserDao;
import link.xuchen.springbootjpaintegration.entity.User;
import link.xuchen.springbootjpaintegration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/5/16 1:54 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
