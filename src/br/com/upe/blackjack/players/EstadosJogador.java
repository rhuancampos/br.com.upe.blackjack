package br.com.upe.blackjack.players;

import java.util.Scanner;

import br.com.upe.blackjack.table.Baralho;

public class EstadosJogador {
	private static EstadosJogador Instance;
		
	public static EstadosJogador getInstance() {
		if (Instance == null) {
			Instance = new EstadosJogador();
		}
		return Instance;
	}
	
	public boolean jogar(Jogador j, Baralho baralho) {
		j.geraValorDasCartas();
		if (j.ganhou(j.getPontos())) {
			System.out.println("<------------------------------->");
		    System.out.println(j.getNome() + "voce tem " + j.getPontos() + " pontos. e venceu com as cartas: Deseja pegar outra carta?");
		    j.imprimirMao();
			return true;
		}
		if (j.estourou) {
			System.out.println("<------------------------------->");
		    System.out.println(j.getNome() + "voce tem " + j.getPontos() + " pontos. E ESTOUROU");
		    j.imprimirMao();
			return true;
		}
		System.out.println("<------------------------------->");
	    System.out.println(j.getNome() + "voce tem " + j.getPontos() + " pontos. Com as cartas: ");
	    j.imprimirMao();
	    System.out.println(" ");
	    pegarOutraCarta(j, baralho);
	    aumentarAposta (j);
	   	return false;
	}
	
	public void apostando(Jogador j) {
		j.banco.coletarAposta(j);
	}
	
	public void aumentarAposta(Jogador j) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Deseja aumentar sua aposta " + j.getNome() + "?");
	    System.out.println("1 - Sim");
	    System.out.println("2 - Nao");
	    int opcao = in.nextInt();
	    
	    switch (opcao) {
		case 1:
			System.out.println("Quanto?");
			j.banco.apostar(in.nextFloat());
		break;
		default:
		break;
	    }
	    System.out.println("<------------------------------->");
	}
	
	public void pegarOutraCarta (Jogador j, Baralho baralho) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Deseja pegar outra carta?");
	    System.out.println("1 - Sim");
	    System.out.println("2 - Nao");
	    int opcao = in.nextInt();
	    
	    switch (opcao) {
		case 1:
			j.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
		break;
		default:
		break;
	    }
	}
	
	public void esperando () {
		//FAZ NADA
	}
	
	public void estourou (Jogador j) {
		System.out.println(" ");
		System.out.println(j.getNome() + " voce estourou!");
	}
	
}