import java.util.List;
import java.util.Arrays;

public class Testes {
    public static void main(String[] args) {
        List<String> reservadas = Arrays.asList("eevee", "espeon", "forretress", "poliwhirl", "porygon", "squirtle", "unown", "pokeball", "pokedex", "ditto");

        for (String palavra : reservadas) {
            for (char c : palavra.toCharArray()) {
                System.out.println(reservadas[c]);
            }
        }
    }
}
