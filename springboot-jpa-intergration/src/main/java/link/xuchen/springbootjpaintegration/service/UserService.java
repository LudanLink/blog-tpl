package link.xuchen.springbootjpaintegration.service;

import link.xuchen.springbootjpaintegration.entity.User;

import java.util.List;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/5/16 1:52 PM
 */
public interface UserService {
    List<User> findAll();
}
