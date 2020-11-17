package ArvoreBuscaBinaria;

public class Teste {

	public static void main(String[] args) {
		
		ArvoreBuscaBinaria ab=new ArvoreBuscaBinaria();
		try {
			ab.inserir(20);
			ab.inserir(10);
			ab.inserir(30);
			ab.inserir(5);
			ab.retira(10);
			ab.imprimi();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ab.busca(5));
		//System.out.println(ab.altura());
	}

}
