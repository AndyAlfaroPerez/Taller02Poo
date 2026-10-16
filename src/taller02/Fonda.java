package taller02;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Fonda {

	private String[] participantes = new String[200];
	private int cantidadParticipantes = 0;

	private Choripan[] choripanes = new Choripan[200];
	private int cantidadChoripanes = 0;

	private Terremoto[] terremotos = new Terremoto[200];
	private int cantidadTerremotos = 0;

	public void cargarParticipantes() {

		try {
			Scanner archivo = new Scanner(new File("Participantes.txt"));

			while (archivo.hasNextLine()) {

				String linea = archivo.nextLine().trim();

				if (!linea.isEmpty() && cantidadParticipantes < 200) {
					participantes[cantidadParticipantes] = linea;
					cantidadParticipantes++;
				}
			}

			archivo.close();

		} catch (IOException e) {
			System.out.println("Error al cargar Participantes.txt");
		}
	}

	public void cargarConsumos() {

		try {
			Scanner archivo = new Scanner(new File("Consumido.txt"));

			while (archivo.hasNextLine()) {

				String linea = archivo.nextLine().trim();
				String[] datos = linea.split(";");

				try {

					if (datos.length == 5 && datos[0].equals("Choripan") && cantidadChoripanes < 200) {

						String consumidor = datos[1];
						double largo = Double.parseDouble(datos[2]);
						double ancho = Double.parseDouble(datos[3]);
						String fecha = datos[4];

						if (largo > 0 && ancho > 0 && !consumidor.isEmpty() && !fecha.isEmpty()) {

							choripanes[cantidadChoripanes] = new Choripan(consumidor, largo, ancho, fecha);

							cantidadChoripanes++;
						}

					} else if (datos.length == 4 && datos[0].equals("Terremoto") && cantidadTerremotos < 200) {

						String consumidor = datos[1];
						double litros = Double.parseDouble(datos[2]);
						String fecha = datos[3];

						if (litros > 0 && !consumidor.isEmpty() && !fecha.isEmpty()) {

							terremotos[cantidadTerremotos] = new Terremoto(consumidor, litros, fecha);

							cantidadTerremotos++;
						}
					}

				} catch (NumberFormatException e) {
					System.out.println("Registro invalido: " + linea);
				}
			}

			archivo.close();

		} catch (IOException e) {
			System.out.println("Error al cargar Consumido.txt");
		}
	}

	public String espacios(String texto, int largo) {

		while (texto.length() < largo) {
			texto = texto + " ";
		}

		return texto;
	}

	public double redondear(double numero) {

		int entero = (int) (numero * 100 + 0.5);

		return entero / 100.0;
	}

	public void mostrarChoripanes() {

		System.out.println("=============== CHORIPANES =================");
		System.out.println("  #   Consumidor     Largo    Ancho    Fecha         KCal");

		for (int i = 0; i < cantidadChoripanes; i++) {

			Choripan c = choripanes[i];

			System.out.println(
					espacios("  " + (i + 1), 6) + espacios(c.getConsumidor(), 15) + espacios(c.getLargo() + " cm", 9) + espacios(c.getAncho() + " cm", 9) + espacios(c.getFecha(), 14) + redondear(c.calcularKcal()));
		}

		System.out.println("----------------------------------------------------------");
		System.out.println("  Total: " + cantidadChoripanes + " choripanes registrados");
		System.out.println("==========================================================");
		
		
	}

	public void mostrarTerremotos() {

		double totalLitros = 0;

		System.out.println("=============== TERREMOTOS =================");
		System.out.println("  #   Consumidor     Litros     Fecha         KCal");

		for (int i = 0; i < cantidadTerremotos; i++) {

			Terremoto t = terremotos[i];

			System.out.println(espacios("  " + (i + 1), 6) + espacios(t.getConsumidor(), 15) + espacios(t.getLitros() + " L", 11) + espacios(t.getFecha(), 14) + redondear(t.calcularKcal()));

			totalLitros = totalLitros + t.getLitros();
		}

		System.out.println("----------------------------------------------------------");
		System.out.println("  Total: " + cantidadTerremotos + " terremotos registrados (" + totalLitros + " L)");
		System.out.println("==========================================================");
	}

	public int getCantidadParticipantes() {
		return cantidadParticipantes;
	}

	public int getCantidadRegistros() {
		return cantidadChoripanes + cantidadTerremotos;
	}
}