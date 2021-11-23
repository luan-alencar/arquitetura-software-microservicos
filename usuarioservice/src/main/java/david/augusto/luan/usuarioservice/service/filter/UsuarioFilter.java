package david.augusto.luan.usuarioservice.service.filter;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioFilter extends DefaultFilter implements BaseFilter, Serializable {
    private static final long serialVersionUID = -6013192769896824142L;

    @Override
    public BoolQueryBuilder getFilter() {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        List<String> campos = new ArrayList<>();

        filterFields(campos, querry, queryBuilder, "email", "cpf", "chave");
        addShouldTermQuery(queryBuilder,"dataNascimento", querry);

        return queryBuilder;
    }
}