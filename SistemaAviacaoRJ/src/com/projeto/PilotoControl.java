package com.projeto;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PilotoControl {
	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty cpf = new SimpleStringProperty("");
	private StringProperty telefone = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> admissao = new SimpleObjectProperty<>(LocalDate.now());
	private LongProperty horasDeVoo = new SimpleLongProperty(0);
	
	private ObservableList<Piloto> lista = FXCollections.observableArrayList();
	private PilotoDAO pilotoDAO = new PilotoDAOImpl();
	
	@SuppressWarnings("exports")
	public LongProperty idProperty() {
		return this.id;
	}

	@SuppressWarnings("exports")
	public StringProperty nomeProperty() {
		return nome;
	}

	@SuppressWarnings("exports")
	public StringProperty cpfProperty() {
		return cpf;
	}

	@SuppressWarnings("exports")
	public StringProperty telefoneProperty() {
		return telefone;
	}

	public ObjectProperty<LocalDate> admissaoProperty() {
		return admissao;
	}

	@SuppressWarnings("exports")
	public LongProperty horasDeVooProperty() {
		return horasDeVoo;
	}

	public ObservableList<Piloto> getLista() {
		return lista;
	}
	
	public void cadastrar() {
		Piloto p = new Piloto();
		p.setId(id.get());
		p.setNome(nome.get());
		p.setCpf(cpf.get());
		p.setTelefone(telefone.get());
		p.setAdmissao(admissao.get());
		p.setHorasDeVoo(horasDeVoo.get());
		pilotoDAO.cadastrar(p);
		consultarTodos();		
	}
	
	public void consultarTodos() {
		List<Piloto> pilotos = pilotoDAO.consultarTodos();
		lista.clear();
		lista.addAll(pilotos);
	}
	
	public void consultar() {
		List<Piloto> pilotos = pilotoDAO.consultarNome(nome.get());
		lista.clear();
		lista.addAll(pilotos);
	}
	
}
