package Grafo;

import java.io.File;

public class Teste {

	public static void main(String[] args) {
		File arq = new File("/media/george/Meus arquiv/Estrutura de Dados/entrada.txt");
        Parser parser = new Parser(arq);
        Grafo grafo = parser.ParserBFSDFS();
        GrafoListaEnc gle=new GrafoListaEnc(2);
        BuscaEmProfundidade bp=new BuscaEmProfundidade(grafo);
        BuscaEmLargura bl= new BuscaEmLargura(grafo);
        try {
        	System.out.println("busca em largura");
			bl.buscaEmLargura();
			bl.imprimiAntecessor();
			bl.Caminho(0, 1);
			gle.inseriAresta(0, 0, 0);
			gle.inseriAresta(0, 1, 0);
			gle.inseriAresta(1, 0, 0);
			gle.inseriAresta(1, 1, 0);
			gle.imprime();
			System.out.println("gle "+gle.existeAresta(0, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        bp.buscaEmProfundidade();
        System.out.println("pro");
        System.out.println(bp.d(4));
        
	}

}
