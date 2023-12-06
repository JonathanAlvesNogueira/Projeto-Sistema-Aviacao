package com.projeto.passageiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassageiroDAOIML implements PassageiroDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/GESTAOAEROPORTO";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "954150691Joth";
    private Connection con;

    public PassageiroDAOIML() {
        try {
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Passageiro psg) {
        String sql = "INSERT INTO PASSAGEIRO(nome, cpf, rg, cidade, cargo) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, psg.getNome());
            stmt.setString(2, psg.getCpf());
            stmt.setString(3, psg.getRG());
            stmt.setString(4, psg.getCidade());
            stmt.setString(5, psg.getCargo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Passageiro> lerTodos() {
        return pesquisarCpf(""); // Você pode querer implementar um método separado para ler todos os registros.
    }

    @Override
    public List<Passageiro> pesquisarCpf(String cpf) {
        List<Passageiro> lista = new ArrayList<>();
        String sql = "SELECT * FROM PASSAGEIRO WHERE cpf LIKE ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + cpf + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Passageiro a = new Passageiro();
                a.setCpf(rs.getString("cpf"));
                a.setRG(rs.getString("rg"));
                a.setNome(rs.getString("nome"));
                a.setCargo(rs.getString("cargo"));
                a.setCidade(rs.getString("Cidade"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
