package com.projeto;

import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class PassageiroBoundary implements BoundaryRender{
	public TextField nomeField;
    public TextField cpfField;
    public TextField rgField;
    public TextField cargoField;
    public TextField cidadeField;

    public Pane render() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Adicionando componentes à grade
        grid.add(new Label("Nome:"), 0, 0);
        nomeField = new TextField();
        grid.add(nomeField, 1, 0);

        grid.add(new Label("CPF:"), 0, 1);
        cpfField = new TextField();
        grid.add(cpfField, 1, 1);

        grid.add(new Label("RG:"), 0, 2);
        rgField = new TextField();
        grid.add(rgField, 1, 2);

        grid.add(new Label("Cargo:"), 0, 3);
        cargoField = new TextField();
        grid.add(cargoField, 1, 3);

        grid.add(new Label("Cidade:"), 0, 4);
        cidadeField = new TextField();
        grid.add(cidadeField, 1, 4);

        Button cadastrarButton = new Button("Cadastrar");
        Button consultarButton = new Button("Consultar");

        // Adicionando botões à grade
        grid.add(cadastrarButton, 0, 5);
        grid.add(consultarButton, 1, 5);

        // Configurando a ação do botão Cadastrar
        cadastrarButton.setOnAction(e -> {
            // Lógica para lidar com o botão Cadastrar
            System.out.println("Botão Cadastrar clicado!");
            BancoDados banco = new BancoDados();
            
            String nome = nomeField.getText();
            if(nome == "") {
            	Label lblNome = new Label("Erro nome obrigatorio");
            	grid.add(lblNome, 0, 6);
            }
            String cpf = cpfField.getText();
            if(cpf == "") {
            	Label lblCpf = new Label("Erro cpf obrigatorio");
            	grid.add(lblCpf, 0, 7);
            }
            String rg = rgField.getText();
            String cargo = cargoField.getText();
            String cidade = cidadeField.getText();
            
            
            
            Passageiro psg = new Passageiro(nome,cpf, cidade, cargo, rg);
            if(nome != "" && cpf != "") {
            	  try {
      				banco.salvar(psg);
      			} catch (SQLException e1) {
      				// TODO Auto-generated catch block
      				e1.printStackTrace();
      			}
            }
          
            
            
            
            
            
            
        });

        // Configurando a ação do botão Consultar
        consultarButton.setOnAction(e -> {
            // Lógica para lidar com o botão Consultar
            System.out.println("Botão Consultar clicado!");
            BancoDados banco = new BancoDados();
            String cpfText = cpfField.getText();
//            banco.pesquisarPorNome(cpfText);
            banco.preencherInformacoesPorCPF(cpfField, nomeField, rgField, cidadeField);
            
            
            
        });
        return grid;
	}
}
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.stage.Stage;
//
//
//
//public class PassageiroBoundary extends BorderPane {
//
//
//	private Scene cena1;
//	private Scene cena2;
//	private Scene cena3;
//	private Stage janela;
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		janela = primaryStage;
//		
//		primeiraCena();
//		segundaCena();
//		terceiraCena();
//		janela.setScene(cena1);
//		janela.setTitle("Cadastro Passageiro: ");
//		janela.show();
//	}
//	
//	
//	
//
//	public void primeiraCena() {
//		Button btn = new Button("Cadastrar Passageiro");
//		btn.setOnAction( e -> {
//			janela.setScene(cena2);
//		});
//		HBox hb = new HBox();
//		hb.setAlignment(Pos.CENTER);
//		hb.getChildren().add(btn);
//		
//		cena1 = new Scene(hb, 400, 400);
//		
//		
//		
//		
//	}
//	
//	public void segundaCena() {
//		Button btn2 = new Button("Passo anterior");
//		Button btnFim = new Button("Finalizar");
//		
////		parte da inteligencia da classe
//		btn2.setOnAction(e -> {
//			janela.setScene(cena1);
//		});
//		
//
//		btnFim.setOnAction(e -> {
//			janela.setScene(cena3);
//		});
//		
//
//		
//		HBox hb = new HBox();
//		hb.setAlignment(Pos.CENTER);
//		hb.getChildren().add(btn2);
//		hb.getChildren().add(btnFim);
//		
//		cena2 = new Scene(hb, 400, 400);
//		
//		
//		
//		
//	}
//
//	public void terceiraCena() {
//		Button btn = new Button("Finalizado Cadastro");
//		btn.setOnAction( e -> {
////			verifica dados do cliente. aqui deve se fazer uma leitura 
//		});
//		HBox hb = new HBox();
//		hb.setAlignment(Pos.CENTER);
//		hb.getChildren().add(btn);
//		
//		cena3 = new Scene(hb, 400, 400);
//		
//	}
//	
//}
