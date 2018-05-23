import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author pingan.yang
 * @program SpringCloud
 * @description
 * @create 2018-05-23 15:39
 */
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerApplication.class).run(args);
    }
}
