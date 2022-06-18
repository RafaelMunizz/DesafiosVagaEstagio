package teste_target;

/**
 * @author Rafael_Muniz
 */

public class Teste5_String {
    public static void main(String[] args) {
        
        // Chamadas ao método de inversão de string
        inverterString("estrada");
        inverterString("computador");
        inverterString("videogame");
        inverterString("estágio");
    }
    
    // Método que inverterá as strings
    public static String inverterString(String palavra){
        
        // Separando a palavra de entrada
        String[] palavraSeparada = palavra.split("");
        // Nova variável que será a palavra inversa
        String novaPalavra = "";
        // Tamanho da palavra de entrada
        int tamPalavra = palavraSeparada.length;
        
        // Laço que percorrerá inversamente a palavra de entrada
        // e colocará suas letras em ordem na variável novaPalavra
        for(int i = tamPalavra-1; i >= 0; i--){
            novaPalavra += palavraSeparada[i];
        }
        
        System.out.println(novaPalavra);
        return novaPalavra;
    }
}
