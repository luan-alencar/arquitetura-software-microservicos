package david.augusto.luan.usuarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@ComponentScan(basePackages = "david.augusto.luan.usuarioservice.service.mapper")
@SpringBootApplication
public class AcessoserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcessoserviceApplication.class, args);
    }

}
