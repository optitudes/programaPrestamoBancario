package programacion2.parcial3.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * esta clase reprenta al cliente, donde esta
 * toda la informacion perssonal del cliente
 *
 * Ingenieria de sistemas y computacion
 *
 * @author(es) Juan Sebastian Rojas - Juan Pablo Cardona
 *
 * Universidad del quindio
 *
 * 2021
**/

public class Cliente {

	//Atributos de la clase
	private String nombre;
	private String apellido;
	private String cedula;
	private String telefono;
	private String direccion;
	private String numCuenta;
	private double saldo;

	ArrayList<Transaccion> listaTransacciones;

	/**
	 * Constructor de la clase
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param telefono
	 * @param direccion
	 * @param numCuenta
	 * @param saldo
	 */
	public Cliente(String nombre, String apellido, String cedula, String telefono, String direccion, String numCuenta,
			double saldo ) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.telefono = telefono;
		this.direccion = direccion;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.listaTransacciones = new ArrayList<>();
	}

	/**
	 * MEtodo get del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * metodo set del atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * MEtodo get del atributo apellido
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * metodo set del atributo apellido
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * MEtodo get del atributo cedula
	 * @return cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * metodo set del atributo cedula
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * MEtodo get del atributo telefono
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * metodo set del atributo telefono
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * MEtodo get del atributo direccion
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * metodo set del atributo direccion
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * MEtodo get del atributo Numero de cuenta
	 * @return numero de cuenta
	 */
	public String getNumCuenta() {
		return numCuenta;
	}

	/**
	 * metodo set del atributo numero de la cuenta
	 * @param numCuenta
	 */
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	/**
	 * MEtodo get del atributo Saldo
	 * @return saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * metodo set del atributo saldo
	 * @param saldo
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * MEtodo get del atributo listaTransacciones
	 * @return listaTransacciones
	 */
	public ArrayList<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}

	/**
	 * metodo set del atributo lista Transacciones
	 * @param listaTransacciones
	 */
	public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}

	/**
	 * ToString de la clase
	 */
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", numCuenta=" + numCuenta + ", saldo=" + saldo + ", listaTransacciones="
				+ listaTransacciones + "]";
	}
	/**
	 * Metodo crea una lista de tipo deposito y la retorna
	 * @return Lista depositos
	 */
	public Collection<Deposito> obtenerDepositos() {
		ArrayList<Deposito> listaDepositosCliente= new ArrayList<>();
		for(Transaccion transaccion : listaTransacciones) {

			if(transaccion instanceof Deposito)
			{
				listaDepositosCliente.add((Deposito) transaccion);
			}

		}
		return listaDepositosCliente;
	}

	/**
	 * MEtodo que agrega el deposito
	 * a la lista de transacciones
	 * @param deposito
	 * @return creado (true si se puede crear y false de lo contrario
	 */
	public boolean crearDeposito(Deposito deposito) {
		boolean creado=false;
		String codigoAux=deposito.getCodigo();
		if(!verificarExistenciaDeposito(codigoAux))
		{
			double valor=deposito.getValor();
			listaTransacciones.add(deposito);
			this.saldo+=valor;
			creado=true;
			return creado;
		}
		return creado;
	}

	/**
	 * metodo que ceridica la existencia de un deposito
	 * usando el codigo ingresado
	 * @param codigoAux
	 * @return extir (True si existe y de los contrario false)
	 */
	private boolean verificarExistenciaDeposito(String codigoAux) {
		String codigoDeposito;
		boolean existe=false;
		for (Transaccion transaccionAux : listaTransacciones) {
			if(transaccionAux instanceof Deposito)
			{
				codigoDeposito=transaccionAux.getCodigo();
				if(codigoDeposito.equals(codigoAux)){
					existe=true;
					return existe;
				}
			}
		}
		return existe;
	}
/**
 * Metodo que varifica si el saldo ingreado
 * es menor al saldo del cliente
 * @param valorAux
 * @return true si es suficiente y de lo contrario false
 */
	public boolean verificarSaldo(double valorAux) {
		boolean esInsuficiente=false;
		if(valorAux>saldo)
			esInsuficiente=true;
		return esInsuficiente;
	}
/**
 * Metodo que crea un retiro y los agrega a la lista de transacciones
 * y resta el saldo
 * @param retiro
 * @return
 */
	public boolean crearRetiro(Retiro retiro) {
		boolean creado=false;
		String codigoAux=retiro.getCodigo();
		if(!verificarExistenciaRetiro(codigoAux))
		{
			double valor=retiro.getValor();
			listaTransacciones.add(retiro);
			this.saldo-=valor;
			creado=true;
			return creado;
		}
		return creado;

	}

	/**
	 * MEtodo que verifica la existencia de un retiro ya ingresado
	 * usando el codigo dado
	 * @param codigoAux
	 * @return true si existe y de lo contrario false
	 */
	private boolean verificarExistenciaRetiro(String codigoAux) {
		String codigoRetiro;
		boolean existe=false;
		for (Transaccion transaccionAux : listaTransacciones) {
			if(transaccionAux instanceof Retiro)
			{
				codigoRetiro=transaccionAux.getCodigo();
				if(codigoRetiro.equals(codigoAux)){
					existe=true;
					return existe;
				}
			}
		}
		return existe;
	}

	/**
	 * Metodo que obtiene la lista de los retiros y la retorna
	 * @return lista de retiros
	 */
	public Collection<Retiro> obtenerRetiros() {
		ArrayList<Retiro> listaRetirosCliente= new ArrayList<>();
		for(Transaccion transaccion : listaTransacciones) {

			if(transaccion instanceof Retiro)
			{
				listaRetirosCliente.add((Retiro) transaccion);
			}

		}
		return listaRetirosCliente;
	}

}
