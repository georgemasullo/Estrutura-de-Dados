package ArvoreRubroNegra;

public class No<tipo> {
	private Integer chave;
	private tipo item;
	private int cor;
	private No<tipo> pai;
	private No<tipo> esq,dir;
	
	public No() {
		// TODO Auto-generated constructor stub
	}
	
	public No(int chave,tipo item,No<tipo> pai) {
		this.setChave(chave);
		this.setItem(item);
		this.setPai(pai);
		this.setCor(1);//cor vermelha
	}
	public No(Integer chave,tipo item,No<tipo> pai,int cor) {
		this.setChave(chave);
		this.setItem(item);
		this.setPai(pai);
		this.setCor(cor);//cor/:1 vermelha ou 0 preto
	}
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public tipo getItem() {
		return item;
	}
	public void setItem(tipo item) {
		this.item = item;
	}
	public int getCor() {
		return cor;
	}
	public void setCor(int cor) {
		this.cor = cor;
	}
	public No<tipo> getPai() {
		return pai;
	}
	public void setPai(No<tipo> pai) {
		this.pai = pai;
	}
	public No<tipo> getEsq() {
		return esq;
	}
	public void setEsq(No<tipo> esq) {
		this.esq = esq;
	}
	public No<tipo> getDir() {
		return dir;
	}
	public void setDir(No<tipo> dir) {
		this.dir = dir;
	}
	
}
