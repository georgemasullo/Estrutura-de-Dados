package Fila;

public class FilaArray<tipo> {
	
	private tipo item[];
	private int frente,tras;
	
	public FilaArray(int maxTam) {
		this.item=(tipo[]) new Object[maxTam];
		this.frente=0;
		this.tras=this.frente;
	}
	public void enfileira(tipo x)throws Exception{
		if((this.tras+1)%this.item.length==this.frente){
			throw new Exception("Erro:Fila cheia");
		}
		this.item[this.tras]=x;
		this.tras=(this.tras+1)%this.item.length;
		
	}
	public tipo desenfileira() throws Exception{
		if(this.vazia()){
			throw new Exception("Erro:A fila esta vazia");
		}
		tipo item=this.item[this.frente];
		this.frente=(this.frente+1)%this.item.length;
		return item;
	}
	public boolean vazia(){
		if(this.frente==this.tras){
			return true;
		}
		return false;
	}
}
