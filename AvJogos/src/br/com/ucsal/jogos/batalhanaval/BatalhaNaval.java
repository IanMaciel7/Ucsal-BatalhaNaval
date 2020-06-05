package br.com.ucsal.jogos.batalhanaval;

import java.util.Scanner;

public class BatalhaNaval {

	private Scanner scanner;
	private Jogador jogador1;
	private Jogador jogador2;

	public BatalhaNaval(Scanner scanner) {
		this.scanner = scanner;
		this.jogador1 = new Jogador(1);
		this.jogador2 = new Jogador(2);
	}

	public void iniciarJogo() {
		iniciarJogador(this.jogador1);
		iniciarJogador(this.jogador2);
		faseDeDisparo(jogador1, jogador2);

	}

	private void iniciarJogador(Jogador jogador) {
		boolean escolhaSubMarinoEstaComProblema = true;
		while (escolhaSubMarinoEstaComProblema) {
			escolhaSubMarinoEstaComProblema = jogador.getSubmarino().escolherPosicaoDaEmbarcacao(scanner);
		}
		jogador.getTabuleiro().imprimirTabuleiro();

		boolean escolhaPortaAvioesEstaComProblema = true;
		while (escolhaPortaAvioesEstaComProblema) {
			escolhaPortaAvioesEstaComProblema = jogador.getPortaAvioes().escolherPosicaoDaEmbarcacao(scanner);
		}
		jogador.getTabuleiro().imprimirTabuleiro();

		boolean escolhaNavioTanqueEstaComProblema = true;
		while (escolhaNavioTanqueEstaComProblema) {
			escolhaNavioTanqueEstaComProblema = jogador.getNavioTanque().escolherPosicaoDaEmbarcacao(scanner);
		}
		jogador.getTabuleiro().imprimirTabuleiro();

		boolean escolhaTorpedeiroEstaComProblema = true;
		while (escolhaTorpedeiroEstaComProblema) {
			escolhaTorpedeiroEstaComProblema = jogador.getContraTorpedeiro().escolherPosicaoDaEmbarcacao(scanner);
		}
		jogador.getTabuleiro().imprimirTabuleiro();

	}

	private Jogador faseDeDisparo(Jogador jogador1, Jogador jogador2) {

		boolean disparoJogador1SemProblemas;
		boolean disparoJogador2SemProblemas;
		boolean naoExisteMaisEmbarcacoesDoJogador2;
		boolean algumDosJogadoresNaoTemMaisEmbarcacao;

		do {
			naoExisteMaisEmbarcacoesDoJogador2 = jogador2.exiteAindaEmbarcacoes() == false;
			disparoJogador1SemProblemas = false;
			disparoJogador2SemProblemas = false;
			algumDosJogadoresNaoTemMaisEmbarcacao = true;

			while (!disparoJogador1SemProblemas) {
				disparoJogador1SemProblemas = efetutarJogadaDeDisparo(jogador2, jogador1);
			}

			if (naoExisteMaisEmbarcacoesDoJogador2) {
				break;
			}

			while (!disparoJogador2SemProblemas) {
				disparoJogador2SemProblemas = efetutarJogadaDeDisparo(jogador1, jogador2);
			}

			if (jogador1.somaDoTamanhoEmbarcacoes() == 0 | jogador2.somaDoTamanhoEmbarcacoes() == 0) {
				algumDosJogadoresNaoTemMaisEmbarcacao = false;
			}

		} while (algumDosJogadoresNaoTemMaisEmbarcacao);
		System.out.println("");
		if (jogador1.exiteAindaEmbarcacoes() == true) {
			System.out.println("----------------------------");
			System.out.println(jogador1 + " venceu!!");
			System.out.println("");
			System.out.println(jogador1.descricaoDoTamanhoTotalDasEmbarcacoes());
			System.out.println(jogador2.descricaoDoTamanhoTotalDasEmbarcacoes());
			return jogador1;
		} else {
			System.out.println("----------------------------");
			System.out.println(jogador2 + " venceu!!");
			System.out.println("");
			System.out.println(jogador1.descricaoDoTamanhoTotalDasEmbarcacoes());
			System.out.println(jogador2.descricaoDoTamanhoTotalDasEmbarcacoes());
			return jogador2;
		}

	}

	private boolean efetutarJogadaDeDisparo(Jogador jogadorQueVaiSofrerOAtaque, Jogador jogadorQueVaiDisparar) {
		jogadorQueVaiSofrerOAtaque.getTabuleiro().imprimirTabuleiroSemEmbarcacoes();
		return jogadorQueVaiDisparar.disparo(jogadorQueVaiSofrerOAtaque, scanner);
	}

}
