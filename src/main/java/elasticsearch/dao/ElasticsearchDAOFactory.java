package elasticsearch.dao;

public class ElasticsearchDAOFactory extends DAOFactory {

    public static Connection createConnection() {
        return new Connection();
    }

    @Override
    public OportunidadeDAO getOportunidadeDAO() {
        return new ElasticsearchOportunidadeDAO();
    }
}
