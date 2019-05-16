package link.xuchen.jwtaction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/5/14 4:23 PM
 * Description: TODO
 */
@Entity
@Data
@Table(name="dept")
public class Dept implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    @NotNull
    private Boolean enabled;

    /**
     * 上级部门
     */
    @Column(name = "pid",nullable = false)
    @NotNull
    private Long pid;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    @ManyToMany(mappedBy = "depts")
    @JsonIgnore
    private Set<Role> roles;

    public @interface Update {}
}
