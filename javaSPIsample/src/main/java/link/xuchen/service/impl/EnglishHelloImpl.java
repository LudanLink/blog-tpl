package link.xuchen.service.impl;

import link.xuchen.service.HelloService;

/**
 * 英文实现类
 */
public class EnglishHelloImpl implements HelloService {
    public String hello(String word) {

        return "hello " + word;
    }
}
