package elasticsearch;

import elasticsearch.dao.Connection;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class InsertUpdateOportunidade extends Abstract {

    public InsertUpdateOportunidade() {
        Connection connection = new Connection();
        client = connection.createClient();
    }

    public void create(String id, String titulo, String organizacao, String cidade, String descricao) throws IOException {

        XContentBuilder builder = jsonBuilder()
            .startObject()
                .field("titulo", titulo)
                .field("descricao", descricao)
                .field("organizacao", organizacao)
                .field("cidade", cidade)
            .endObject();

        client.prepareIndex(index, type, id)
            .setSource(builder).execute()
            .actionGet();

    }

    public void update(String id, String titulo, String organizacao, String cidade, String descricao) throws Exception {

        XContentBuilder builder = jsonBuilder()
            .startObject()
                .field("titulo", titulo)
                .field("descricao", descricao)
                .field("organizacao",organizacao)
                .field("cidade",cidade)
            .endObject();

        client.prepareUpdate(index, type, id)
            .setSource(builder).execute()
            .actionGet();

    }

    public void delete(String id) {
        client.prepareDelete(index, type, id);
    }

}
