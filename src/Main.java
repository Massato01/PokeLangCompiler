import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import Token.Token;
import Lexer.Lexer;
import Syntactic.GLC.Parser;

public class Main {
  public static void main(String[] args) {
    List<Token> tokens = null;

    String codigoFonte = new Main().Code();

    Lexer lexer = new Lexer(codigoFonte);
    tokens = lexer.getTokens();

    // PRINTA OS TOKENS
    for (Token token : tokens) {
      System.out.println(token);
    }
    // TESTE PARSER   
    Parser parser = new Parser(tokens);
    parser.main();
  }

  public String Code() {
    try {
        String code = new String(Files.readAllBytes(Paths.get("src\\code3.txt")), StandardCharsets.UTF_8);
        return code;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
  }
}