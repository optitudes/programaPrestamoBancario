package programacion2.parcial3.model;

import java.util.ArrayList;

/**
 * esta clase reprenta la cooperativa,la cual
 * es el centro del programa
 *
 * IngenierÃ­a de sistemas y computaciÃ³n
 *
 * @author(es) Juan Sebastian Rojas - Juan Pablo Cardona
 *
 * Universidad del quindio
 *
 * 2021
**/
public class Cooperativa {
	private String nombre;
	private String nit;

	ArrayList<Cliente> listaClientes= new ArrayList<>();
/**
 * método constructor de la clase cooperativa
 * @param nombre
 * @param nit
 */
	public Cooperativa(String nombre, String nit) {
		super();
		this.nombre = nombre;
		this.nit = nit;
		this.listaClientes=crearClientes();
	}

	private ArrayList<Cliente> crearClientes() {
		ArrayList<Cliente> listaAux= new ArrayList<>();
		Cliente clienteAux=null;

		clienteAux= new Cliente("Maicol", "Robles", "1101191", "31285500124", "Cra 5 8-80", "1001", 100000);
		listaAux.add(clienteAux);


		clienteAux= new Cliente("Rebeca", "Zapata", "1101192", "31285500125", "Cra 6 7-81", "1002", 200000);
		listaAux.add(clienteAux);

		clienteAux= new Cliente("Juan", "Ramirez", "1101193", "31285500126", "Cra 7 8-82", "1003", 300000);
		listaAux.add(clienteAux);

		clienteAux= new Cliente("Laura", "Gonzales", "1101194", "31285500127", "Cra 8 8-83", "1004", 400000);
		listaAux.add(clienteAux);

		clienteAux= new Cliente("Pablo", "Clavijo", "1101195", "31285500128", "Cra 9 8-84", "1005", 500000);
		listaAux.add(clienteAux);

		clienteAux= new Cliente("Brayan", "Guitierrez", "1101196", "31285500129", "Cra 10 8-85", "1006", 600000);
		listaAux.add(clienteAux);

		clienteAux= new Cliente("Nicol", "Londoño", "1101197", "31285500110", "Cra 11 8-86", "1007", 700000);
		listaAux.add(clienteAux);

		clienteAux= new Cliente("Jose", "Robles", "1101198", "31285500111", "Cra 12 12-87", "1008", 800000);
		listaAux.add(clienteAux);

		clienteAux= new Cliente("Antonio", "Gomez", "1101199", "31285500123", "Cra 13 8-88", "1009", 900000);
		listaAux.add(clienteAux);

		clienteAux= new Cliente("Marceline", "Garcia", "1101200", "31285500123", "Cra 14 8-89", "2001", 1000000);
		listaAux.add(clienteAux);


		return listaAux;
	}
	/**
	 * metodo get del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * método set del atributo nombre
	 *
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * metodo get del atributo nit
	 * @return nit
	 */
	public String getNit() {
		return nit;
	}
	/**
	 * método set del atributo nit
	 *
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * método get del arraylist listaClientes
	 * @return listaClientes
	 */
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	/**
	 * metodo set del arraylist listaClientes
	 * @param listaClientes
	 */
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	/**
	 * método que obtiene un cliente usando su numero
	 * de cuenta
	 * @param numCuentaAux
	 * @return clienteaux(retorna null si no encuentra al cliente)
	 */
	public Cliente obtenerCliente(String numCuentaAux) {
		String numCuenta;

		for (Cliente clienteAux : listaClientes) {
			numCuenta=clienteAux.getNumCuenta();
			if(numCuenta.equals(numCuentaAux)){
				return clienteAux;
			}
		}
		return null;
	}
	/**
	 * metodo que obtiene la lista de depositos
	 * @return listaDepositos
	 */
	public ArrayList<Deposito> obtenerListaDepositos() {
		ArrayList<Deposito> listaDepositosAux=new ArrayList<>();

		for (Cliente clienteAux : listaClientes) {
			listaDepositosAux.addAll(clienteAux.obtenerDepositos());
		}
		return listaDepositosAux;
	}
/**
 * método que agrega un deposito que entra por parametro
 * a la lista de transacciones del cliente con el
 * mismo numero de cuenta
 * @param deposito
 * @return agregado(true si se agrego con exito de lo contrario false)
 */
	public boolean crearDeposito(Deposito deposito) {
		String numCuentaBuscar=deposito.getNumCuenta();
		String numCuentaCliente;
		boolean agregado=false;
		Cliente clienteAux=null;

		for (int i = 0; i < listaClientes.size(); i++) {
			clienteAux=listaClientes.get(i);
			numCuentaCliente=clienteAux.getNumCuenta();
			if(numCuentaCliente.equals(numCuentaBuscar))
			{
				if(clienteAux.crearDeposito(deposito))
				{
					agregado=true;
					return agregado;
				}
			}
		}
		return agregado;
	}
	/**
	 * método que verifica si existe un cliente con el
	 * mismo numero de cuenta que ingresa por parametro
	 * @param numCuentaBuscar
	 * @return true si existe false de lo contrario
	 */
	public boolean verificarNumCuenta(String numCuentaBuscar) {
		String numCuenta;
		for (Cliente cliente : listaClientes) {

			numCuenta=cliente.getNumCuenta();
			if(numCuenta.equals(numCuentaBuscar))
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * método que verifica si el saldo de un cliente
	 * es superior al valorAux (ingreesado por parametro)
	 * @param valorAux
	 * @param numCuentaBuscar
	 * @return esInsuficiente(true si el valorAux es mayor que el saldo false de lo contrario)
	 */
	public boolean verificarSaldo(double valorAux, String numCuentaBuscar) {
		boolean esInsuficiente=false;
		String numCuenta;
		for (Cliente cliente : listaClientes) {

			numCuenta=cliente.getNumCuenta();
			if(numCuenta.equals(numCuentaBuscar))
			{
				esInsuficiente=cliente.verificarSaldo(valorAux);
				return esInsuficiente;
			}
		}
		return esInsuficiente;



	}

/**
 * método que agrega un retiro que entra por parametro
 * a la lista de transacciones del cliente con el
 * mismo numero de cuenta
 * @param retiro
 * @return agregado(true si se agrego con exito false de lo contrario)
 */
	public boolean crearRetiro(Retiro retiro) {
		String numCuentaBuscar=retiro.getNumCuenta();
		String numCuentaCliente;
		boolean agregado=false;
		Cliente clienteAux=null;

		for (int i = 0; i < listaClientes.size(); i++) {
			clienteAux=listaClientes.get(i);
			numCuentaCliente=clienteAux.getNumCuenta();
			if(numCuentaCliente.equals(numCuentaBuscar))
			{
				if(clienteAux.crearRetiro(retiro))
				{
					agregado=true;
					return agregado;
				}
			}
		}
		return agregado;
	}

/**
 * método que obtiene la lista de retiros
 * @return listaRetirosAux
 */
	public ArrayList<Retiro> obtenerListaRetiros() {
		ArrayList<Retiro> listaRetirosAux=new ArrayList<>();

		for (Cliente clienteAux : listaClientes) {
			listaRetirosAux.addAll(clienteAux.obtenerRetiros());
		}
		return listaRetirosAux;
	}

}

