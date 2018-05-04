package br.com.upe.blackjack.table;

import java.util.ArrayList;

public class FaceValor {

	private ArrayList<Integer> valor = new ArrayList<Integer>();
	private ArrayList<String> face = new ArrayList<String>();
	
	public FaceValor() {
		this.valor.add(2);
		this.face.add("2");
		
		this.valor.add(3);
		this.face.add("3");
		
		this.valor.add(4);
		this.face.add("4");
		
		this.valor.add(5);
		this.face.add("5");
		
		this.valor.add(6);
		this.face.add("6");
		
		this.valor.add(7);
		this.face.add("7");
		
		this.valor.add(8);
		this.face.add("8");
		
		this.valor.add(9);
		this.face.add("9");
		
		this.valor.add(10);
		this.face.add("10");
		
		this.valor.add(10);
		this.face.add("J");
		
		this.valor.add(10);
		this.face.add("Q");
		
		this.valor.add(10);
		this.face.add("K");
		
		this.valor.add(11);
		this.face.add("A");
	}
	
	public int getValor (int j){
		if (valor == null) {
			return 0;
		}
		
		return valor.get(j);
	}
	
	public String getFace (int j){
		if (face == null) {		
			return null;
		}
		
		return face.get(j);
	}
	
	public int tamanho () {
		
		return valor.size();
		
	}
	
}
