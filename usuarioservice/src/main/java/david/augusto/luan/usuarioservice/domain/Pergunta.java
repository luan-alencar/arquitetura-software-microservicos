package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TB_PERGUNTA")
public class Pergunta implements Serializable {
    private static final long serialVersionUID = 1082389780941208127L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Boolean obrigatoriedade;
}
