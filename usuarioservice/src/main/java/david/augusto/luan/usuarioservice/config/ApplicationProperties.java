package david.augusto.luan.usuarioservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.mail")
public class ApplicationProperties {

    private String enderecoRemetente;
    private String nomeRemetente;
}
