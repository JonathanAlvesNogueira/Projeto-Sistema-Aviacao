package com.projeto;

import java.time.LocalDate;

public class Aeroporto {
	private long id = 0;
	private String nome = "";
	private String cidade = "";
	private String sigla = "";
	private LocalDate inauguracao = LocalDate.now();
	private long portoes = 0;
	
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public LocalDate getInauguracao() {
		return inauguracao;
	}
	public void setInauguracao(LocalDate inauguracao) {
		this.inauguracao = inauguracao;
	}
	public long getPortoes() {
		return portoes;
	}
	public void setPortoes(long portoes) {
		this.portoes = portoes;
	}
	
}
