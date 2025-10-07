import com.google.gson.Gson;

public record Livro(String titulo, String autor, Editora editora) {
    public record Editora(String nome, int anoFundacao) {} //Classe aninhada

    public static void main(String[] args) {
        String json = """
       {
        "titulo" : "1984",
        "autor" : "George Orwell",
        "editora" : {
          "nome" : "Landmark".
          "anoFundacao" : 2022
         }
       }
       """;

        Gson gson = new Gson();

        Livro livro01 = gson.fromJson(json, Livro.class);

        System.out.println("Json convertido: " + livro01);
    }
}

