package projeto;

import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import Lexico.Token;
import Lexico.Lexer;
import Sintatico.Parser;

public class Main {
  public static void main(String[] args) throws IOException {
    List<Token> tokens = null;

    String codigoFonte = new Main().Arquivo();

    Lexer lexer = new Lexer(codigoFonte);
    tokens = lexer.getTokens();

    for (Token token : tokens) {
    System.out.println(token);
    }
    
    Parser parser = new Parser(tokens);
    parser.main();
  }

  public String Arquivo() throws IOException {
    String data = new String(
        Files.readAllBytes(Paths
            .get("C:\\Users\\carlos.chinen_beyoun\\OneDrive\\Main\\FEI\\6_semestre\\Compiladores\\PokeLang\\src\\alvaro\\projeto\\teste.me")),
        StandardCharsets.UTF_8);
    return data;
  }
}
