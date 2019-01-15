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









		char[][] matrizTablero =     {{'-','○','-','○','-','○','-','○'},
				{'○','-','○','-','○','-','○','-'},
				{'-','○','-','○','-','○','-','○'},
				{'-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-'},
				{'•','-','•','-','•','-','•','-'},
				{'-','•','-','•','-','•','-','•'},
				{'•','-','•','-','•','-','•','-'}};


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
			boolean fitxaCorrecta = false;
			int filaPrincipi = -1;
			int columnaPrincipi = -1;
			int filaFinal;
			int columnaFinal;
			boolean coronat = false;

			// Imprimim Taula
			mostrarTaulell(matrizTablero);

			// Demanem Posició que es vol moure (Fila + Columna)
			System.out.println("Torn de les NEGRES");

			while (!fitxaCorrecta) {
				// Fila
				System.out.println("Fila on tens la fitxa:");
				filaPrincipi = teclado.nextInt();

				// Columna
				System.out.println("Columna on tens la fitxa:");
				columnaPrincipi = teclado.nextInt();

				// Comprobem que es del seu color
				if(comprobacioColorFitxa(1, filaPrincipi, columnaPrincipi, matrizTablero)) {
					fitxaCorrecta = true;
				}
			}

			fitxaCorrecta = false;

			while (!fitxaCorrecta) {
				// Demanem Posició on es vol moure (Fila + Columna)
				// Fila
				System.out.println("Fila on mouras la fitxa:");
				filaFinal = teclado.nextInt();

				// Columna
				System.out.println("Columna on mouras la fitxa:");
				columnaFinal = teclado.nextInt();

				// Comprobem que es pot moure alla
				if(colocacioCorrecta(filaPrincipi, columnaPrincipi, filaFinal, columnaFinal, matrizTablero)) {
					fitxaCorrecta = true;
				}

				// Comprobem que la fitxa esta coronada

				// Comprobem que el moviment es legal

				// Comprobem que no esta ocupat

				// Comprobem si hi ha una altre peça que mata

				// Movem la fitxa
				moviment(coronat, 1, filaPrincipi, columnaPrincipi, filaFinal, columnaFinal, matrizTablero);

				// Comprobem si mata
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
			if (matrizTablero[fila][columna] == '•' && fila == 0) {
				matrizTablero[fila][columna] = '☻';
			}
		}
		else if (color == 2) {
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

			if (matrizTablero[fila][columna] == '•' || matrizTablero[fila][columna] == '☻') {
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (color == 2) {
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
	public static boolean colocacioCorrecta(int filaPrincipi, int columnaPrincipi, int filaFinal, int columnaFinal, char[][] matrizTablero) {
		return true;
	}
	public static char[][] matar(int color, int filaMatada, int columnaMatada, char[][] matrizTablero) {

	}
}
