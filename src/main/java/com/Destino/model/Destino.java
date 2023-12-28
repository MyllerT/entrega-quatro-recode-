package com.Destino.model;

import jakarta.persistence.*;


@Entity
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String checkIn;
	private String checkOut;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Destino() {
	}

	public Destino(String nome, String checkIn, String checkOut, Cliente cliente) {
		this.nome = nome;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.cliente = cliente;
	}

	public Destino(Cliente cliente) {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
