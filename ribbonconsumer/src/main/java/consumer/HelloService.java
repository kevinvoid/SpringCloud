package consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author pingan.yang
 * @program SpringCloud
 * @description 具备熔断功能的service类
 * @create 2018-05-22 16:43
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://SERVICE/service", String.class).getBody();
    }

    public String helloFallback() {
        return "error";
    }
}
