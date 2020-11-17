package ArvoreBinaria;

public class teste {

	public static void main(String[] args) {
		
		ArvoreBinaria ab=new ArvoreBinaria();
		try {
			//ab.insere(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ab.pesquisa(0));
		try {
			//ab.retira(0);
			/*ab.insere(10);
			ab.insere(5);
			ab.insere(6);
			ab.insere(20);
			ab.insere(2);
			ab.insere(3);
			ab.insere(1);
			*/
			ab.insere(2);
			ab.insere(1);
			ab.insere(7);
			ab.insere(6);
			ab.insere(5);
			ab.insere(4);
			ab.insere(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ab.pesquisa(20));
		//ab.pre();
		//ab.ordem();
		//ab.pos();
		try {
			ab.retira(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ab.imprimi();
		System.out.println("A"+ab.altura());
	}

}
