package teste_target;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Rafael_Muniz
 */

public class Teste4_Estados {
    
    public static void main(String[] args) {
        
        HashMap<String, Double> faturamentoEstados = new HashMap<>();
        
        faturamentoEstados.put("SP", 67836.43);
        faturamentoEstados.put("RJ", 36678.66);
        faturamentoEstados.put("MG", 29229.88);
        faturamentoEstados.put("ES", 27165.48);
        faturamentoEstados.put("Outros", 19849.53);
        
        Set estados = faturamentoEstados.keySet();
        Double totalFaturamento = 0.0;
        
        for(Object sigla:estados){
            totalFaturamento += faturamentoEstados.get(sigla);
        }
        
        for(Object sigla:estados){
            System.out.printf("Representação de %s: %.2f%c\n", sigla, (faturamentoEstados.get(sigla)/totalFaturamento)*100, '%');
        }
    }
}
