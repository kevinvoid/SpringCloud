package feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author pingan.yang
 * @program SpringCloud
 * @description 声明式服务调用（feign）
 * @create 2018-05-22 17:28
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class FeignApplication {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
