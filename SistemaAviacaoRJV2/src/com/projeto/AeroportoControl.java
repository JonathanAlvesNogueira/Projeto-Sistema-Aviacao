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

public class AeroportoControl {
	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty cidade = new SimpleStringProperty("");
	private StringProperty sigla = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> inauguracao = new SimpleObjectProperty<>(LocalDate.now());
	private LongProperty portoes = new SimpleLongProperty(0);
	
	private ObservableList<Aeroporto> lista = FXCollections.observableArrayList();
	private AeroportoDAO aeroportoDAO = new AeroportoDAOImpl();
	
	@SuppressWarnings("exports")
	public LongProperty idProperty() {
		return this.id;
	}

	@SuppressWarnings("exports")
	public StringProperty nomeProperty() {
		return nome;
	}

	@SuppressWarnings("exports")
	public StringProperty cidadeProperty() {
		return cidade;
	}

	@SuppressWarnings("exports")
	public StringProperty siglaProperty() {
		return sigla;
	}

	public ObjectProperty<LocalDate> inauguracaoProperty() {
		return inauguracao;
	}

	@SuppressWarnings("exports")
	public LongProperty portoesProperty() {
		return portoes;
	}

	public ObservableList<Aeroporto> getLista() {
		return lista;
	}
	
	public void cadastrar() {
		Aeroporto a = new Aeroporto();
		a.setId(id.get());
		a.setNome(nome.get());
		a.setCidade(cidade.get());
		a.setSigla(sigla.get());
		a.setInauguracao(inauguracao.get());
		a.setPortoes(portoes.get());
		aeroportoDAO.cadastrar(a);
		consultarTodos();		
	}
	
	public void consultarTodos() {
		List<Aeroporto> aeroportos = aeroportoDAO.consultarTodos();
		lista.clear();
		lista.addAll(aeroportos);
	}
	
	public void consultar() {
		List<Aeroporto> aeroportos = aeroportoDAO.consultarNome(nome.get());
		lista.clear();
		lista.addAll(aeroportos);
	}
	
}
