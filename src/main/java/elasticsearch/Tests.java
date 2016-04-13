package elasticsearch;

public class Tests {

    public static void main(String... args) throws Exception {

        new RetrieveAll().retrieveAll();

        InsertUpdateOportunidade insertUpdateOportunidade = new InsertUpdateOportunidade();
        insertUpdateOportunidade.create("1", "Oportunidade", "Organização", "Cidade", "Descrição");

    }
}
