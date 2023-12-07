package com.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotoDAOImpl implements PilotoDAO{

	private static final String JDBC_URL =  "jdbc:mariadb://localhost:3306/aviacao";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;
	
	public PilotoDAOImpl() { 
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
	public void cadastrar(Piloto p) {
		String sql = "INSERT INTO pilotos "
				+ "(id, nome, cpf, telefone, admissao, horasDeVoo) VALUES "
				+ "(?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setLong(1, p.getId());
				stmt.setString(2, p.getNome());
				stmt.setString(3, p.getCpf());
				stmt.setString(4, p.getTelefone());
				stmt.setDate(5, java.sql.Date.valueOf(p.getAdmissao()));
				stmt.setLong(6, p.getHorasDeVoo());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}

	@Override
	public List<Piloto> consultarTodos() {
		return consultarNome("");
	}

	@Override
	public List<Piloto> consultarNome(String nome) {
		List<Piloto> lista = new ArrayList<>();
		String sql = "SELECT * FROM pilotos WHERE nome LIKE ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Piloto p = new Piloto();
				p.setId( rs.getLong("id") );
				p.setNome( rs.getString("nome") );
				p.setCpf( rs.getString("cpf") );
				p.setTelefone( rs.getString("telefone") );
				p.setAdmissao( rs.getDate("admissao").toLocalDate() );
				p.setHorasDeVoo( rs.getLong("horasDeVoo") );
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
