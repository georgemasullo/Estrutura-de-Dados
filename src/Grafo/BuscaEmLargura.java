package Grafo;

import Fila.FilaEncad;

public class BuscaEmLargura {
	
	public static final byte branco=0;
	public static byte cinza=1;
	public static byte preto=2;
	
	private int d[];//tempo de descoberta
	private int antec[];
	private Grafo grafo;
	
	public BuscaEmLargura(Grafo grafo) {
		this.grafo=grafo;
		int x=grafo.numVertice;
		this.d=new int[x];
		this.antec=new int[x];
	}
	
	public void buscaEmLargura() throws Exception{
		int cor[]=new int[this.grafo.numVertice];
		for(int i=0;i<this.grafo.numVertice;i++){
			cor[i]=branco;
			this.d[i]=Integer.MAX_VALUE;
			this.antec[i]=-1;
		}
		for(int i=0;i<this.grafo.numVertice;i++){
			if(cor[i]==branco){
				this.visita(i, cor);
			}
		}
	}
	
	private void visita(int u,int cor[]) throws Exception {
		cor[u]=cinza;
		this.d[u]=0;
		FilaEncad<Integer> fila=new FilaEncad<Integer>();
		fila.enfileira(u);
		while(!fila.vazia()){
			Integer aux=fila.desenfileira();
			u=aux.intValue();
			if(!this.grafo.listaAdjVazia(u)){
				Aresta a=this.grafo.primeiroListaAdj(u);
				while(a!=null){
					int v=a.getV2();
					if(cor[v]==branco){
						cor[v]=cinza;
						this.d[v]=this.d[u]+1;
						this.antec[v]=u;
						fila.enfileira(v);
					}
					a=this.grafo.proxAdj(u);
				}
			}
			cor[u]=preto;
		}
	}
	
	public void imprimiAntecessor(){
        System.out.print("Ind :");
        for (int i = 0; i < this.antec.length; i++) {
            System.out.print ("  " + i );
            
        }
        System.out.println("");
        System.out.print("Pai :");
        for (int i = 0; i < this.antec.length; i++) {
            System.out.print ("  " + this.antec[i] );
            
        }
        System.out.println("");
    }
	public boolean Caminho(int origem,int v){
		if( origem == v ) {
			System.out.println( origem );
			return true;
		}else if( this.antec[v] == -1){
			System.out.println( "Nao existe caminho de "+origem+" ate "+ v );
			return false;
		}else {
			boolean aux=Caminho (origem,this.antec[v]);
			if(aux==true)
				System.out.println(v);
			return aux;
		}
	}
}
