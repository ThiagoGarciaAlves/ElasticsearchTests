package elasticsearch;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

public class RetrieveAll extends Abstract {
    private Client client;

    public RetrieveAll() {
        Connection connection = new Connection();
        client = connection.createClient();
    }

    public void retrieveAll() {

        SearchResponse response = client
                .prepareSearch(index)
                .setQuery(QueryBuilders.matchAllQuery())
                .execute()
                .actionGet();

        for (SearchHit hit : response.getHits().getHits()) {
            System.out.println("------------------------------");
            System.out.println("Id: " + hit.getId());
            System.out.println("Título: " + hit.getSource().get("titulo"));
            System.out.println("Cidade: " + hit.getSource().get("cidade"));
            System.out.println("Descrição: " + hit.getSource().get("descricao"));
            System.out.println("Organização: " + hit.getSource().get("organizacao"));
            System.out.println("------------------------------");
        }
    }
}
