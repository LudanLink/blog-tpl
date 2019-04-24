package link.xuchen.javabase.copy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/24 2:42 PM
 * Description: TODO
 */
@Data
@ToString
@AllArgsConstructor
@Accessors(chain = true)
public class People implements Cloneable, Serializable {
    private int age;
    private String name;
    private People.Address address;

    public People(People p) {
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
        People obj1 = (People) obj;
        obj1.address = (Address) obj1.getAddress().clone();
        return obj;
    }

    @ToString
    @Data
    @AllArgsConstructor
    public static class Address implements Cloneable, Serializable{
        private String address;
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
    }
}
