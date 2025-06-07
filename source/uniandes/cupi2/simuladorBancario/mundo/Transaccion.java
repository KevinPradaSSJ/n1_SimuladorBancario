package mundo;

public class Transacciones {
	private String tipo;
	private double monto;
	private String fecha;
	private float interes;
	
	public Transacciones(String tipo, double monto, String fecha, int interes) {
		this.tipo = tipo;
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}
}