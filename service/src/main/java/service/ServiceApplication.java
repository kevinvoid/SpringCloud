package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lzr on 2017/4/15.
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service")
    public String service() throws Exception {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();

        // 设置处理线程等几秒钟
        /*int sleepTime = new Random().nextInt(2000);
        Thread.sleep(sleepTime);*/

        return "service:" + serviceInstance.getHost() + " " + serviceInstance.getServiceId();
    }

    @GetMapping("/greet1")
    public String greet1(@RequestParam String name) {
        return "greet:" + name;
    }

    @GetMapping("/greet2")
    public User greet2(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping(value = "/greet3")
    @ResponseBody
    public String greet3(@RequestBody(required = false) User user) {
        return "greet3:" + user.getName() + "," + user.getAge();
    }


    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
