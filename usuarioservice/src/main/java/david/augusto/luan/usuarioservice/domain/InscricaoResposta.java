package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "TB_INSCRICAO_RESPOSTA")
public class InscricaoResposta implements Serializable {
    private static final long serialVersionUID = -4863434457865710934L;

    @EmbeddedId
    private InscricaoRespostaID id;

    @MapsId("inscricaoID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscricao")
    private Inscricao inscricao;

    @MapsId("eventoID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @MapsId("perguntaID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pergunta")
    private Pergunta pergunta;

    private String resposta;
}
