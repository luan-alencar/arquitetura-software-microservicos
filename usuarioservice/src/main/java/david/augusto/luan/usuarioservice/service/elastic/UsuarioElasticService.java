package david.augusto.luan.usuarioservice.service.elastic;

import david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument;
import david.augusto.luan.usuarioservice.repository.UsuarioRepository;
import david.augusto.luan.usuarioservice.repository.elastic.UsuarioSearchRepository;
import david.augusto.luan.usuarioservice.service.event.UsuarioEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class
UsuarioElasticService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioSearchRepository searchRepository;

    @TransactionalEventListener(fallbackExecution = true)
    public void reindex(UsuarioEvent usuarioEvent) {
        log.debug("Iniciando indexação de Usuário a partir de: {}", usuarioEvent.getId());
        UsuarioDocument usuarioDocument = usuarioRepository.getDocument(usuarioEvent.getId());
        searchRepository.save(usuarioDocument);
    }
}
