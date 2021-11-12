package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_EVENTO")
@Getter
@Setter
public class Evento implements Serializable {
    private static final long serialVersionUID = 2213349394564022776L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String local;

    private String titulo;

    private String descricao;

    private Integer quantidadeVagas;

    private Double valor;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private Boolean tipoInscricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evento")
    private TipoEvento tipoEvento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "evento")
    private List<EventoPergunta> perguntas = new ArrayList<>();
}
