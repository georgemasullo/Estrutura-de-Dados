/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Tatiane
 */
public class Parser {
    int[][] matriz = null;

    public Parser(File selectedFile) {
        String linha = null;
        String[] temp = null;
        Grafo grafo;
        try {
            // instancia do arquivo que vou ler  
            FileReader reader = new FileReader(selectedFile);
            BufferedReader leitor = new BufferedReader(reader);
            int i = 0;
            int j = 0;
            // loop que percorrerá todas as  linhas do arquivo.txt que eu quero ler  
            while ((linha = leitor.readLine()) != null) {

                //No metodo StringTokenizer passo os parametros que quero ler, em seguida o que eu quero descartar no meu caso ( - ) e ( ; ).   
                StringTokenizer st = new StringTokenizer(linha, "{}");
                int tamanho = st.countTokens();
                // Aqui determino que enquanto existir tokens que ele faça a leitura  
                String dados = st.nextToken();
                System.out.print(dados);
                temp = dados.split("\\,");
                grafo = new Grafo(temp.length);
                if (matriz == null){
                    matriz = new int[temp.length][temp.length];
                }
                for (j = 0; j < temp.length; j++) {
                    matriz[i][j] = Integer.parseInt(temp[j]);
                    grafo.insereAresta(i, j, Integer.parseInt(temp[j]));
                }
                j = 0;
                i++;
                System.out.println("");
            }
            leitor.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Grafo ParserBFSDFS() {
        Grafo grafo = new Grafo(matriz.length);
        int i;
        int j;
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != 0) {
                    grafo.insereAresta(i, j, matriz[i][j]);
                }
            }
            j = 0;
        }
        System.out.println("");
        return grafo;
    }

    public void ParserDijkstra(Grafo grafo) throws FileNotFoundException, IOException {

        int i;
        int j;
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != 0) {
                    grafo.insereAresta(i + 1, j + 1, matriz[i][j]);
                }
            }
            j = 0;
        }
        System.out.println("");
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
