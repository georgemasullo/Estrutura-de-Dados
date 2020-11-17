package Grafo;

public class BuscaEmProfundidade {
	
	
	public static final byte branco=0;
	public static byte cinza=1;
	public static byte preto=2;
	
	private int d[];//tempo de descoberta
	private int t[];//tempo de termino
	private int antec[];
	private Grafo grafo;
	
	public BuscaEmProfundidade(Grafo grafo) {
		this.grafo=grafo;
		int x=grafo.numVertice;
		this.t=new int[x];
		this.d=new int[x];
		this.antec=new int[x];
	}
	public void buscaEmProfundidade(){
		int tempo=0;
		int cor[]=new int[this.grafo.numVertice];
		for(int i=0;i<this.grafo.numVertice;i++){
			cor[i]=branco;
			this.antec[i]=-1;
		}
		for(int i=0;i<this.grafo.numVertice;i++){
			if(cor[i]==branco){
				tempo=this.visita(i, tempo, cor);
			}
		}
	}
	
	
	private int visita(int v,int tempo, int cor[]){
		cor[v]=cinza;
		this.d[v]=tempo++;
		if(!this.grafo.listaAdjVazia(v)){
			Aresta a = this.grafo.primeiroListaAdj(v);
			while(a!=null){
				int v_aux=a.getV2();
				if(cor[v_aux]==branco){
					this.antec[v_aux]=v;
					tempo=this.visita(v_aux, tempo, cor);
				}
				a=this.grafo.proxAdj(v);
			}
		}
		cor[v]=preto;
		this.t[v]=tempo++;
		return tempo;
	}
	public int d(int v){
		return this.d[v];
	}
	public int t(int v){
		return this.t[v];
	}

}
