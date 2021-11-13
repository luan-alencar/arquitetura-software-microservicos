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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscricao")
    private Inscricao inscricaoID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento eventoID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pergunta")
    private Pergunta perguntaID;

    private String resposta;
}
