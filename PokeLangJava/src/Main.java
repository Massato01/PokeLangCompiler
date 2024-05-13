import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import Token.Token;
import Lexer.Lexer;
// import Sintatico.Parser;

public class Main {
  public static void main(String[] args) throws IOException {
    List<Token> tokens = null;

    // String codigoFonte = new Main().Arquivo();
    String codigoFonte = "porygon x = 1;";

    Lexer lexer = new Lexer(codigoFonte);
    tokens = lexer.getTokens();

    // System.out.print(tokens);

    for (Token token : tokens) {
      System.out.println(token);
    }

    // Parser parser = new Parser(tokens);
    // parser.main();
  }

  public String Arquivo() throws IOException {
    String data = new String(
        Files.readAllBytes(Paths.get("PokeLangJava\\src\\validacao.txt")), StandardCharsets.UTF_8);
    return data;
  }
}