package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class EventoPerguntaID implements Serializable {

    private Long eventoID;
    private Integer perguntaID;
}
