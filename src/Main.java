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
import Lexer.Lexer;f
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

  // public static void criarArquivo(String nomeArquivo, String conteudo) {
  //   // Usando BufferedWriter para escrever no arquivo
  //   try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
  //       escritor.write(conteudo);
  //       System.out.println("Arquivo criado e conteúdo escrito com sucesso!");
  //   } catch (IOException e) {
  //       System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
  //   }
  // }
}