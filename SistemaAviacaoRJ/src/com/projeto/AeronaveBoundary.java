package com.projeto;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class AeronaveBoundary implements BoundaryRender{

	@Override
	public Pane render() {
		 GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setHgap(10);
		grid.setVgap(10);
		Button buscarAeronavesModelo = new Button("Consultar modelos");
        Button button2 = new Button("Consultar");
        Button button3 = new Button("Cadastrar");

        // Adicionando elementos à grade
        Label lblModelo = new Label("Modelo");
        TextField txtModelo = new TextField();
        grid.add(lblModelo, 0, 0);
        grid.add(txtModelo, 2, 0);
        grid.add(buscarAeronavesModelo, 3, 0);
        Label lblAno = new Label("Ano Fabricação:");
        TextField txtAno = new TextField("");
        grid.add(lblAno, 0, 1); // Coluna 0, Linha 0
        grid.add(txtAno, 2, 1); // Coluna 1, Linha 0
        grid.add(button3, 0, 4);
        grid.add(button2, 1, 4);
        
        
		
		
		
		
		return grid;
	}

	
	
	
	
	
	
	
	
	
	
	
}
