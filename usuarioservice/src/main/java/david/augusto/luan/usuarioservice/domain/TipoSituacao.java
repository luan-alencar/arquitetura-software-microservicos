package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_TIPO_SITUACAO")
@Setter
@Getter
public class TipoSituacao implements Serializable {
    private static final long serialVersionUID = 5750976099916928214L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", columnDefinition = "VARCHAR(255)")
    private String descricao;
}
