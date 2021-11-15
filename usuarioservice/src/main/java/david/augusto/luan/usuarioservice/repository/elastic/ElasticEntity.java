package david.augusto.luan.usuarioservice.repository.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ElasticEntity<T, I> extends ElasticsearchRepository<T, I> {

    Class<T> getEntityClass();
}
