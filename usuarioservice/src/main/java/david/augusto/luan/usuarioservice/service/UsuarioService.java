package david.augusto.luan.usuarioservice.service;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService<E, D> {

    List<D> listar();

    UsuarioDTO salvar(Usuario entidade);

    UsuarioDTO buscarPorID(Long id);

    UsuarioDTO editar(Usuario dto);

    void deletar(Usuario dto);
}
