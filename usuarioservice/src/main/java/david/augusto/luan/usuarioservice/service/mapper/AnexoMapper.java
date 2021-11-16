package david.augusto.luan.usuarioservice.service.mapper;

import david.augusto.luan.usuarioservice.domain.Anexo;
import david.augusto.luan.usuarioservice.service.dto.AnexoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnexoMapper extends EntityMapperModel<Anexo, AnexoDTO> {

    @Override
    Anexo toEntity(AnexoDTO dto);

    @Override
    AnexoDTO toDto(Anexo entity);

    @Override
    List<Anexo> toEntity(List<AnexoDTO> dtoList);

    @Override
    List<AnexoDTO> toDto(List<Anexo> entityList);
}
