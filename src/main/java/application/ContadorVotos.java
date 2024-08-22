package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContadorVotos {
    public static void main(String[]args){
        Scanner resp = new Scanner(System.in);

        System.out.print("Digite o endereço do arquivo: ");
        String path = resp.nextLine();
        Map<String, Integer> candidatos = new HashMap<>();

        try(BufferedReader leitor = new BufferedReader(new FileReader(path))){
            String line = leitor.readLine();
            while(line != null){
                String[] texto = line.split(",");
                String nome = texto[0];
                Integer votos = Integer.parseInt(texto[1]);
                if(candidatos.containsKey(nome)){
                    Integer votosMudar = candidatos.get(nome) + votos;
                    candidatos.put(nome, votosMudar);
                }else{
                    candidatos.put(nome, votos);
                }
                line = leitor.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(String c : candidatos.keySet()){
            System.out.println(c + ": " + candidatos.get(c));
        }
    }
}
