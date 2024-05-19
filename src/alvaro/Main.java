public class Main {
  public static void main(String[] args) {
    int b = 1;
    int c = 1;
    int d = 3;
    String texto = "É pra ser uma string";
    int soma = (b + c) * d;
    System.out.println(soma);
    System.out.println(3);
    System.out.println("Funcionou com string");
    System.out.println(texto);
    double x = 1.1;
    int y = 5;
    double z = 2.2;
    int p = 10;
    double result = x * y + z;
    if (result > 2) {
      System.out.println(result);
    } else {
      if (result <= 2) {
        System.out.println(result);
      }
    }
    if (result == 2) {
      System.out.println("Entrou no nosso comando if");
    }
    
    for (int i = 0; i < 5; i++) {
      System.out.println("Deu bom");
    }
  }
}