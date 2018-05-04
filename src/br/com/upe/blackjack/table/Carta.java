package br.com.upe.blackjack.table;

public class Carta {
	
	private int valor;
	private String face;
	private String naipe;
	
	public Carta(String naipe, int valor, String face) {
		this.valor = valor;
		this.face = face;
		this.naipe = naipe;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getNaipe() {
		return naipe;
	}
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
	public String getCarta() {
		return this.face + " " + this.naipe + " ";
	}
	public String printCart() {
		return this.face + " de " + this.naipe;
	}

}
