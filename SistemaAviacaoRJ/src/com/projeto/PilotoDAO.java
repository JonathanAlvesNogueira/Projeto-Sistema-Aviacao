package com.projeto;

import java.util.List;

public interface PilotoDAO {
	void cadastrar(Piloto p);
	List<Piloto> consultarTodos();
	List<Piloto> consultarNome(String nome);
}
