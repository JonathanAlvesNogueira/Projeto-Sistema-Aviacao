package com.projeto;

import java.time.LocalDate;

public class Piloto {
	private long id = 0;
	private String nome = "";
	private String cpf = "";
	private String telefone = "";
	private LocalDate admissao = LocalDate.now();
	private long horasDeVoo = 0;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getAdmissao() {
		return admissao;
	}
	public void setAdmissao(LocalDate admissao) {
		this.admissao = admissao;
	}
	public long getHorasDeVoo() {
		return horasDeVoo;
	}
	public void setHorasDeVoo(long horasDeVoo) {
		this.horasDeVoo = horasDeVoo;
	}
	
	
	
}
