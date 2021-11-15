package david.augusto.luan.documentservice.web.rest;

import david.augusto.luan.documentservice.service.DocumentService;
import david.augusto.luan.documentservice.service.dto.DocumentDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentResource {

    private final DocumentService service;

    @GetMapping("/{uuid}")
    public ResponseEntity<DocumentDTO> buscar(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(service.getDocument(uuid));
    }

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody DocumentDTO documentDTO) {
        return ResponseEntity.ok(service.save(documentDTO));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletar(@PathVariable("uuid") String uuid) {
        service.deletar(uuid);
        return ResponseEntity.ok().build();
    }
}
