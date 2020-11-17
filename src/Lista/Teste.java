package Lista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Teste {
	public static No novo_no(int a){
		No no = new No(a);
		return no;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=203;
		Hashing h =new Hashing(x);
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		for(int i=0;i<x;i++){
			numeros.add(i);
		}
		Collections.shuffle(numeros);
		System.out.print("[");
		for(int i=0;i<x;i++){
			System.out.print(" "+numeros.get(i)+" ");
		}		
		System.out.println("]");
		for(int i=0;i<x;i++){
			try {
				h.insere(Teste.novo_no(numeros.get(i)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		h.listar();
		ListaEnc<Integer> le= new ListaEnc<Integer>();
		le.insere(10);
		le.insere(5);
	}


	}

