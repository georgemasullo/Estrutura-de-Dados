package ArvoreBinaria;

import Fila.FilaEncad;
public class ArvoreBinaria {
	private static class No{
		int item;
		int altura;
		No esq,dir;
	}
	private No raiz;
	private FilaEncad f;
	public ArvoreBinaria() {
		this.raiz=null;
	}
	public Integer pesquisa(int x){
		return this.pesquisa(x, raiz);
	}
	private Integer pesquisa(int x,No p){
		if(p==null){
			return null;
		}else if(x<p.item){
			return pesquisa(x,p.esq);
		}else if(x>p.item){
			return pesquisa(x,p.dir);
		}else{
			return p.item;
		}
		
	}
	public void insere(int x) throws Exception{
		this.raiz=this.inseri(x,this.raiz);
	}
	private No inseri(int x,No p) throws Exception{
		if (p==null){
			p=new No();
			p.item=x;
			p.dir=null;
			p.esq=null;
		}else if(x<p.item){
			p.esq=inseri(x, p.esq);
		}else if(x>p.item){
			p.dir=inseri(x,p.dir);
		}else{
			throw new Exception("Erro");
		}
		return p;
	}
	public void retira(int x) throws Exception{
		this.raiz=this.retira(x, this.raiz);
	}
	private No retira (int x,No p) throws Exception{
		if(p==null){
			throw new Exception("Erro");
		}else if(x<p.item){
			p.esq=this.retira(x, p.esq);
		}else if(x>p.item){
			p.dir=this.retira(x, p.dir);
		}else{
			if(p.dir==null){
				p=p.esq;
			}else if(p.esq==null){
				p=p.dir;
			}else{
				p.esq=antecessor(p,p.esq);
			}
		}
		return p;
	}
	private No antecessor(No q, No r){
		if(r.dir!=null){
			r.dir=this.antecessor(q, r.dir);
		}else{
			q.item=r.item;
			r=r.esq;
		}
		return r;
	}
	public void pre(){
		this.f=new FilaEncad();
		this.pre(raiz);
		this.f.listar();
	} 
	private void pre(No p){
		if(p!=null){
			//this.visita(p);
			f.enfileira(p.item);
		}
		if(p.esq!=null){
			pre(p.esq);
		}
		if(p.dir!=null){
			pre(p.dir);
		}
	}
	public void ordem(){
		this.f=new FilaEncad();
		this.ordem(raiz);
		this.f.listar();
	} 
	private void ordem(No p){
		if(p.esq!=null){
			ordem(p.esq);
		}
		if(p!=null){
			f.enfileira(p.item);
			this.visita(p);
		}
		if(p.dir!=null){
			ordem(p.dir);
		}
	}
	public void pos(){
		this.f=new FilaEncad();
		this.pos(raiz);
		this.f.listar();
	} 
	private void pos(No p){
		if(p.esq!=null){
			pos(p.esq);
		}
		if(p.dir!=null){
			pos(p.dir);
		}
		if(p!=null){
			if(f!=null){
				f.enfileira(p.item);
			}
			this.visita(p);
		}
	}
	public int altura(){
		this.pos(raiz);
		return this.raiz.altura;
	}
	private void visita(No p){
		int alt1=0;
		int alt2=0;
		if(p.esq!=null){
			alt1=p.esq.altura;
		}
		if(p.dir!=null){
			alt2=p.dir.altura;
		}
		if(alt1>alt2){
			p.altura=alt1+1;
		}else{
			p.altura=alt2+1;
		}
	}
	public void imprimi(){
		this.pos(raiz,raiz,"raiz");
	}
	private void pos(No p,No pai,String x){
		if(p!=null){
			System.out.println(x+"---"+p.item+"---"+pai.item);
		}
		if(p.esq!=null){
			pos(p.esq,p,"esq");
		}
		if(p.dir!=null){
			pos(p.dir,p,"dir");
		}
	}
}
