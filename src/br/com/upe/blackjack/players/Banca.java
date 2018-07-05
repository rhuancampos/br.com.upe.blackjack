package br.com.upe.blackjack.players;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.upe.blackjack.dates.Gravar;
import br.com.upe.blackjack.interfaces.VBanca;
import br.com.upe.blackjack.interfaces.VBaralho;
import br.com.upe.blackjack.interfaces.VJogador;


public class Banca extends BasicMetodos {
	private EstadosBanca estado = EstadosBanca.getInstance();

	public void iniciarRodada(ArrayList<VJogador> jogadores, VBanca banca, int quantidade) {
		VBaralho baralho = new VBaralho();
		
		banca.getEstado().pegarApostas(jogadores);

		banca.getEstado().destribuirCartas(jogadores, baralho, banca);

		
		
		System.out.println("A primeira da mao da banca eh: " + super.getPrimeiraCarta().getCarta());
		
		if (banca.vinteeum()) {
			System.out.println("A banca somou 21 pontos, e ganhou!");
		}	
			

		banca.getEstado().rodada(jogadores, baralho, banca);
			
		banca.getEstado().jogar(banca, baralho);
			
		if(banca.estorou()) {
			System.out.println("A banca estourou");
			banca.getEstado().ganhadores(jogadores);
		} 
		
		if (banca.getParou()) {
			for(Jogador j : jogadores) {
				if (j.getParou()) {
					if (j.getPontos() > banca.getPontos()) {
						System.out.println(j.getNome() + " voce ganhou da banca com " + j.getPontos() + " pontos e a banca tinha " + banca.getPontos() + " pontos.");
						System.out.println("Suas cartas foram: ");
						j.imprimirMao();
						j.banco.premioGanhador(j, j.vinteeum());
						jogoSalvo(jogadores, banca);
					} else {
						if (j.getPontos() == banca.getPontos()) {
							System.out.println(j.getNome() + " voce empatou com a banca " + j.getPontos() + "pontos");
							jogoSalvo(jogadores, banca);
						} else {
							System.out.println(j.getNome() + " voce perdeu da banca com " + j.getPontos() + "pontos e a banca tinha " + banca.getPontos() + " pontos.");
							jogoSalvo(jogadores, banca);
						}
					}
				}
			}
		}
	}
			
	public VJogador novoJogador() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("<---------------Entre com seu nome!---------------->");
		System.out.print("Digite seu nome: ");
		String nome = in.next();
		VJogador jogador = new VJogador(nome);
		System.out.println("<------------------------------->");			
		return jogador;
	}
	
	public void removerJogador (ArrayList<VJogador> jogadores) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	    int aux = 1;
	       
	    System.out.println("Qual? (digite o numero)");

	    for (Jogador j : jogadores) {
	    	System.out.println(aux + " " + j.getNome());
	    	aux = aux + 1;
	    }
	    
	    aux = in.nextInt();
	    
	    jogadores.remove(aux - 1);
	}
	
	public void criarRodada(ArrayList<VJogador> jogadores, VBanca banca){
		ArrayList<VJogador> j = new ArrayList<VJogador>();
		if (jogadores == null) {
			j.add(novoJogador());
		}
		
		if (jogadores != null) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
		    int opcao;
		       
		    System.out.println("<------------------------------->");
		    System.out.println("Remover jogador");
		    System.out.println("1 - Sim");
		    System.out.println("2 - Nao");
		    opcao = in.nextInt();
		    switch (opcao) {
			case 1:
				removerJogador(jogadores);
				break;
		    }
		    
		}
		
	    @SuppressWarnings("resource")
	      	       
	    Scanner in = new Scanner(System.in);
	    int opcao;
	       
	    System.out.println("<------------------------------->");
	    System.out.println("Mais algum jogador?");
	    System.out.println("1 - Sim");
	    System.out.println("2 - Nao");
	    opcao = in.nextInt();
	    System.out.println("<------------------------------->");
	       
	    switch (opcao) {
			case 1:
										
				System.out.println("<------------------------------->");
			    System.out.println("Quantos?");
			    int quantidade = in.nextInt() + 1;
			    System.out.println("<------------------------------->");
			    
			    for(int index = 0; index < quantidade - 1; index++){
			    	j.add(novoJogador());
			    }
			    
			    iniciarRodada(j,banca,quantidade);
				break;

			case 2:
				iniciarRodada(j,banca,1);
				
				break;
			default:
				break;
		}
	}
	
	public void NovoJogo(VBanca banca){
		@SuppressWarnings({ "resource", "unused" })
		Scanner in = new Scanner(System.in);
				
		criarRodada(null,banca);
		   
	   }
	
	public void jogoSalvo(ArrayList<VJogador> jogadores, Banca banca) {
		int opcao;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		do{
	    	  System.out.println("<------------------------------->");
	          System.out.println("1 - Iniciar rodada.");
	          System.out.println("2 - Salvar jogo.");
	          System.out.print("Digite sua opçao: ");
	          opcao = in.nextInt();
	          System.out.println("<------------------------------->");
	          
	       switch (opcao) {
				case 1:
					if (jogadores != null) {
						System.out.println("Rodada vai começar com os jogadores: ");
						for (Jogador j : jogadores) {
							System.out.println(j.getNome());
						}
					}       
	                criarRodada(jogadores, (VBanca) banca);
					
					break;
					
				case 2:
						for(VJogador j : jogadores) {
							Gravar.Salvar(j);
							System.out.println("\nJogo Salvo "+j.getNome()+"!");
							System.out.println("");
						}
					
					break;
	
				default:
					break;
				}
	      }while(opcao != 0); 
	}

	public EstadosBanca getEstado() {
		return estado;
	}
	
}
