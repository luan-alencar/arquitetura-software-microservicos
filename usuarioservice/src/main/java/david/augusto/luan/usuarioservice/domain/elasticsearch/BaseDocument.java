package david.augusto.luan.usuarioservice.domain.elasticsearch;

import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;

@Getter
@Setting(settingPath = "/config/elastic/config.json")
public class BaseDocument implements Serializable {
    private static final long serialVersionUID = 4971672691552824628L;

    protected static final String TRIM_CASE_INSENSITIVE = "trim_case_insensitive";
    protected static final String SORT = "sort";
    protected static final String DATE_PATTERN = "dd/MM/yyyy";

    @MultiField(mainField = @Field(type = FieldType.Long, store = true),
    otherFields = {@InnerField(suffix = SORT, type = FieldType.Long, store = true)})
    protected Long id;
}
