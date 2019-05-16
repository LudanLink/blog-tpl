package link.xuchen.springbootjpaintegration.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/5/16 11:48 AM
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String nickname;
}
