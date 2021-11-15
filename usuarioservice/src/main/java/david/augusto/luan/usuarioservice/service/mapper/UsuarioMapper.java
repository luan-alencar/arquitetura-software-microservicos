package david.augusto.luan.usuarioservice.service.mapper;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapperModel<Usuario, UsuarioDTO> {

    @Override
    Usuario toEntity(UsuarioDTO dto);

    @Override
    UsuarioDTO toDto(Usuario entity);

    @Override
    List<Usuario> toEntity(List<UsuarioDTO> dtoList);

    @Override
    List<UsuarioDTO> toDto(List<Usuario> entityList);
}
