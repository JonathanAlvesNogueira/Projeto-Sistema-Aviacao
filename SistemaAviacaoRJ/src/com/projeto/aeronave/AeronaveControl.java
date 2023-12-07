package com.projeto.aeronave;

import java.sql.SQLException;
import java.util.List;

import com.projeto.passageiro.Passageiro;
import com.projeto.passageiro.PassageiroDAO;
import com.projeto.passageiro.PassageiroDAOIML;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AeronaveControl {

	  private StringProperty modelo = new SimpleStringProperty("");
	  private StringProperty numeroSerie = new SimpleStringProperty();
	  private LongProperty anoFabricacao = new SimpleLongProperty();
	
	    private AeronaveDAO aeronaveDAO = new AeronaveDAOIML();
	    private ObservableList<Aeronave> lista = FXCollections.observableArrayList();
	    
	    
	    AeronaveControl(){
	    	
	    }


		public AeronaveControl(StringProperty modelo, StringProperty numeroSerie, LongProperty anoFabricacao) {
			super();
			this.modelo = modelo;
			this.numeroSerie = numeroSerie;
			this.anoFabricacao = anoFabricacao;
		}


		public StringProperty getModelo() {
			return modelo;
		}


		public void setModelo(StringProperty modelo) {
			this.modelo = modelo;
		}


		public StringProperty getNumeroSerie() {
			return numeroSerie;
		}


		public void setNumeroSerie(StringProperty numeroSerie) {
			this.numeroSerie = numeroSerie;
		}


		public LongProperty getAnoFabricacao() {
			return anoFabricacao;
		}


		public void setAnoFabricacao(LongProperty anoFabricacao) {
			this.anoFabricacao = anoFabricacao;
		}


		public AeronaveDAO getPassageiroDAO() {
			return aeronaveDAO;
		}


		public void setPassageiroDAO(AeronaveDAO aeronaveDAO) {
			this.aeronaveDAO = aeronaveDAO;
		}


		public ObservableList<Aeronave> getLista() {
			return lista;
		}


		public void setLista(ObservableList<Aeronave> lista) {
			this.lista = lista;
		}
		
		
		public void salvar() throws SQLException {
			Aeronave a = new Aeronave();
			a.setModelo(modelo.get());
			a.setNumeroSerie(numeroSerie.get());
			a.setAnoFabricao(anoFabricacao.get());
			aeronaveDAO.salvar(a);
			lerTodos();
		}
		
		public void lerTodos() {
			List<Aeronave> aeronaves = aeronaveDAO.lerTodos();
			lista.clear();
			lista.addAll(aeronaves);
		}
		
		public void ler() {
			List<Aeronave> aeronaves = aeronaveDAO.pesquisarModelo(modelo.get());
			lista.clear();
			lista.addAll(aeronaves);
		}
	    
	    
	
	
	
	
	
	
	
	
}
