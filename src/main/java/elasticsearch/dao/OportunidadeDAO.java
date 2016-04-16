package elasticsearch.dao;

import elasticsearch.model.Oportunidade;
import java.util.List;

public interface OportunidadeDAO {

    public void inserirOportunidade(Oportunidade oportunidade);
    public void alterarOportunidade(Oportunidade oportunidade);
    public void excluirOportunidade(Oportunidade oportunidade);
    public List<Oportunidade> obterTodasOportunidades();

}
