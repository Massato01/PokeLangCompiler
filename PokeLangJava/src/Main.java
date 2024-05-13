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
    String codigoFonte = "porygon x = 1;\nporygon y = 32;\neevee(x > 2) {\nx = 1;\n} espeon {\nx = 2;\n} # comentario";
    /*
      porygon x = 1;
      porygon y = 32;
      eevee (x > 2) {
        x = 1;
      } espeon {
        x = 2;
      }
     */


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