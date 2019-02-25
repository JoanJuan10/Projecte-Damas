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
				{'○','-','○','-','○','-','-','-'},
				{'-','○','-','○','-','○','-','○'},
				{'-','-','-','-','-','-','-','-'},
				{'-','-','-','○','-','-','-','-'},
				{'•','-','•','-','☻','-','•','-'},
				{'-','•','-','•','-','•','-','•'},
				{'•','-','•','-','•','-','•','-'}};


		boolean jocActiu = true;
		while (jocActiu) {
			// Comença Torn Negres
			boolean tornNegres = true;
			boolean tornBlanques = false;

			// Demanem Posició que es vol moure (Fila + Columna)
			System.out.println("---| Torn de les NEGRES |---");
			while (tornNegres) {
				int filaMatada;
				int columnaMatada;
				boolean colorFitxa = false;
				boolean unAltreMata = true;
				int filaPrincipi = -1;
				int columnaPrincipi = -1;
				int filaFinal = -1;
				int columnaFinal = -1;

				while (!colorFitxa || unAltreMata) {
					filaPrincipi = -1;
					columnaPrincipi = -1;
					filaFinal = -1;
					columnaFinal = -1;

					mostrarTaulell(matrizTablero);

					// Fila
					while (filaPrincipi < 0 || filaPrincipi > 8) {
						System.out.println("Fila on tens la fitxa:");
						filaPrincipi = teclado.nextInt() - 1;
					}

					// Columna
					while (columnaPrincipi < 0 || columnaPrincipi > 8) {
						System.out.println("Columna on tens la fitxa:");
						columnaPrincipi = teclado.nextInt() - 1;
					}

					// Comprobem que es del seu color

					colorFitxa = comprobacioColorFitxa(1, filaPrincipi, columnaPrincipi, matrizTablero);


					char[][] matriuMatar = new char[8][8];
					boolean igual = true;

					for (int i = 0; i < matriuMatar.length; i++) {
						for (int j = 0; j < matriuMatar[i].length; j++) {
							matriuMatar[i][j] = matrizTablero[i][j];
						}
					}
					matriuMatar = potMatar(matriuMatar, filaPrincipi, columnaPrincipi, 1);
					for (int i = 0; i < matriuMatar.length; i++) {
						for (int j = 0; j < matriuMatar[i].length; j++) {
							if(matrizTablero[i][j] != matriuMatar[i][j]) {
								igual = false;
							}
						}
					}

					if (igual) {
						unAltreMata = saberSiAltrePeçaMata(1, filaPrincipi, columnaPrincipi, matrizTablero);
					}
					else {
						unAltreMata = false;
					}

					if (!colorFitxa) {
						System.out.println("Aquesta fitxa no es teva");
					}
					else if (unAltreMata) {
						System.out.println("Hi ha una altre peça que mata");
					}
					if (colorFitxa && !unAltreMata) {

						boolean colocacioCorrecta = false;
						// Demanem on la volem moure
						while (filaFinal < 0 || filaFinal > 8) {
							System.out.println("Fila on vols moure la fitxa:");
							filaFinal = teclado.nextInt() - 1;
						}

						while (columnaFinal < 0 || columnaFinal > 8) {
							System.out.println("Columna on vols moure la fitxa:");
							columnaFinal = teclado.nextInt() - 1;
						}

						// Comprobem que el moviment es correcte
						colocacioCorrecta = colocacioCorrecta(false, 1, filaPrincipi, columnaPrincipi, filaFinal, columnaFinal, matrizTablero);

						if (!colocacioCorrecta) {
							System.out.println("La posicio sel·leccionada no es correcta");
							colorFitxa = false;
							unAltreMata = true;
						}
					}
				}
				// Movem la fitxa
				if (matrizTablero[filaPrincipi][columnaPrincipi] == '☻') {
					moviment(true, 1, filaPrincipi, columnaPrincipi, filaFinal, columnaFinal, matrizTablero);
				}
				else {
					moviment(false, 1, filaPrincipi, columnaPrincipi, filaFinal, columnaFinal, matrizTablero);
				}
				mostrarTaulell(matrizTablero);

				// Comprobem si mata

				// Comprobem si al moure la peça, ha matat
				if ((filaFinal + 2 == filaPrincipi || filaFinal - 2 == filaPrincipi) && (columnaFinal + 2 == columnaPrincipi || columnaFinal - 2 == columnaPrincipi)) {
					// Mentre alrededor tingui alguna peça que pot matar
					boolean igual = true;
					while (igual) {
						char[][] matriuMatar = new char[8][8];

						for (int i = 0; i < matriuMatar.length; i++) {
							for (int j = 0; j < matriuMatar[i].length; j++) {
								matriuMatar[i][j] = matrizTablero[i][j];
							}
						}
						matriuMatar = potMatar(matriuMatar, filaFinal, columnaFinal, 1);
						for (int i = 0; i < matriuMatar.length; i++) {
							for (int j = 0; j < matriuMatar[i].length; j++) {
								if(matrizTablero[i][j] != matriuMatar[i][j]) {
									igual = false;
									if (matriuMatar[i][j] == '•' || matriuMatar[i][j] == '☻') {
										filaFinal = matriuMatar[i][j];
										columnaFinal = matriuMatar[i][j];
									}
								}
							}
						}

						if (!igual) {
							System.out.println("Pots Tornar a matar");
							
						}
						else {
							igual = false;
							tornNegres = false;
						}
					}
				}
			}

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
		// Comprobem que no esta ocupat
		if (matrizTablero[filaFinal][columnaFinal] == '☻' || matrizTablero[filaFinal][columnaFinal] == '•' || matrizTablero[filaFinal][columnaFinal] == '☺' || matrizTablero[filaFinal][columnaFinal] == '○') {
			System.out.println("Lugar ocupado");
			return false;
		}
		// Comprobem que el moviment es legal
		if (color == 1) {
			// Negre
			// Comprobem si vol moure endevant (Matant)
			if (filaPrincipi - 2 > 0 && columnaPrincipi + 2 < 8) {
				if (filaPrincipi - 2 == filaFinal && columnaPrincipi + 2 == columnaFinal) {
					if (matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '○' || matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '☺') {
						// Matem la peça
						matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] = '-';
						return true;
					}
				}
			}
			if (filaPrincipi - 2 > 0 && columnaPrincipi - 2 > 0) {
				if (filaPrincipi - 2 == filaFinal && columnaPrincipi - 2 == columnaFinal) {
					if (matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '○' || matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '☺') {
						// Matem la peça
						matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] = '-';
						return true;
					}
				}
			}
			if (coronat) {
				// Comprobem si vol moure endarrere (Matant)
				if (filaPrincipi + 2 < 8 && columnaPrincipi + 2 < 8) {
					if (filaPrincipi + 2 == filaFinal && columnaPrincipi + 2 == columnaFinal) {
						if (matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '○' || matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '☺') {
							// Matem la peça
							matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] = '-';
							return true;
						}
					}
				}
				if (filaPrincipi + 2 < 8 && columnaPrincipi - 2 > 0) {
					if (filaPrincipi + 2 == filaFinal && columnaPrincipi - 2 == columnaFinal) {
						if (matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '○' || matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '☺') {

							// Matem la peça
							matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] = '-';
							return true;
						}
					}
				}
			}
			// Comprobem si vol moure's endevant (No Matant)
			if (filaPrincipi - 1 > 0 && columnaPrincipi + 1 < 8) {
				if (filaPrincipi - 1 == filaFinal && columnaPrincipi + 1 == columnaFinal) {
					if (matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '-'){
						return true;
					}
				}
			}
			if (filaPrincipi - 1 > 0 && columnaPrincipi - 1 > 0) {
				if (filaPrincipi - 1 == filaFinal && columnaPrincipi - 1 == columnaFinal) {
					if (matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '-') {
						return true;
					}
				}
			}
			if (coronat) {
				// Comprobem si vol moure's endarrere (No Matant)
				if (filaPrincipi + 1 < 8 && columnaPrincipi + 1 < 8) {
					if (filaPrincipi + 1 == filaFinal && columnaPrincipi + 1 == columnaFinal) {
						if (matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '-') {
							return true;
						}
					}
				}
				if (filaPrincipi + 1 < 8 && columnaPrincipi - 1 > 0) {
					if (filaPrincipi + 1 == filaFinal && columnaPrincipi - 1 == columnaFinal) {
						if (matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '-') {
							return true;
						}
					}
				}
			}
		}
		if (color == 2) {
			// Blanc
			// Comprobem si vol moure endevant (Matant)
			if (filaPrincipi + 2 < 8 && columnaPrincipi + 2 < 8) {
				if (filaPrincipi + 2 == filaFinal && columnaPrincipi + 2 == columnaFinal) {
					if (matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '•' || matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '☻') {

						// Matem la peça
						matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] = '-';
						return true;
					}
				}
			}
			else if (filaPrincipi + 2 < 8 && columnaPrincipi - 2 > 0) {
				if (filaPrincipi + 2 == filaFinal && columnaPrincipi - 2 == columnaFinal) {
					if (matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '•' || matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '☻') {

						// Matem la peça
						matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] = '-';
						return true;
					}
				}
			}
			else if (coronat) {
				// Comprobem si vol moure endarrere (Matant)
				if (filaPrincipi - 2 > 0 && columnaPrincipi + 2 < 8) {
					if (filaPrincipi - 2 == filaFinal && columnaPrincipi + 2 == columnaFinal) {
						if (matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '•' || matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '☻') {

							// Matem la peça
							matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] = '-';
							return true;
						}
					}
				}
				else if (filaPrincipi - 2 > 8 && columnaPrincipi - 2 > 0) {
					if (filaPrincipi - 2 == filaFinal && columnaPrincipi - 2 == columnaFinal) {
						if (matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '•' || matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '☻') {

							// Matem la peça
							matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] = '-';
							return true;
						}
					}
				}
			}
			// Comprobem si vol moure's endevant (No Matant)
			else if (filaPrincipi + 1 < 8 && columnaPrincipi + 1 < 8) {
				if (filaPrincipi + 1 == filaFinal && columnaPrincipi + 1 == columnaFinal) {
					if (matrizTablero[filaPrincipi + 1][columnaPrincipi + 1] == '-'){
						return true;
					}
				}
			}
			else if (filaPrincipi + 1 < 8 && columnaPrincipi - 1 > 0) {
				if (filaPrincipi + 1 == filaFinal && columnaPrincipi - 1 == columnaFinal) {
					if (matrizTablero[filaPrincipi + 1][columnaPrincipi - 1] == '-') {
						return true;
					}
				}
			}
			else if (coronat) {
				// Comprobem si vol moure's endarrere (No Matant)
				if (filaPrincipi - 1 > 0 && columnaPrincipi + 1 < 8) {
					if (filaPrincipi - 1 == filaFinal && columnaPrincipi + 1 == columnaFinal) {
						if (matrizTablero[filaPrincipi - 1][columnaPrincipi + 1] == '-') {
							return true;
						}
					}
				}
				else if (filaPrincipi - 1 > 0 && columnaPrincipi - 1 > 0) {
					if (filaPrincipi - 1 == filaFinal && columnaPrincipi - 1 == columnaFinal) {
						if (matrizTablero[filaPrincipi - 1][columnaPrincipi - 1] == '-') {
							return true;
						}
					}
				}
			}
			else {
				return false;
			}
		}
		if (color > 3 || color < 1) {
			System.out.println("No deberias ver esto (CODE: colocacioCorrecta - COLOR ERROR)");
		}
		return false;
	}

	public static boolean saberSiAltrePeçaMata(int color, int fila, int columna, char[][] matrizTablero) {

		// Negre
		for (int i = 0; i < matrizTablero.length; i++) {
			for (int j = 0; j < matrizTablero[i].length; j++) {
				if (color == 1) {
					if (matrizTablero[i][j] == '•' || matrizTablero[i][j] == '☻') {
						if (fila != i || columna != j) {
							if (i > 0 && j < 7 && (matrizTablero[i - 1][j + 1] == '☺' || matrizTablero[i - 1][j + 1] == '○')) {
								if (i > 0 && j < 7 && (matrizTablero[i - 2][j + 2] == '-' || matrizTablero[i - 2][j + 2] == '-')) {

									return true;
								}
							}
							else if (i > 0 && j > 0 && (matrizTablero[i - 1][j - 1] == '☺' || matrizTablero[i - 1][j - 1] == '○')) {
								if (i > 0 && j > 0 && (matrizTablero[i - 2][j - 2] == '-' || matrizTablero[i - 2][j - 2] == '-')) {

									return true;
								}
							}
							else if (matrizTablero[i][j] == '☻') {
								if (i < 7 && j < 7 && (matrizTablero[i + 1][j + 1] == '☺' || matrizTablero[i + 1][j + 1] == '○')) {
									if (i < 7 && j < 7 && (matrizTablero[i + 2][j + 2] == '-' || matrizTablero[i + 2][j + 2] == '-')) {
										return true;
									}
								}
								else if (i < 7 && j > 0 && (matrizTablero[i + 1][j - 1] == '☺' || matrizTablero[i + 1][j - 1] == '○')) {
									if (i < 7 && j > 0 && (matrizTablero[i + 2][j - 2] == '-' || matrizTablero[i + 2][j - 2] == '-')) {
										return true;
									}
								}
							}
						}
					}
				}
				// Blanc
				else if (color == 2) {
					if (matrizTablero[i][j] == '○' || matrizTablero[i][j] == '☺') {
						if (fila != i || columna != j) {
							if (i > 0 && j < 7 && (matrizTablero[i - 1][j + 1] == '☻' || matrizTablero[i - 1][j + 1] == '•')) {
								if (i > 0 && j < 7 && (matrizTablero[i - 2][j + 2] == '-' || matrizTablero[i - 2][j + 2] == '-')) {
									return true;
								}
							}
							else if (i > 0 && j > 7 && (matrizTablero[i - 1][j - 1] == '☻' || matrizTablero[i - 1][j - 1] == '•')) {
								if (i > 0 && j > 7 && (matrizTablero[i - 2][j - 2] == '-' || matrizTablero[i - 2][j - 2] == '-')) {
									return true;
								}
							}
							else if (matrizTablero[i][j] == '☺') {
								if (i < 7 && j < 7 && (matrizTablero[i + 1][j + 1] == '☻' || matrizTablero[i + 1][j + 1] == '•')) {
									if (i < 7 && j < 7 && (matrizTablero[i + 2][j + 2] == '-' || matrizTablero[i + 2][j + 2] == '-')) {

										return true;
									}
								}
								else if (i < 7 && j < 7 && (matrizTablero[i + 1][j - 1] == '☻' || matrizTablero[i + 1][j - 1] == '•')) {
									if (i < 7 && j > 0 && (matrizTablero[i + 2][j - 2] == '-' || matrizTablero[i + 2][j - 2] == '-')) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	public static char[][] potMatar (char[][] matrizTablero, int filaFinal, int columnaFinal, int color) {
		boolean potMatar = true;
		if (color == 1) {
			while (potMatar) {
				// Comprobem la direcció i que está dintre de la matriu
				if (filaFinal - 2 > 0 && columnaFinal - 2 > 0) {
					if (matrizTablero[filaFinal - 1][columnaFinal - 1] == '○' || matrizTablero[filaFinal - 1][columnaFinal - 1] == '☺') {
						// Comprobem si el seguent está lliure
						if (matrizTablero[filaFinal - 2][columnaFinal - 2] == '-') {
							if (matrizTablero[filaFinal][columnaFinal] == '☻') {
								moviment(true, 1, filaFinal, columnaFinal, filaFinal - 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
							else {
								moviment(false, 1, filaFinal, columnaFinal, filaFinal - 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
						}
					}
					else {
						potMatar = false;
					}
				}
				if (filaFinal + 2 < 8 && columnaFinal - 2 > 0) {
					if (matrizTablero[filaFinal + 1][columnaFinal - 1] == '○' || matrizTablero[filaFinal + 1][columnaFinal - 1] == '☺') {
						// Comprobem si el seguent está lliure
						if (matrizTablero[filaFinal + 2][columnaFinal - 2] == '-') {
							if (matrizTablero[filaFinal][columnaFinal] == '☻') {
								moviment(true, 1, filaFinal, columnaFinal, filaFinal + 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
							else {
								moviment(false, 1, filaFinal, columnaFinal, filaFinal + 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
						}
					}
					else {
						potMatar = false;
					}
				}
				if (filaFinal - 2 > 0 && columnaFinal + 2 < 8) {
					if (matrizTablero[filaFinal - 1][columnaFinal + 1] == '○' || matrizTablero[filaFinal - 1][columnaFinal + 1] == '☺' ) {
						// Comprobem si el seguent está lliure
						if (matrizTablero[filaFinal - 2][columnaFinal + 2] == '-') {
							if (matrizTablero[filaFinal][columnaFinal] == '☻') {
								moviment(true, 1, filaFinal, columnaFinal, filaFinal - 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
							else {
								moviment(false, 1, filaFinal, columnaFinal, filaFinal - 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
						}
					}
					else {
						potMatar = false;
					}
				}
				if (filaFinal + 2 > 8 && columnaFinal + 2 > 8) {
					if (matrizTablero[filaFinal + 1][columnaFinal + 1] == '○' || matrizTablero[filaFinal + 1][columnaFinal + 1] == '☺') {
						// Comprobem si el seguent está lliure
						if (matrizTablero[filaFinal + 2][columnaFinal + 2] == '-') {
							if (matrizTablero[filaFinal][columnaFinal] == '☻') {
								moviment(true, 1, filaFinal, columnaFinal, filaFinal + 2, columnaFinal + 2, matrizTablero);
								potMatar = false;
							}
							else {
								moviment(false, 1, filaFinal, columnaFinal, filaFinal + 2, columnaFinal + 2, matrizTablero);
								potMatar = false;
							}
						}
					}
					else {
						potMatar = false;
					}
				}
				else {
					potMatar = false;
				}
			}
			return matrizTablero;
		}
		else if (color == 2) {
			while (potMatar) {

				// Comprobem la direcció i si esta dintre la matriu
				if (filaFinal - 2 > 0 && columnaFinal - 2 > 0) {
					if (matrizTablero[filaFinal - 1][columnaFinal - 1] == '•' || matrizTablero[filaFinal - 1][columnaFinal - 1] == '☻') {
						// Comprobem si el seguent está lliure
						if (matrizTablero[filaFinal - 2][columnaFinal - 2] == '-') {
							if (matrizTablero[filaFinal][columnaFinal] == '☺') {
								moviment(true, 2, filaFinal, columnaFinal, filaFinal - 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
							else {
								moviment(false, 2, filaFinal, columnaFinal, filaFinal - 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
						}
					}
					else {
						potMatar = false;
					}
				}
				if (filaFinal + 2 < 8 && columnaFinal - 2 > 0) {
					if (matrizTablero[filaFinal + 1][columnaFinal - 1] == '•' || matrizTablero[filaFinal + 1][columnaFinal - 1] == '☻') {
						// Comprobem si el seguent está lliure
						if (matrizTablero[filaFinal + 2][columnaFinal - 2] == '-') {
							if (matrizTablero[filaFinal][columnaFinal] == '☺') {
								moviment(true, 2, filaFinal, columnaFinal, filaFinal + 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
							else {
								moviment(false, 2, filaFinal, columnaFinal, filaFinal + 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
						}
					}
					else {
						potMatar = false;
					}
				}
				if (filaFinal - 2 > 0 && columnaFinal + 2 < 8) {
					if (matrizTablero[filaFinal - 1][columnaFinal + 1] == '•' || matrizTablero[filaFinal - 1][columnaFinal + 1] == '☻' ) {
						// Comprobem si el seguent está lliure
						if (matrizTablero[filaFinal - 2][columnaFinal + 2] == '-') {
							if (matrizTablero[filaFinal][columnaFinal] == '☺') {
								moviment(true, 2, filaFinal, columnaFinal, filaFinal - 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
							else {
								moviment(false, 2, filaFinal, columnaFinal, filaFinal - 2, columnaFinal - 2, matrizTablero);
								potMatar = false;
							}
						}
					}
					else {
						potMatar = false;
					}
				}
				if (filaFinal + 2 < 8 && columnaFinal + 2 < 8) {
					if (matrizTablero[filaFinal + 1][columnaFinal + 1] == '•' || matrizTablero[filaFinal + 1][columnaFinal + 1] == '☻') {
						// Comprobem si el seguent está lliure
						if (matrizTablero[filaFinal + 2][columnaFinal + 2] == '-') {
							if (matrizTablero[filaFinal][columnaFinal] == '☺') {
								moviment(true, 2, filaFinal, columnaFinal, filaFinal + 2, columnaFinal + 2, matrizTablero);
								potMatar = false;
							}
							else {
								moviment(false, 2, filaFinal, columnaFinal, filaFinal + 2, columnaFinal + 2, matrizTablero);
								potMatar = false;
							}
						}
					}
					else {
						potMatar = false;
					}
				}
				else {
					potMatar = false;
				}
			}
			return matrizTablero;
		}
		System.out.println("No deberias ver esto");
		return matrizTablero;
	}

}
