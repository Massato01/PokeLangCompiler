// === Codigo Traduzido para JAVA ===
// POKELANG -> JAVA
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);

 System.out.println ( "Valor:" ) ; int  number = input.nextInt ( ) ; for ( int  i = 0 ; i < number ; i ++ ) { System.out.println ( i ) ; if ( i == 5 ) { System.out.println ( "IF: chegou em 5" ) ; } else { if ( i == 10 ) { System.out.println ( "IF com ELSE: chegou em 10" ) ; } } }  System.out.println ( "Valor 1:" ) ; int  inputum = input.nextInt ( ) ; System.out.println ( "Valor 2:" ) ; int  inputdois = input.nextInt ( ) ; if ( inputum > inputdois ) { System.out.println ( "Maior:" ) ; System.out.println ( inputum ) ; } else { System.out.println ( "Maior:" ) ; System.out.println ( inputdois ) ; }  
}}