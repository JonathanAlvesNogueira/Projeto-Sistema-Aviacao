package com.projeto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BancoDados {


	public static final String JDBC_URL= "jdbc:mariadb://localhost:3307";
	public static final String JDBC_USER="root";
	public static final String JDBC_PASS="alunofatec";
	private Connection con;
	
	public BancoDados() {
		try {
			System.out.println("Banco Iniciado");
			Class.forName("org.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Passageiro psg) throws SQLException {
		
		Statement stmt2 = con.createStatement();
//		CRIA TABELA SE NÃO EXISTIR
		
		
	    String tabela = "CREATE TABLE IF NOT EXISTS PASSAGEIRO("
	    		+ "ID_PASSAGEIRO INT AUTO_INCREMENT PRIMARY KEY"
	    		+ "NOME VARCHAR(50) NOT NULL"
	    		+ "CPF CHAR(11) NOT NULL)"
	    		+ "RG CHAR(9)"
	    		+ "CIDADE VARCHAR(20)"
	    		+ "CARGO VARCHAR(50)";
		
	    stmt2.execute(tabela);
		System.out.println("Criando tabela Passageiro");
		
		String sql = "INSERT INTO psgteste (nome, cpf, rg, cidade, cargo, dataPublicacao) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, psg.getNome());
			stmt.setString(2, psg.getRG());
			stmt.setString(3, psg.getCpf());
			stmt.setString(4, psg.getCidade());
			stmt.setString(4, psg.getCargo());
			stmt.setDate(5, Date.valueOf(psg.getDataPublicacao()));
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Passageiro> lerTodos() {
		return pesquisarPorNome("");
	}

	public List<Passageiro> pesquisarPorNome(String titulo) {
		
		List<Passageiro> lista = new ArrayList<>();
		String sql = "SELECT * FROM psgteste WHERE titulopsg LIKE ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + titulo + "%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) { 
//				Passageiro passageiro = new Passageiro();
//				passageiro.set(rs.getString("tituloPassageiro"));
////				passageiro.setDescricaoPassageiro(rs.getString("descricaoPassageiro"));
//				lista.add(passageiro);
			}
		} catch (Exception e){
			e.printStackTrace();
		}

		return lista;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	

