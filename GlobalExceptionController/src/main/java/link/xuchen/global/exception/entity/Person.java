package link.xuchen.global.exception.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import link.xuchen.global.exception.validator.validates.Add;
import link.xuchen.global.exception.validator.validates.Update;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import java.util.Date;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/16 1:53 PM
 */
@Data
@Entity
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Length(min = 1,max = 3, message = "name在1和3之间", groups = {Add.class, Update.class})
    private String name;

    @Max(value = 100, message = "老不死??", groups = { Update.class})
    private int age;

    private Date created;

    private Date updated;
}
