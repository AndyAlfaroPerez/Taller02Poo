package taller02;

public class Choripan {

	private String consumidor;
	private double largo;
	private double ancho;
	private String fecha;

	public Choripan(String consumidor, double largo, double ancho, String fecha) {
		this.consumidor = consumidor;
		this.largo = largo;
		this.ancho = ancho;
		this.fecha = fecha;
	}

	public String getConsumidor() {
		return consumidor;
	}

	public double getLargo() {
		return largo;
	}

	public double getAncho() {
		return ancho;
	}

	public String getFecha() {
		return fecha;
	}

	public double calcularKcal() {
		return (largo * ancho) / 3;
	}
}