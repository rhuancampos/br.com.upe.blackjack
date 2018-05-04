package br.com.upe.blackjack.dates;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import br.com.upe.blackjack.players.Jogador;

public abstract class Gravar {
	public static void Salvar(Jogador jogador) {
		
		String jogadorLinha = jogador.getNome() + ";" + jogador.getDinheiro();
		try {
			FileWriter fw = new FileWriter("Jogador.txt", true);
			BufferedWriter conexao = new BufferedWriter(fw);
			conexao.write(jogadorLinha);
			conexao.newLine();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Deletar(Jogador jogador){
		try{
			
		File inputFile = new File("Jogador.txt");
		File tempFile = new File("jogadoresTemp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = jogador.getNome();
		String currentLine;

		while((currentLine = reader.readLine()) != null) {

		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.contains(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		inputFile.delete();
		tempFile.renameTo(inputFile);

		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
