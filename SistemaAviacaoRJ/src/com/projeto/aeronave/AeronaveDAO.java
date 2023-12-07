package com.projeto.aeronave;

import java.util.List;

public interface AeronaveDAO {

	public void salvar(Aeronave a);
	List<Aeronave> lerTodos();
	List<Aeronave> pesquisarModelo(String nome);
}
	
	

