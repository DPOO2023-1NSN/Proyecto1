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
	
	
	public int getPrecioAdulto() {
		return precioAdulto;
	}

	public void setPrecioAdulto(int precioAdulto) {
		this.precioAdulto = precioAdulto;
	}

	public int getPrecioNinio() {
		return precioNinio;
	}

	public void setPrecioNinio(int precioNinio) {
		this.precioNinio = precioNinio;
	}

	public int getPrecioBalcon() {
		return precioBalcon;
	}

	public void setPrecioBalcon(int precioBalcon) {
		this.precioBalcon = precioBalcon;
	}

	public int getPrecioVista() {
		return precioVista;
	}

	public void setPrecioVista(int precioVista) {
		this.precioVista = precioVista;
	}

	public int getPrecioCocina() {
		return precioCocina;
	}

	public void setPrecioCocina(int precioCocina) {
		this.precioCocina = precioCocina;
	}
	private int precioVista;
	private int precioCocina;
	
	
	public Map<LocalDate, Integer> getPreciosEstandar() {
		return preciosEstandar;
	}
	
	public void setPreciosEstandar(Map<LocalDate, Integer> preciosEstandar) {
		this.preciosEstandar = preciosEstandar;
	}
	public Map<LocalDate, Integer> getPreciosSuit() {
		return preciosSuit;
	}
	public void setPreciosSuit(Map<LocalDate, Integer> preciosSuit) {
		this.preciosSuit = preciosSuit;
	}
	public Map<LocalDate, Integer> getPreciosSuitDoble() {
		return preciosSuitDoble;
	}
	public void setPreciosSuitDoble(Map<LocalDate, Integer> preciosSuitDoble) {
		this.preciosSuitDoble = preciosSuitDoble;
	}
	
}
