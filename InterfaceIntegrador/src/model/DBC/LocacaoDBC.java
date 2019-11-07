/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DBC;

import control.connection.ConnectionFactory;
import control.reserva.Locacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LocacaoDBC {

    public void insert(Locacao loc) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("INSERT INTO Locacao (dataLocacao, idEquipamento, nomeResponsavel, CPFResponsavel, idFuncionario, status) values (?, ?, ?, ?, ?, ?)");

            pst.setString(1, loc.getDataLocacao());
            pst.setInt(2, loc.getIdEquipamento());
            pst.setString(3, loc.getNomeResponsavel());
            pst.setString(4, String.valueOf(loc.getCPFResponsavel()));
            pst.setInt(5, loc.getIdFuncionarioLocacao());
            pst.setString(6, "locado");
            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public void update(Locacao loc) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Locacao set dataLocacao = ?, idEquipamento = ?, nomeResponsavel = ?, cpfResponsavel = ?, idFuncionario = ? where idLocacao = ?");

            pst.setString(1, loc.getDataLocacao());
            pst.setInt(2, loc.getIdEquipamento());
            pst.setString(3, loc.getNomeResponsavel());
            pst.setString(4, loc.getCPFResponsavel());
            pst.setInt(5, loc.getIdFuncionarioLocacao());
            pst.setInt(6, loc.getIdLocacao());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public List<Locacao> select() {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<Locacao> lista = new ArrayList<>();

        try {

            pst = conn.prepareStatement("SELECT * from Locacao");
            rs = pst.executeQuery();

            while (rs.next()) {

                Locacao loc = new Locacao();
                loc.setDataLocacao(rs.getString("dataLocacao"));
                loc.setIdLocacao(rs.getInt("idLocacao"));
                loc.setNomeResponsavel(rs.getString("nomeResponsavel"));
                loc.setCPFResponsavel(rs.getString("CPFResponsavel"));
                loc.setIdFuncionarioLocacao(rs.getInt("idFuncionario"));
                loc.setIdEquipamento(rs.getInt("idEquipamento"));
                loc.setStatus(rs.getString("status"));
                lista.add(loc);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public void delete(Locacao loc) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("DELETE FROM Locacao WHERE id = ?");
            pst.setInt(1, loc.getIdEquipamento());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public Locacao selectLocacao(int id) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        Locacao loc = new Locacao();

        try {

            pst = conn.prepareStatement("SELECT * from Locacao where idLocacao = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {

                loc.setDataLocacao(rs.getString("dataLocacao"));
                loc.setIdLocacao(rs.getInt("idLocacao"));
                loc.setNomeResponsavel(rs.getString("nomeResponsavel"));
                loc.setCPFResponsavel(rs.getString("CPFResponsavel"));
                loc.setIdFuncionarioLocacao(rs.getInt("idFuncionario"));
                loc.setIdEquipamento(rs.getInt("idEquipamento"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return loc;

    }

    public void atrasado(Locacao loc) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Locacao set status = ? where idLocacao = ?");

            pst.setString(1, "atrasado");
            pst.setInt(2, loc.getIdLocacao());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public void devolveLocacao(Locacao loc) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Locacao set status = ? where idLocacao = ?");

            pst.setString(1, "devolvido");
            pst.setInt(2, loc.getIdLocacao());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

}
