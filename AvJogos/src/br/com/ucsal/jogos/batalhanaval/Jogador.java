package br.com.ucsal.jogos.batalhanaval;

import java.util.Scanner;

public class Jogador {

	private Tabuleiro tabuleiro;
	private PortaAvioes portaAvioes;
	private NavioTanque navioTanque;
	private ContraTorpedeiro contraTorpedeiro;
	private Submarino submarino;

	final int NUMERODOJOGADOR;

	public Jogador(int numeroDoJogador) {
		this.tabuleiro = new Tabuleiro(this);
		this.NUMERODOJOGADOR = numeroDoJogador;
		this.portaAvioes = new PortaAvioes(this);
		this.navioTanque = new NavioTanque(this);
		this.contraTorpedeiro = new ContraTorpedeiro(this);
		this.submarino = new Submarino(this);
	}

	public PortaAvioes getPortaAvioes() {
		return portaAvioes;
	}

	public void setPortaAvioes(PortaAvioes portaAvioes) {
		this.portaAvioes = portaAvioes;
	}

	public NavioTanque getNavioTanque() {
		return navioTanque;
	}

	public ContraTorpedeiro getContraTorpedeiro() {
		return contraTorpedeiro;
	}

	public Submarino getSubmarino() {
		return submarino;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public int somaDoTamanhoEmbarcacoes() {
		int tamanhoTotal = submarino.getTamanho() + portaAvioes.getTamanho() + navioTanque.getTamanho()
				+ contraTorpedeiro.getTamanho();
		return tamanhoTotal;
	}

	public boolean exiteAindaEmbarcacoes() {
		if (somaDoTamanhoEmbarcacoes() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String descricaoDoTamanhoTotalDasEmbarcacoes() {
		String usuario = ("Jogador " + this.NUMERODOJOGADOR);
		return usuario + ":" + submarino + "," + portaAvioes + "," + contraTorpedeiro + "," + navioTanque;
	}

	@Override
	public String toString() {
		return "Jogador-" + this.NUMERODOJOGADOR;
	}

	public boolean disparo(Jogador jogador, Scanner scanner) {
		int coluna;
		int linha;
		System.out.println("----------------------------");
		System.out.println(this);

		System.out.println("Dispare contra o inimigo");
		System.out.print("digite a coluna: ");
		coluna = scanner.nextInt();
		System.out.print("digite a linha: ");
		linha = scanner.nextInt();

		return jogador.getTabuleiro().escolherUmaPosicao(linha, coluna);
	}
}
