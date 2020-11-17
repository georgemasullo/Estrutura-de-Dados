package Fila;

import javax.swing.SingleSelectionModel;

public class FilaEncad<tipo> {
	private static class Celula<tipo>{
		tipo item;
		Celula prox;
	}
	private Celula frente,tras;
	
	public FilaEncad() {
		this.frente=new Celula<tipo>();
		this.tras=this.frente;
		this.frente.prox=null;
	}
	public void enfileira(tipo x){
		this.tras.prox=new Celula<tipo>();
		this.tras=this.tras.prox;
		this.tras.item=x;
		this.tras.prox=null;
	}
	public tipo desenfileira() throws Exception{
		tipo item=null;
		if(this.vazia()){
			throw new Exception("Erro:A fila esta vazia");
		}
		this.frente=this.frente.prox;
		item=(tipo) this.frente.item;
		return item;
	}
	public void listar(){
		while(this.frente!=null){
			if(this.frente.item!=null)
				System.out.println(this.frente.item);
			this.frente=this.frente.prox;
		}
	}
	public boolean vazia(){
		if(this.frente==this.tras){
			return true;
		}
		return false;
	}
}
