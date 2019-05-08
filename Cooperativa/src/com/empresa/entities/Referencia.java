package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the referencia database table.
 * 
 */
@Entity
@NamedQuery(name="Referencia.findAll", query="SELECT r FROM Referencia r")
public class Referencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_referencia")
	private int idReferencia;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	private Integer tiempo_conocerse;
	
	public Integer getTiempo_conocerse() {
		return tiempo_conocerse;
	}

	public void setTiempo_conocerse(Integer tiempo_conocerse) {
		this.tiempo_conocerse = tiempo_conocerse;
	}

	public Referencia() {
	}

	public int getIdReferencia() {
		return this.idReferencia;
	}

	public void setIdReferencia(int idReferencia) {
		this.idReferencia = idReferencia;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}