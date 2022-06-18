
package teste_target;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Rafael_Muniz
 */

public class Teste3_Distribuidora {
    public static void main(String[] args) {
        
        JSONParser parser = new JSONParser();
        
        HashMap<Integer, Double> dados = new HashMap<>();
        Double menorFaturamento = 0.0;
        Integer dataMenorFaturamento = 0;
        Double maiorFaturamento = 0.0;
        Integer dataMaiorFaturamento = 0;
        
        Double TotalFaturamento = 0.0;
        Integer diasFaturamento = 0;
        Double mediaFaturamento = 0.0;
        Integer diasSuperiorMedia = 0;
        
        // Caminho para o arquivo JSON
        String url = "C:\\Users\\...\\dados.json";
        
        try (FileReader reader = new FileReader(url)){
            
            // Registros do JSON
            JSONArray registrosLista = (JSONArray) parser.parse(reader);
            
            // Percorrendo os registros do JSON
            for(Object registro: registrosLista){
                JSONObject dado = (JSONObject) registro;
                
                // Armazenando os dois valores de cada registro
                Integer dia = Integer.parseInt(dado.get("dia").toString());
                Double valor = (Double) dado.get("valor");
                
                //Criando HashMap com os dados
                dados.put(dia, valor);
                
                // Ignorando os dias sem faturamentos e registrando o total de 
                // dias e capital.
                if(valor != 0){
                    TotalFaturamento += valor;
                    diasFaturamento++;
                }
                
                // Pegando maior valor e o dia ocorrido
                if(valor > maiorFaturamento){
                    
                    dataMaiorFaturamento = dia;
                    maiorFaturamento = valor;
                }
            }   
            
            // Média do faturamento mensal
            mediaFaturamento = TotalFaturamento/diasFaturamento;
            
            // Para garantir o menor valor, é importante que ele seja 
            // maior que 0 e pelo menos do tamanho do menor valor, independente
            // de qual tamanho ele tenha
            
            menorFaturamento = maiorFaturamento;
            Set keys = dados.keySet(); // Set com todas as keys
            for (Object key:keys){
                
                // Análise do menor valor de faturamento e sua data
                if (dados.get(key) < menorFaturamento && dados.get(key) != 0){
                    menorFaturamento = dados.get(key);
                    dataMenorFaturamento = (Integer) key;
                }
                
                // Pegando quantidade de dais em que o faturamento foi maior que 
                // a média mensal
                if (dados.get(key) > mediaFaturamento && dados.get(key) != 0){
                    diasSuperiorMedia++;
                }
            }
        }
        
        // Tratamentos paraS possíveis erros
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Erro: " + e);
        } catch (IOException | ParseException e) {
            System.out.println("Erro: " + e);
        }
        
        /////////// DADOS ///////////
        
        //System.out.printf("Dia de menor faturamento no mês: %d", dataMenorFaturamento);
        System.out.printf("Valor do menor faturamento: %f\n", menorFaturamento);
        //System.out.printf("Dia de maior faturamento no mês: %d\n", dataMaiorFaturamento);
        System.out.printf("Valor do maior faturamento: %f\n", maiorFaturamento);
        //System.out.printf("Total de faturamento do mês: %f\n", TotalFaturamento);
        //System.out.printf("Quantidade de dias que houveram faturamento: %d\n", diasFaturamento);
        //System.out.printf("Média de faturamento no mês: %f\n", mediaFaturamento);
        System.out.printf("Quantidade de dias com média de faturamento superior a mensal: %d\n", diasSuperiorMedia);
    
    }
}


