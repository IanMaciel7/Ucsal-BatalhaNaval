package br.com.ucsal.jogos.batalhanaval;

import java.util.Scanner;

public class ContraTorpedeiro extends Embarcacao {

	public ContraTorpedeiro(Jogador jogador) {
		super(jogador,"contra torpedeiro", 3, 4);	
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

	@Override
	public int getTamanho() {
		// TODO Auto-generated method stub
		return super.getTamanho();
	}

	@Override
	public boolean escolherPosicaoDaEmbarcacao(Scanner scanner) {
		// TODO Auto-generated method stub
		return super.escolherPosicaoDaEmbarcacao(scanner);
	}

	
	

}
