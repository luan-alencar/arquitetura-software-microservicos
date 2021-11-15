package david.augusto.luan.usuarioservice.repository.elastic;

import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Reindexer {

    <T>Page<T> reindexPage(Pageable pageable);

    @SneakyThrows
    default String getEntity() {
        throw new IllegalAccessException("Método não implementado");
    }
}
