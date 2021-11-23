package david.augusto.luan.usuarioservice.service.impl;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument;
import david.augusto.luan.usuarioservice.repository.UsuarioRepository;
import david.augusto.luan.usuarioservice.repository.elastic.UsuarioSearchRepository;
import david.augusto.luan.usuarioservice.service.UsuarioService;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import david.augusto.luan.usuarioservice.service.event.UsuarioEvent;
import david.augusto.luan.usuarioservice.service.exception.RegraNegocioException;
import david.augusto.luan.usuarioservice.service.filter.UsuarioFilter;
import david.augusto.luan.usuarioservice.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return this.mapper.toDto(repository.findAll());
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = repository.save(validarDadosUsuario(usuarioDTO));
        this.eventPublisher.publishEvent(new UsuarioEvent(usuario.getId()));
        return this.mapper.toDto(usuario);
    }

    private Usuario validarDadosUsuario(UsuarioDTO usuarioDTO) {

        this.repository.findUsuarioByCpf(usuarioDTO.getCpf());
        this.verificaDataNascimento(usuarioDTO);

        Usuario usuario = mapper.toEntity(usuarioDTO);
        usuario.setAdm(false);
        usuario.setChave(UUID.randomUUID().toString());
        return usuario;
    }

    private void verificaDataNascimento(UsuarioDTO usuarioDTO) {
        Optional.of(usuarioDTO.getDataNascimento().isAfter(LocalDate.now())).orElseThrow(
                () -> new RegraNegocioException("Data de nascimento inválida", HttpStatus.BAD_REQUEST));
    }

    @Override
    public UsuarioDTO buscarPorID(Long id) {
        return this.mapper.toDto(repository.findById(id).orElseThrow(
                () -> new RegraNegocioException("Usuário não encontrado", HttpStatus.BAD_REQUEST)));
    }

    @Override
    public UsuarioDTO editar(UsuarioDTO usuarioDTO) {
        return this.salvar(usuarioDTO);
    }

    @Override
    public void deletar(Long id) {
        this.buscarPorID(id);
        this.repository.deleteById(id);
        this.searchRepository.deleteById(id);
    }

    @Override
    public Page<UsuarioDocument> pesquisar(UsuarioFilter filter, Pageable pageable) {
        return this.searchRepository.search(filter.getFilter(), pageable);
    }
}