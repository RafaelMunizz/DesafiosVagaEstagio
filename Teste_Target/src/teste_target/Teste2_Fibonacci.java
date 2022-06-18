package teste_target;

/**
 * @author Rafael_Muniz
 */

public class Teste2_Fibonacci {

    public static void main(String[] args) {
        
        System.out.println(pertenceFibonacci(48));
        System.out.println(pertenceFibonacci(15));
        System.out.println(pertenceFibonacci(34));
        System.out.println(pertenceFibonacci(50));
    }
    
    // Método que retorna o Fibonacci de um inteiro
    private static int fibonacci(int num){
        
        switch (num) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }
    
    // Método que analisará se o valor faz parte da 
    // sequência e retornará um booleano
    public static boolean pertenceFibonacci(int num){
        
        int i = 0;
        while(true){
            
            int var = fibonacci(i);
            
            if (var == num){
                return true;
            } else if (var > num){
                break;
            }
            i++;
        }
        return false;
    }
}
