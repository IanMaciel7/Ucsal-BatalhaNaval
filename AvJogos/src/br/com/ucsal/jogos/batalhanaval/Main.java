package br.com.ucsal.jogos.batalhanaval;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BatalhaNaval batalhaNaval = new BatalhaNaval(scanner);
		batalhaNaval.iniciarJogo();

	}

}
