package feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pingan.yang
 * @program SpringCloud
 * @description 使用声明式调用service
 * @create 2018-05-22 17:30
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/feignconsumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }


    @RequestMapping(value = "/feigngreet1", method = RequestMethod.GET)
    public String feigngreet1() {
        return helloService.greet1("kevin");
    }

    @RequestMapping(value = "/feigngreet2", method = RequestMethod.GET)
    public User feigngreet2() {
        return helloService.greet2("kevin", 28);
    }

    @RequestMapping(value = "/feigngreet3", method = RequestMethod.POST)
    public String feigngreet3() {
        return helloService.greet3(new User("pingan", 28));
    }
}
