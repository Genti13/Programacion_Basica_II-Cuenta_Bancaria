package ar.edu.unlam.pb2.CuentaBancaria;

import org.junit.Assert;
import org.junit.Test;

public class testCuentaSueldo {

	private static final Double SALDOINICIAL = 0.0;
	private static final Double SALDO_A_SUMAR = 170.0;
	private static final Double SALDO_A_EXTRAER = 150.0;
	private static final Double SALDO_EN_CUENTA = 300.0;

	@Test
	public void creoLaCuenta() {

		CuentaSueldo cuenta = cuentaSueldo();

		elSaldoDeberiaSerCero(cuenta);
	}

	@Test
	public void depositoDeLaCuenta() {
		CuentaSueldo cuenta = dadoQueExistecuentaSueldo(SALDO_A_SUMAR);
		Double saldoAnterior = cuenta.getSaldo();

		cuandoDepositoEnLaCuenta(cuenta, SALDO_A_SUMAR);

		elSaldoDeberiaAgregarse(cuenta, saldoAnterior, SALDO_A_SUMAR);
	}

	@Test
	public void extraigoDeLacuenta() {
		CuentaSueldo cuenta = dadoQueExistecuentaSueldo(SALDO_EN_CUENTA);
		Double saldoAnterior = cuenta.getSaldo();

		cuandoExtraigoDeLaCuenta(cuenta, SALDO_A_EXTRAER);

		elSaldoDeberiaDescontarse(cuenta, saldoAnterior, SALDO_A_EXTRAER);
	}

//Operaciones
	private void cuandoExtraigoDeLaCuenta(CuentaSueldo cuenta, Double saldoAExtraer) {
		if (cuenta.getSaldo() - saldoAExtraer >= 0)
			cuenta.retirarDinero(saldoAExtraer);
	}

	private void cuandoDepositoEnLaCuenta(CuentaSueldo cuenta, Double plata) {
		cuenta.agregarSaldo(plata);
	}

//Creo Cuentas
	private CuentaSueldo dadoQueExistecuentaSueldo(Double saldoASumar) {

		return new CuentaSueldo(saldoASumar);
	}

	private CuentaSueldo cuentaSueldo() {
		return new CuentaSueldo();
	}

//Asserts
	private void elSaldoDeberiaSerCero(CuentaSueldo cuenta) {
		Assert.assertEquals(SALDOINICIAL, cuenta.getSaldo());
	}

	private void elSaldoDeberiaDescontarse(CuentaSueldo cuenta, Double saldoAnterior, Double saldoAExtraer) {
		Assert.assertEquals(cuenta.getSaldo(), (Double) (saldoAnterior - saldoAExtraer));
	}

	private void elSaldoDeberiaAgregarse(CuentaSueldo cuenta, Double saldoAnterior, Double saldoASumar) {
		Assert.assertEquals(cuenta.getSaldo(), (Double) (saldoAnterior + saldoASumar));
	}
}