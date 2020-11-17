package ArvoreBuscaBinaria;


public class ArvoreBuscaBinaria {
	private static class No{
		int item;
		int altura;
		No esq,dir;
	}
	private No raiz;
	private int f;
	private Integer b;
	public ArvoreBuscaBinaria() {
		this.raiz=null;
	}
	public Integer busca(int x){
		this.b=null;
		this.busca_arvore(x, raiz);
		return this.b;
	}
	private void busca_arvore(int x, No p){
		if(p==null){
			this.f=0;
			//return null;
		}else if(x==p.item){
			this.f=1;
			this.b=p.item;
		}else if(x<p.item){
			if(p.esq==null){
				this.f=2;
			}else{
				p=p.esq;
				this.busca_arvore(x, p);
			}
		}else if(p.dir==null){
			this.f=3;
		}else{
			p=p.dir;
			this.busca_arvore(x, p);
		}
		
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
	public void inserir(int x) throws Exception{
		this.raiz=this.inserir(x, raiz);
	}
	private No inserir(int x,No p) throws Exception {
		this.busca_arvore(x, p);
		if(this.f==1){
			throw new Exception();
		}
		else{
			No aux = new No();
			aux.item=x;
			aux.esq=null;
			aux.dir=null;
			if(this.f==0){
				//System.out.println("aki 0"+aux.item);
				return aux;
			}else{
				if(this.f==2){
					//System.out.println("aki 2"+aux.item);
					p.esq=this.inserir(x, p.esq);
				}else{
					//System.out.println("aki 3"+aux.item);
					p.dir=this.inserir(x, p.dir);
				}
			}
		}
		return p;
	}
	private void pos(No p){
		if(p.esq!=null){
			pos(p.esq);
		}
		if(p.dir!=null){
			pos(p.dir);
		}
		if(p!=null){
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
