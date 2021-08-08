package programacion2.parcial3.model;

/**
 * esta clase es la enumeracio del Tipo de Retiro
 *
 * Ingenieria de sistemas y computacin
 *
 * @author(es) Juan Sebastian Rojas - Juan Pablo Cardona
 *
 * Universidad del quindio
 *
 * 2021
**/
public enum TipoRetiro {

	CAJERO(1),OFICINA(2);
/**
 * Atriburto de la enumeracion
 */
	private int numTipo;

	/**
	 * Contructor de la enumeracion
	 * @param numTipo
	 */
	private TipoRetiro(int numTipo) {
		this.numTipo = numTipo;
	}

	/**
	 * MEtodo get del numero tipo
	 * @return numero tipo
	 */
		public int getNumTipo() {
		return numTipo;
	}

		/**
		 * MEtodo set del numero tipo
		 * @param numTipo
		 */
	public void setNumTipo(int numTipo) {
		this.numTipo = numTipo;
	}


}
