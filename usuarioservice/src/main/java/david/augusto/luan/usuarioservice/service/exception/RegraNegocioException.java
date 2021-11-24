package david.augusto.luan.usuarioservice.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegraNegocioException extends IllegalArgumentException {

    private String msg;
    private int request;

    public RegraNegocioException(final String message, HttpStatus badRequest) {
        super(message, null);
    }

    public RegraNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RegraNegocioException(String s) {
    }
}
