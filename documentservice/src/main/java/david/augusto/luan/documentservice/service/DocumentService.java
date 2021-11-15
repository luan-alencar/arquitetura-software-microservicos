package david.augusto.luan.documentservice.service;


import david.augusto.luan.documentservice.config.ApplicationProperties;
import david.augusto.luan.documentservice.service.dto.DocumentDTO;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final MinioClient minioClient;
    private final ApplicationProperties applicationProperties;

    @SneakyThrows
    public String save(DocumentDTO documentDTO){
        minioClient.putObject(PutObjectArgs.builder()
                .stream(new ByteArrayInputStream(documentDTO.getFile().getBytes()), documentDTO.getFile().getBytes().length,0)
                .contentType(StandardCharsets.UTF_8.toString())
                .bucket(applicationProperties.getBucket())
                .object(documentDTO.getUuid())
                .build());
        return documentDTO.getUuid();
    }

    @SneakyThrows
    public DocumentDTO getDocument(String uuid){
        GetObjectResponse file = minioClient.getObject(GetObjectArgs.builder()
                .bucket(applicationProperties.getBucket())
                .object(uuid)
                .build());
        return new DocumentDTO(uuid, IOUtils.toString(file, StandardCharsets.UTF_8.toString()));
    }

    @SneakyThrows
    public void deletar(String uuid){
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(applicationProperties.getBucket())
                .object(uuid)
                .build());
    }
}

