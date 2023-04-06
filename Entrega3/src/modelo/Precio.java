package modelo;

import java.time.LocalDate;
import java.util.Map;

public class Precio {
	
	private Map <LocalDate, Integer> preciosEstandar;
	private Map <LocalDate, Integer> preciosSuit;
	private Map <LocalDate, Integer> preciosSuitDoble;
	private int precioAdulto;
	private int precioNinio;
	private int precioBalcon;
	private int precioVista;
	private int precioCocina;
	
	
	
	
	public Precio(Map<LocalDate, Integer> preciosEstandar, Map<LocalDate, Integer> preciosSuit,Map<LocalDate, Integer> preciosSuitDoble, int precioAdulto, int precioNinio, int precioBalcon,int precioVista, int precioCocina) {
		this.preciosEstandar = preciosEstandar;
		this.preciosSuit = preciosSuit;
		this.preciosSuitDoble = preciosSuitDoble;
		this.precioAdulto = precioAdulto;
		this.precioNinio = precioNinio;
		this.precioBalcon = precioBalcon;
		this.precioVista = precioVista;
		this.precioCocina = precioCocina;
	}

	public int getPrecioAdulto() {
		return precioAdulto;
	}


	public int getPrecioNinio() {
		return precioNinio;
	}

	public int getPrecioBalcon() {
		return precioBalcon;
	}


	public int getPrecioVista() {
		return precioVista;
	}


	public int getPrecioCocina() {
		return precioCocina;
	}
	
	public Map<LocalDate, Integer> getPreciosEstandar() {
		return preciosEstandar;
	}
	
	public Map<LocalDate, Integer> getPreciosSuit() {
		return preciosSuit;
	}

	public Map<LocalDate, Integer> getPreciosSuitDoble() {
		return preciosSuitDoble;
	}

}
