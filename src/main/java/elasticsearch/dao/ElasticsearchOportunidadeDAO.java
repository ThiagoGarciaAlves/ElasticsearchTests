package elasticsearch.dao;

import elasticsearch.model.Oportunidade;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class ElasticsearchOportunidadeDAO implements OportunidadeDAO {

    private Client client;
    private String index;
    private String type;

    public ElasticsearchOportunidadeDAO() {
        client = ElasticsearchDAOFactory.createConnection().createClient();
        index = "voluntarios";
        type = "oportunidade";
    }

    public void inserirOportunidade(Oportunidade oportunidade) throws IOException {

        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("titulo", oportunidade.getTitulo())
                .field("descricao", oportunidade.getDescricao())
                .field("organizacao", oportunidade.getOrganizacao())
                .field("cidade", oportunidade.getCidade())
                .endObject();

        client.prepareIndex(index, type, oportunidade.getId())
                .setSource(builder).execute()
                .actionGet();

    }

    public void alterarOportunidade(Oportunidade oportunidade) throws Exception {

        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("titulo", oportunidade.getTitulo())
                .field("descricao", oportunidade.getDescricao())
                .field("organizacao", oportunidade.getOrganizacao())
                .field("cidade", oportunidade.getCidade())
                .endObject();

        client.prepareUpdate(index, type, oportunidade.getId())
                .setSource(builder).execute()
                .actionGet();

    }

    public void excluirOportunidade(Oportunidade oportunidade) {

        client.prepareDelete(index, type, oportunidade.getId());

    }

    public List<Oportunidade> obterTodasOportunidades() {

        List<Oportunidade> oportunidades = new ArrayList<Oportunidade>();

        SearchResponse response = client
                .prepareSearch(index)
                .setTypes(type)
                .setQuery(QueryBuilders.matchAllQuery())
                .execute()
                .actionGet();

        for (SearchHit hit : response.getHits().getHits()) {

            Oportunidade oportunidade = new Oportunidade();
            oportunidade.setId( hit.getId() );
            oportunidade.setTitulo( (String) hit.getSource().get("titulo") );
            oportunidade.setOrganizacao( (String) hit.getSource().get("organizacao") );
            oportunidade.setCidade( (String) hit.getSource().get("cidade") );
            oportunidade.setDescricao( (String) hit.getSource().get("descricao") );

            oportunidades.add(oportunidade);

        }

        return oportunidades;

    }
}
