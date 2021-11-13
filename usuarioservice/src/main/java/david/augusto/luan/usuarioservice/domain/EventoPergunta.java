package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_EVENTO_PERGUNTA")
public class EventoPergunta {
    private static final long serialVersionUID = -4297014346032098956L;

    @EmbeddedId
    private EventoPerguntaID id;

    @MapsId("eventoID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento eventoID;

    @MapsId("perguntaID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pergunta")
    private Pergunta perguntaID;
}
