package Lexico;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
  private List<Token> tokens;
  private List<AFD> afds;
  private CharacterIterator code;
  private int lineError, coluna;

  public Lexer(String code) {
    tokens = new ArrayList<>();
    this.code = new StringCharacterIterator(code);
    this.lineError = 1;
    this.coluna = 0;
    afds = new ArrayList<>();
    afds.add(new Comment());
    afds.add(new Reservada());
    afds.add(new MathOperator());
    afds.add(new Number());
    afds.add(new ID());
    afds.add(new StringText());
  }

  // Metodo para pular espaco em branco
  public void skipWhiteSpace() {
    while (code.current() == ' ' || code.current() == '\n' || code.current() == '\r' || code.current() == '\t'
        || code.current() == CharacterIterator.DONE || (code.current() == '\r' && code.current() == '\n')) {
      if (code.current() == '\n' || (code.current() == '\r' && code.current() == '\n')) {
        this.lineError++;
        this.coluna = code.getIndex();
      }
      code.next();
    }
  }

  public List<Token> getTokens() {
    boolean accepted;

    while (code.current() != CharacterIterator.DONE) {
      this.coluna++;
      accepted = false;
      skipWhiteSpace();

      if (code.current() == CharacterIterator.DONE)
        break;

      for (AFD afd : afds) {
        int pos = code.getIndex();
        Token t = afd.evaluate(code, lineError, (Math.abs(code.getIndex() - this.coluna)));

        if (t != null) {
          accepted = true;
          tokens.add(t);
          break;
        } else {
          code.setIndex(pos);
        }
      }

      if (accepted)
        continue;

      throw new RuntimeException("Error: Token not recognized: " + code.current() + " at line: " + lineError
          + " column: " + (Math.abs(code.getIndex() - this.coluna)));
    }

    tokens.add(new Token("EOF", "$", lineError, (Math.abs(code.getIndex() - this.coluna))));
    return tokens;
  }
}