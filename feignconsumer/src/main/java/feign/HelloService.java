package feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("SERVICE")
public interface HelloService {

    @RequestMapping("/service")
    String hello();

    @RequestMapping(value = "/greet1", method = RequestMethod.GET)
    String greet1(@RequestParam("name") String name);

    @RequestMapping(value = "/greet2", method = RequestMethod.GET)
    User greet2(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/greet3", method = RequestMethod.POST)
    String greet3(@RequestBody User user);
}
