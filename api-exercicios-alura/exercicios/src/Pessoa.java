import com.google.gson.Gson;

public record Pessoa(String nome, int idade, String cidade) {

    public static void main(String[] args) {

        //JSON
        String json = """
                {
                "nome" : "Kaillanny",
                "idade" : "20",
                "cidade" : "Porto Alegre"
                }
                """;

        Gson gson = new Gson();

        Pessoa pessoa01 = gson.fromJson(json, Pessoa.class);

        System.out.println("Json convertido: " + pessoa01);
        System.out.println("Nome: " + pessoa01.nome());
    }
}
