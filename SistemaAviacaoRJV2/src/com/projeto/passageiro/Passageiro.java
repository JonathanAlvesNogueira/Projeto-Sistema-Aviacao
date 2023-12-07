package com.projeto.passageiro;

import java.time.LocalDate;

public class Passageiro {

	String nome;
	String cpf;
	String cidade;
	String cargo;
	String RG;
	
	
	public Passageiro(String nome, String cpf, String cidade, String cargo, String rG) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
		this.cargo = cargo;
		this.RG = rG;
		

	}

	
	public Passageiro() {
		
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


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getRG() {
		return RG;
	}


	public void setRG(String rG) {
		RG = rG;
	}

	
	
	
	
	
	
	
	
}
