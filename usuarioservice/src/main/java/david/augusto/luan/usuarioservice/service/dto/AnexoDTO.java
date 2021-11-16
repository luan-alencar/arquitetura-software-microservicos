package david.augusto.luan.usuarioservice.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnexoDTO {

    private Long id;

    private String file;
    private String fileName;
    private String uuid;
    private EventoDTO evento;
}
