package Lista;

public class ListaArray<tipo> {
	private tipo item[];
	private int primeiro,ultimo;
	
	public ListaArray(int maxTam){
		this.item=(tipo[]) new Object [maxTam];
		this.primeiro=0;
		this.ultimo=this.primeiro;
	}
	public boolean isVazia(){
		return (this.primeiro==this.ultimo);
	}
	public tipo pesquisa(tipo item){
		if(this.isVazia()||item==null){
			return null;
		}
		for(int p=0;p<this.ultimo;p++){
			if(this.item[p].equals(item)){
				return this.item[p];
			}
		}
		return null;
	}
	public void inserir(tipo item) throws Exception{
		if(this.ultimo>=this.item.length){
			throw new Exception("cheio");
		}else{
			this.item[this.ultimo]=item;
			this.ultimo++;
		}
	}
	public tipo retira(tipo item) throws Exception{
		if(this.isVazia() || item==null){
			throw new Exception("Vazio");
		}
		int p=0;
		while(p<this.ultimo && !this.item[p].equals(item)){
			p++;
		}
		if(p>=this.ultimo){return null;}
		tipo aux=this.item[p];
		this.ultimo=this.ultimo-1;
		for(int i=p;i<this.ultimo;i++){
			this.item[i]=this.item[i+1];
		}
		return item;
	}
}
