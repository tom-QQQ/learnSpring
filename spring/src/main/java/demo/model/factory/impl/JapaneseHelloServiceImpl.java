package demo.model.factory.impl;

import demo.model.factory.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author Ning
 * @date Create in 2019/1/4
 */
@Component("JapaneseHelloService")
public class JapaneseHelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "こんにちは, " + name + "君";
    }
}
