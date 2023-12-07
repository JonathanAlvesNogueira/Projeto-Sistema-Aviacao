package com.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.passageiro.Passageiro;

import javafx.scene.control.TextField;

public class BancoDados {


	public static final String JDBC_URL= "jdbc:mysql://localhost:3306";
	public static final String JDBC_USER="root";
	public static final String JDBC_PASS="";
	private Connection con;
	
	public BancoDados() {
		try {
			System.out.println("Banco Iniciado");
//			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			Statement stmt2 = con.createStatement();
//			CRIA TABELA SE NÃO EXISTIR
			stmt2.execute("USE GESTAOAEROPORTO;");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Passageiro psg) throws SQLException {
		
		Statement stmt2 = con.createStatement();
//		CRIA TABELA SE NÃO EXISTIR
		stmt2.execute("USE GESTAOAEROPORTO;");
	 
		String tabela = "CREATE TABLE IF NOT EXISTS PASSAGEIRO ("
		        + "ID_PASSAGEIRO INT AUTO_INCREMENT PRIMARY KEY, "
		        + "NOME VARCHAR(50) NOT NULL, "
		        + "CPF CHAR(11) NOT NULL, "
		        + "RG CHAR(9), "
		        + "CIDADE VARCHAR(20), "
		        + "CARGO VARCHAR(50)"
		        + ")";
		
	    stmt2.execute(tabela);
		System.out.println("Criando tabela Passageiro");
		
		
		String sql = "INSERT INTO PASSAGEIRO(nome, cpf, rg, cidade, cargo) VALUES(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			System.out.println(psg.getNome());
			stmt.setString(1, psg.getNome());
			stmt.setString(2, psg.getCpf());
			stmt.setString(3, psg.getRG());
			stmt.setString(4, psg.getCidade());
			stmt.setString(5, psg.getCargo());
		
			stmt.executeUpdate();
			System.out.println("Insert feito");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

//	public List<Passageiro> lerTodos() {
//		return pesquisarPorNome("");
//	}

	
	public void preencherInformacoesPorCPF(TextField cpfField, TextField nomeField, TextField rgField, TextField cidadeField) {
        String cpf = cpfField.getText();

        // Substitua "SUA_QUERY_SQL" pela consulta SQL real que você precisa
        String sql = "SELECT nome, rg, cidade FROM PASSAGEIRO WHERE CPF = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Preencher os campos com as informações obtidas do banco de dados
                String nome = rs.getString("nome");
                String rg = rs.getString("rg");
                String cidade = rs.getString("cidade");

                // Verificar se os campos não estão vazios antes de definir os valores
                if (!nome.isEmpty()) {
                    nomeField.setText(nome);
                }
                if (!rg.isEmpty()) {
                    rgField.setText(rg);
                }
                if (!cidade.isEmpty()) {
                    cidadeField.setText(cidade);
                }
            } else {
                // Lidar com o caso em que nenhum resultado é encontrado para o CPF
                System.out.println("Nenhuma informação encontrada para o CPF: " + cpf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções SQL, se necessário
        }
    }
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	

