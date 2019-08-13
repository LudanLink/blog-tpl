package link.xuchen.service.impl;

import link.xuchen.service.HelloService;

/**
 * 中文实现类
 */
public class ChineseHelloImpl implements HelloService {
    public String hello(String word) {
        return "你好 " + word;
    }
}
