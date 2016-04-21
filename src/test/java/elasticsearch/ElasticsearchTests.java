package elasticsearch;

import elasticsearch.dao.DAOFactory;
import elasticsearch.dao.ElasticsearchDAOFactory;
import elasticsearch.dao.OportunidadeDAO;
import elasticsearch.model.Oportunidade;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.client.Client;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ElasticsearchTests {

    private Client client;
    private String index;
    private String type;

    public ElasticsearchTests() {
        client = ElasticsearchDAOFactory.createConnection().createClient();
        index = "elasticsearch_tests";
        type = "test";
    }

    @Test
    public void createDeleteIndexTest() {
        CreateIndexResponse createIndexResponse = client.admin().indices().prepareCreate(index).execute().actionGet();
        assertTrue(createIndexResponse.isAcknowledged());
        DeleteIndexResponse deleteIndexResponse = client.admin().indices().prepareDelete(index).execute().actionGet();
        assertTrue(deleteIndexResponse.isAcknowledged());
    }

    @Test
    public void obterTodasOportunidadesTest() {

        System.out.println("obterTodasOportunidadesTest");

        OportunidadeDAO oportunidadeDAO = DAOFactory.getDAOFactory().getOportunidadeDAO();

        List<Oportunidade> oportunidades = oportunidadeDAO.obterTodasOportunidades();

        System.out.println("\n### OPORTUNIDADES ###\n");
        for (Oportunidade oportunidade : oportunidades) {
            System.out.println("-------------------------");
            System.out.println("ID: "+oportunidade.getId());
            System.out.println("Título: "+oportunidade.getTitulo());
            System.out.println("Organização: "+oportunidade.getOrganizacao());
            System.out.println("Cidade: "+oportunidade.getCidade());
            System.out.println("Descrição: "+oportunidade.getDescricao());
            System.out.println("-------------------------");
        }
        System.out.println("\n### Quantidade de oportunidades = " + oportunidades.size());

        assertTrue(oportunidades.size() > 0);

    }
}
