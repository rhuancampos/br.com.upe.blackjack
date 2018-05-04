package br.com.upe.blackjack.table;

import java.util.Scanner;

import br.com.upe.blackjack.players.Jogador;


public class Banco {
	private float aposta = 0.0f;
	private float dinheiro = 5000.0f;
	
	public void coletarAposta (Jogador j) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println( j.getNome() + " voce tem R$ " + this.dinheiro + ". Quanto deseja apostar? ");
			apostar(in.nextFloat());			
	}
	
	public void apostar (float aposta) {
			this.dinheiro = this.dinheiro - aposta;
			this.aposta = aposta;
	}
	
	public void premioGanhador(Jogador j, boolean vinteeum) {
		if(vinteeum) {
			this.dinheiro = this.dinheiro + (this.aposta * 1.50f);
		}	else	{
			this.dinheiro = this.dinheiro + (this.aposta * 2);
		}
	}
	
	public float getAposta() {
		return aposta;
	}

	public void setAposta(float aposta) {
		this.aposta = aposta;
	}
	public float getDinheiro() {
		return this.dinheiro;
	}
	public void setDinheiro(float dinheiro) {
		this.dinheiro = dinheiro;
	}
	
}
