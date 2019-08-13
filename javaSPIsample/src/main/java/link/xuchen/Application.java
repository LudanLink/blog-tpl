package link.xuchen;

import link.xuchen.service.HelloService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * java官方英文文档： https://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html
 * 通过java提供的serviceLoader来读取META-INF.services文件包下的配置
 * 决定使用哪一个实现类
 */
public class Application {

    public static void main(String[] args) {
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Iterator<HelloService> it =  loader.iterator();
        while (it != null && it.hasNext()) {
            HelloService service = it.next();
            System.out.println(service.getClass().getName() + ";" + service.hello("world!"));
        }
    }
}
