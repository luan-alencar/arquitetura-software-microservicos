package david.augusto.luan.usuarioservice.service;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UsuarioService {

    @Transactional(readOnly = true)
    List<UsuarioDTO> listar();

    UsuarioDTO salvar(Usuario entidade);

    UsuarioDTO buscarPorID(Long id);

    UsuarioDTO editar(Usuario dto);

    void deletar(Long id);
}
