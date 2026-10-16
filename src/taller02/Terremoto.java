package taller02;

public class Terremoto {

	private String consumidor;
	private double litros;
	private String fecha;

	public Terremoto(String consumidor, double litros, String fecha) {
		this.consumidor = consumidor;
		this.litros = litros;
		this.fecha = fecha;
	}

	public String getConsumidor() {
		return consumidor;
	}

	public double getLitros() {
		return litros;
	}

	public String getFecha() {
		return fecha;
	}

	public double calcularKcal() {
		return (litros * 10) / 3;
	}
}