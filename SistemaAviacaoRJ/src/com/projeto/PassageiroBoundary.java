package com.projeto;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class PassageiroBoundary extends Application {

	
	private Scene cena1;
	private Scene cena2;
	private Scene cena3;
	private Stage janela;

	@Override
	public void start(Stage primaryStage) throws Exception {
		janela = primaryStage;
		
		primeiraCena();
		segundaCena();
		terceiraCena();
		janela.setScene(cena1);
		janela.setTitle("Cadastro Passageiro: ");
		janela.show();
	}

	public void primeiraCena() {
		Button btn = new Button("Cadastrar Passageiro");
		btn.setOnAction( e -> {
			janela.setScene(cena2);
		});
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().add(btn);
		
		cena1 = new Scene(hb, 400, 400);
		
		
		
		
	}
	
	public void segundaCena() {
		Button btn2 = new Button("Passo anterior");
		Button btnFim = new Button("Finalizar");
		
//		parte da inteligencia da classe
		btn2.setOnAction(e -> {
			janela.setScene(cena1);
		});
		

		btnFim.setOnAction(e -> {
			janela.setScene(cena3);
		});
		

		
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().add(btn2);
		hb.getChildren().add(btnFim);
		
		cena2 = new Scene(hb, 400, 400);
		
		
		
		
	}

	public void terceiraCena() {
		Button btn = new Button("Finalizado Cadastro");
		btn.setOnAction( e -> {
//			verifica dados do cliente. aqui deve se fazer uma leitura 
		});
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().add(btn);
		
		cena3 = new Scene(hb, 400, 400);
		
		
		
		
	}
	

	public static void main(String[] args) {
		launch(args);

	}
	
	
	
}
