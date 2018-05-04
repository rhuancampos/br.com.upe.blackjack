package br.com.upe.blackjack.table;

import java.util.ArrayList;

public class Naipe {
	
	private ArrayList<String> naipes = new ArrayList<String>();
	
	public Naipe() {
		naipes.add("Copas");
		naipes.add("Ouro");
		naipes.add("Paus");
		naipes.add("Espada");
		
	}
	
	public int tamanhoArray() {
		
		if (naipes == null) {
			return 0;
		}
		
		return naipes.size();
	}
	
	public String getNaipe(int i){
		return naipes.get(i);
	}
}
