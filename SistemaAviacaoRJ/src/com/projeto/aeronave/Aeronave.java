package com.projeto.aeronave;

public class Aeronave {

	String numeroSerie;
	String modelo;
	Long anoFabricacao;
	
	
	public Aeronave() {
		
	}
	
	public Aeronave(String numeroSerie, String modelo, Long anoFabricao) {
		super();
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricao;
	}
	
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Long getAnoFabricao() {
		return anoFabricacao;
	}
	public void setAnoFabricao(Long anoFabricao) {
		this.anoFabricacao = anoFabricao;
	}
	
}
