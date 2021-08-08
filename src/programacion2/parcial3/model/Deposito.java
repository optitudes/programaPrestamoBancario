package programacion2.parcial3.model;

import java.util.Calendar;

/**
 * esta clase reprenta el deposito, donde esta
 * toda la informacion necesaria para depositar
 * dinero, es una clase hija de Transaccion
 *
 * Ingeniería de sistemas y computación
 *
 * @author(es) Juan Sebastian Rojas - Juan Pablo Cardona
 *
 * Universidad del quindio
 *
 * 2021
**/
public class Deposito extends Transaccion{

	//Atributo de la clase
	private double costo;

	/**
	 * Contructor de la clase
	 * @param numCuenta
	 * @param codigo
	 * @param fechaDeposito
	 * @param horaDeposito
	 * @param valor
	 * @param costo
	 */
	public Deposito(String numCuenta, String codigo, String fechaDeposito,
					String horaDeposito, double valor, double costo) {
		super(numCuenta, codigo, fechaDeposito, horaDeposito, valor);
		this.costo=costo;
	}

	/**
	 * ToString dde la clase
	 */
	@Override
	public String toString() {
		return "Deposito [costo=" + costo + ", getNumCuenta()=" + getNumCuenta() + ", getCodigo()=" + getCodigo()
				+ ", getFecha()=" + getFecha() + ", getHora()=" + getHora() + ", getValor()=" + getValor() + "]";
	}

	/**
	 * Metodo get del atributo del costo
	 * @return costo
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * MEtodo set del atributo costo
	 * @param costo
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}

}