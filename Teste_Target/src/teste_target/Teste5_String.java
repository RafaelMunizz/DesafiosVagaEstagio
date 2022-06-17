package teste_target;

/**
 * @author Rafael_Muniz
 */

public class Teste5_String {
    public static void main(String[] args) {
        
        inverterString("estrada");
        inverterString("computador");
        inverterString("videogame");
        inverterString("estágio");
    }
    
    public static String inverterString(String palavra){
        
        String[] palavraSeparada = palavra.split("");
        String novaPalavra = "";
        int tamPalavra = palavraSeparada.length;
        
        for(int i = tamPalavra-1; i >= 0; i--){
            novaPalavra += palavraSeparada[i];
        }
        
        System.out.println(novaPalavra);
        return novaPalavra;
    }
}
