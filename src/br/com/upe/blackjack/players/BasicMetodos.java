package br.com.upe.blackjack.players;

import java.util.ArrayList;

import br.com.upe.blackjack.table.Carta;


public abstract class BasicMetodos{
	private ArrayList<Carta> mao = new ArrayList<Carta>();
	protected int pontos = 0;
	private boolean parou = false;
	private boolean win = false;
	
	public void novaCarta (Carta carta) {
		mao.add(carta);
	}
	
	public void geraValorDasCartas(){
		if (mao != null) {
			int aux = 0;
	        int temAs = 0;
	        for(Carta carta : mao){
	        	if (carta.getFace().equals("A")) {
	        		temAs = temAs + 1;
	        	}
	        	aux = aux + carta.getValor();
	        	
	        }
	        this.pontos = aux;
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
	
	public boolean vinteeum() {
		if (this.pontos == 21) {
			return true;
		}
		return false;
	}
	
	public boolean estorou() {
		if (this.pontos > 21) {
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
			
	public Carta getPrimeiraCarta () {
		return this.mao.get(0);
	}

	public boolean getParou() {
		return parou;
	}

	public void setParou(boolean parou) {
		this.parou = parou;
	}

	public boolean getWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
}