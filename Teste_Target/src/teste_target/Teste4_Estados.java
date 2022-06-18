package teste_target;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Rafael_Muniz
 */

public class Teste4_Estados {
    
    public static void main(String[] args) {
        
        HashMap<String, Double> faturamentoEstados = new HashMap<>();
        
        // Armazenando dados de siglas e o faturamento do estado
        faturamentoEstados.put("SP", 67836.43);
        faturamentoEstados.put("RJ", 36678.66);
        faturamentoEstados.put("MG", 29229.88);
        faturamentoEstados.put("ES", 27165.48);
        faturamentoEstados.put("Outros", 19849.53);
        
        // Set de keys com as siglas dos estados
        Set estados = faturamentoEstados.keySet();
        Double totalFaturamento = 0.0;
        
        // Laço para soma total do faturamento
        for(Object sigla:estados){
            totalFaturamento += faturamentoEstados.get(sigla);
        }
        
        // Laço que imprimirá a representação em porcentagem de cada estado
        for(Object sigla:estados){
            System.out.printf("Representação de %s: %.2f%c\n", sigla, (faturamentoEstados.get(sigla)/totalFaturamento)*100, '%');
        }
    }
}
