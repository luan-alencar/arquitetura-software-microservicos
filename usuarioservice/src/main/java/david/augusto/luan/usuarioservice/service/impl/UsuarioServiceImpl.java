package david.augusto.luan.usuarioservice.service.impl;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.repository.UsuarioRepository;
import david.augusto.luan.usuarioservice.service.UsuarioService;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import david.augusto.luan.usuarioservice.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService<Usuario, UsuarioDTO> {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;


    @Override
    public List<UsuarioDTO> listar() {
        return null;
    }

    @Override
    public UsuarioDTO salvar(Usuario entidade) {
        return null;
    }

    @Override
    public UsuarioDTO buscarPorID(Long id) {
        return null;
    }

    @Override
    public UsuarioDTO editar(Usuario dto) {
        return null;
    }

    @Override
    public void deletar(Usuario dto) {

    }
}
