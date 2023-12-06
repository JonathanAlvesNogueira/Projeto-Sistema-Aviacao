package com.projeto;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BoundaryPrincipal extends Application{
	private BorderPane painelPrincipal = new BorderPane();
	private BoundaryRender passageiroBoundary = new PassageiroBoundary(); 
	@Override
	public void start(Stage stage) throws Exception {
		MenuBar menuPrincipal = new MenuBar();
		Menu menuGestao = new Menu("Gestão");
		MenuItem menuItemPassageiros = new MenuItem("Passageiros");
		menuPrincipal.getMenus().addAll(menuGestao);
		menuGestao.getItems().add(menuItemPassageiros);
		
		menuItemPassageiros.setOnAction( e -> {
						painelPrincipal.setCenter(passageiroBoundary.render());
						System.out.println("Abrir Tela Passageiro");
						});
		
		painelPrincipal.setTop(menuPrincipal);
		painelPrincipal.setCenter(new Label("** Bem-vindo ao Sistema de Aviação RJ!! **"));
		
		Scene cena = new Scene(painelPrincipal, 800, 600);
		stage.setScene(cena);
		stage.setTitle("Sistema de Aviação RJ");
		stage.show();	
	}
	
	public static void main(String[] args) {
		Application.launch(BoundaryPrincipal.class,args);
	}
}


//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class BoundaryPrincipal extends Application {
//
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//
//	
//
//		        primaryStage.setTitle("Tela de Login");
//
//		        // Criando um layout de grade (GridPane)
//		        GridPane grid = new GridPane();
//		        grid.setPadding(new Insets(20, 20, 20, 20));
//		        grid.setVgap(10);
//		        grid.setHgap(10);
//
//		        // Adicionando componentes à grade
//		        grid.add(new Label("Nome:"), 0, 0);
//		        TextField nomeField = new TextField();
//		        grid.add(nomeField, 1, 0);
//
//		        grid.add(new Label("CPF:"), 0, 1);
//		        TextField cpfField = new TextField();
//		        grid.add(cpfField, 1, 1);
//
//		        grid.add(new Label("RG:"), 0, 2);
//		        TextField rgField = new TextField();
//		        grid.add(rgField, 1, 2);
//
//		        grid.add(new Label("Cargo:"), 0, 3);
//		        TextField cargoField = new TextField();
//		        grid.add(cargoField, 1, 3);
//
//		        grid.add(new Label("Cidade:"), 0, 4);
//		        TextField cidadeField = new TextField();
//		        grid.add(cidadeField, 1, 4);
//
//		        Button cadastrarButton = new Button("Cadastrar");
//		        Button consultarButton = new Button("Consultar");
//
//		        // Adicionando botões à grade
//		        grid.add(cadastrarButton, 0, 5);
//		        grid.add(consultarButton, 1, 5);
//
//		        // Configurando a ação do botão Cadastrar
//		        cadastrarButton.setOnAction(e -> {
//		            // Lógica para lidar com o botão Cadastrar
//		            System.out.println("Botão Cadastrar clicado!");
//		        });
//
//		        // Configurando a ação do botão Consultar
//		        consultarButton.setOnAction(e -> {
//		            // Lógica para lidar com o botão Consultar
//		            System.out.println("Botão Consultar clicado!");
//		        });
//
//		        Scene scene = new Scene(grid, 300, 250);
//		        primaryStage.setScene(scene);
//
//		        primaryStage.show();
//		    }
//		
//
//		
//		
//		
//		
//		
//		
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
