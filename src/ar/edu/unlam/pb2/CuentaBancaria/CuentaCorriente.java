package ar.edu.unlam.pb2.CuentaBancaria;

public class CuentaCorriente extends Cuenta {

	private Integer extracciones;

	public CuentaCorriente() {
		super();
		this.extracciones = 0;
	}
	
	public CuentaCorriente(Double saldo, Integer extracciones)
	{
		super(saldo);
		this.extracciones = extracciones;
	}

	public void realizoExtraccion(Integer extracciones) {
		this.extracciones = extracciones;
	}

	public int getExtracciones() {
		return this.extracciones;
	}

}
