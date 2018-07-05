package br.com.upe.blackjack.players;

import java.util.ArrayList;

import br.com.upe.blackjack.interfaces.VBanca;
import br.com.upe.blackjack.interfaces.VBaralho;
import br.com.upe.blackjack.interfaces.VJogador;
import br.com.upe.blackjack.table.Baralho;



public class EstadosBanca {
	private static EstadosBanca Instance;
	
	public static EstadosBanca getInstance() {
		if (Instance == null) {
			Instance = new EstadosBanca();
		}
		return Instance;
	}
	
	public void jogar(Banca banca, Baralho baralho) {
		while(true) {
			banca.geraValorDasCartas();
			if (banca.getPontos() < 17) {
				banca.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
			} else {
				banca.setParou(true);
				break;
			}
		}
	}
	
	public void destribuirCartas (ArrayList<VJogador> jogadores, VBaralho baralho, VBanca banca) {
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				j.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
			}
			banca.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
			for (Jogador j : jogadores) {
				j.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
			}
			banca.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
		}
	}
	
	public void pegarApostas (ArrayList<VJogador> jogadores) {
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				j.banco.coletarAposta(j);
			}
		}
	}
	
	public void rodada (ArrayList<VJogador> jogadores, VBaralho baralho, Banca b) {
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				j.estado.jogar(j, baralho);
			} 
		}
	}
	
	public void ganhadores(ArrayList<VJogador> jogadores) {
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				if(j.estorou()) {
					System.out.println(j.getNome() + " voce estourou");
				} else {
					System.out.println(j.getNome() + " voce ganhou com " + j.getPontos() + " pontos.");
					j.banco.premioGanhador(j, j.vinteeum());
				}
			}
		}
	}

	
	public void esperar() {
		//FAZ NADA
	}
}
