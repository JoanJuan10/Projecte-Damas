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
		// Variables Inicials
		
		
		// Comença Torn Negres
		
		
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
	
	
	public static void veureRecords() {
		
	}
	public static void movimentBlanc(int filaPrincipi, int columnaPrincipi, int filaFinal, int ColumnaFinal, char[][] matrizTablero) {
		
	}
	public static void movimentNegre(int filaPrincipi, int columnaPrincipi, int filaFinal, int ColumnaFinal, char[][] matrizTablero) {
		
	}
	public static void movimentCoronat(int color,int filaPrincipi, int columnaPrincipi, int filaFinal, int ColumnaFinal, char[][] matrizTablero) {
		
	}
	public static void coronacio(int color, int fila, int columna, char[][] matrizTablero) {
		
	}
	public static boolean colocacioCorrecta(int fila, int columna, char[][] matrizTablero) {
		
		return true;
	}
	public static void matar(int color, int filaMatada, int columnaMatada, char[][] matrizTablero) {
		
	}
}
