package br.com.ucsal.jogos.batalhanaval;

import java.util.Scanner;

public abstract class Embarcacao {

	protected Jogador jogador;
	private String nome;
	private int tamanho;
	private int numeroDeReferencia;
	
	public Embarcacao(Jogador jogador,String nome, int tamanho, int numeroDeReferencia) {
		super();
		this.nome = nome;
		this.tamanho = tamanho;
		this.jogador = jogador;
		this.numeroDeReferencia = numeroDeReferencia;
		
	}
		
	public String getNome() {
		return nome;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public int getNumeroDeReferencia() {
		return numeroDeReferencia;
	}
	
	public void diminuirTamanhoDaEmbarcacao() {	
				tamanho-=1;	
	}
		
	@Override
	public String toString() {
		return nome+"-"+tamanho;
	}

	public boolean escolherPosicaoDaEmbarcacao(Scanner scanner) {
		
		int linha =0;
		int coluna =0;
		
		
		System.out.println("----------------------------");
		System.out.println("Jogador - "+jogador.NUMERODOJOGADOR);
		System.out.println("Embarcação:"+this.getNome() );
		System.out.println("Escolha o exixo" );
		System.out.println("1 - horizontal");
		System.out.println("2 - vertical \n");
		System.out.print("digite o eixo: ");
		int escolhaEixo=scanner.nextInt();
		
	
		if (escolhaEixo==1) {
			System.out.println("Escolheu horizontal \n");
			System.out.print("digite a coluna: ");
			coluna =scanner.nextInt();
			System.out.print("digite a linha: ");
			linha=scanner.nextInt();	
			return jogador.getTabuleiro().escolherMaisDeUmaPosicaoDeFormaHorizontal(linha, coluna, this.getTamanho(), numeroDeReferencia);
			
		} else if(escolhaEixo==2) {
			System.out.println("Escolheu vertical \n");
			System.out.print("digite a coluna: ");
			coluna =scanner.nextInt();
			System.out.print("digite a linha: ");
			linha=scanner.nextInt();
			return jogador.getTabuleiro().escolherMaisDeUmaPosicaoDeFormaVertical(linha, coluna, this.getTamanho(),numeroDeReferencia);
			
		}else {
			System.out.println("Ops escolha invalida... \n\n");
			return true;
		}
	}
		
}
