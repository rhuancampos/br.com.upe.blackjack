package br.com.upe.blackjack.interfaces;

import java.util.ArrayList;

public class Newgamer {

	private VBanca vbanca = new VBanca();;
	private ArrayList<VJogador> jogadores = new ArrayList<VJogador>();
	private VBaralho vbaralho = new VBaralho();
	
	public void novoJogador(String nome) {
		VJogador j = new VJogador(nome);
		this.jogadores.add(j);
	}

	public void entregarCartas() {
		this.vbanca.getEstado().destribuirCartas(jogadores, vbaralho, vbanca);
	}
	
	
	public ArrayList<VJogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<VJogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public void setVBanca (VBanca vbanca) {
		this.vbanca = vbanca;
	}
	public VBanca getVBanca () {
		return this.vbanca;
	}

	public VBaralho getVbaralho() {
		return vbaralho;
	}

	public void setVbaralho(VBaralho vbaralho) {
		this.vbaralho = vbaralho;
	}
}
