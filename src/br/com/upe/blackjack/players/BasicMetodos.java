package br.com.upe.blackjack.players;

import java.util.ArrayList;

import br.com.upe.blackjack.table.Carta;


public abstract class BasicMetodos{
	private ArrayList<Carta> mao = new ArrayList<Carta>();
	protected int pontos = 0;
	protected boolean estourou = false;
	protected boolean win = false;
	
	public void novaCarta (Carta carta) {
		mao.add(carta);
	}
	
	public void geraValorDasCartas(){
		if (mao != null) {
	        int temAs = 0;
	        for(Carta carta : mao){
	        	if (carta.getFace().equals("A")) {
	        		temAs = temAs + 1;
	        	}
	        	this.pontos = this.pontos + carta.getValor();
	        	
	        }
	        temAs(temAs);
	    }
		
	}
	
	public void temAs(int quantidade) {
		if (quantidade > 0) {
			this.pontos = this.pontos - (quantidade * 10);
		}
	}
	
	public void imprimirMao() {
		if(mao != null){
           for(Carta carta : mao){
        	   System.out.print(" " + carta.getCarta());
           }
        }
	}
	
	public boolean ganhou(int pontos) {
		if (pontos > 21) {
			estourou = true;
			win = false;
			return false;
		}
		if (pontos == 21) {
			estourou = false;
			win = true;
			return true; 
		}
		
		return false;
	}
	
	public void LimpaCartas(){
        mao.clear();
	}
	
	public ArrayList<Carta> getCartas() {
		return mao;
	}

	public void setCartas(ArrayList<Carta> mao) {
		this.mao = mao;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public String cartasNaMao() {
		String aux = " ";
		for (Carta c : mao) {
			aux = aux + c.getFace() + " de " + c.getNaipe() + " ||";
		} 
		return aux;
	}
	
	public boolean getEstourou() {
		return estourou;
	}
	
	public void setEstourou(boolean e){
		estourou = e;
	}
	
	public boolean getWin() {
		return win;
	}
	
	public Carta getPrimeiraCarta () {
		return this.mao.get(0);
	}
	
}