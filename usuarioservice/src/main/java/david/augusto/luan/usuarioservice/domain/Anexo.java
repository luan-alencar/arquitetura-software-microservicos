package david.augusto.luan.usuarioservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "`TB_ANEXO`")
public class Anexo implements Serializable {

    private static final long serialVersionUID = -3819082393237055892L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`id`")
    private Long id;

    @Column(name = "`file`")
    private String file;

    @Column(name = "`filename`")
    private String fileName;

    @Column(name = "`uuid`")
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`evento`")
    private Evento evento;
}
