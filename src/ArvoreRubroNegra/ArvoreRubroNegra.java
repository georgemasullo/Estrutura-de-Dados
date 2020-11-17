package ArvoreRubroNegra;

public class ArvoreRubroNegra<tipo> {
	private class Retorno{
	 No<tipo> ptv,ptw,ptr,ptq;
	 int a;
	}
	public static final int BLACK = 0;
    public static final int RED = 1;
	
	private No<tipo> raiz,nill;
	
	public ArvoreRubroNegra() {
		this.nill=new No<tipo>(Integer.MAX_VALUE, null, null, BLACK);
		this.raiz=nill;
	}
	
		
	public void insere(int valor) throws Exception{
		insert(valor, raiz, nill, nill, 1);
	}
	
	
	private Retorno insert(int chave, No<tipo> ptv, No<tipo> ptw, No<tipo> ptr, int a) throws Exception{
		No<tipo> ptq = nill;
		Retorno x = new Retorno();
		if(ptv == nill){
			ptv = new No();
			ptv.setChave(chave);
			ptv.setDir(nill);
			ptv.setEsq(nill);
			if(raiz == nill){
				ptv.setCor(BLACK);
				raiz = ptv;
			}else{
				if(chave < ptw.getChave()){
					ptw.setEsq(ptv);
				}else{
					ptw.setDir(ptv);
				}
			}	
		}else{
			if (chave != ptv.getChave()) {
				if (chave < ptv.getChave()) {
					ptq = ptv.getEsq();
				}else{
					ptq = ptv.getDir();
				}
				x = insert(chave, ptq, ptv, ptw, a);
				ptq = x.ptv;
				ptv = x.ptw;
				ptw = x.ptr;
				a = x.a;
				if(a == 1){
					x = rota(ptq, ptv, ptw, ptr, a);
					ptq = x.ptq;
					ptv = x.ptv;
					ptw = x.ptw;
					ptr = x.ptr;
					a = x.a;
				}else{
					if(a == 2){
						a = 1;
					}
				}
			}else{
				throw new Exception("Inserção inválida");
			}
		}
		x.a = a;
		x.ptq = ptq;
		x.ptv = ptv;
		x.ptw = ptw;
		x.ptr = ptr;		
		return x;
	}
	


	private Retorno rota(No ptq, No ptv, No ptw, No ptr, int a){
		No ptt = nill;
		No aux = nill;
		Retorno x = new Retorno();
		a = 2;
		if(ptv.getCor()==RED){
			if (ptv == ptw.getEsq()) {
				ptt = ptw.getDir();
			}else{
				ptt = ptw.getEsq();
			}
			if (ptt.getCor()==RED) {
				ptv.setCor(BLACK);
				ptw.setCor(RED);
				ptt.setCor(BLACK); 
				a = 0;
			}else{
				ptw.setCor(RED);
				if (ptq == ptv.getEsq()) {
					if (ptv == ptw.getEsq()) {
						aux = ptv;
						ptv.setCor(BLACK);
						ptw.setEsq(ptv.getDir());
						ptv.setDir(ptw);
					}else{
						aux = ptq;
						ptq.setCor(BLACK);
						ptw.setDir(ptq.getEsq());
						ptv.setEsq(ptq.getDir());
						ptq.setEsq(ptw);
						ptq.setDir(ptv);
						
					}
				}else{
					if(ptv == ptw.getDir()){
						aux = ptv;
						ptv.setCor(BLACK);
						ptw.setDir(ptv.getEsq());
						ptv.setEsq(ptw);
					}else{
						aux = ptq;
						ptq.setCor(BLACK);
						ptw.setEsq(ptq.getDir());
						ptv.setDir(ptq.getEsq());
						ptq.setEsq(ptv);
						ptq.setDir(ptw);
					}
				}
				if(ptr != nill){
					if(ptq.getChave() < ptr.getChave()){
						ptr.setEsq(aux);
					}else{
						ptr.setDir(aux);
					}
				}else{
					raiz = aux;
				}
			}
			
		}
		x.a = a;
		x.ptq = ptq;
		x.ptv = ptv;
		x.ptw = ptw;
		x.ptr = ptr;
		raiz.setCor(BLACK);
		return x;
	}

	
	
	public void imprime(){
		imprimir(raiz);
	}
	
	private void imprimir(No pt){
		
		if (pt != nill) {
			System.out.println(pt.getChave());
			if (pt.getCor()==BLACK) {
				System.out.println("Preto");
			} else {
				System.out.println("Vermelho");
			}
		}
		
		if(pt.getEsq() != null){
			imprimir(pt.getEsq());
		}
		if (pt.getDir() != null) {
			imprimir(pt.getDir());
		}
		
		
	}
	
}
