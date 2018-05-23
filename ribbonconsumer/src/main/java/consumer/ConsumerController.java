package consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author pingan.yang
 * @program SpringCloud
 * @description
 * @create 2018-05-22 14:57
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbonconsumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://SERVICE/service", String.class).getBody();
    }

    @RequestMapping(value = "/ribbonconsumerHystrix", method = RequestMethod.GET)
    public String helloConsumerHystrix() {
        return helloService.helloService();
    }

}
