package david.augusto.luan.usuarioservice.service.dto;

import david.augusto.luan.usuarioservice.domain.Anexo;
import david.augusto.luan.usuarioservice.domain.EventoPergunta;
import david.augusto.luan.usuarioservice.domain.TipoEvento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EventoDTO implements Serializable {

    private Long id;
    private String local;
    private String titulo;
    private String descricao;
    private Integer quantidadeVagas;
    private Double valor;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Boolean tipoInscricao;
//    private TipoEvento tipoEvento;
//    private List<EventoPergunta> perguntas = new ArrayList<>();
//    private List<Anexo> anexos;
}
