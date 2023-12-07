package com.projeto.aeronave;

import java.sql.SQLException;
import java.util.List;

public interface AeronaveDAO {

	public void salvar(Aeronave a) throws SQLException;
	List<Aeronave> lerTodos();
	List<Aeronave> pesquisarModelo(String nome);
}
	
	

