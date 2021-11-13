package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "TB_INSCRICAO")
public class Inscricao implements Serializable {
    private static final long serialVersionUID = -4114513045338274747L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento eventoID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_situacao")
    private TipoSituacao tipoSituacao;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "inscricaoID")
    private List<InscricaoResposta> resposta = new ArrayList<>();
}
