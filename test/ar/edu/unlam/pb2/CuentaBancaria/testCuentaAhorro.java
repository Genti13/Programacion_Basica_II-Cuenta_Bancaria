package ar.edu.unlam.pb2.CuentaBancaria;

import org.junit.Assert;
import org.junit.Test;

public class testCuentaAhorro {

	private static final Double SALDO_INICIAL = 0.0;
	private static final Double SALDO_EN_CUENTA = 600.0;
	private static final Double SALDO_A_DEPOSITAR = 150.0;
	private static final Double SALDO_A_RETIRAR = 700.0;
	private static final Double COMISION = 1.5;

	@Test
	public void creoUnaCuenta() {

		CuentaAhorros cuenta = creoLaCuenta();

		laCuentaDeberiaEstarVacia(cuenta);

	}

	@Test
	public void depositoEnLaCuenta() {
		CuentaAhorros cuenta = dadoQueExisteUnaCuenta(SALDO_EN_CUENTA);
		Double saldoAnterior = cuenta.getSaldo();

		cuandoDepositoEnLaCuenta(cuenta, SALDO_A_DEPOSITAR);

		elSaldoDebioAumentar(cuenta, SALDO_A_DEPOSITAR, saldoAnterior);
	}

	@Test
	public void extraigoDeLaCuenta() {
		CuentaAhorros cuenta = dadoQueExisteUnaCuenta(SALDO_EN_CUENTA);
		Double saldoAnterior = cuenta.getSaldo();

		cuandoRetiroDeLaCuenta(cuenta, SALDO_A_RETIRAR);

		elSaldoDebioDisminuir(cuenta, SALDO_A_RETIRAR, saldoAnterior);
	}

	// Operaciones

	private void cuandoRetiroDeLaCuenta(CuentaAhorros cuenta, Double saldoARetirar) {
		if (cuenta.getSaldo() >= saldoARetirar) {
			cuenta.retirarDinero(saldoARetirar);
		} else {
			if (cuenta.getSaldo() + cuenta.getExtra() >= saldoARetirar) {
				Double deuda = saldoARetirar - cuenta.getSaldo();
				cuenta.retirarDinero(cuenta.getSaldo());
				cuenta.endeudar(deuda * COMISION);
			}
		}
	}

	private void cuandoDepositoEnLaCuenta(CuentaAhorros cuenta, Double saldoADepositar) {
		cuenta.agregarSaldo(saldoADepositar);
	}

	// Asserts
	private void elSaldoDebioDisminuir(CuentaAhorros cuenta, Double saldoARetirar, Double saldoAnterior) {
		Assert.assertEquals((Double) (cuenta.getSaldo() - cuenta.getDeuda()), (Double) ((saldoAnterior - saldoARetirar) * COMISION));
	}

	private void laCuentaDeberiaEstarVacia(CuentaAhorros cuenta) {
		Assert.assertEquals(cuenta.getSaldo(), SALDO_INICIAL);
	}

	private void elSaldoDebioAumentar(CuentaAhorros cuenta, Double saldoADepositar, Double saldoAnterior) {
		Assert.assertEquals(cuenta.getSaldo(), (Double) (saldoADepositar + saldoAnterior));
	}

	// Creo Cuentas
	private CuentaAhorros creoLaCuenta() {
		return new CuentaAhorros();
	}

	private CuentaAhorros dadoQueExisteUnaCuenta(Double saldoEnCuenta) {
		return new CuentaAhorros(saldoEnCuenta);
	}

}
