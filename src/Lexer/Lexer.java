package Lexer;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import Token.Token;
import AFD.AFD;
import AFD.Comment;
import AFD.ID;
import AFD.MathOperator;
import AFD.Number;
import AFD.Reservada;
import AFD.StringAFD;

public class Lexer {
  private List<Token> tokens;
  private List<AFD> afds;
  private CharacterIterator code;

  // Pula os espaços em branco
  public void skipWhiteSpace() {
    while (code.current() == ' ' || code.current() == '\n' || code.current() == '\r' || code.current() == '\t' || code.current() == CharacterIterator.DONE) {
      code.next();
    }
  }

  public Lexer(String code) {
    tokens = new ArrayList<>(); // Array para armazenar os Tokens
    this.code = new StringCharacterIterator(code);
    afds = new ArrayList<>(); // Array com todas as AFDs
    afds.add(new Comment());
    afds.add(new Reservada());
    afds.add(new MathOperator());
    afds.add(new Number());
    afds.add(new ID());
    afds.add(new StringAFD());
  }

  // Analisa cada token e armazena no array "tokens"
  public List<Token> getTokens() {
    boolean accepted;

    while (code.current() != CharacterIterator.DONE) {
      accepted = false;
      skipWhiteSpace();

      if (code.current() == CharacterIterator.DONE) // Break quando terminar de analisar a entrada
        break;

      for (AFD afd : afds) {
        int pos = code.getIndex(); // Salva o index da parte que está sendo analisada
        Token t = afd.evaluate(code);

        if (t != null) {
          accepted = true;
          tokens.add(t);
          break;
        } else {
          code.setIndex(pos); // Seta o index da parte analisada
        }
      }

      if (accepted) {
        continue;
      }
      throw new RuntimeException("Error: Token not recognized: " + code.current());
    }

    tokens.add(new Token("EOF", "$"));
    return tokens;
  }
}
