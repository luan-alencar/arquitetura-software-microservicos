package david.augusto.luan.usuarioservice.service.filter;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DefaultFilter implements Serializable {

    protected String querry;
    protected String status;
}
