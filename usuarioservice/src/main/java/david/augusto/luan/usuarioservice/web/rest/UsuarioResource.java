package david.augusto.luan.usuarioservice.web.rest;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument;
import david.augusto.luan.usuarioservice.service.UsuarioService;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import david.augusto.luan.usuarioservice.service.filter.UsuarioFilter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuarios")
@Slf4j
public class UsuarioResource {

    private final Logger log = LoggerFactory.getLogger(UsuarioResource.class);
    private final UsuarioService service;

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        log.debug("Requisição REST para listar Usuarios");
        List<UsuarioDTO> listaUsuariosDTO = service.listar();
        return new ResponseEntity<>(listaUsuariosDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar (@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(service.salvar(usuarioDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorID(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorID(id));
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(service.editar(usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/pesquisar")
    public ResponseEntity<Page<UsuarioDocument>> pesquisar(@RequestBody UsuarioFilter filter, Pageable pageable) {
        return ResponseEntity.ok(service.pesquisar(filter, pageable));
    }
}
