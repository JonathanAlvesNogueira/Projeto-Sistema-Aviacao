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

public class AeroportoBoundary implements BoundaryRender {
	private TableView<Aeroporto> table = new TableView<>();
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtCidade = new TextField();
	private TextField txtSigla = new TextField();
	private TextField txtInauguracao = new TextField();
	private TextField txtPortoes = new TextField();
	
	Button btnCadastrar = new Button("Cadastrar");
    Button btnConsultar = new Button("Consultar");
    
    private AeroportoControl control = new AeroportoControl();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public void generateBindings() { 
		Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(txtCidade.textProperty(), control.cidadeProperty());
		Bindings.bindBidirectional(txtSigla.textProperty(), control.siglaProperty());
		LocalDateStringConverter localDtf = new LocalDateStringConverter(dtf, dtf);
		Bindings.bindBidirectional(txtInauguracao.textProperty(), control.inauguracaoProperty(),localDtf);
		Bindings.bindBidirectional(txtPortoes.textProperty(), control.portoesProperty(), new NumberStringConverter());
		
	}  
    
    public void generateTable() { 
		table.setItems( control.getLista() );
			
		TableColumn<Aeroporto, Long> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Aeroporto, Long>("id") );
			
		TableColumn<Aeroporto, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getNome()));
		
		TableColumn<Aeroporto, String> colCidade = new TableColumn<>("Cidade");
		colCidade.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getCidade()));
		
		TableColumn<Aeroporto, String> colSigla = new TableColumn<>("Sigla");
		colSigla.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getSigla()));
		
		TableColumn<Aeroporto, String> colNasc = new TableColumn<>("Inauguracao");
		colNasc.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(dtf.format(itemData.getValue().getInauguracao())));		
		
		TableColumn<Aeroporto, Long> colPortoes = new TableColumn<>("Portoes");
		colPortoes.setCellValueFactory(new PropertyValueFactory<Aeroporto, Long>("portoes") );
		
		table.getColumns().add(colId);
		table.getColumns().add(colNome);
		table.getColumns().add(colCidade);
		table.getColumns().add(colSigla);
		table.getColumns().add(colNasc);
		table.getColumns().add(colPortoes);
		
	}
    
	@SuppressWarnings("exports")
	@Override
	public Pane render() {
		BorderPane border = new BorderPane();
		GridPane grid = new GridPane();
	    grid.setPadding(new Insets(20, 20, 20, 20));
	    grid.setVgap(10);
	    grid.setHgap(10);
        
        grid.add(new Label("Id:"), 0, 0);
        grid.add(txtId, 1, 0);
        
        grid.add(new Label("Nome:"), 0, 1);
        grid.add(txtNome, 1, 1);
        
        grid.add(new Label("Cidade:"), 0, 2);
        grid.add(txtCidade, 1, 2);

        grid.add(new Label("Sigla:"), 0, 3);
        grid.add(txtSigla, 1, 3);

        grid.add(new Label("Inauguração:"), 0, 4);
        grid.add(txtInauguracao, 1, 4);

        grid.add(new Label("Numero de Portões:"), 0, 5);
        grid.add(txtPortoes, 1, 5);

        grid.add(btnCadastrar, 0, 6);
        grid.add(btnConsultar, 1, 6);

        btnCadastrar.setOnAction(e -> control.cadastrar());
        btnConsultar.setOnAction(e -> control.consultar());
        
        generateBindings();
        generateTable();
        
        border.setTop(grid);
        border.setCenter(table);
        
        return border;
	}

}
