package Lista;

public class Hashing {
	private No item [] ;
	private int tam;

	public Hashing ( int maxTam) {
		this.tam=maxTam;
		this.item = new No [maxTam] ; 
	}


	private int multiplo(){
		if(this.tam%3==0 || (this.tam%3==1 && (this.tam+1)%3==1 ) ){
			return 3;
		}else if(this.tam%2==0){
			return 2;
		}else{
			return 1;
		}
		
	}
	private int hashing(int x){
		return ( ((x+1)*this.multiplo())% (this.tam+1) )-1;
	}
	public void insere(No elem)throws Exception{
		int x=this.hashing(elem.getPri());
		if(x>=0){
			this.item[x]=elem;
		}else if(x==-1){
			x++;
			this.item[x]=elem;
		}else{
		 throw new Exception("Erro");	
		}
	}
	public void listar(){
		System.out.println("");
		System.out.print("[");
		for(int i=0;i<this.tam;i++){
			if(this.item[i]!=null){
				System.out.print(" "+this.item[i].getPri()+" ");
			}else{
				System.out.print("null");
			}
		}
		System.out.println("]");
	}
}
