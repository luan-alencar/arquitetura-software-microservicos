package david.augusto.luan.usuarioservice.service.elastic;

import david.augusto.luan.usuarioservice.repository.elastic.ElasticEntity;
import david.augusto.luan.usuarioservice.repository.elastic.Reindexer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElasticsearchService {

    @Value("${nuvem.elastisearch.reindex.pageSize:10000}")
    private Integer pageSize;

    private final List<Reindexer> reindexadores;
    private final List<ElasticEntity> repositories;
    private final ElasticsearchRestTemplate elasticsearchTemplate;

    @Transactional(readOnly = true)
    @Async
    public void reindex() {
        log.info("Starting reindex.");
        for (Reindexer reindexer : reindexadores) {
            reindex(reindexer);
        }
    }

    @Transactional(readOnly = true)
    @Async
    public void reindexEntity(String entity) {
        log.info("Starting reindex entity: {}", entity);
        for (Reindexer reindexer : reindexadores) {
            if(reindexer.getEntity().equals(entity)) {
                reindex(reindexer);
            }
        }
    }

    private void reindex(Reindexer bean) {
        Pageable pageable = PageRequest.of(0, pageSize);
        Page<?> page = bean.reindexPage(pageable);
        log.info("Objects found {}.", page.getTotalElements());
        if (!page.hasContent()) {
            return;
        }
        log.info("Total Pages {}.", page.getTotalPages());
        ElasticEntity searchRepository = getSearchRepository(page);
        recreateIndexDocument(searchRepository.getEntityClass());

        while (page.hasContent()) {
            log.info("Page Number {}.", page.getNumber());
            searchRepository.saveAll(page);
            page = bean.reindexPage(page.getPageable().next());
        }

        log.info("Finish reindex of {}.", bean.getEntity());
    }

    private ElasticEntity getSearchRepository(Page<?> page) {
        Class documentClass = page.getContent().get(0).getClass();
        Iterator<ElasticEntity> var3 = this.repositories.iterator();

        ElasticEntity searchRepository;
        do {
            if (!var3.hasNext()) {
                throw new RuntimeException("Falha de Reindexação...");
            }

            searchRepository = var3.next();
        } while(!searchRepository.getEntityClass().equals(documentClass));

        return searchRepository;
    }

    private <T> void recreateIndexDocument(Class<T> entityClass) {
        log.info("Recreate index class: {}", entityClass.getName());
        elasticsearchTemplate.deleteIndex(entityClass);
        elasticsearchTemplate.createIndex(entityClass);
        elasticsearchTemplate.putMapping(entityClass);
    }

}