package br.com.upe.blackjack.dates;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import br.com.upe.blackjack.players.Banca;
import br.com.upe.blackjack.players.Jogador;

public abstract class Ler {
	
public static ArrayList<Jogador> retornaJogadores(){
		
		ArrayList<Jogador> jogadores = new ArrayList<>();
	        
	        Path path = Paths.get("Jogador.txt");
			try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))) {
				sc.useDelimiter("[;\n]"); 
				sc.nextLine();
				while (sc.hasNext()) {
				    String nome, dinheiro;
				    nome = sc.next();
				    dinheiro  = sc.next();
				    float dinheiroJogador = Float.parseFloat(dinheiro);
				    Jogador jogadorBanco = new Jogador(nome);
				    jogadorBanco.setDinheiro(dinheiroJogador);
				    jogadores.add(jogadorBanco);
			  }
			} 
			catch (IOException x) {
			  System.err.format("Erro de E/S: %s%n", x);
			} catch (Exception e) {
				System.out.println("Não foi possível carregar arquivo Jogadores. Verifique!");
			}
			
			
			return jogadores;
	              
	}


	public static Jogador buscaJogador (String nome) {
		for (Jogador j : retornaJogadores()) {
			if(j.getNome().equals(nome)) {
				return j;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Jogador> rank(){
		
		@SuppressWarnings("rawtypes")
		ArrayList j = new ArrayList();
				j = retornaJogadores ();
		
		if (j == null) {
			return null;
		}
		
		Collections.sort(j);
		
		ArrayList<Jogador> aux = new ArrayList<Jogador>();
		
		for (int i = 0; i < 4; i++) {
			aux.add((Jogador) j.get(i));
		}
		
		return aux;
	}
	
		public static void CarregaJogo(Jogador jogador){  
		   	System.out.println("\nOlá "+jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");
			Banca banca = new Banca();
			ArrayList<Jogador> jogadorsalvo = new ArrayList<Jogador>();
			jogadorsalvo.add(jogador);
			banca.jogoSalvo(jogadorsalvo, banca);                 		   
	   }
	
		public static void ListaJogadoresSalvos(){
			   
			   ArrayList<Jogador> jogadores = retornaJogadores();
			   
			   if(!jogadores.isEmpty()){
			   System.out.println("---- Jogadores Salvos: ----\n");
				   
			   	   for(int x = 0; x < jogadores.size(); x++){
					   System.out.println(Integer.toString(x) +" "+ jogadores.get(x).toString());
				   }
				   System.out.println();
				   
				   int opcao;
				   @SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);
				   System.out.println("Selecione um jogador:");
				   opcao = in.nextInt();
				   
				   do {
					   
					   System.out.println("Você selecionou o jogador -> " +jogadores.get(opcao).getNome());
					   			   
					   				
				   } while (opcao < 0 || opcao > jogadores.size());
				   
				   CarregaJogo(jogadores.get(opcao));
				   
			   }else{
				   System.out.println("Nenhum jogo salvo!");
			   }
			   
			   
		   }
	   
		public static void imprimeTopCincoJogadores(){
		   
			  ArrayList<Jogador> jogadores = rank();
			  
			  if(!jogadores.isEmpty()){
				  int tamanho = 5;
				  if(jogadores.size() < 5){
					  tamanho = jogadores.size();
				  }
				
				  System.out.println("\n -------- Ranking TOP 5 Jogadores!  -------- ");
				  System.out.println("");
				  for(int x = 0; x < tamanho; x++){
					  
					  System.out.println(Integer.toString(x+1)+"º Lugar -> " + jogadores.get(x).getNome() + " com R$ " + jogadores.get(x).getDinheiro());
					  
				  }
					  
				  System.out.println("\n ------------------------------------------- ");
				  System.out.println("");
				  
			  }
	   }

}
