/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DBC;

import control.cadastro.Pessoa;
import control.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelli
 */
public class PessoaDBC {

    public void insert(Pessoa pss) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("INSERT INTO Pessoa (nome, email, senha, cargo, CPF) values (?, ?, ?, ?, ?)");

            pst.setString(1, pss.getNome());
            pst.setString(2, pss.getEmail());
            pst.setString(3, pss.getSenha());
            pst.setString(4, pss.getCargo());
            pst.setString(5, pss.getCpf());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public void update(Pessoa pss) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Pessoa set nome = ?, email = ?, senha = ?, cargo = ?, CPF = ? where id = ?");

            pst.setString(1, pss.getNome());

            pst.setString(2, pss.getEmail());
            pst.setString(3, pss.getSenha());
            pst.setString(4, pss.getCargo());

            pst.setString(5, pss.getCpf());
            pst.setString(6, String.valueOf(pss.getId()));

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public List<Pessoa> select() {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<Pessoa> lista = new ArrayList();

        try {

            pst = conn.prepareStatement("SELECT * from Pessoa");
            rs = pst.executeQuery();

            while (rs.next()) {

                Pessoa pss = new Pessoa();
                pss.setNome(rs.getString("nome"));

                pss.setEmail(rs.getString("email"));
                pss.setSenha(rs.getString("senha"));
                pss.setCargo(rs.getString("cargo"));

                pss.setCpf(rs.getString("CPF"));
                pss.setId(rs.getInt("id"));

                lista.add(pss);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public void delete(Pessoa pss) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            pst.setInt(1, pss.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public Pessoa selectPessoa(int id) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;
        Pessoa pss = new Pessoa();

        try {

            pst = conn.prepareStatement("SELECT * from Pessoa where id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {

                pss.setNome(rs.getString("nome"));

                pss.setEmail(rs.getString("email"));
                pss.setSenha(rs.getString("senha"));
                pss.setCargo(rs.getString("cargo"));

                pss.setCpf(rs.getString("CPF"));
                pss.setId(rs.getInt("id"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return pss;

    }

}
