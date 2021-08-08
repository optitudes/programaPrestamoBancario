package programacion2.parcial3.model;

import java.util.Calendar;

/**
 * esta clase reprenta el Retiro, donde esta
 * toda la informacion necesaria para retirar
 * dinero, es una clase hija de Transaccion
 *
 * Ingenieria de sistemas y computacin
 *
 * @author(es) Juan Sebastian Rojas - Juan Pablo Cardona
 *
 * Universidad del quindio
 *
 * 2021
**/
public class Retiro extends Transaccion{

	/**
	 * Atributos de clase
	 */
	private TipoRetiro tipoRetiro;

	public Retiro(String numCuenta, String codigo, String fecha, String hora, double valor, String tipoRetiroAux) {
		super(numCuenta, codigo, fecha, hora, valor);
		this.tipoRetiro=validarTipo(tipoRetiroAux);

	}

	/**
	 * MEtodo que valida el tipo ingresado
	 * @param tipoRetiroAux
	 * @return TipoRetiro
	 */
	private TipoRetiro validarTipo(String tipoRetiroAux) {
		if(tipoRetiroAux.equalsIgnoreCase("CAJERO"))
			return TipoRetiro.CAJERO;
		if(tipoRetiroAux.equalsIgnoreCase("OFICINA"))
			return TipoRetiro.OFICINA;
		return null;
	}
}
