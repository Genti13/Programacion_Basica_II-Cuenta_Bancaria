package ar.edu.unlam.pb2.CuentaBancaria;

public class CuentaAhorros extends Cuenta {
	private Double limiteAdicional;
	private Double deuda;

	CuentaAhorros() {
		super();
		limiteAdicional = 200.0;
		deuda = 0.0;
	}

	CuentaAhorros(Double saldo) {
		super(saldo);
		limiteAdicional = 200.0;
		deuda = 0.0;
	}

	public Double getExtra() {
		return this.limiteAdicional;
	}

	public Double endeudar(Double deuda) {
		return this.deuda = deuda;
	}

	public Double getDeuda() {
		return this.deuda;
	}

}
