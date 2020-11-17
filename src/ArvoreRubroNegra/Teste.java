package ArvoreRubroNegra;

public class Teste {
public static void main(String[] args) {
	ArvoreRubroNegra<Integer> a =new ArvoreRubroNegra<Integer>();
	try {
		a.insere(3);
		a.insere(2);
		a.insere(1);
		a.insere(8);
		a.insere(4);
		a.imprime();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
