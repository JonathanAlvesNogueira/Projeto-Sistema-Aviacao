package com.projeto;

import java.time.format.DateTimeFormatter;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

public class PilotoBoundary implements BoundaryRender {
	private TableView<Piloto> table = new TableView<>();
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtCpf = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtAdmissao = new TextField();
	private TextField txtHorasDeVoo = new TextField();
	
	Button btnCadastrar = new Button("Cadastrar Piloto");
    Button btnConsultar = new Button("Consultar Piloto por Nome");
    
    private PilotoControl control = new PilotoControl();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public void generateBindings() { 
		Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(txtCpf.textProperty(), control.cpfProperty());
		Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
		LocalDateStringConverter localDtf = new LocalDateStringConverter(dtf, dtf);
		Bindings.bindBidirectional(txtAdmissao.textProperty(), control.admissaoProperty(),localDtf);
		Bindings.bindBidirectional(txtHorasDeVoo.textProperty(), control.horasDeVooProperty(), new NumberStringConverter());
		
	}  
    
    public void generateTable() { 
		table.setItems( control.getLista() );
			
		TableColumn<Piloto, Long> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Piloto, Long>("id") );
			
		TableColumn<Piloto, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getNome()));
		
		TableColumn<Piloto, String> colCpf = new TableColumn<>("CPF");
		colCpf.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getCpf()));
		
		TableColumn<Piloto, String> colTel = new TableColumn<>("Telefone");
		colTel.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getTelefone()));
		
		TableColumn<Piloto, String> colAdm = new TableColumn<>("Admissao");
		colAdm.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(dtf.format(itemData.getValue().getAdmissao())));		
		
		TableColumn<Piloto, Long> colHoras = new TableColumn<>("Horas de Voo");
		colHoras.setCellValueFactory(new PropertyValueFactory<Piloto, Long>("horasDeVoo") );
		
		table.getColumns().add(colId);
		table.getColumns().add(colNome);
		table.getColumns().add(colCpf);
		table.getColumns().add(colTel);
		table.getColumns().add(colAdm);
		table.getColumns().add(colHoras);
		
	}
    
	@SuppressWarnings("exports")
	@Override
	public Pane render() {
		BorderPane border = new BorderPane();
		GridPane grid = new GridPane();
	    grid.setPadding(new Insets(20, 20, 20, 20));
	    grid.setVgap(10);
	    grid.setHgap(10);
        
	    grid.add(new Label("GESTÃO DE PILOTOS"), 0, 0);
	    
        grid.add(new Label("Id do Piloto:"), 0, 1);
        grid.add(txtId, 1, 1);
        
        grid.add(new Label("Nome do Piloto:"), 0, 2);
        grid.add(txtNome, 1, 2);
        
        grid.add(new Label("CPF:"), 0, 3);
        grid.add(txtCpf, 1, 3);

        grid.add(new Label("Telefone : +55 "), 0, 4);
        grid.add(txtTelefone, 1, 4);

        grid.add(new Label("Data de Admissão:"), 0, 5);
        grid.add(txtAdmissao, 1, 5);

        grid.add(new Label("Horas de Voo:"), 0, 6);
        grid.add(txtHorasDeVoo, 1, 6);

        grid.add(btnCadastrar, 0, 7);
        grid.add(btnConsultar, 1, 7);

        btnCadastrar.setOnAction(e -> control.cadastrar());
        btnConsultar.setOnAction(e -> control.consultar());
        
        generateBindings();
        generateTable();
        
        border.setTop(grid);
        border.setCenter(table);
        
        return border;
	}

}
