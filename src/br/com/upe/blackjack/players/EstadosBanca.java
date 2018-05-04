package br.com.upe.blackjack.players;

import java.util.ArrayList;
import java.util.Collections;

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
		banca.geraValorDasCartas();
		if (banca.getPontos() < 17) {
			banca.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
		}
	}
	
	public void destribuirCartas (ArrayList<Jogador> jogadores, Baralho baralho, Banca banca) {
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				j.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
				j.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
			}
			banca.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
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
	
	public boolean rodada (ArrayList<Jogador> jogadores, Baralho baralho) {
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				if (j.win) {
					return false;
				}
				if (j.estourou) {
					j.estado.estourou(j);
				} else {
					j.estado.jogar(j, baralho);
				}
			}
		} else {
			return false;
		}
		return true;
	}
	
	public void jogadorGanhador(ArrayList<Jogador> jogadores) {

		
		Collections.sort(jogadores);
		
		if (jogadores.get(0).getPontos() == jogadores.get(1).getPontos()) {
			
		}
	}

	
	public void esperar() {
		//FAZ NADA
	}
}
