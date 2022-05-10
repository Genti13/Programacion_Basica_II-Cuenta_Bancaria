package ar.edu.unlam.pb2.CuentaBancaria;

import org.junit.Assert;
import org.junit.Test;

public class testCuentaCorriente {

	private static final Double SALDO_INICIAL = 0.0;
	private static final Double SALDO_EN_CUENTA = 300.0;
	private static final Double SALDO_A_DEPOSITAR = 150.0;
	private static final Double SALDO_A_RETIRAR = 250.0;
	private static final Double COSTO_EXTRA = 6.0;
	private static final Integer EXTRACCIONES_REALIZADAS = 6;

	@Test
	public void creoLaCuenta() {
		CuentaCorriente cuenta = cuentaCorriente();
		elSaldoDeberiaSerCero(cuenta);
	}

	@Test
	public void depositoEnLaCuenta() {
		CuentaCorriente cuenta = dadoQueExisteUnaCuenta(SALDO_EN_CUENTA, (Integer) 0);
		Double saldoAnterior = cuenta.getSaldo();

		cuandoDepositoEnLaCuenta(cuenta, SALDO_A_DEPOSITAR);

		elSaldoDeberiaAgregarse(cuenta, saldoAnterior, SALDO_A_DEPOSITAR);
	}

	@Test
	public void extraigoDeLaCuenta() {
		CuentaCorriente cuenta = dadoQueExisteUnaCuenta(SALDO_EN_CUENTA, EXTRACCIONES_REALIZADAS);
		Double saldoAnterior = cuenta.getSaldo();
		Double extra = 0.0;

		extra = cuandoRetiroDeLaCuenta(cuenta, SALDO_A_RETIRAR, extra);

		elSaldoDeberiaDebitarse(cuenta, saldoAnterior, SALDO_A_RETIRAR, extra);
	}

	// Operaciones

	private Double cuandoRetiroDeLaCuenta(CuentaCorriente cuenta, Double saldoARetirar, Double extra) {
		if (cuenta.getExtracciones() != 6) {
			if (cuenta.getSaldo() >= saldoARetirar) {
				cuenta.retirarDinero(saldoARetirar);
				cuenta.realizoExtraccion(cuenta.getExtracciones() + 1);
			}
		} else {
			if (cuenta.getSaldo() >= saldoARetirar + COSTO_EXTRA) {
				cuenta.retirarDinero(saldoARetirar + COSTO_EXTRA);
				cuenta.realizoExtraccion(0);
				extra = COSTO_EXTRA;
			}
		}
		return extra;
	}

	private void cuandoDepositoEnLaCuenta(CuentaCorriente cuenta, Double saldoADepositar) {
		cuenta.agregarSaldo(saldoADepositar);
	}

	// Asserts
	private void elSaldoDeberiaDebitarse(CuentaCorriente cuenta, Double saldoAnterior, Double saldoARetirar,
			Double extra) {
		Assert.assertEquals(cuenta.getSaldo(), (Double) (saldoAnterior - saldoARetirar - extra));
	}

	private void elSaldoDeberiaAgregarse(CuentaCorriente cuenta, Double saldoAnterior, Double saldoADepositar) {
		Assert.assertEquals(cuenta.getSaldo(), (Double) (saldoAnterior + saldoADepositar));
	}

	private void elSaldoDeberiaSerCero(CuentaCorriente cuenta) {
		Assert.assertEquals(SALDO_INICIAL, cuenta.getSaldo());
	}

	// Creo Cuentas
	private CuentaCorriente dadoQueExisteUnaCuenta(Double saldoEnCuenta, Integer extracciones) {
		return new CuentaCorriente(saldoEnCuenta, extracciones);
	}

	private CuentaCorriente cuentaCorriente() {
		return new CuentaCorriente();
	}

}
