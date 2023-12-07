package com.projeto;

import java.util.List;

public interface AeroportoDAO {
	void cadastrar(Aeroporto a);
	List<Aeroporto> consultarTodos();
	List<Aeroporto> consultarNome(String nome);
}
