package david.augusto.luan.usuarioservice.rabbit;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProdutorTarget {

    String BINDING_MAILER = "mailer";

    @Input(ProdutorTarget.BINDING_MAILER)
    MessageChannel enviarEmail();
}
