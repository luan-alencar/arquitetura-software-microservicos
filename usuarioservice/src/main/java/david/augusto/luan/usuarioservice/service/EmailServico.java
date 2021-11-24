package david.augusto.luan.usuarioservice.service;

import david.augusto.luan.usuarioservice.service.dto.EmailDTO;
import david.augusto.luan.usuarioservice.service.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class EmailServico {

    private final JavaMailSender javaMailSender;

    public void enviarEmail(EmailDTO emailDTO) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = getMimeMessageHelper(emailDTO, mimeMessage);
            for (String s : emailDTO.getCopias()) {
                message.addCc(s);
            }
            message.setText(emailDTO.getCorpo(), true);
            javaMailSender.send(mimeMessage);

        } catch (UnsupportedEncodingException | javax.mail.MessagingException e) {
            throw new RegraNegocioException("error.title");
        }
    }

    private MimeMessageHelper getMimeMessageHelper(EmailDTO emailDTO, MimeMessage mimeMessage) throws MessagingException, UnsupportedEncodingException {
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        message.setTo(emailDTO.getDestinatario());
        message.setFrom("sgegestaoeventos@gmail.com", "SGE");
        message.setSubject(emailDTO.getAssunto());
        return message;
    }
}
