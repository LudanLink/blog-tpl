package link.xuchen.springbootjpaintegration.dao;

import link.xuchen.springbootjpaintegration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/5/16 1:49 PM
 */
@Component
public interface UserDao extends JpaRepository<User, Long> {
}
