package br.com.upe.blackjack.table;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {

	private ArrayList<Carta> baralho = new ArrayList<Carta>();
	
	public Baralho() {
		Naipe n = new Naipe();	
		FaceValor fv = new FaceValor();
		
		for (int i = 0; i < n.tamanhoArray(); i++) {
			for (int j = 0; j < fv.tamanho(); j++) {
				Carta c = new Carta(n.getNaipe(i), fv.getValor(j), fv.getFace(j));
				baralho.add(c);
			}
		}
		misturaBaralho();
	}
			
	public void misturaBaralho(){
        Collections.shuffle(baralho);
        Carta c1 = new Carta("Copas", 10, "10");
        Carta c2 = new Carta("Copas", 11, "A");
        Carta c3 = new Carta("Copas", 7, "7");
        Carta c4 = new Carta("Copas", 11, "A");
        
        
        this.baralho.set(0, c4);
        this.baralho.set(1, c3);
        this.baralho.set(2, c2);
        this.baralho.set(3, c1);
     
    }
	
	public void imprimeBaralho(){
	        for(Carta carta : baralho){
	        	System.out.println(carta.getCarta());
	        }
	        
	}
	
	public Carta retiraPrimeiraCartaDoBaralho(){
        return baralho.remove(0);
    }
}