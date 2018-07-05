package br.com.upe.blackjack.table;

import java.util.Scanner;


import br.com.upe.blackjack.players.Jogador;


public class Banco {
	private float aposta = 0.0f;
	private float dinheiro = 1000.0f;
	
	public void coletarAposta (Jogador j) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println( j.getNome() + " voce tem R$ " + this.dinheiro + ". Quanto deseja apostar? ");
			apostar(in.nextFloat());
			System.out.println(this.dinheiro);
	}
	
	public void apostar (float a) {
			this.dinheiro = this.dinheiro - a;
			this.aposta = a;
	}
	
	public void premioGanhador(Jogador j, boolean vinteeum) {
		if(vinteeum) {
			System.out.println(j.getNome() + " voce ganhou R$ " + (this.aposta * 1.50f));
			this.dinheiro = this.dinheiro + this.aposta + (this.aposta * 1.50f);
		}	else	{
			System.out.println(j.getNome() + " voce ganhou R$ " + this.aposta);
			this.dinheiro = this.dinheiro + this.aposta + this.aposta;
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
