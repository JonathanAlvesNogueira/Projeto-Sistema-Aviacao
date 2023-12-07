package com.projeto.passageiro;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PassageiroControl {

    private StringProperty rg = new SimpleStringProperty("");
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty cpf = new SimpleStringProperty("");
    private StringProperty cidade = new SimpleStringProperty("");
    private StringProperty cargo = new SimpleStringProperty("");
    private PassageiroDAO passageiroDAO = new PassageiroDAOIML();
    private ObservableList<Passageiro> lista = FXCollections.observableArrayList();

    PassageiroControl(){
    	
    }
    
    
    public PassageiroControl(StringProperty rg, StringProperty nome, StringProperty cpf, StringProperty cidade,
            StringProperty cargo) {
        super();
        this.rg = rg;
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.cargo = cargo;
    }
    
    

    public StringProperty getRg() {
		return rg;
	}


	public void setRg(StringProperty rg) {
		this.rg = rg;
	}


	public StringProperty getNome() {
		return nome;
	}


	public void setNome(StringProperty nome) {
		this.nome = nome;
	}


	public StringProperty getCpf() {
		return cpf;
	}


	public void setCpf(StringProperty cpf) {
		this.cpf = cpf;
	}


	public StringProperty getCidade() {
		return cidade;
	}


	public void setCidade(StringProperty cidade) {
		this.cidade = cidade;
	}


	public StringProperty getCargo() {
		return cargo;
	}


	public void setCargo(StringProperty cargo) {
		this.cargo = cargo;
	}


	public PassageiroDAO getPassageiroDAO() {
		return passageiroDAO;
	}


	public void setPassageiroDAO(PassageiroDAO passageiroDAO) {
		this.passageiroDAO = passageiroDAO;
	}


	public ObservableList<Passageiro> getLista() {
		return lista;
	}


	public void setLista(ObservableList<Passageiro> lista) {
		this.lista = lista;
	}


	public void salvar() {
        Passageiro a = new Passageiro();
        a.setRG(rg.get());
        a.setNome(nome.get());
        a.setCpf(cpf.get());
        a.setCargo(cargo.get());
        a.setCidade(cidade.get());
        passageiroDAO.salvar(a);
        lerTodos();
    }

    public void lerTodos() {
        List<Passageiro> passageiros = passageiroDAO.lerTodos();
        lista.clear();
        lista.setAll(passageiros);
    }

    public void ler() {
        List<Passageiro> passageiros = passageiroDAO.pesquisarCpf(nome.get());
        lista.clear();
        lista.setAll(passageiros);
    }
}
