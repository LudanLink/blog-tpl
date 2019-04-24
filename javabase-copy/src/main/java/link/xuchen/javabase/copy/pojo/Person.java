package link.xuchen.javabase.copy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/24 11:45 AM
 * Description: TODO
 */
@Data
@ToString
@AllArgsConstructor
@Accessors(chain = true)
public class Person implements Cloneable{
    private int age;
    private String name;
    private Address address;

    public Person(Person p) {
        this.age = p.age;
        this.name = p.name;
        this.address = p.address;
    }

    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @ToString
    @Data
    @AllArgsConstructor
    public static class Address{
        private String address;
    }
}
