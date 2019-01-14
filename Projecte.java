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

}

