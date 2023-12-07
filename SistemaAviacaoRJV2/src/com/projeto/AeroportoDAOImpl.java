package com.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AeroportoDAOImpl implements AeroportoDAO{

	private static final String JDBC_URL =  "jdbc:mariadb://localhost:3306/aviacao";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;
	
	public AeroportoDAOImpl() { 
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
	public void cadastrar(Aeroporto a) {
		String sql = "INSERT INTO alunos "
				+ "(id, nome, cidade, sigla, inauguracao, portoes) VALUES "
				+ "(?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setLong(1, a.getId());
				stmt.setString(2, a.getNome());
				stmt.setString(3, a.getCidade());
				stmt.setString(4, a.getSigla());
				stmt.setDate(5, java.sql.Date.valueOf(a.getInauguracao()));
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}

	@Override
	public List<Aeroporto> consultarTodos() {
		return consultarNome("");
	}

	@Override
	public List<Aeroporto> consultarNome(String nome) {
		List<Aeroporto> lista = new ArrayList<>();
		String sql = "SELECT * FROM alunos WHERE nome LIKE ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Aeroporto a = new Aeroporto();
				a.setId( rs.getLong("id") );
				a.setNome( rs.getString("nome") );
				a.setCidade( rs.getString("cidade") );
				a.setCidade( rs.getString("sigla") );
				a.setInauguracao( rs.getDate("inauguracao").toLocalDate() );
				a.setPortoes( rs.getLong("portoes") );
				lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
