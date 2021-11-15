package david.augusto.luan.usuarioservice.service;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import david.augusto.luan.usuarioservice.service.filter.UsuarioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UsuarioService {

    @Transactional(readOnly = true)
    List<UsuarioDTO> listar();

    UsuarioDTO salvar(UsuarioDTO usuarioDTO);

    UsuarioDTO buscarPorID(Long id);

    UsuarioDTO editar(UsuarioDTO usuarioDTO);

    void deletar(Long id);

    Page<UsuarioDocument> pesquisar(UsuarioFilter filter, Pageable pageable);
}
