package br.com.upe.blackjack.players;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.upe.blackjack.dates.Gravar;
import br.com.upe.blackjack.table.Baralho;


public class Banca extends BasicMetodos {
	EstadosBanca estado = EstadosBanca.getInstance();

	public void iniciarRodada(ArrayList<Jogador> jogadores, Banca banca, int quantidade) {
		Baralho baralho = new Baralho();
		
		System.out.println("<------------------------------->");
		System.out.println("Rodada iniciada!");
		System.out.println("Coletando apostas");
		
		banca.estado.pegarApostas(jogadores);
						
		System.out.println("Apostas coletadas");
		System.out.println("<------------------------------->");
		System.out.println("Distribuindo cartas...");
		
		banca.estado.destribuirCartas(jogadores, baralho, banca);
		
		System.out.println("Cartas distribuidas");
		System.out.println("<------------------------------->");
		System.out.println("A primeira da mao da banca eh: " + super.getPrimeiraCarta().getCarta());
		boolean laco = true;
		while (laco) {
			laco = banca.estado.rodada(jogadores, baralho);
			if (banca.win) {
				System.out.println("A banca somou 21 pontos, e ganhou!");
				laco = false;
				break;
			}	
			if(banca.estourou) {
				System.out.println("A banca estourou");
				banca.estado.jogadorGanhador(jogadores);
				laco = false;
				break;
			} else {
				banca.estado.jogar(banca, baralho);
			}
		}							
	}
			
	public Jogador novoJogador() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("<---------------Entre com seu nome!---------------->");
		System.out.print("Digite seu nome: ");
		String nome = in.next();
		Jogador jogador = new Jogador(nome);
		System.out.println("<------------------------------->");			
		return jogador;
	}
	
	public void criarRodada(ArrayList<Jogador> jogadores, Banca banca){
			ArrayList<Jogador> j = new ArrayList<Jogador>();
			j.add(novoJogador());
			
	       @SuppressWarnings("resource")
	       	       
	       Scanner in = new Scanner(System.in);
	       int opcao;
	       
	       System.out.println("<------------------------------->");
	       System.out.println("Mais algum jogador?");
	       System.out.println("0 - Sim");
	       System.out.println("1 - Nao");
	       opcao = in.nextInt();
	       System.out.println("<------------------------------->");
	       
	       switch (opcao) {
			case 0:
										
				System.out.println("<------------------------------->");
			    System.out.println("Quantos?");
			    int quantidade = in.nextInt() + 1;
			    System.out.println("<------------------------------->");
			    
			    for(int index = 0; index < quantidade - 1; index++){
			    	j.add(novoJogador());
			    }
			    
			    iniciarRodada(j,banca,quantidade);
				break;

			case 1:
				iniciarRodada(j,banca,1);
				
				break;
			default:
				break;
			}
	       
	       
	       
	   }
	
	public void NovoJogo(Banca banca){
		@SuppressWarnings({ "resource", "unused" })
		Scanner in = new Scanner(System.in);
				
		criarRodada(null,banca);
		   
	   }
	
	public void jogoSalvo(ArrayList<Jogador> jogadores, Banca banca) {
		int opcao;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		do{
	    	  System.out.println("<------------------------------->");
	          System.out.println("1 - Iniciar rodada.");
	          System.out.println("2 - Salvar jogo.");
	          System.out.println("0 - Voltar Menu Inicial.");
	          System.out.print("Digite sua opçao: ");
	          opcao = in.nextInt();
	          System.out.println("<------------------------------->");
	          
	       switch (opcao) {
				case 1:
					                 
	                criarRodada(jogadores, banca);
					
					break;
					
				case 2:
						for(Jogador j : jogadores) {
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
	
}
