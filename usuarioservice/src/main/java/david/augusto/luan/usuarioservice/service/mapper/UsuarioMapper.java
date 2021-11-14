package david.augusto.luan.usuarioservice.service.mapper;

import david.augusto.luan.usuarioservice.domain.Usuario;
import david.augusto.luan.usuarioservice.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper extends EntityMapperModel<Usuario, UsuarioDTO> {
}
