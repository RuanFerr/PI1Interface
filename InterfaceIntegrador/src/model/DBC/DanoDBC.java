/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DBC;

import control.connection.ConnectionFactory;
import java.sql.Connection;
import control.reserva.Dano;
import control.reserva.Equipamento;
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
public class DanoDBC {

    public void insert(Dano dano) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("INSERT INTO Dano (descricaoDano, idEquipamento) values (?, ?)");

            pst.setString(1, dano.getDano());
            pst.setInt(2, dano.getEquip().getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public void update(Dano dano) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Dano set descricaoDano = ?, idEquipamento = ? where idDano = ?");

            pst.setString(1, dano.getDano());
            pst.setInt(2, dano.getEquip().getId());
            pst.setInt(3, dano.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public List<Dano> select() {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<Dano> lista = new ArrayList();

        try {

            pst = conn.prepareStatement("SELECT * from Dano");
            rs = pst.executeQuery();

            while (rs.next()) {

                Dano dano = new Dano();
                dano.setDano(rs.getString("descricao"));
                dano.setId(rs.getInt("idDano"));
                dano.setEquip(new Equipamento());
                dano.getEquip().setId(rs.getInt("idEquipamento"));
                lista.add(dano);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public void delete(Dano dano) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("DELETE FROM Dano WHERE idDano = ?");
            pst.setInt(1, dano.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

}
