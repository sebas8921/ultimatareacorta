package cr.ac.ulead.entidades;

import java.time.LocalDate;

public class Persona {
	private String nombre;
	private String apellido;
	private String cedula;
	private LocalDate fecha_nac;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDate getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	@Override
	public String toString() {
		return "Persona [\nnombre=" + nombre + "\napellido=" + apellido + "\ncedula=" + cedula + "\nfecha_nac="
				+ fecha_nac + "\n]";
	}

	
	
}
