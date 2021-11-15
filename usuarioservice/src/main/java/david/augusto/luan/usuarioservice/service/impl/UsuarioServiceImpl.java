package david.augusto.luan.usuarioservice.service.impl;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.repository.UsuarioRepository;
import david.augusto.luan.usuarioservice.service.UsuarioService;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import david.augusto.luan.usuarioservice.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;


    @Transactional(readOnly = true)
    @Override
    public List<UsuarioDTO> listar() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public UsuarioDTO salvar(Usuario entidade) {
        return mapper.toDto(repository.save(entidade));
    }

    @Override
    public UsuarioDTO buscarPorID(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public UsuarioDTO editar(Usuario dto) {
        return this.salvar(dto);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
