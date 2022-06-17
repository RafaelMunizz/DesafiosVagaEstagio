
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
            
            JSONArray registrosLista = (JSONArray) parser.parse(reader);
            
            for(Object registro: registrosLista){
                JSONObject dado = (JSONObject) registro;
                
                Integer dia = Integer.parseInt(dado.get("dia").toString());
                Double valor = (Double) dado.get("valor");
                
                dados.put(dia, valor);
                
                if(valor != 0){
                    TotalFaturamento += valor;
                    diasFaturamento++;
                }
                
                if(valor > maiorFaturamento){
                    
                    dataMaiorFaturamento = dia;
                    maiorFaturamento = valor;
                }
            }   
            
            mediaFaturamento = TotalFaturamento/diasFaturamento;
            
            // Para garantir o menor valor, é importante que ele seja 
            // maior que 0 e pelo menos do tamanho do menor valor, independente
            // de qual tamanho ele tenha
            
            menorFaturamento = maiorFaturamento;
            Set keys = dados.keySet();
            for (Object key:keys){
                
                // Análise do menor valor de faturamento
                if (dados.get(key) < menorFaturamento && dados.get(key) != 0){
                    menorFaturamento = dados.get(key);
                    dataMenorFaturamento = (Integer) key;
                }
                
                if (dados.get(key) > mediaFaturamento && dados.get(key) != 0){
                    diasSuperiorMedia++;
                }
            }
        }
        
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Erro: " + e);
        } catch (IOException | ParseException e) {
            System.out.println("Erro: " + e);
        }
        
        /////////// DADOS ///////////
        
        //System.out.print("Dia de menor faturamento no mês: ");
        //System.out.println(dataMenorFaturamento);
        System.out.print("Valor do menor faturamento: ");
        System.out.println(menorFaturamento);
        //System.out.print("Dia de maior faturamento no mês: ");
        //System.out.println(dataMaiorFaturamento);
        System.out.print("Valor do maior faturamento: ");
        System.out.println(maiorFaturamento);
        //System.out.print("Total de faturamento do mês: ");
        //System.out.println(TotalFaturamento);
        //System.out.print("Quantidade de dias que houveram faturamento: ");
        //System.out.println(diasFaturamento);
        //System.out.print("Média de faturamento no mês: ");
        //System.out.println(mediaFaturamento);
        System.out.print("Quantidade de dias com média de faturamento superior a mensal: ");
        System.out.println(diasSuperiorMedia);
    
    }
}


