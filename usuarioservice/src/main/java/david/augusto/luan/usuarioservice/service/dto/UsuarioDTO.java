package david.augusto.luan.usuarioservice.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long id;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String chave;
    private Boolean adm;
}
