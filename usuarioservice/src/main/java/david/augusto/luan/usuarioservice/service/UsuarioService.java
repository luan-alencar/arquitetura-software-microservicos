package david.augusto.luan.usuarioservice.service;

import java.util.List;

public interface UsuarioService<E, D> extends GenericEntityService{

    @Override
    List listar();

    @Override
    Object salvar(Object entidade);

    @Override
    Object buscarPorID(Long id);

    @Override
    Object editar(Object dto);

    @Override
    void deletar(Object dto);
}
