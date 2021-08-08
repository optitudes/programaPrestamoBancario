package programacion2.parcial3;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import programacion2.parcial3.controller.CooperativaTransaccionesController;
import programacion2.parcial3.model.Cliente;
import programacion2.parcial3.model.Cooperativa;
import programacion2.parcial3.model.Deposito;
import programacion2.parcial3.model.Retiro;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * clase aplicación, esta clase contiene la interacción entre el
 * controlador y el modelo
 * @author Juan sebastian rojas- Juan Pablo Cardona
 *
 */
public class Aplicacion extends Application {
	private Stage primaryStage;

	Cooperativa cooperativa = new Cooperativa("Cooperativa", "1022");
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Cooperativa");
			mostrarVentanaPrincipal();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * metodo que carga la vista del programa y le asigna n controlador y
	 * la clase main
	 */
private void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/CooperativaTransaccionesView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();
			CooperativaTransaccionesController cooperativaTransaccionesControler = loader.getController();
			cooperativaTransaccionesControler.setAplicacion(this);


			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * método que obtiene los clientes registrados
 * de la clase cooperativa
 * @return listaClientes(ArrayList)
 */
public ArrayList<Cliente> obtenerClientes() {

	return cooperativa.getListaClientes();
}
/**
 * método que obtiene un cliente usando su numero de
 * cuenta como parametro, si no lo encuentra
 * retorna null
 * @param numCuentaAux
 * @return clienteAux(Cliente encontrado)
 */
public Cliente buscarCliente(String numCuentaAux) {

	Cliente clienteAux = null;

	clienteAux=cooperativa.obtenerCliente(numCuentaAux);

	return clienteAux;
}
/**
 * Metodo que obtiene la lista de depositos
 * de la clase cooperativa
 * @return listaDespositosAux (lista de depositos)
 */
public ArrayList<Deposito> obtenerDepositos() {

	ArrayList<Deposito> listaDepositosAux= new ArrayList<>();

	listaDepositosAux=cooperativa.obtenerListaDepositos();

	return listaDepositosAux;
}

/**
 * Metodo envia un deposito a la
 * clase cooperativa para ser creado
 * @param deposito
 * @return creado(true si fue creado de lo contrario false)
 */
public boolean crearDeposito(Deposito deposito) {
	boolean creado;
	creado=cooperativa.crearDeposito(deposito);
	return creado;
}

public boolean verificarNumCuenta(String numCuentaBuscar) {
	boolean respuesta;
	respuesta=cooperativa.verificarNumCuenta(numCuentaBuscar);
	return respuesta;
}

/**
 * Metodo que envia un valor auxiliar y numero de la cuenta
 * a la clase cooperativa para verificar si el saldo de la cuenta
 * es mayor al valor
 * @param valorAux
 * @param numCuentaRetiro
 * @return respuesta (True si el saldo es mayor al valorAux de lo
 * contrario false)
 */
public boolean verificarSaldo(double valorAux, String numCuentaRetiro) {
	boolean respuesta;
	respuesta=cooperativa.verificarSaldo(valorAux,numCuentaRetiro);
	return respuesta;
}

/**
 * Metodo que manda el retiro a la clase cooperativa para
 * que sea añadido al cliente
 * @param retiro
 * @return creado (True si fue creado de lo contrario false)
 */
public boolean crearRetiro(Retiro retiro) {
	boolean creado;
	creado=cooperativa.crearRetiro(retiro);
	return creado;
}

/**
 * Metodo que obtiene las lista de retiros
 * de la clase cooperativa
 * @return listaRetiros
 */
public ArrayList<Retiro> obtenerRetiros() {

	ArrayList<Retiro> listaRetirosAux= new ArrayList<>();

	listaRetirosAux=cooperativa.obtenerListaRetiros();

	return listaRetirosAux;
}
}
