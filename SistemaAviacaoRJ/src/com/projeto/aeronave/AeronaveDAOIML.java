package com.projeto.aeronave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AeronaveDAOIML implements AeronaveDAO{

	
	private static final String JDBC_URL =  "jdbc:mysql://localhost:3306/GESTAOAEROPORTO";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "954150691Joth";
	private Connection con;
	
	public AeronaveDAOIML() { 
		try {
//			Class.forName("org.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void salvar(Aeronave a) throws SQLException {
		
		  Statement stmtCriacao = con.createStatement();
		  String criacaoBD = "CREATE DATABASE IF NOT EXISTS GESTAOAEROPORTO";
		  stmtCriacao.execute(criacaoBD);
		  String use = "USE GESTAOAEROPORTO";
		  stmtCriacao.execute(use);
		  
		  String createTableSQL = "CREATE TABLE IF NOT EXISTS AERONAVE ("
                  + "id INT AUTO_INCREMENT PRIMARY KEY,"
                  + "modelo VARCHAR(50),"
                  + "numero_serie VARCHAR(255),"
                  + "ano_fabricacao INT"
                  + ");";
		  
          stmtCriacao.executeUpdate(createTableSQL);
          
          
          System.out.println("Tabela 'aeronave' criada com sucesso!");
		
		
		
		String sql = "INSERT INTO AERONAVE "
				+ "(modelo, numero_serie, ano_fabricacao) VALUES "
				+ "(?, ?, ?);";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, a.getModelo());
				stmt.setString(2, a.getNumeroSerie());
				stmt.setLong(3, a.getAnoFabricao());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}

	@Override
	public List<Aeronave> lerTodos() {
		return pesquisarModelo("");
	}

	@Override
	public List<Aeronave> pesquisarModelo(String nome) {
		List<Aeronave> lista = new ArrayList<>();
		String sql = "SELECT * FROM AERONAVE WHERE modelo LIKE ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Aeronave a = new Aeronave();
				a.setAnoFabricao(rs.getLong("ano_fabricacao"));
				a.setModelo( rs.getString("modelo") );
				a.setNumeroSerie(rs.getString("numero_serie"));
				lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	
	
	
	
	
	
	
	
	
	
}
