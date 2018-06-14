package br.com.upe.blackjack.players;

import java.util.ArrayList;

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
	
	public void destribuirCartas (ArrayList<Jogador> jogadores, Baralho baralho, Banca banca) {
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
	
	public void pegarApostas (ArrayList<Jogador> jogadores) {
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				j.banco.coletarAposta(j);
			}
		}
	}
	
	public void rodada (ArrayList<Jogador> jogadores, Baralho baralho, Banca b) {
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				j.estado.jogar(j, baralho);
			} 
		}
	}
	
	public void ganhadores(ArrayList<Jogador> jogadores) {
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
