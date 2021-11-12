package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class InscricaoRespostaID  implements Serializable {
    private static final long serialVersionUID = 6849844032514932053L;

    private Long inscricaoID;
    private Long eventoID;
    private Long perguntaID;
}
