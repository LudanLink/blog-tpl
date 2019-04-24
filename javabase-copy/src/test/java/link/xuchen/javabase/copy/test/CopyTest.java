package link.xuchen.javabase.copy.test;

import link.xuchen.javabase.copy.JavabaseCopyApplication;
import link.xuchen.javabase.copy.pojo.People;
import link.xuchen.javabase.copy.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/24 11:43 AM
 * Description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavabaseCopyApplication.class)
public class CopyTest {

    /**
     * 浅拷贝,基本类型是值传递,引用类型是引用传递
     * 通过构造器浅拷贝
     */
    @Test
    public void shallowCopy1() {
        Person.Address address = new Person.Address("address");
        Person p1 = new Person(10, "zhangsan", address);
        Person p2 = new Person(p1);
        System.out.println(p1);
        System.out.println(p2);
        p1.setName("lisi");
        p1.setAge(11);
        p1.setAddress(address.setAddress("Address"));
        System.out.println(p1);
        System.out.println(p2);
    }

    /**
     * 浅拷贝,基本类型是值传递,引用类型是引用传递
     * 通过重写clone()方法浅拷贝
     */
    @Test
    public void shallowCopy2() {
        Person.Address address = new Person.Address("address");
        Person p1 = new Person(10, "zhangsan", address);
        Person p2 = (Person) p1.clone();
        System.out.println(p1);
        System.out.println(p2);
        p1.setName("lisi");
        p1.setAge(11);
        p1.setAddress(address.setAddress("Address"));
        System.out.println(p1);
        System.out.println(p2);
    }

    /**
     * 深拷贝,重写clone()
     */
    @Test
    public void deepCopy1() {
        People.Address address = new People.Address("address");
        People p1 = new People(10, "zhangsan", address);
        People p2 = (People) p1.clone();
        System.out.println(p1);
        System.out.println(p2);
        p1.setName("lisi");
        p1.setAge(11);
        p1.setAddress(address.setAddress("Address"));
        System.out.println(p1);
        System.out.println(p2);
    }

    /**
     * 深拷贝,通过对象序列化实现
     */
    @Test
    public void deepCopy2() {
        People.Address address = new People.Address("address");
        People p1 = new People(10, "zhangsan", address);
        People p2 = null;

        ByteArrayOutputStream bos;
        ObjectOutputStream oos;
        ByteArrayInputStream bis;
        ObjectInputStream ois;
        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(p1);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            p2 = (People) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(p1);
        System.out.println(p2);
        p1.setName("lisi");
        p1.setAge(11);
        p1.setAddress(address.setAddress("Address"));
        System.out.println(p1);
        System.out.println(p2);
    }
}
