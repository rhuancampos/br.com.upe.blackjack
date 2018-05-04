package br.com.upe.blackjack.players;

import br.com.upe.blackjack.table.Banco;

public class Jogador extends BasicMetodos implements Comparable<Jogador> {
	EstadosJogador estado = EstadosJogador.getInstance();
	
	private String nome;
	Banco banco = new Banco();
		
	public Jogador (String nome) {
		this.nome = nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	public Banco getBanco() {
		return this.banco;
	}
	
	public float getDinheiro() {
		return this.banco.getDinheiro();
	}
	
	public void setDinheiro(float dinheiro) {
		this.banco.setDinheiro(dinheiro);
	}

	@Override
	public int compareTo(Jogador outroJogador) {
		// TODO Auto-generated method stub
		if (this.pontos > outroJogador.getPontos()) {
	          return -1;
	     }
	     if (this.pontos < outroJogador	.getPontos()) {
	          return 1;
	     }
		return 0;
	}
	
}
