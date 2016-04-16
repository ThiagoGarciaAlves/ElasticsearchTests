package elasticsearch.dao;

import elasticsearch.model.Oportunidade;

import java.io.IOException;
import java.util.List;

public interface OportunidadeDAO {

    public void inserirOportunidade(Oportunidade oportunidade) throws IOException;
    public void alterarOportunidade(Oportunidade oportunidade) throws Exception;
    public void excluirOportunidade(Oportunidade oportunidade);
    public List<Oportunidade> obterTodasOportunidades();

}
