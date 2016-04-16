package elasticsearch.model;

public class Oportunidade {

    private String id;
    private String titulo;
    private String organizacao;
    private String cidade;
    private String descricao;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getOrganizacao() {
        return organizacao;
    }
    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
