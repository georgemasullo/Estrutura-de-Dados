package Grafo;

public class Grafo {//matriz de adjacencia
	int matriz[][];
	int pos[];//posicao atual ao percorrer os adj de um vertice 
	int numVertice;
	
	public Grafo(int numVertice) {
		this.matriz= new int [numVertice][numVertice];
		this.pos=new int [numVertice];
		this.numVertice=numVertice;
		for(int i=0;i<numVertice;i++){
			this.pos[i]=-1;
		}
	}
	public void insereAresta(int v1, int v2, int peso) {
        this.matriz[v1][v2] = peso;
    }

    public boolean existeAresta(int v1, int v2) {
        return (this.matriz[v1][v2] > 0);
    }
    public boolean listaAdjVazia(int v) {
        for (int i = 0; i < this.numVertice; i++) {
            if (this.matriz[v][i] > 0) {
                return false;
            }
        }
        return true;
    }
    public Aresta primeiroListaAdj ( int v ) {
    	this.pos[v] = -1; 
    	return this.proxAdj(v);
    	
    	}
    public Aresta proxAdj(int v) {
        this.pos[v] = this.pos[v]+1;
        while ((this.pos[v] < this.numVertice)
                && (this.matriz[v][ this.pos[v]] == 0)) {
            this.pos[v] = pos[v]+1;
           }
          if (this.pos[v] == this.numVertice) {
            return null;
         }else{
             return new Aresta(v, this.pos[v], this.matriz[v][ this.pos[v]]);
        }
    }
    
    public Aresta retiraAresta(int v1, int v2) {
        if (this.matriz[v1][v2] == 0) {
            return null;
        } else {
            Aresta aresta = new Aresta(v1, v2, this.matriz[v1][v2]);
            this.matriz[v1][v2] = 0;
            return aresta;
        }
    }
    public int numVertices(){
    	return this.numVertice;
    }
    
}
