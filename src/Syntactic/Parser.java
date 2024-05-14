import java.util.List;

public class Parser {

  List<Token> tokens;
  Token token;

  public Parser(List<Token> tokens) {
    this.tokens = tokens;
  }

  public Tree main() {
    System.out.println("public class Main {\n\tpublic static void main(String[] args) {");
    
    Node node = new Node("ifelse");
    Tree tree = new Tree(node);

    token = getNextToken();
    if(ifelse(node)){
      if (token.tipo == "EOF"){
        System.out.println("\t}\n}");
        return tree;
      }
      else{
        erro("ERRO!");
      }
    }
    erro("main");
    return null;
  }

  public Token getNextToken() {
    if (tokens.size() > 0) {
      return tokens.remove(0);
    } else
      return null;
  }

  private void erro(String node) {
    System.out.println("regra: " + node);
    System.out.println("token inválido: " + token.lexema);
    System.exit(0);
  }

  private boolean ifelse(Node node) {
    if (
      matchLexema("se","if", node) && 
      condicao(node.addChild("condicao")) && 
      matchLexema("entao","", node) && 
      expressao(node.addChild("expressao")) && 
      matchLexema("senao","else", node) && 
      expressao(node.addChild("expressao"))
      ){
      return true;
    }

    erro("ifelse");
      return false;
  }

  private boolean expressao(Node node) {
    node.enter = "{";
    if (
      var(node.addChild("var")) && 
      operadorAtribuicao(node.addChild("operadorAtribuicao")) && 
      num(node.addChild("num"))
      ){
      node.exit = "}";
      return true;
    }
    erro("expressao");
    return false;
  }

  private boolean operador(Node node) {
    if (
    matchLexema(">",">", node) || 
    matchLexema("<", "<", node) || 
    matchLexema("==", "==", node)
    ){
      return true;
    }

    erro("operador");
    return false;
  }

  private boolean condicao(Node node) {
    node.enter = "(";
    if(
      var(node.addChild("var")) && 
      operador(node.addChild("operador")) &&
      num(node.addChild("num"))
      ){
      node.exit = ")";
      return true;
    }
    erro("condicao");
    return false;
  }

  private boolean operadorAtribuicao(Node node) {
    if(matchLexema("=", token.lexema, node)){
      return true;
    }
    erro("operadorAtribuicao");
      return false;
  }

  private boolean var(Node node) {
    if (matchTipo("id", token.lexema, node)){
      return true;
    }
    erro("var");
    return false;
  }

  private boolean num(Node node) {
    if(matchTipo("num", token.lexema, node)){
      return true;
    }
    erro("num");
    return false;
  }

  private boolean matchLexema(String palavra, String newcode, Node node){
    if (token.lexema.equals(palavra)){
      node.addChild(newcode);
      token = getNextToken();
      return true;
    }
    erro(palavra);
    return false;
  }

  private boolean matchTipo(String palavra, String newcode, Node node){
    if (token.tipo.equals(palavra)){
      node.addChild(newcode);
      token = getNextToken();
      return true;
    }
    erro(palavra);
    return false;
  }
}