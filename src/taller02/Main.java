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
				menuActualizar(scan, fonda);
				break;

			case 3:
			    fonda.calcularMetricas();
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

	public static void menuActualizar(Scanner scan, Fonda fonda) {

		int opcion = 0;

		while (opcion != 4) {

			System.out.println("========== ACTUALIZAR REGISTROS ============");
			System.out.println("  [1] Agregar");
			System.out.println("  [2] Editar");
			System.out.println("  [3] Eliminar");
			System.out.println("  [4] Volver al menu principal");
			System.out.println("============================================");
			System.out.print("Seleccione una opcion: ");

			if (scan.hasNextInt()) {
				opcion = scan.nextInt();
				scan.nextLine();
			} else {
				System.out.println(">> Error: ingrese un numero valido.");
				scan.nextLine();
				continue;
			}

			switch (opcion) {

			case 1:
				agregarRegistro(scan, fonda);
				break;

			case 2:
				editarRegistro(scan, fonda);
				break;

			case 3:
			    eliminarRegistro(scan, fonda);
			    break;

			case 4:
				break;

			default:
				System.out.println(">> Error: opcion fuera de rango.");
				break;
			}
		}
	}

	public static void agregarRegistro(Scanner scan, Fonda fonda) {

		System.out.println("\nTipo de registro:");
		System.out.println("  [1] Choripan");
		System.out.println("  [2] Terremoto");
		System.out.println("  [3] Cancelar");
		System.out.print("Seleccione una opcion: ");

		if (!scan.hasNextInt()) {
			System.out.println(">> Error: opcion invalida.");
			scan.nextLine();
			return;
		}

		int tipo = scan.nextInt();
		scan.nextLine();

		if (tipo == 3) {
			return;
		}

		if (tipo != 1 && tipo != 2) {
			System.out.println(">> Error: opcion invalida.");
			return;
		}

		if (fonda.getCantidadRegistros() >= 200) {
			System.out.println(">> Error: capacidad maxima de registros (200).");
			return;
		}

		fonda.mostrarParticipantes();

		System.out.print("Seleccione el consumidor: ");

		if (!scan.hasNextInt()) {
			System.out.println(">> Error: consumidor invalido.");
			scan.nextLine();
			return;
		}

		int numero = scan.nextInt();
		scan.nextLine();

		if (numero < 1 || numero > fonda.getCantidadParticipantes()) {
			System.out.println(">> Error: consumidor inexistente.");
			return;
		}

		String consumidor = fonda.getParticipante(numero - 1);

		double largo = 0;
		double ancho = 0;
		double litros = 0;

		if (tipo == 1) {

			System.out.print("Largo del choripan (cm): ");

			if (!scan.hasNextDouble()) {
				System.out.println(">> Error: largo invalido.");
				scan.nextLine();
				return;
			}

			largo = scan.nextDouble();
			scan.nextLine();

			System.out.print("Ancho del choripan (cm): ");

			if (!scan.hasNextDouble()) {
				System.out.println(">> Error: ancho invalido.");
				scan.nextLine();
				return;
			}

			ancho = scan.nextDouble();
			scan.nextLine();

			if (largo <= 0 || ancho <= 0) {
				System.out.println(">> Error: las medidas deben ser mayores a 0.");
				return;
			}

		} else {

			System.out.print("Litros del terremoto: ");

			if (!scan.hasNextDouble()) {
				System.out.println(">> Error: litros invalidos.");
				scan.nextLine();
				return;
			}

			litros = scan.nextDouble();
			scan.nextLine();

			if (litros <= 0) {
				System.out.println(">> Error: los litros deben ser mayores a 0.");
				return;
			}
		}

		System.out.print("Fecha (YYYY-MM-DD): ");
		String fecha = scan.nextLine();

		String[] partes = fecha.split("-", -1);

		if (partes.length != 3) {
			System.out.println(">> Error: formato de fecha invalido.");
			return;
		}

		if (partes[0].length() != 4 || partes[1].length() != 2 || partes[2].length() != 2) {

			System.out.println(">> Error: formato de fecha invalido.");
			return;
		}

		try {
			int anio = Integer.parseInt(partes[0]);
			int mes = Integer.parseInt(partes[1]);
			int dia = Integer.parseInt(partes[2]);

			if (anio < 1 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {

				System.out.println(">> Error: fecha invalida.");
				return;
			}

		} catch (NumberFormatException e) {
			System.out.println(">> Error: la fecha debe contener numeros.");
			return;
		}

		boolean agregado;

		if (tipo == 1) {
			agregado = fonda.agregarChoripan(consumidor, largo, ancho, fecha);
		} else {
			agregado = fonda.agregarTerremoto(consumidor, litros, fecha);
		}

		if (agregado) {

			if (fonda.guardarConsumos()) {
				System.out.println(">> Registro agregado correctamente.");
			} else {
				System.out.println(">> El registro se agrego, pero no se pudo guardar.");
			}

		} else {
			System.out.println(">> Error: no se pudo agregar el registro.");
		}
	}

	public static void editarRegistro(Scanner scan, Fonda fonda) {

		System.out.println("\n========== EDITAR REGISTRO ==========");
		System.out.println("  [1] Choripan");
		System.out.println("  [2] Terremoto");
		System.out.println("  [3] Cancelar");
		System.out.print("Seleccione una opcion: ");

		if (!scan.hasNextInt()) {
			System.out.println(">> Error: opcion invalida.");
			scan.nextLine();
			return;
		}

		int tipo = scan.nextInt();
		scan.nextLine();

		if (tipo == 3) {
			return;
		}

		if (tipo != 1 && tipo != 2) {
			System.out.println(">> Error: opcion invalida.");
			return;
		}

		int cantidad = 0;

		if (tipo == 1) {
			fonda.mostrarChoripanes();
			cantidad = fonda.getCantidadChoripanes();
		} else {
			fonda.mostrarTerremotos();
			cantidad = fonda.getCantidadTerremotos();
		}

		if (cantidad == 0) {
			System.out.println(">> No hay registros para editar.");
			return;
		}

		System.out.print("Numero del registro a editar: ");

		if (!scan.hasNextInt()) {
			System.out.println(">> Error: numero invalido.");
			scan.nextLine();
			return;
		}

		int numero = scan.nextInt();
		scan.nextLine();

		if (numero < 1 || numero > cantidad) {
			System.out.println(">> Error: registro inexistente.");
			return;
		}

		fonda.mostrarParticipantes();

		System.out.print("Seleccione el nuevo consumidor: ");

		if (!scan.hasNextInt()) {
			System.out.println(">> Error: consumidor invalido.");
			scan.nextLine();
			return;
		}

		int participante = scan.nextInt();
		scan.nextLine();

		if (participante < 1 || participante > fonda.getCantidadParticipantes()) {

			System.out.println(">> Error: consumidor inexistente.");
			return;
		}

		String consumidor = fonda.getParticipante(participante - 1);

		double largo = 0;
		double ancho = 0;
		double litros = 0;

		if (tipo == 1) {

			System.out.print("Nuevo largo (cm): ");

			if (!scan.hasNextDouble()) {
				System.out.println(">> Error: largo invalido.");
				scan.nextLine();
				return;
			}

			largo = scan.nextDouble();
			scan.nextLine();

			System.out.print("Nuevo ancho (cm): ");

			if (!scan.hasNextDouble()) {
				System.out.println(">> Error: ancho invalido.");
				scan.nextLine();
				return;
			}

			ancho = scan.nextDouble();
			scan.nextLine();

			if (!(largo > 0 && largo <= 1000) || !(ancho > 0 && ancho <= 1000)) {

				System.out.println(">> Error: medidas invalidas.");
				return;
			}

		} else {

			System.out.print("Nuevos litros: ");

			if (!scan.hasNextDouble()) {
				System.out.println(">> Error: litros invalidos.");
				scan.nextLine();
				return;
			}

			litros = scan.nextDouble();
			scan.nextLine();

			if (!(litros > 0 && litros <= 1000)) {
				System.out.println(">> Error: litros invalidos.");
				return;
			}
		}

		System.out.print("Nueva fecha (YYYY-MM-DD): ");
		String fecha = scan.nextLine();

		String[] partes = fecha.split("-", -1);

		if (partes.length != 3) {
			System.out.println(">> Error: fecha invalida.");
			return;
		}

		if (partes[0].length() != 4 || partes[1].length() != 2 || partes[2].length() != 2) {

			System.out.println(">> Error: formato de fecha invalido.");
			return;
		}

		try {

			int anio = Integer.parseInt(partes[0]);
			int mes = Integer.parseInt(partes[1]);
			int dia = Integer.parseInt(partes[2]);

			if (anio < 1 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {

				System.out.println(">> Error: fecha invalida.");
				return;
			}

		} catch (NumberFormatException e) {

			System.out.println(">> Error: fecha invalida.");
			return;
		}

		if (tipo == 1) {

			fonda.editarChoripan(numero - 1, consumidor, largo, ancho, fecha);

		} else {

			fonda.editarTerremoto(numero - 1, consumidor, litros, fecha);
		}

		if (fonda.guardarConsumos()) {
			System.out.println(">> Registro editado correctamente.");
		} else {
			System.out.println(">> Registro editado, pero no se pudo guardar.");
		}
	}

	public static void eliminarRegistro(Scanner scan, Fonda fonda) {

		System.out.println("\n========== ELIMINAR REGISTRO ==========");
		System.out.println("  [1] Choripan");
		System.out.println("  [2] Terremoto");
		System.out.println("  [3] Cancelar");
		System.out.print("Seleccione una opcion: ");

		if (!scan.hasNextInt()) {
			System.out.println(">> Error: opcion invalida.");
			scan.nextLine();
			return;
		}

		int tipo = scan.nextInt();
		scan.nextLine();

		if (tipo == 3) {
			return;
		}

		if (tipo != 1 && tipo != 2) {
			System.out.println(">> Error: opcion invalida.");
			return;
		}

		int cantidad = 0;

		if (tipo == 1) {
			fonda.mostrarChoripanes();
			cantidad = fonda.getCantidadChoripanes();
		} else {
			fonda.mostrarTerremotos();
			cantidad = fonda.getCantidadTerremotos();
		}

		if (cantidad == 0) {
			System.out.println(">> No hay registros para eliminar.");
			return;
		}

		System.out.print("Numero del registro a eliminar: ");

		if (!scan.hasNextInt()) {
			System.out.println(">> Error: numero invalido.");
			scan.nextLine();
			return;
		}

		int numero = scan.nextInt();
		scan.nextLine();

		if (numero < 1 || numero > cantidad) {
			System.out.println(">> Error: registro inexistente.");
			return;
		}

		System.out.println("¿Esta seguro de eliminar el registro?");
		System.out.println("  [1] Si");
		System.out.println("  [2] No");
		System.out.print("Seleccione una opcion: ");

		if (!scan.hasNextInt()) {
			System.out.println(">> Error: opcion invalida.");
			scan.nextLine();
			return;
		}

		int confirmar = scan.nextInt();
		scan.nextLine();

		if (confirmar != 1) {
			System.out.println(">> Eliminacion cancelada.");
			return;
		}

		boolean eliminado;

		if (tipo == 1) {
			eliminado = fonda.eliminarChoripan(numero - 1);
		} else {
			eliminado = fonda.eliminarTerremoto(numero - 1);
		}

		if (eliminado) {

			if (fonda.guardarConsumos()) {
				System.out.println(">> Registro eliminado correctamente.");
			} else {
				System.out.println(">> Registro eliminado, pero no se pudo guardar.");
			}

		} else {
			System.out.println(">> Error: no se pudo eliminar el registro.");
		}
	}
}