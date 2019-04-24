package link.xuchen.global.exception.service;

import link.xuchen.global.exception.entity.Person;
import link.xuchen.global.exception.exceptions.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/16 2:14 PM
 */
@Service
public class PersonService {
    @Transactional
    public Person save(Person person) {
        if (1L== person.getId()) {
            throw new BusinessException("数据库不喜欢id是1的数据");
        }
        return person;
    }

    public Person update(Person person) {
        if ("update".equals(person.getName())) {
            throw new BusinessException("居然敢使用关键字");
        }
        return person;
    }
}
