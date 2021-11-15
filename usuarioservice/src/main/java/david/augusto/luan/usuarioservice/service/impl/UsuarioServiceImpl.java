package david.augusto.luan.usuarioservice.service.impl;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument;
import david.augusto.luan.usuarioservice.repository.UsuarioRepository;
import david.augusto.luan.usuarioservice.repository.elastic.UsuarioSearchRepository;
import david.augusto.luan.usuarioservice.service.UsuarioService;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import david.augusto.luan.usuarioservice.service.event.UsuarioEvent;
import david.augusto.luan.usuarioservice.service.filter.UsuarioFilter;
import david.augusto.luan.usuarioservice.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper mapper;
    private final UsuarioRepository repository;
    private final UsuarioSearchRepository searchRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional(readOnly = true)
    @Override
    public List<UsuarioDTO> listar() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        if(usuarioDTO.getDataNascimento().isAfter(LocalDate.now())) {
            throw new RuntimeException("Data de nascimento é futura");
        }
        Usuario usuario = repository.save(mapper.toEntity(usuarioDTO));
        eventPublisher.publishEvent(new UsuarioEvent(usuario.getId()));
        return mapper.toDto(usuario);
    }

    @Override
    public UsuarioDTO buscarPorID(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public UsuarioDTO editar(UsuarioDTO usuarioDTO) {
        return this.salvar(usuarioDTO);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
        searchRepository.deleteById(id);
    }

    @Override
    public Page<UsuarioDocument> pesquisar(UsuarioFilter filter, Pageable pageable) {
        return searchRepository.search(filter.getFilter(), pageable);
    }
}