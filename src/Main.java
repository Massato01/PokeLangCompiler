import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Token.Token;
import Lexer.Lexer;
import Syntactic.Parser;

public class Main {
  public static void main(String[] args) {
    List<Token> tokens = null;

    String codigoFonte = new Main().Code();

    Lexer lexer = new Lexer(codigoFonte);
    tokens = lexer.getTokens();

    System.out.print("=== Codigo de entrada: === \n" + codigoFonte);
    // TESTE LEXICO
    System.out.println("\n\n=== Analisando Tokens... ===");
    for (Token token : tokens) {
      System.out.println(token);
    }
    System.out.println("=== Tokens Analisados ===\n");

    // TESTE SINTATICO   
    System.out.println("=== Codigo Traduzido para JAVA ===\n");
    Parser parser = new Parser(tokens);
    parser.main();
  }
  
  // LEITURA DE ARQUIVO DE ENTRADA
  public String Code() {
    try {
        String code = new String(Files.readAllBytes(Paths.get("src\\code.txt")), StandardCharsets.UTF_8);
        return code;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
  }
}