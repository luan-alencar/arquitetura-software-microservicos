package david.augusto.luan.usuarioservice.service.mapper;

import java.util.List;

public interface EntityMapperModel<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
