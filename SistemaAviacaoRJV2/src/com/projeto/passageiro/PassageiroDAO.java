package com.projeto.passageiro;

import java.util.List;

public interface PassageiroDAO {

	void salvar(Passageiro a);
	List<Passageiro> lerTodos();
	List<Passageiro> pesquisarCpf(String cpf);
	
	
	
}
