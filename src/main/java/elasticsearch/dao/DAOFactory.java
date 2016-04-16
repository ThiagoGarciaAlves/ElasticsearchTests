package elasticsearch.dao;

public abstract class DAOFactory {

    public static final int ELASTICSEARCH = 1;

    public abstract OportunidadeDAO getOportunidadeDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case ELASTICSEARCH :
                return new ElasticsearchDAOFactory();
            default :
                return null;
        }
    }

    public static DAOFactory getDAOFactory() {
        return getDAOFactory(ELASTICSEARCH);
    }

}
