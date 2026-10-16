package taller02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Fonda fonda = new Fonda();

		fonda.cargarParticipantes();
		fonda.cargarConsumos();

		int opcion = 0;

		while (opcion != 4) {

			System.out.println("============================================");
			System.out.println("           LA FONDA DEL PAPU");
			System.out.println("============================================");
			System.out.println("  Registros cargados: " + fonda.getCantidadRegistros());
			System.out.println("--------------------------------------------");
			System.out.println("  [1] Ver registros");
			System.out.println("  [2] Actualizar registros");
			System.out.println("  [3] Calcular metricas");
			System.out.println("  [4] Salir");
			System.out.println("============================================");
			System.out.print("Seleccione una opcion: ");

			if (scan.hasNextInt()) {
				opcion = scan.nextInt();
				scan.nextLine();
			} else {
				System.out.println("Error: ingrese un numero.");
				scan.nextLine();
				continue;
			}

			switch (opcion) {

			case 1:
				menuRegistros(scan, fonda);
				break;

			case 2:
				System.out.println("Actualizar registros");
				break;

			case 3:
				System.out.println("Calcular metricas");
				break;

			case 4:
				System.out.println(">> Hasta luego...");
				break;

			default:
				System.out.println(">> Error: opcion fuera de rango. Intente nuevamente.");
				break;
			}
		}

		scan.close();
	}

	public static void menuRegistros(Scanner sc, Fonda fonda) {

		int opcion = 0;

		while (opcion != 3) {

			System.out.println("============ VER REGISTROS =================");
			System.out.println("  [1] Choripanes");
			System.out.println("  [2] Terremotos");
			System.out.println("  [3] Volver al menu principal");
			System.out.println("============================================");
			System.out.print("Seleccione una opcion: ");

			if (sc.hasNextInt()) {
				opcion = sc.nextInt();
				sc.nextLine();
			} else {
				System.out.println(">> Error: la opcion debe ser un numero entre 1 y 3. Intente nuevamente.");
				sc.nextLine();
				continue;
			}

			switch (opcion) {

			case 1:
				fonda.mostrarChoripanes();
				break;

			case 2:
				fonda.mostrarTerremotos();
				break;

			case 3:
				break;

			default:
				System.out.println(">> Error: opcion fuera de rango. Intente nuevamente.");
				break;
			}
		}
	}
}