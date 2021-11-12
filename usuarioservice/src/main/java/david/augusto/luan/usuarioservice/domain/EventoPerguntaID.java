package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EventoPerguntaID implements Serializable {
    private static final long serialVersionUID = -6785434124634555966L;

    private Long eventoID;
    private Integer perguntaID;
}
