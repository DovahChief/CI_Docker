package com.sixdelta.exposp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.sixdelta.exposp.model.Cuenta;
import java.util.*;
import javax.persistence.CascadeType;

@Entity
public class Cliente {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Nombre;
	private String Direccion;
	private String Correo;
	private String Telefono;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn (name="id_cliente")
	private List<Cuenta> cuenta;
	
	public List<Cuenta> getCuenta() {
		return cuenta;
	}
	public void setCuenta(List<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	

}
