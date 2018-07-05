package br.com.upe.blackjack.table;

import java.util.ArrayList;
import java.util.Collections;

import br.com.upe.blackjack.interfaces.VCarta;

public class Baralho {

	private ArrayList<VCarta> vbaralho = new ArrayList<VCarta>();
	public Baralho() {
		
		this.vbaralho.add(new VCarta("Copas", 11, "As", "/br/com/upe/blackjack/view/img/copas_as.png"));
		this.vbaralho.add(new VCarta("Copas", 2, "2", "/br/com/upe/blackjack/view/img/copas_2.png"));
		this.vbaralho.add(new VCarta("Copas", 3, "3", "/br/com/upe/blackjack/view/img/copas_3.png"));
		this.vbaralho.add(new VCarta("Copas", 4, "4", "/br/com/upe/blackjack/view/img/copas_4.png"));
		this.vbaralho.add(new VCarta("Copas", 5, "5", "/br/com/upe/blackjack/view/img/copas_5.png"));
		this.vbaralho.add(new VCarta("Copas", 6, "6", "/br/com/upe/blackjack/view/img/copas_6.png"));
		this.vbaralho.add(new VCarta("Copas", 7, "7", "/br/com/upe/blackjack/view/img/copas_7.png"));
		this.vbaralho.add(new VCarta("Copas", 8, "8", "/br/com/upe/blackjack/view/img/copas_8.png"));
		this.vbaralho.add(new VCarta("Copas", 9, "9", "/br/com/upe/blackjack/view/img/copas_9.png"));
		this.vbaralho.add(new VCarta("Copas", 10, "10", "/br/com/upe/blackjack/view/img/copas_10.png"));
		this.vbaralho.add(new VCarta("Copas", 10, "Q", "/br/com/upe/blackjack/view/img/copas_dama.png"));
		this.vbaralho.add(new VCarta("Copas", 10, "J", "/br/com/upe/blackjack/view/img/copas_valete.png"));
		this.vbaralho.add(new VCarta("Copas", 10, "K", "/br/com/upe/blackjack/view/img/copas_rei.png"));
		
		this.vbaralho.add(new VCarta("espada", 11, "As", "/br/com/upe/blackjack/view/img/espada_as.png"));
		this.vbaralho.add(new VCarta("espada", 2, "2", "/br/com/upe/blackjack/view/img/espada_2.png"));
		this.vbaralho.add(new VCarta("espada", 3, "3", "/br/com/upe/blackjack/view/img/espada_3.png"));
		this.vbaralho.add(new VCarta("espada", 4, "4", "/br/com/upe/blackjack/view/img/espada_4.png"));
		this.vbaralho.add(new VCarta("espada", 5, "5", "/br/com/upe/blackjack/view/img/espada_5.png"));
		this.vbaralho.add(new VCarta("espada", 6, "6", "/br/com/upe/blackjack/view/img/espada_6.png"));
		this.vbaralho.add(new VCarta("espada", 7, "7", "/br/com/upe/blackjack/view/img/espada_7.png"));
		this.vbaralho.add(new VCarta("espada", 8, "8", "/br/com/upe/blackjack/view/img/espada_8.png"));
		this.vbaralho.add(new VCarta("espada", 9, "9", "/br/com/upe/blackjack/view/img/espada_9.png"));
		this.vbaralho.add(new VCarta("espada", 10, "10", "/br/com/upe/blackjack/view/img/espada_10.png"));
		this.vbaralho.add(new VCarta("espada", 10, "Q", "/br/com/upe/blackjack/view/img/espada_dama.png"));
		this.vbaralho.add(new VCarta("espada", 10, "J", "/br/com/upe/blackjack/view/img/espada_valete.png"));
		this.vbaralho.add(new VCarta("espada", 10, "K", "/br/com/upe/blackjack/view/img/espada_rei.png"));
		
		this.vbaralho.add(new VCarta("ouro", 11, "As", "/br/com/upe/blackjack/view/img/ouro_as.png"));
		this.vbaralho.add(new VCarta("ouro", 2, "2", "/br/com/upe/blackjack/view/img/ouro_2.png"));
		this.vbaralho.add(new VCarta("ouro", 3, "3", "/br/com/upe/blackjack/view/img/ouro_3.png"));
		this.vbaralho.add(new VCarta("ouro", 4, "4", "/br/com/upe/blackjack/view/img/ouro_4.png"));
		this.vbaralho.add(new VCarta("ouro", 5, "5", "/br/com/upe/blackjack/view/img/ouro_5.png"));
		this.vbaralho.add(new VCarta("ouro", 6, "6", "/br/com/upe/blackjack/view/img/ouro_6.png"));
		this.vbaralho.add(new VCarta("ouro", 7, "7", "/br/com/upe/blackjack/view/img/ouro_7.png"));
		this.vbaralho.add(new VCarta("ouro", 8, "8", "/br/com/upe/blackjack/view/img/ouro_8.png"));
		this.vbaralho.add(new VCarta("ouro", 9, "9", "/br/com/upe/blackjack/view/img/ouro_9.png"));
		this.vbaralho.add(new VCarta("ouro", 10, "10", "/br/com/upe/blackjack/view/img/ouro_10.png"));
		this.vbaralho.add(new VCarta("ouro", 10, "Q", "/br/com/upe/blackjack/view/img/ouro_dama.png"));
		this.vbaralho.add(new VCarta("ouro", 10, "J", "/br/com/upe/blackjack/view/img/ouro_valete.png"));
		this.vbaralho.add(new VCarta("ouro", 10, "K", "/br/com/upe/blackjack/view/img/ouro_rei.png"));
		
		this.vbaralho.add(new VCarta("paus", 11, "As", "/br/com/upe/blackjack/view/img/paus_as.png"));
		this.vbaralho.add(new VCarta("paus", 2, "2", "/br/com/upe/blackjack/view/img/paus_2.png"));
		this.vbaralho.add(new VCarta("paus", 3, "3", "/br/com/upe/blackjack/view/img/paus_3.png"));
		this.vbaralho.add(new VCarta("paus", 4, "4", "/br/com/upe/blackjack/view/img/paus_4.png"));
		this.vbaralho.add(new VCarta("paus", 5, "5", "/br/com/upe/blackjack/view/img/paus_5.png"));
		this.vbaralho.add(new VCarta("paus", 6, "6", "/br/com/upe/blackjack/view/img/paus_6.png"));
		this.vbaralho.add(new VCarta("paus", 7, "7", "/br/com/upe/blackjack/view/img/paus_7.png"));
		this.vbaralho.add(new VCarta("paus", 8, "8", "/br/com/upe/blackjack/view/img/paus_8.png"));
		this.vbaralho.add(new VCarta("paus", 9, "9", "/br/com/upe/blackjack/view/img/paus_9.png"));
		this.vbaralho.add(new VCarta("paus", 10, "10", "/br/com/upe/blackjack/view/img/paus_10.png"));
		this.vbaralho.add(new VCarta("paus", 10, "Q", "/br/com/upe/blackjack/view/img/paus_dama.png"));
		this.vbaralho.add(new VCarta("paus", 10, "J", "/br/com/upe/blackjack/view/img/paus_valete.png"));
		this.vbaralho.add(new VCarta("paus", 10, "K", "/br/com/upe/blackjack/view/img/paus_rei.png"));
		
		misturaBaralho();
		
	}
		
	public void misturaBaralho(){
        Collections.shuffle(vbaralho);     
    }
	
	public void imprimeBaralho(){
	        for(VCarta carta : vbaralho){
	        	System.out.println(carta.getCarta());
	        }
	        
	}
	
	public VCarta retiraPrimeiraCartaDoBaralho(){
        return vbaralho.remove(0);
    }
}