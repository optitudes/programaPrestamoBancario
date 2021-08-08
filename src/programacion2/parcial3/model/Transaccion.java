package programacion2.parcial3.model;

import java.util.Calendar;

/**
 * ésta clase reprenta la transaccion, es la clase padre
 * de Deposito y Retiro
 *
 * Ingeniería de sistemas y computación
 *
 * @author(es) Juan Sebastian Rojas - Juan Pablo Cardona
 *
 * Universidad del quindio
 *
 * 2021
 */
public class Transaccion {
	/**
	 * atributos de la clase
	 */
	private String   numCuenta;
	private String   codigo;
	private String   fecha;
	private String   hora;
	private double   valor;
	/**
	 * método constructor de la clase transaccion
	 * @param numCuenta
	 * @param codigo
	 * @param fecha
	 * @param hora
	 * @param valor
	 */
	public Transaccion(String numCuenta, String codigo, String fecha, String hora, double valor) {
		super();
		this.numCuenta = numCuenta;
		this.codigo = codigo;
		this.fecha = fecha;
		this.hora = hora;
		this.valor = valor;
	}
	/**
	 * método constructor usando la superclase
	 */
	public Transaccion() {
		super();
	}

	/**
	 * metodo get del atributo numero de cuenta
	 * @return numCuenta
	 */
	public String getNumCuenta() {
		return numCuenta;
	}
	/**
	 * metodo set del atributo numCuenta
	 * @param numCuenta
	 */
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	/**
	 * metodo get del atributo codigo
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * metodo set del atributo codigo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * metodo get del atributo fecha
	 * @return fecha
	 */
	public String getFecha() {
		return  fecha;
	}
	/**
	 * metodo set del atributo fecha
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * metodo get del atributo hora
	 * @return hora
	 */
	public String getHora() {
		return hora;
	}
	/**
	 * metodo set del atributo hora
	 * @param hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	/**
	 * metodo get del atributo valor
	 * @return valor
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * metodo set del atributo  valor
	 * @param valor
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * metodo toString de la clase transaccion
	 */
	@Override
	public String toString() {
		return "Transaccion [numCuenta=" + numCuenta + ", codigo=" + codigo + ", fecha=" + fecha + ", hora=" + hora
				+ ", valor=" + valor + "]";
	}



}
