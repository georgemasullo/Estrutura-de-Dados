package Grafo;

import Lista.ListaEnc;

public class GrafoListaEnc {
	private static class Celula {
		int vertice,peso;
		public Celula(int v,int p){
			vertice=v;
			peso=p;
		}
		public boolean equals (Object obj) {
		      Celula item = (Celula) obj;
		      return (this.vertice == item.vertice);
		 }
		@Override
		public String toString() {
			String tudo=vertice+","+peso;
			return tudo;
		}
	}
	private ListaEnc<Celula> adj[];
	private int numVertices;
	
	public GrafoListaEnc(int numVertice) {
		this.adj=new ListaEnc[numVertice];
		this.numVertices = numVertice;
		for(int i=0;i<numVertice;i++){
			this.adj[i]=new ListaEnc<Celula>();
		}
	}
	public void inseriAresta(int v1,int v2,int peso){
		Celula item=new Celula(v2, peso);
		this.adj[v1].insere(item);
	}
	public boolean existeAresta (int v1, int v2) {
	    Celula item = new Celula (v2, 0);
	    if(this.adj[v1].pesquisa (item)==null){ 
	    	return false;
	    }
	    return true;
	  }
	public boolean listaAdjVazia(int v){
		return this.adj[v].isVazio();
	}
	public Celula primeiroListaAdj(int v){
		Celula item =this.adj[v].primeiro();
		if(item==null){
			return null;
		}
		return item;
	}
	public int numVertices () { 
		return this.numVertices; 
	}
	public void imprime () {
	    for (int i = 0; i < this.numVertices; i++) { 
	      System.out.println ("Vertice " + i + ":");
	      Celula item = (Celula) this.adj[i].primeiro ();
	      while (item != null) {
	        System.out.println ("  " + item.vertice + " (" +item.peso+ ")");
	        item = (Celula) this.adj[i].proximo ();
	      }
	    }
	
	}
}
