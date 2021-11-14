package david.augusto.luan.usuarioservice.repository;

import david.augusto.luan.usuarioservice.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
