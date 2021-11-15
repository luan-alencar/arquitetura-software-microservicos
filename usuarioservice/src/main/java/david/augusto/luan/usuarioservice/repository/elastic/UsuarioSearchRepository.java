package david.augusto.luan.usuarioservice.repository.elastic;

import david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument;

public interface UsuarioSearchRepository extends ElasticEntity<UsuarioDocument, Long> {

    @Override
    default Class<UsuarioDocument> getEntityClass() {
        return UsuarioDocument.class;
    }
}
