package david.augusto.luan.usuarioservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenericEntityService<E, D> {

    List<D> listar();

    D salvar(E entidade);

    D buscarPorID(Long id);

    E editar(D dto);

    void deletar(D dto);

}
