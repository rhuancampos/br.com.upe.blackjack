package br.com.upe.blackjack.players;

import java.util.Scanner;

import br.com.upe.blackjack.interfaces.VBaralho;


public class EstadosJogador {
	private static EstadosJogador Instance;
		
	public static EstadosJogador getInstance() {
		if (Instance == null) {
			Instance = new EstadosJogador();
		}
		return Instance;
	}
	
	public void jogar(Jogador j, VBaralho baralho) {
		while (true) {
			j.geraValorDasCartas();
			if (j.vinteeum()) {
				System.out.println("<------------------------------->");
			    System.out.println(j.getNome() + " voce tem 21 pontos. e venceu com as cartas: ");
			    j.imprimirMao();
			    j.banco.premioGanhador(j, true);
			    break;
			}
			if (j.estorou()) {
				System.out.println("<------------------------------->");
			    System.out.println(j.getNome() + " voce tem " + j.getPontos() + " pontos. E ESTOUROU");
			    j.imprimirMao();
			    System.out.println(" ");
			    System.out.println("<------------------------------->");
			    break;
			}
			System.out.println("<------------------------------->");
		    System.out.println(j.getNome() + " voce tem " + j.getPontos() + " pontos. Com as cartas: ");
		    j.imprimirMao();
		    System.out.println(" ");
		    aumentarAposta (j);
		    if (pegarOutraCarta(j, baralho)) {
		    	j.setParou(true);
		    	break;
		    }
		}
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
	}
	
	public boolean pegarOutraCarta (Jogador j, VBaralho baralho) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Deseja pegar outra carta?");
	    System.out.println("1 - Sim");
	    System.out.println("2 - Nao");
	    int opcao = in.nextInt();
	    
	    switch (opcao) {
		case 1:
			j.novaCarta(baralho.retiraPrimeiraCartaDoBaralho());
			return false;

		case 2:
			return true;
			
		default:
		break;
	    }
		return false;
	}
	
	public void esperando () {
		//FAZ NADA
	}
	
	public void estourou (Jogador j) {
		System.out.println(" ");
		System.out.println(j.getNome() + " voce estourou!");
	}
	
}