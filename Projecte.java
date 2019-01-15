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


			// Imprimim Taula
			mostrarTaulell(matrizTablero);

			// Demanem Posició que es vol moure (Fila + Columna)
			System.out.println("Torn de les NEGRES");
			
			// Fila
			System.out.println("Fila on tens la fitxa:");
			int filaPrincipi = teclado.nextInt();
			
			// Columna
			System.out.println("Columna on tens la fitxa:");
			int columnaPrincipi = teclado.nextInt();
			
			// Comprobem que es del seu color
			while (matrizTablero[filaPrincipi][columnaPrincipi] != '•') {
				
				// Indiquem que la posicio es incorrecte
				System.out.println("La posicio es incorrecte");
				
				// Fila
				System.out.println("Fila on tens la fitxa:");
				filaPrincipi = teclado.nextInt();
				
				// Columna
				System.out.println("Columna on tens la fitxa:");
				columnaPrincipi = teclado.nextInt();
			}

			// Demanem Posició on es vol moure (Fila + Columna)
			// Fila
			System.out.println("Fila on mouras la fitxa:");
			int filaFinal = teclado.nextInt();

			// Columna
			System.out.println("Columna on mouras la fitxa:");
			int columnaFinal = teclado.nextInt();

			// Comprobem que el moviment es legal
			while ((filaPrincipi + 1 != filaFinal) || (filaPrincipi - 1 != filaFinal) && (columnaPrincipi + 1 != columnaFinal) || (columnaPrincipi - 1 != columnaFinal)) {
				// Indiquem que no es pot moure a aquesta posicio
				System.out.println("No es pot moure a la fila " + filaFinal + " i columna " + columnaFinal);
				
				// Fila
				System.out.println("Fila on mouras la fitxa:");
				filaFinal = teclado.nextInt();

				// Columna
				System.out.println("Columna on mouras la fitxa:");
				columnaFinal = teclado.nextInt();
			}

			// Comprobem que no esta ocupat


			// Comprobem si hi ha una altre peça que mata


			// Movem la fitxa


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
	
	
	public static void veureRecords() {
		
	}
	public static char[][] moviment(boolean coronat,int color, int filaPrincipi, int columnaPrincipi, int filaFinal, int columnaFinal, char[][] matrizTablero) {
		// Moviment Blanc
		if (color == 1) {
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
		else if (color == 2) {
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
		
	}
	public static boolean colocacioCorrecta(int principiFila, int principiColumna, int finalFila, int finalColumna, char[][] matrizTablero) {
		
		return true;
	}
	public static char[][] matar(int color, int filaMatada, int columnaMatada, char[][] matrizTablero) {
		
	}
}
