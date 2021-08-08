package programacion2.parcial3.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import programacion2.parcial3.Aplicacion;
import programacion2.parcial3.model.Cliente;
import programacion2.parcial3.model.Deposito;
import programacion2.parcial3.model.Retiro;
import programacion2.parcial3.model.TipoRetiro;
/**
 * clasee que funciona como controlador de la
 * vista y sirve de enlace entre la vista ya mencionada
 * y la clase aplicación
 * @author Juan Sebastian Rojas - Juan Pablo Cardona
 *
 */
public class CooperativaTransaccionesController {

	ObservableList<Cliente> listaClientesData = FXCollections.observableArrayList();
	ObservableList<Deposito> listaDepositosData = FXCollections.observableArrayList();
	ObservableList<Retiro> listaRetirosData = FXCollections.observableArrayList();

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Retiro, String> columnNumeroCuentaRetiro;

    @FXML
    private ComboBox<TipoRetiro> comboTipoRetiro;

    @FXML
    private Label labelFechaDeposito;

    @FXML
    private TableColumn<Retiro, String> columnValorRetiro;

    @FXML
    private TextField txtCedula;

    @FXML
    private TableColumn<Cliente, String> columnNombreCliente;

    @FXML
    private TextField txtValorDeposito;

    @FXML
    private TableView<Cliente> tableClientes;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumCuentaClienteBuscar;

    @FXML
    private TextField txtNumCuentaRetiro;

    @FXML
    private Label labelHoraRetiro;

    @FXML
    private Button btnAgregarDepositoAction;

    @FXML
    private TableColumn<Retiro, String> columnFechaRetiro;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TableColumn<Deposito, String> columnValorDeposito;

    @FXML
    private Button btnActualizarRetiro;

    @FXML
    private TextField txtApellido;

    @FXML
    private Button btnAgregarRetiro;

    @FXML
    private TableView<Retiro> tableRetiro;

    @FXML
    private Button btnActualizarDeposito;

    @FXML
    private TableColumn<Deposito, String> columnFechaDeposito;

    @FXML
    private TableColumn<Cliente, String> columnNumeroCuentaCliente;

    @FXML
    private TableColumn<Deposito, String> columnCodigoDeposito;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtCodigoRetiro;

    @FXML
    private TableView<Deposito> tableDeposito;

    @FXML
    private Button btnEliminarRetiro;

    @FXML
    private TextField txtNumCuenta;

    @FXML
    private Button btnBuscarCliente;

    @FXML
    private TextField txtCostoDeposito;

    @FXML
    private Button btnNuevoRetiro;

    @FXML
    private Button btnNuevoDeposito;

    @FXML
    private TextField txtValorRetiro;

    @FXML
    private TableColumn<Retiro, String> columnCodigoRetiro;

    @FXML
    private Label labelFechaRetiro;

    @FXML
    private TextField txtNumCuentaDeposito;

    @FXML
    private Label labelHoraDeposito;

    @FXML
    private Button btnEliminarDeposito;

    @FXML
    private TableColumn<Cliente, String> columnApellidoCliente;

    @FXML
    private TableColumn<Deposito, String> columnNumCuentaDeposito;

    @FXML
    private TextField txtCodigoDeposito;

    @FXML
    private TextField txtSaldo;

    private Aplicacion aplicacion;

    public Aplicacion getAplicacion() {
		return aplicacion;
	}
/*
 * método que setea la aplicación y los
 * datos de las tablas
 */
    public void setAplicacion(Aplicacion aplicacion) {

    	this.aplicacion = aplicacion;

    	tableClientes.getItems().clear();
		tableClientes.setItems(getListaClientesData());

		tableDeposito.getItems().clear();
		tableDeposito.setItems(getListaDepositosData());

		tableRetiro.getItems().clear();
		tableRetiro.setItems(getListaRetirosData());

	}
    /**
     * método que obtiene la lista de retiros de la
     * clse aplicacion, la transforma a obserbablelist
     * y la retorna
     * @return listaRetirosData
     */
private ObservableList<Retiro> getListaRetirosData() {

	listaRetirosData.addAll(aplicacion.obtenerRetiros());

	return listaRetirosData;
	}
/**
 * método que obtiene la lista de depositos de la
 * clse aplicacion, la transforma a obserbablelist
 * y la retorna
 * @return listaDepositossData
 */
private ObservableList<Deposito> getListaDepositosData() {

	listaDepositosData.addAll(aplicacion.obtenerDepositos());

	return listaDepositosData;
	}
/**
 * método qeu obtiene los clientes de la clase aplicación
 * y los retorna como un obserbablelist
 * @return listaclientesData(lista de los clientes registrados)
 */
    public ObservableList<Cliente> getListaClientesData() {

		listaClientesData.addAll(aplicacion.obtenerClientes());

		return listaClientesData;
	}

    @FXML
    void buscarClienteAction(ActionEvent event) {
    	buscarCliente();
    }
/**
 * método que busca un cliente usando su numero de cuenta
 * al encontrarlo setea los datos en la interfa, si n o lo
 * encuentra genera una ventana informando el error
 */
    private void buscarCliente() {
		String numCuentaAux = txtNumCuentaClienteBuscar.getText();

		Cliente clienteAux  = null;

		if(!numCuentaAux.isEmpty()){
			clienteAux=aplicacion.buscarCliente(numCuentaAux);
			if(clienteAux != null){
				mostrarDatos(clienteAux);
			}else{
				mostrarMensaje("Advertencia", "Cliente no encontrado",
						"El numero de cuenta ingresado no pertene a ningun cliente", AlertType.WARNING);
			}
		}else{
			mostrarMensaje("Error", "Número de cuenta no valido",
							"Debe ingresar el numero de cuenta en la caja adyacente al boton buscar", AlertType.ERROR);
		}

	}
/**
 * método que setea los datos del cliente encontrado
 * en las casillas de la interfaz
 * @param clienteAux
 */
	private void mostrarDatos(Cliente clienteAux) {
		String saldoAux=""+clienteAux.getSaldo();

		txtNombre.setText   (clienteAux.getNombre());
		txtApellido.setText (clienteAux.getApellido());
		txtCedula.setText   (clienteAux.getCedula());
		txtDireccion.setText(clienteAux.getDireccion());
		txtNumCuenta.setText(clienteAux.getNumCuenta());
		txtTelefono.setText (clienteAux.getTelefono());
		txtSaldo.setText    (saldoAux);

	}

	@FXML
    void nuevoDepositoAction(ActionEvent event) {
		nuevoDeposito();
    }

	@FXML
    void agregarDepositoAction(ActionEvent event) {
		agregarDeposito();
    }



    @FXML
    void nuevoRetiroAction(ActionEvent event) {
    	nuevoRetiro();
    }

	@FXML
    void agregarRetiroAction(ActionEvent event) {
		agregarRetiro();
    }

	@FXML
    void actualizarRetiroAction(ActionEvent event) {

    }

    @FXML
    void eliminarRetiroAction(ActionEvent event) {

    }
/**
 * método que inicializa el constructor, define los atributos de
 * las columnas de las tablas y crea el combobox
 */
    @FXML
    void initialize() {

    	this.columnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.columnApellidoCliente.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	this.columnNumeroCuentaCliente.setCellValueFactory(new PropertyValueFactory<>("numCuenta"));

    	this.columnCodigoDeposito.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	this.columnNumCuentaDeposito.setCellValueFactory(new PropertyValueFactory<>("numCuenta"));
    	this.columnValorDeposito.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	this.columnFechaDeposito.setCellValueFactory(new PropertyValueFactory<>("fecha"));

    	this.columnCodigoRetiro.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	this.columnNumeroCuentaRetiro.setCellValueFactory(new PropertyValueFactory<>("numCuenta"));
    	this.columnValorRetiro.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	this.columnFechaRetiro.setCellValueFactory(new PropertyValueFactory<>("fecha"));

    	comboTipoRetiro.getItems().addAll(TipoRetiro.CAJERO, TipoRetiro.OFICINA);

    }
/**
 * método que imprime un mensaje por ventana según el tipo
 * @param titulo
 * @param header
 * @param contenido
 * @param alertType
 */
    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle      (titulo);
    	alert.setHeaderText (header);
    	alert.setContentText(contenido);
    	alert.showAndWait   ();
	}
/**
 * método que llena las casillas del tab deposito con
 * el fin de orientar al usuario
 */
    private void nuevoDeposito() {
    	LocalDate fecha= LocalDate.now();
    	LocalTime hora= LocalTime.now();

    	txtCodigoDeposito.setText("Ingrese el codigo del deposito");
    	txtNumCuentaDeposito.setText("Ingrese el numero  de cuenta");
    	labelFechaDeposito.setText(fecha+"");
    	labelHoraDeposito.setText(hora+"");
    	txtCostoDeposito.setText("Ingrese el costo del deposito");
    	txtValorDeposito.setText("Ingrese el valor del deposito");


	}
    /**
     * método que llena las casillas del tab retiro con
     * el fin de orientar al usuario
     */
    private void nuevoRetiro() {
    	LocalDate fecha= LocalDate.now();
    	LocalTime hora= LocalTime.now();

    	txtCodigoRetiro.setText("Ingrese el codigo del retiro");
    	txtNumCuentaRetiro.setText("Ingrese el numero  de cuenta");
    	labelFechaRetiro.setText(fecha+"");
    	labelHoraRetiro.setText(hora+"");
    	txtValorRetiro.setText("Ingrese el valor del retiro");

	}
    /**
     * método que toma los valores de las celdas del tab deposito
     * las valida y crea un deposito.
     */
    private void agregarDeposito() {

    	String codigoDeposito   =txtCodigoDeposito.getText();
    	String numCuentaDeposito=txtNumCuentaDeposito.getText();
    	String fechaDeposito    =labelFechaDeposito.getText();
    	String horaDeposito     =labelHoraDeposito.getText();
    	String costoDeposito    =txtCodigoDeposito.getText();
    	String valorDeposito    =txtValorDeposito.getText();

    	double costoAux;
		double valorAux;

    	if(validarDatosDepositos(codigoDeposito, numCuentaDeposito, fechaDeposito, horaDeposito, costoDeposito, valorDeposito) == true){

    		Deposito deposito = null;

    		costoAux=Double.parseDouble(costoDeposito);
    		valorAux=Double.parseDouble(valorDeposito);

    		deposito=new Deposito(numCuentaDeposito, codigoDeposito, fechaDeposito, horaDeposito, valorAux, costoAux);
    		if(aplicacion.crearDeposito(deposito)){
    			listaDepositosData.add(deposito);

        		mostrarMensaje("Notificación Deposito", "Deposito registrado", "El deposito se ha registrado con éxtio", AlertType.INFORMATION);

    		}else{
    			mostrarMensaje("Notificación Deposito", "Deposito no registrado", "El deposito con codigo "+codigoDeposito+" ya se encuentra registrado", AlertType.ERROR);
    		}
    	}
    }
    /**
     * método que toma los valores de las celdas del tab retiro
     * las valida y crea un retiro.
     */
    private void agregarRetiro() {

    	String codigoRetiro   =txtCodigoRetiro.getText();
    	String numCuentaRetiro=txtNumCuentaRetiro.getText();
    	String fechaRetiro    =labelFechaRetiro.getText();
    	String horaRetiro     =labelHoraRetiro.getText();
    	String valorRetiro    =txtValorRetiro.getText();
    	String tipoRetiro     =comboTipoRetiro.getTypeSelector();
		double valorAux;

    	if(validarDatosRetiro(codigoRetiro, numCuentaRetiro, fechaRetiro, horaRetiro,valorRetiro,tipoRetiro) == true){

    		Retiro retiro = null;

    		valorAux=Double.parseDouble(valorRetiro);

    		retiro=new Retiro(numCuentaRetiro, codigoRetiro, fechaRetiro, horaRetiro, valorAux, tipoRetiro);

    		if(aplicacion.crearRetiro(retiro)){
    			listaRetirosData.add(retiro);

        		mostrarMensaje("Notificación Retiro", "Retiro  registrado", "El retiro se ha registrado con éxtio", AlertType.INFORMATION);

    		}else{
    			mostrarMensaje("Notificación Retiro", "Retiro no registrado", "El retiro con codigo "+codigoRetiro+" ya se encuentra registrado", AlertType.ERROR);
    		}
    	}
    }
/**
 * método que valida los datos capturados y define
 * si son aptos o no para crear un retiro
 * @param codigoRetiro
 * @param numCuentaRetiro
 * @param fechaRetiro
 * @param horaRetiro
 * @param valorRetiro
 * @param tipoRetiro
 * @return (true si son aptos, false si no)
 */
	private boolean validarDatosRetiro(String codigoRetiro, String numCuentaRetiro, String fechaRetiro,
			String horaRetiro, String valorRetiro, String tipoRetiro) {
		String mensaje="";
		double costoAux;
		double valorAux;
		if(codigoRetiro == null || codigoRetiro.equals(""))
			mensaje += "El codigo del retiro es invalido \n";

		if(numCuentaRetiro == null || numCuentaRetiro.equals(""))
			mensaje += "El número de cuenta del retiro no es invalido \n";

		if(valorRetiro == null || valorRetiro.equals(""))
			mensaje += "El valor del retiro es invalido \n";

		if(tipoRetiro == null || tipoRetiro.equals(""))
			mensaje += "El tipo del retiro es invalido \n";

		valorAux=Double.parseDouble(valorRetiro);

		if(valorAux<0)
			mensaje += "El valor del retiro no puede ser negativo \n";



		if(!aplicacion.verificarNumCuenta(numCuentaRetiro)){
			mensaje+="El numero de cuenta no coincide con ninguna cuenta registrada";
		}else{
			if(aplicacion.verificarSaldo(valorAux,numCuentaRetiro)){
				mensaje+= "el valor del reetiro es superior al saldo";
			}
		}

		if(mensaje.equals("")){
			return true;

		}else{
			mostrarMensaje("Información del deposito", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}
/**
 * método que valida los datos capturados y define
 * si son aptos o no para crear un deposito
 * @param codigoDeposito
 * @param numCuentaDeposito
 * @param fechaDeposito
 * @param horaDeposito
 * @param costoDeposito
 * @param valorDeposito
 * @return (true si son aptos, falase si no)
 */
    private boolean validarDatosDepositos(String codigoDeposito, String numCuentaDeposito, String fechaDeposito,
    		String horaDeposito, String costoDeposito, String valorDeposito) {
		String mensaje="";
		double costoAux;
		double valorAux;
		if(codigoDeposito == null || codigoDeposito.equals(""))
			mensaje += "El codigo del deposito es invalido \n";

		if(numCuentaDeposito == null || numCuentaDeposito.equals(""))
			mensaje += "El número de cuenta del deposito es invalido \n";

		if(costoDeposito == null || costoDeposito.equals(""))
			mensaje += "El costo del deposito es invalido \n";

		if(valorDeposito == null || valorDeposito.equals(""))
			mensaje += "El valor del deposito es invalido \n";

		costoAux=Double.parseDouble(costoDeposito);
		valorAux=Double.parseDouble(valorDeposito);

		if(costoAux < 0)
			mensaje+= "El costo no puede ser negativo";
		if(!aplicacion.verificarNumCuenta(numCuentaDeposito))
			mensaje+="El numero de cuenta no coincide con ninguna cuenta registrada";


		if(valorAux < 0)
			mensaje+= "El valor no puede ser negativo";

		if(mensaje.equals("")){
			return true;

		}else{
			mostrarMensaje("Información del deposito", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}
}
