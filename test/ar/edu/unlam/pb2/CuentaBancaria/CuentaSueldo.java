package ar.edu.unlam.pb2.CuentaBancaria;

public class CuentaSueldo {
	private Double saldo;
	
	public CuentaSueldo(){
		saldo = 0.0;
	}
	public CuentaSueldo(Double valor){
		saldo = valor;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void saldoInicial() {
		this.saldo = 0.0;
	}

	public void agregarSaldo(Double plata) {
		this.saldo += plata;
	}
	public void retirarDinero(Double saldoAExtraer) {
		this.saldo -= saldoAExtraer;
	}

}
