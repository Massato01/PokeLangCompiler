import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import Token.Token;
import Lexer.Lexer;
import Syntactic.Parser;

public class Main {
    public static void main(String[] args) {
        List<Token> tokens = null;
        String path = "src\\code.txt";
        String codigoFonte = new Main().Code(path);

        Lexer lexer = new Lexer(codigoFonte);
        tokens = lexer.getTokens();

        System.out.print("=== Codigo de entrada: === \n" + codigoFonte);
        
        // LEXICO
        System.out.println("\n\n=== Analisando Tokens... ===");
        for (Token token : tokens) {
            System.out.println(token);
        }
        System.out.println("=== Tokens Analisados ===\n");

        System.out.println("=== Gerando codigo traduzido para JAVA... ===\n");

        // Cria o diretório "Validacao" se não existir
        File dir = new File("Validacao");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Define o arquivo para onde a saída do parser será redirecionada
        File file = new File("Validacao/Main.java");

        try {
            // Cria um PrintStream que irá escrever no arquivo
            PrintStream printStream = new PrintStream(file);
            
            // Redireciona a saída padrão (System.out) para o arquivo Validacao/Main.java
            System.setOut(printStream);

            // SINTATICO
            System.out.println("// === Codigo Traduzido para JAVA ===");
            Parser parser = new Parser(tokens);
            parser.main();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // LEITURA DE ARQUIVO DE ENTRADA
    public String Code(String path) {
        try {
            String code = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
            return code;
        } catch (IOException e) {
            System.out.print("!!File not found!!\n");
            return null;
        }
    }
}