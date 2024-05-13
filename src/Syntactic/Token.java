public class Token {

  public String tipo;
  public String lexema;

  public Token(String lexema, String tipo) {
    this.lexema = lexema;
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return "<" + this.lexema + ", " + this.tipo + ">";
  }
}
