/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DBC;

import control.connection.ConnectionFactory;
import control.reserva.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EquipamentoDBC {

    public void insert(Equipamento equip) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("INSERT INTO Equipamento (nome, descricao, numSerie, marca) values (?, ?, ?, ?)");

            pst.setString(1, equip.getNome());
            pst.setString(2, equip.getDescricao());
            pst.setInt(3, equip.getNumSerie());
            pst.setString(4, equip.getMarca());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public void update(Equipamento equip) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Equipamento set nome = ?, descricao = ?, numSerie = ?, marca = ? where idEquipamento = ?");

            pst.setString(1, equip.getNome());
            pst.setString(2, equip.getDescricao());
            pst.setInt(3, equip.getNumSerie());
            pst.setString(4, equip.getMarca());
            pst.setInt(5, equip.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public List<Equipamento> select() {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<Equipamento> lista = new ArrayList();

        try {

            pst = conn.prepareStatement("SELECT * from Equipamento");
            rs = pst.executeQuery();

            while (rs.next()) {

                Equipamento equip = new Equipamento(
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("descricao"),
                        rs.getInt("numSerie"));
                equip.setId(rs.getInt("idEquipamento"));
                lista.add(equip);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public void delete(Equipamento equipamento) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("DELETE FROM Equipamento WHERE idEquipamento = ?");
            pst.setInt(1, equipamento.getId());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public List<Equipamento> selectComData(String busca, String data) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<Equipamento> lista = new ArrayList();

        try {
            if (busca.equals("locados")) {
                pst = conn.prepareStatement("SELECT Equipamento.*, Reserva.dataHoraReserva from Equipamento join Reserva on Reserva.idEquipamento = Equipamento.idEquipamento where dataHoraReserva = ?");
            } else {
                pst = conn.prepareStatement("SELECT Equipamento.*, Reserva.dataHoraReserva from Equipamento join Reserva on Reserva.idEquipamento = Equipamento.idEquipamento where dataHoraReserva != ?");
            }

            pst.setString(1, data);

            rs = pst.executeQuery();

            while (rs.next()) {

                if (rs.getString("dataHoraReserva").equals(data)) {
                    Equipamento equip = new Equipamento(
                            rs.getString("nome"),
                            rs.getString("marca"),
                            rs.getString("descricao"),
                            rs.getInt("numSerie"));
                    equip.setId(rs.getInt("idEquipamento"));
                    lista.add(equip);

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public Equipamento selectEquip(int id) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        Equipamento equip = new Equipamento();

        try {

            pst = conn.prepareStatement("SELECT nome, marca, descricao, numSerie from Equipamento where idEquipamento = ?");
            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {

                equip.setId(id);
                equip.setNome(rs.getString("nome"));

                equip.setMarca(rs.getString("marca"));

                equip.setDescricao(rs.getString("descricao"));

                equip.setNumSerie(rs.getInt("numSerie"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return equip;

    }

}
