package br.com.ucsal.jogos.batalhanaval;



public class Tabuleiro {
	
	private int[][] linhas; 
	private int[][] copiaLinhas; 
	Jogador jogador;
	
	
	
	
	public int[][] getLinhas() {
		return linhas;
	}
	public int getLinhasLength() {
		return linhas.length;
	}


	public Tabuleiro(Jogador jogador) {
		this.linhas = new int[10][10];
		this.copiaLinhas = new int[10][10];
		this.jogador = jogador;
	}
	
	public void imprimirTabuleiroSemEmbarcacoes() {
		pularLinha();
		int nVertical = 0;
					
		linhaNumericaHorizontal();
	
		pularLinha();
		
		for (int i = 0; i < linhas.length; i++) {
			System.out.print(nVertical);
			++nVertical;
			for (int j = 0; j < linhas[i].length; j++) {
				//System.out.print(linhas[i][j] +" ");
				
				if(linhas[i][j]==10) {
					System.out.print(" | b | ");
				}else if(linhas[i][j]==20) {
					System.out.print(" | * | ");
				}
				else {
					System.out.print(" |   | ");
				}
				
			}
			pularLinha();
			criarsuporteLinhaHorizontal();
			pularLinha();
			
		}
		pularLinha();
	}
	
	public void imprimirTabuleiro() {
		pularLinha();
		int nVertical = 0;
					
		linhaNumericaHorizontal();
	
		pularLinha();
		
		for (int i = 0; i < linhas.length; i++) {
			System.out.print(nVertical);
			++nVertical;
			for (int j = 0; j < linhas[i].length; j++) {
				//System.out.print(linhas[i][j] +" ");
				
				if(linhas[i][j]==1 || linhas[i][j]==2 || linhas[i][j]==3 || linhas[i][j]==4 ) {
					System.out.print(" | x | ");
				}else if(linhas[i][j]==10) {
					System.out.print(" | b | ");
				}else if(linhas[i][j]==20) {
					System.out.print(" | * | ");
				}
				else {
					System.out.print(" |   | ");
				}
				
			}
			pularLinha();
			criarsuporteLinhaHorizontal();
			pularLinha();
			
		}
		pularLinha();
	}
	
	private void linhaNumericaHorizontal() {
		for (int i = 0; i <= 9; i++) {
			if (i == 0) {
				System.out.print("  ");
			}
			System.out.print("  "+i+"    ");
		}
	}

	private void pularLinha() {
		System.out.println("");
	}
	
	private void criarsuporteLinhaHorizontal() {
		for (int i = 0; i <= 9; i++) {
			if(i==0) {
				System.out.print(" ");
			}
			System.out.print(" ----- ");		
		}
	}
	
	public boolean escolherUmaPosicao(int linha,int coluna) {
		try {
					
			boolean oParametroLinhaEColunaNaoUltrapassaOLimiteDoTabuleiro = (linha>=0 && linha<=9 && coluna>=0 && coluna<=9);
			if(oParametroLinhaEColunaNaoUltrapassaOLimiteDoTabuleiro) {
				
								
				if (linhas[linha][coluna]==1 | linhas[linha][coluna]==2 | linhas[linha][coluna]==3 | linhas[linha][coluna]==4 ) {
					
					if(linhas[linha][coluna]==1) {
						jogador.getSubmarino().diminuirTamanhoDaEmbarcacao();
					}
					else if(linhas[linha][coluna]==2) {
						jogador.getPortaAvioes().diminuirTamanhoDaEmbarcacao();
					}
					else if(linhas[linha][coluna]==3) {
						jogador.getNavioTanque().diminuirTamanhoDaEmbarcacao();
					}
					else if(linhas[linha][coluna]==4){
						jogador.getContraTorpedeiro().diminuirTamanhoDaEmbarcacao();
					}
					System.out.println("Acertou");
					linhas[linha][coluna]=20;
					return true;
				}else if(linhas[linha][coluna]==10 | linhas[linha][coluna]==20){
					System.out.println("Esta posição já foi esolhida mais de uma vez,por favor escolha outra posição");
					return false;
				}
				else {				
					linhas[linha][coluna]=10;
					System.out.println("Errou");
					return true;
				}
								
			
			}else {
				throw new ArrayIndexOutOfBoundsException();
			}
						
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("parece que seu barco esta em uma posição invalida,"
					+ "pode ser que sua embarcação ultrapasou o limite do tabuleiro ");
			return true;
		}
	}
	
	public boolean escolherMaisDeUmaPosicaoDeFormaHorizontal(int linha,int coluna,int tamanho, int numeroDeReferencia) {
		try {
			copiarVetores(linhas,copiaLinhas);
			int ultimaMarcao = coluna+tamanho;
			boolean oParametroLinhaEColunaNaoUltrapassaOLimiteDoTabuleiro = (linha>=0 && linha<=9 && coluna>=0 && coluna<=9)&&(ultimaMarcao>=0 && ultimaMarcao<=9);
			if(oParametroLinhaEColunaNaoUltrapassaOLimiteDoTabuleiro) {
				
				
				for (int i = 0; i < tamanho; i++) {
					if (i!=0) {
						coluna+=1;
					}
					
					
					if (linhas[linha][coluna]==1 || linhas[linha][coluna]==2 || linhas[linha][coluna]==3 || linhas[linha][coluna]==4 ) {
						System.out.println("Essa Posição já foi escolhida,por favor tente novamente");
						copiarVetores(copiaLinhas,linhas);
						return true;
					}else {				
						linhas[linha][coluna]=numeroDeReferencia;
					}
					
				}
				return false;	
			}else {
				throw new ArrayIndexOutOfBoundsException();
			}
						
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("parece que seu barco esta em uma posição invalida,"
					+ "pode ser que sua embarcação ultrapasou o limite do tabuleiro ");
			System.out.println("número necessario de quadrados para embaração é "+tamanho);
			copiarVetores(copiaLinhas,linhas);
			return true;
		}
				
	}
	
	public boolean escolherMaisDeUmaPosicaoDeFormaVertical(int linha,int coluna,int tamanho, int numeroDeReferencia) {
		copiarVetores(linhas,copiaLinhas);
		int ultimaMarcao = linha+tamanho;
		try {
			boolean oParametroLinhaEColunaNaoUltrapassaOLimiteDoTabuleiro = (linha>=0 && linha<=9 && coluna>=0 && coluna<=9)&&(ultimaMarcao>=0 && ultimaMarcao<=9);
			if (oParametroLinhaEColunaNaoUltrapassaOLimiteDoTabuleiro) {
							
				for (int i = 0; i < tamanho; i++) {
					if (i!=0) {
						linha+=1;
					}
															
					if (linhas[linha][coluna]==1 || linhas[linha][coluna]==2 || linhas[linha][coluna]==3 || linhas[linha][coluna]==4 ) {
						System.out.println("Essa Posição já foi escolhida,por favor tente novamente \n\n");
						copiarVetores(copiaLinhas,linhas);
						return true;
					}else {
						linhas[linha][coluna]=numeroDeReferencia;
					}					
				}
				return false;
			}else {
				throw new ArrayIndexOutOfBoundsException();
			}
			
			
		} catch (Exception e) {
			System.out.println("parace que seu barco esta em uma posição invalida,"
					+ "pode ser que sua embarcação ultrapasou o limite do tabuleiro");
			System.out.println("número necessario de quadrados para embaração é "+tamanho);
			copiarVetores(copiaLinhas,linhas);
			return true;
		}
				
	}
	
	private void copiarVetores(int[][]vaiSerCopiado,int[][]copia) {
		int valor=0;
		for (int i = 0; i < vaiSerCopiado.length; i++) {	
			
			for (int j = 0; j < vaiSerCopiado.length; j++) {
				valor=vaiSerCopiado[i][j];
						copia[i][j]=valor;
			}
				
		}
	}
	
	

}
