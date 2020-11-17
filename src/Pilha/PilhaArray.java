package Pilha;

public class PilhaArray {
	
	private Object item[];
	private int topo;
	
	public PilhaArray(int maxTam){
		this.item=new Object[maxTam];
		this.topo=0;
	}
	public boolean vazia(){
		if(this.topo==0)	
			return true;
		return false;
	}
	public Object desempilha() throws Exception{
		if(this.vazia()){
			throw new Exception("Erro: A pilha esta vazia");
		}
		return this.item[--this.topo];
	}
	public void empilha(Object x)throws Exception{
		if(this.topo==this.item.length){
			throw new Exception("Erro:Pilha cheia");
		}else{
			this.item[this.topo++]=x;
		}
	}
	
}
