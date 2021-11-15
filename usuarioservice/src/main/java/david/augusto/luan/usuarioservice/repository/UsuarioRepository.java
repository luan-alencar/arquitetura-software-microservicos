package david.augusto.luan.usuarioservice.repository;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument;
import david.augusto.luan.usuarioservice.repository.elastic.Reindexer;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, Reindexer {

    @Query("SELECT NEW david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument(" +
            " u.id, u.nome, u.cpf, u.email, u.telefone, u.dataNascimento, u.chave, u.adm) " +
            " FROM Usuario u WHERE u.id = :id")
    UsuarioDocument getDocument(@Param("id") Long id);

    @Query("SELECT NEW david.augusto.luan.usuarioservice.domain.elasticsearch.UsuarioDocument(" +
            " u.id, u.nome, u.cpf, u.email, u.telefone, u.dataNascimento, u.chave, u.adm) " +
            " FROM Usuario u ORDER BY u.id")
    Page<UsuarioDocument> reindexPage(Pageable pageable);

    @Override
    default String getEntity() {
        return "usuario";
    }
}
