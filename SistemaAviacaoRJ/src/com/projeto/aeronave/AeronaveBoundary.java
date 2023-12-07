package com.projeto.aeronave;

import java.sql.SQLException;

import com.projeto.Aeroporto;
import com.projeto.BoundaryRender;
import com.projeto.passageiro.Passageiro;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyIntegerWrapper;
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
import javafx.util.converter.NumberStringConverter;

public class AeronaveBoundary implements BoundaryRender{

	private TableView<Aeronave> table = new TableView<>();
	TextField numeroSerie = new TextField();
	TextField modelo = new TextField();
	TextField anoFabricacao = new TextField();
	Button cadastrarButton = new Button("Cadastrar");
    Button consultarButton = new Button("Consultar");
    AeronaveControl control = new AeronaveControl();
	
    
    

    
    
    public void generateBindings() { 
		Bindings.bindBidirectional(numeroSerie.textProperty(), control.getNumeroSerie());
		Bindings.bindBidirectional(modelo.textProperty(), control.getModelo());
		Bindings.bindBidirectional(anoFabricacao.textProperty(), control.getAnoFabricacao(), new NumberStringConverter());
	

    }

	public void generateTable() { 
		table.setItems( control.getLista() );
			
		TableColumn<Aeronave, String> colNumeroSerie = new TableColumn<>("numeroserie");
		colNumeroSerie.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getNumeroSerie()));
		
		TableColumn<Aeronave, String> colModelo = new TableColumn<>("modelo");
		colModelo.setCellValueFactory(itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getModelo()));
		
		TableColumn<Aeronave, Long> colAnoFabricacao = new TableColumn<>("Id");
		colAnoFabricacao.setCellValueFactory(new PropertyValueFactory<Aeronave, Long>("anofabricacao") );
		

		table.getColumns().add(colAnoFabricacao);
		table.getColumns().add(colModelo);
		table.getColumns().add(colNumeroSerie);

		
		
		
	}

	
	@Override
	public Pane render() {
		BorderPane border = new BorderPane();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Adicionando componentes à grade
        grid.add(new Label("Numero Série:"), 0, 0);
        numeroSerie = new TextField();
        grid.add(numeroSerie, 1, 0);

        grid.add(new Label("Modelo :"), 0, 1);
        modelo = new TextField();
        grid.add(modelo, 1, 1);

        grid.add(new Label("Ano Fabricação:"), 0, 2);
        anoFabricacao = new TextField();
        grid.add(anoFabricacao, 1, 2);


        // Adicionando botões à grade
        grid.add(cadastrarButton, 0, 3);
        grid.add(consultarButton, 1, 3);

        // Configurando a ação do botão Cadastrar
        cadastrarButton.setOnAction(e -> {
        		try {
					control.salvar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        });
        

        // Configurando a ação do botão Consultar
        consultarButton.setOnAction(e -> {
        	control.ler();
        	
        	
        
            
        });
        
       
		generateBindings();
		generateTable();

        border.setTop(grid);
        border.setCenter(table);
        
        return border;
	}

	
	
	
	
	
	
	
	
	
	
	
}
