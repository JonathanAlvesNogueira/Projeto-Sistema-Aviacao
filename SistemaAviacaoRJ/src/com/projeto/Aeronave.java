package com.projeto;

public class Aeronave {

	int numeroSerie;
	String modelo;
	int anoFabricao;
	
	
	public Aeronave() {
		
	}
	
	public Aeronave(int numeroSerie, String modelo, int anoFabricao) {
		super();
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
		this.anoFabricao = anoFabricao;
	}
	
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnoFabricao() {
		return anoFabricao;
	}
	public void setAnoFabricao(int anoFabricao) {
		this.anoFabricao = anoFabricao;
	}
	
}
