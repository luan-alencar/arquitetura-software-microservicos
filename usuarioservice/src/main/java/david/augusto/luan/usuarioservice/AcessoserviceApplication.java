package david.augusto.luan.usuarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AcessoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcessoserviceApplication.class, args);
	}

}
