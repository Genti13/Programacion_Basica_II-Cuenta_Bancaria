package ar.edu.unlam.pb2.CuentaBancaria;

public abstract class Cuenta {
	protected Double saldo;

	public Cuenta() {
		this.saldo = 0.0;
	}

	public Cuenta(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void agregarSaldo(Double monto) {
		this.saldo += monto;
	}
	
	public void retirarDinero(Double monto) {
		this.saldo -= monto;
	}

}
