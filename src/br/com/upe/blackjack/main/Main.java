package br.com.upe.blackjack.main;

import java.util.Scanner;

import br.com.upe.blackjack.dates.Ler;
import br.com.upe.blackjack.players.Banca;

public class Main {

	private static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		in = new Scanner(System.in);

    	System.out.println("\nBem vindo ao Jogo 21 (Blackjack)");

    	System.out.println("");
    	
    	int opcao1;
    	do {
    	     
    		 System.out.println("");
    		 System.out.println("1 - Novo jogo.");
    		 System.out.println("2 - Carregar jogo.");
    		 System.out.println("3 - Ranking de jogadores.");
    		 System.out.println("0 - Sair");
             opcao1 = in.nextInt();

    		switch (opcao1) {
			case 1:
				
				Banca banca = new Banca();				
				banca.NovoJogo(banca);
			
				break;

			case 2:
				
				Ler.ListaJogadoresSalvos();
				
				break;
				
			case 3:
				
				Ler.imprimeTopCincoJogadores();
				
				break;

			default:
				break;
			}
			
		} while (opcao1 != 0);
    	
		
	}

}
