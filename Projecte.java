import java.util.Scanner;

public class Projecte {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		// Menu
		System.out.println("Selecciona:");
		System.out.println("1 - Per a jugar");
		System.out.println("2 - Per a veure els records");
		System.out.println("3 - Per a sortir");
		int seleccio = teclado.nextInt();

		boolean ejecucion = true;
		while (ejecucion) {
			if (seleccio == 1) {
				joc();
			}
			else if (seleccio == 2) {
				veureRecords();
			}
			else {
				ejecucion = false;
			}
		}


		//System.out.println("○ • ☺ ☻");

	}
	public static void mostrarTaulell(char[][] matrizTablero) {
		for (int l = 1; l < 9; l++) {
			System.out.print("  " + l);
		}
		System.out.println();
		for (int i = 0; i < matrizTablero.length; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < matrizTablero[i].length; j++) {
				System.out.print(" ");
				System.out.print(matrizTablero[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public static void joc() {
		Scanner teclado = new Scanner(System.in);

		// Variables Inicials
		char[][] matrizTablero =     {{'-','○','-','○','-','○','-','○'},
				{'○','-','○','-','○','-','○','-'},
				{'-','○','-','○','-','○','-','○'},
				{'-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-'},
				{'•','-','•','-','•','-','•','-'},
				{'-','•','-','•','-','•','-','•'},
				{'•','-','•','-','•','-','•','-'}};

		while (true) {
			// Comença Torn Negres
			boolean fitxaNoCorrecta = true;
			int filaPrincipi = -1;
			int columnaPrincipi = -1;
			int filaFinal;
			int columnaFinal;
			int filaMatada;
			int columnaMatada;

			// Imprimim Taula
			mostrarTaulell(matrizTablero);

			// Demanem Posició que es vol moure (Fila + Columna)
			System.out.println("Torn de les NEGRES");

			while (fitxaNoCorrecta) {
				// Fila
				System.out.println("Fila on tens la fitxa:");
				filaPrincipi = teclado.nextInt();

				// Columna
				System.out.println("Columna on tens la fitxa:");
				columnaPrincipi = teclado.nextInt();

				// Comprobem que es del seu color
				
				boolean colorFitxa = comprobacioColorFitxa(1, filaPrincipi, columnaPrincipi, matrizTablero);
				

				// Comprobem si hi ha una altre peça que mata
				
				saberSiAltrePeçaMata(1, filaPrincipi, columnaPrincipi, matrizTablero);
				
				
				// Movem la fitxa
		
				// Comprobem si mata
					
					// Si fa la diagonal amb una BLANCA i te lloc a la casella seguent, la mata
				
				// Si mata, matar

				// Un cop moguda, comprobem si torna a matar


				// Si pot matar, matar un altre cop



				// Comença Torn Blanques


				// Imprimim Taula


				// Demanem Posició que es vol moure (Fila + Columna)


				// Comprobem que es del seu color


				// Demanem Posició on es vol moure (Fila + Columna)


				// Comprobem que el moviment es legal


		// Comprobem que no esta ocupat


		// Comprobem si hi ha una altre peça que mata


				// Movem la fitxa


				// Comprobem si mata
				// Si mata, matar

				// Un cop moguda, comprobem si torna a matar


				// Si pot matar, matar un altre cop
			}
		}
	}
public static void veureRecords() {

}
public static char[][] moviment(boolean coronat,int color, int filaPrincipi, int columnaPrincipi, int filaFinal, int columnaFinal, char[][] matrizTablero) {
	// Moviment Blanc
	if (color == 2) {
			if (coronat) {
				matrizTablero[filaPrincipi][columnaPrincipi] = '-';
				matrizTablero[filaFinal][columnaFinal] = '☺';
			}
			else {
				matrizTablero[filaPrincipi][columnaPrincipi] = '-';
				matrizTablero[filaFinal][columnaFinal] = '○';
			}
		}
		// Moviment Negre
		else if (color == 1) {
			if (coronat) {
				matrizTablero[filaPrincipi][columnaPrincipi] = '-';
				matrizTablero[filaFinal][columnaFinal] = '☻';
			}
			else {
				matrizTablero[filaPrincipi][columnaPrincipi] = '-';
				matrizTablero[filaFinal][columnaFinal] = '•';
			}
		}
		else {
			System.out.println("No deberias ver esto (CODE: movimentBlanc - COLOR ERROR)");
		}

		return matrizTablero;
	}
	public static char[][] coronacio(int color, int fila, int columna, char[][] matrizTablero) {

		if (color == 1) {
			// Negre
			if (matrizTablero[fila][columna] == '•' && fila == 0) {
				matrizTablero[fila][columna] = '☻';
			}
		}
		else if (color == 2) {
			// Blanc
			if (matrizTablero[fila][columna] == '○' && fila == 7) {
				matrizTablero[fila][columna] = '☺';
			}
		}
		else {
			System.out.println("No deberias ver esto (CODE: coronacio - COLOR ERROR)");
		}
		return matrizTablero;

	}
	public static boolean comprobacioColorFitxa(int color, int fila, int columna, char[][] matrizTablero) {
		if (color == 1) {
			// Negre
			if (matrizTablero[fila][columna] == '•' || matrizTablero[fila][columna] == '☻') {
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (color == 2) {
			// Blanc
			if (matrizTablero[fila][columna] == '○' || matrizTablero[fila][columna] == '☺') {
				return true;
			}
			else
			{
				return false;
			}
		}
		else {
			System.out.println("No deberias ver esto (CODE: comprobacioFitxa - COLOR ERROR)");
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean colocacioCorrecta(boolean coronat,int color,int filaPrincipi, int columnaPrincipi, int filaFinal, int columnaFinal, char[][] matrizTablero) {
		// Comprobem que el moviment es legal
		boolean legal = false;
		if (color == 1) {
			// Negre
			if (matrizTablero[filaPrincipi - 2][columnaPrincipi + 2] == matrizTablero[filaFinal][columnaFinal] || matrizTablero[filaPrincipi - 2][columnaPrincipi - 2] == matrizTablero[filaFinal][columnaFinal]) {
				if (matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '○' || matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '☺') {
					legal = true;
				}
				else if (matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '○' || matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '☺') {
					legal = true;
				}
			}
			if (coronat) {
				if (matrizTablero[filaPrincipi + 2][columnaPrincipi + 2] == matrizTablero[filaFinal][columnaFinal] || matrizTablero[filaPrincipi + 2][columnaPrincipi - 2] == matrizTablero[filaFinal][columnaFinal]) {
					if (matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '○' || matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '☺') {
						legal = true;
					}
					else if (matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '○' || matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '☺') {
						legal = true;
					}
				}
			}
			else if (matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == matrizTablero[filaFinal][columnaFinal] || matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == matrizTablero[filaFinal][columnaFinal]) {
				if (matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '-') {
					legal = true;
				}
			}
			else if (coronat) {
				
			}
			else {
				legal = false;
			}
		}
		else if (color == 2) {
			// Blanc
			if (matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '•') {
				legal = true;
			}
			else if (matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '•') {
				legal = true;
			}
			else if (coronat) {
				if (matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '•') {
					legal = true;
				}
				else if (matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '•') {
					legal = true;
				}
			}
		}
		else {
			System.out.println("No deberias ver esto (CODE: colocacioCorrecta - COLOR ERROR)");
		}
		
		if (legal) {
			legal = false;
			
		}





		// Comprobem que no esta ocupat
	}
	public static char[][] matar(int color, int filaMatada, int columnaMatada, char[][] matrizTablero) {

	}






	public static boolean saberSiAltrePeçaMata(int color, int fila, int columna, char[][] matrizTablero) {
		boolean hiHaUnaAltrePeça = false;

		// Negre
		for (int i = 0; i < matrizTablero.length; i++) {
			for (int j = 0; j < matrizTablero[i].length; j++) {
				if (color == 1) {
					if (matrizTablero[i][j] == '•' || matrizTablero[i][j] == '☻') {
						if (matrizTablero[i][j] != matrizTablero[fila][columna]) {
							if (i >= 1 && j < 7 && (matrizTablero[i - 1][j + 1] == '☺' || matrizTablero[i - 1][j + 1] == '○')) {
								hiHaUnaAltrePeça = true;
							}
							else if (i >= 1 && j >= 1 && (matrizTablero[i - 1][j - 1] == '☺' || matrizTablero[i - 1][j - 1] == '○')) {
								hiHaUnaAltrePeça = true;
							}
							else if (matrizTablero[i][j] == '☻') {
								if (i < 7 && j < 7 && (matrizTablero[i + 1][j + 1] == '☺' || matrizTablero[i + 1][j + 1] == '○')) {
									hiHaUnaAltrePeça = true;
								}
								else if (i < 7 && j >= 1 && (matrizTablero[i + 1][j - 1] == '☺' || matrizTablero[i + 1][j - 1] == '○')) {
									hiHaUnaAltrePeça = true;
								}
							}
						}
					}
				}
				// Blanc
				else if (color == 2) {
					if (matrizTablero[i][j] == '○' || matrizTablero[i][j] == '☺') {
						if (matrizTablero[i][j] != matrizTablero[fila][columna]) {
							if (i >= 1 && j < 7 && (matrizTablero[i - 1][j + 1] == '☻' || matrizTablero[i - 1][j + 1] == '•')) {
								hiHaUnaAltrePeça = true;
							}
							else if (i >= 1 && j >= 7 && (matrizTablero[i - 1][j - 1] == '☻' || matrizTablero[i - 1][j - 1] == '•')) {
								hiHaUnaAltrePeça = true;
							}
							else if (matrizTablero[i][j] == '☺') {
								if (i < 7 && j < 7 && (matrizTablero[i + 1][j + 1] == '☻' || matrizTablero[i + 1][j + 1] == '•')) {
									hiHaUnaAltrePeça = true;
								}
								else if (i < 7 && j >= 7 && (matrizTablero[i + 1][j - 1] == '☻' || matrizTablero[i + 1][j - 1] == '•')) {
									hiHaUnaAltrePeça = true;
								}
							}
						}
					}
				}
			}
		}
		if (hiHaUnaAltrePeça) {
			System.out.println("Pots matar amb un altre peça!");
			return hiHaUnaAltrePeça;
		}
		else {
			return hiHaUnaAltrePeça;
		}
	}

}
