package david.augusto.luan.usuarioservice.web.rest;

import david.augusto.luan.usuarioservice.service.ElasticsearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/elasticsearch/reindex")
@RequiredArgsConstructor
public class ElasticsearchResource {

    private final ElasticsearchService service;

    @GetMapping
    public ResponseEntity<String> reindex() {
        this.service.reindex();
        return ResponseEntity.ok().body("Reindexando todo o elasticsearch");
    }

    @GetMapping("/{entity}")
    public ResponseEntity<String> reindex(@PathVariable("entity") String entity) {
        this.service.reindexEntity(entity);
        return ResponseEntity.ok().body("Reindexando o elasticsearch");
    }
}
