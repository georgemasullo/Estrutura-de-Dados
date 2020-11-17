package Lista;


public class ListaEnc<tipo> {
	
	private static class Celula<tipo>{
		tipo item;
		Celula prox;
	}

	
	private Celula primeiro,ultimo,pos;
	
	public ListaEnc() {
		this.primeiro=new Celula<tipo>();
		this.ultimo=this.primeiro;
		this.pos = this.primeiro;
		this.primeiro.prox=null;
	}
	public void insere(tipo x){
		this.ultimo.prox=new Celula();
		this.ultimo=this.ultimo.prox;
		this.ultimo.item=x;
		this.ultimo.prox=null;
	}
	public void inserePrimeiro (tipo item) {
	    Celula aux =  this.primeiro.prox;
	    this.primeiro.prox = new Celula ();
	    this.primeiro.prox.item = item;
	    this.primeiro.prox.prox = aux;
	  }
	public boolean isVazio(){
		return (this.primeiro==this.ultimo);
	}
	public tipo remove() throws Exception{
		if(this.isVazio()){
			throw new Exception("vazio");
		}
		tipo aux= (tipo) this.primeiro.item;
		this.primeiro=this.primeiro.prox;
		return aux;
	}
	public tipo retira(tipo item) throws Exception{
		if(this.isVazio() || item==null){
			throw new Exception("vazio");
		}
		Celula aux=this.primeiro;
		while(aux.prox!=null && !aux.prox.item.equals(item)){
			aux=aux.prox;
		}
		if(aux.prox==null){
			return null;
		}
		Celula q=aux.prox;
		tipo suporte=(tipo) q.item;
		aux.prox=q.prox;
		if(aux.prox==null){
			this.ultimo=aux;
		}
		return suporte;
		
	}
	public tipo pesquisa (tipo chave) {
	    if (this.vazia () || chave == null) return null;
	    Celula aux = this.primeiro;
	    while (aux.prox != null) {
	      if (aux.prox.item.equals (chave)) return (tipo) aux.prox.item;
	      aux = aux.prox;
	    }
	    return null;
	  }
	public boolean estaNaLista (tipo chave) {
	    tipo obj = this.pesquisa (chave);
	    return (obj != null);
	  }
	public boolean vazia () { return (this.primeiro == this.ultimo); } 
	public tipo primeiro () {
	    this.pos = this.primeiro; 
	    return this.proximo ();
	 }

	public tipo proximo () {
		this.pos = this.pos.prox;
	    if (this.pos == null){ 
	    	return null;
	    }else{ 
	    	return (tipo) this.pos.item;
	    }
	}

}
