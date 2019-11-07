/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DBC;

import control.connection.ConnectionFactory;
import control.reserva.Equipamento;
import control.reserva.Reserva;
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
public class ReservaDBC {

    public void insert(Reserva res) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("INSERT INTO Reserva (dataHoraReserva, idEquipamento, nomeResponsavel, CPFResponsavel, status) values (?, ?, ?, ?, ?)");

            pst.setString(1, res.getDataHoraReserva());
            pst.setInt(2, res.getEquipamento().getId());
            pst.setString(3, res.getNomeResponsavel());
            pst.setString(4, String.valueOf(res.getCpfResp()));
            pst.setString(5, "Reservado");

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public void update(Reserva res) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Reserva set dataHoraReserva = ?, idEquipamento = ?, nomeResponsavel = ?, CPFResponsavel = ? where id = ?");

            pst.setString(1, res.getDataHoraReserva());
            pst.setInt(2, res.getEquipamento().getId());
            pst.setString(3, res.getNomeResponsavel());
            pst.setString(4, String.valueOf(res.getCpfResp()));
            pst.setInt(5, res.getIdReserva());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public List<Reserva> select() {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<Reserva> lista = new ArrayList();

        try {

            pst = conn.prepareStatement("SELECT * from Reserva");
            rs = pst.executeQuery();

            while (rs.next()) {

                Reserva res = new Reserva();
                res.setDataHoraReserva(rs.getString("dataHoraReserva"));
                res.setIdReserva(rs.getInt("id"));
                res.setNomeResponsavel(rs.getString("nomeResponsavel"));
                res.setEquipamento(new Equipamento());
                res.getEquipamento().setId(rs.getInt("idEquipamento"));
                res.setStatus(rs.getString("Status"));
                res.setCpfResp((rs.getString("CPFResponsavel")));
                lista.add(res);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public void delete(Reserva res) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("DELETE FROM Reserva WHERE id = ?");
            pst.setInt(1, res.getIdReserva());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public List<Reserva> selectData(String data) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<Reserva> lista = new ArrayList<>();

        try {

            pst = conn.prepareStatement("SELECT * from Reserva where dataHoraReserva = ?");
            pst.setString(1, data);
            rs = pst.executeQuery();

            while (rs.next()) {

                Reserva res = new Reserva();
                res.setDataHoraReserva(rs.getString("dataHoraReserva"));
                res.setIdReserva(rs.getInt("id"));
                res.setNomeResponsavel(rs.getString("nomeResponsavel"));
                res.setEquipamento(new Equipamento());
                res.getEquipamento().setId(rs.getInt("idEquipamento"));
                res.setCpfResp((rs.getString("CPFResponsavel")));
                res.setStatus(rs.getString("Status"));
                lista.add(res);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public List<Reserva> selectComData(String data) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<Reserva> lista = new ArrayList();

        try {

            pst = conn.prepareStatement("SELECT * from Reserva where dataHoraReserva = ?");
            pst.setString(1, data);
            rs = pst.executeQuery();

            while (rs.next()) {

                Reserva res = new Reserva();
                res.setDataHoraReserva(rs.getString("dataHoraReserva"));
                res.setIdReserva(rs.getInt("id"));
                res.setNomeResponsavel(rs.getString("nomeResponsavel"));
                res.setEquipamento(new Equipamento());
                res.getEquipamento().setId(rs.getInt("idEquipamento"));
                res.setCpfResp((rs.getString("CPFResponsavel")));
                lista.add(res);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public Reserva selectReserva(int id) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        Reserva res = new Reserva();

        try {

            pst = conn.prepareStatement("SELECT * from Reserva where id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {

                res.setDataHoraReserva(rs.getString("dataHoraReserva"));
                res.setIdReserva(rs.getInt("id"));
                res.setNomeResponsavel(rs.getString("nomeResponsavel"));
                res.setEquipamento(new Equipamento());
                res.getEquipamento().setId(rs.getInt("idEquipamento"));
                res.setCpfResp((rs.getString("CPFResponsavel")));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return res;

    }

    public void locarReserva(Reserva res) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Reserva set status = ? where id = ?");

            pst.setString(1, "locado");
            pst.setInt(2, res.getIdReserva());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

}
