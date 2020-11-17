package Lista;

public class Heap {
	private No item [ ] ;
	private int  ultimo=0 ;
	private int tam;

	public Heap ( int maxTam) {
		this.tam=maxTam;
		this.item = new No [maxTam] ; 
	}
	
	public boolean vazia(){
		if (this.ultimo == 0)
			return true;
		else
			return false;
		}
	public boolean cheio(){
		if(this.ultimo==this.tam){
			return true;
		}
		else
			return false;
	}
	private int multiplo(int num){
		if(num%3==0)return 3;
		return 2;
	}
	private void subir(int i){
		int j=i/2;
		if (j>=0){
			if(this.item[i].getPri()>this.item[j].getPri()){
				No aux=this.item[j];
				this.item[j]=this.item[i];
				this.item[i]=aux;
				this.subir(j);
			}
		}

	}
	public void insere(No elem)throws Exception{
		if(cheio()== true){
			throw new Exception("Erro: a lista esta cheia");
		}else{
			this.item[this.ultimo] = elem;
			this.subir(ultimo);
			this.ultimo++;

		}
	}
	public void listar(){
		for(int i=0;i<this.ultimo;i++){
			System.out.println("item"+this.item[i].getPri());
		}
	}
	/*public Object remove(){
		if (this.vazia()==true){
			System.out.println("lista vazia");
			return null;
		} else {
			this.ultimo = this.ultimo -1;
			return this.item[this.ultimo];
		}
	}*/
	
}
