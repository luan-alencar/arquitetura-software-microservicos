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

    @Column(name = "local")
    private String local;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "quantidade_vagas")
    private Integer quantidadeVagas;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column(name = "tipo_inscricao")
    private Boolean tipoInscricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evento")
    private TipoEvento tipoEvento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "eventoID")
    private List<EventoPergunta> perguntas = new ArrayList<>();
}
