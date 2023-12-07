package com.projeto.aeronave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projeto.Aeroporto;

public class AeronaveDAOIML implements AeronaveDAO{

	
	private static final String JDBC_URL =  "jdbc:mariadb://localhost:3306/aviacao";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;
	
	public AeronaveDAOIML() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void salvar(Aeronave a) {
		String sql = "INSERT INTO AERONAVES "
				+ "(modelo, numeroserie, anofabricacao) VALUES "
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
		String sql = "SELECT * FROM alunos WHERE nome LIKE ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Aeronave a = new Aeronave();
				a.setAnoFabricao(rs.getLong("anofabricacao"));
				a.setModelo( rs.getString("modelo") );
				a.setNumeroSerie(sql);
				lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	
	
	
	
	
	
	
	
	
	
}
