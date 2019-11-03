/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DBC;

import control.connection.ConnectionFactory;
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

            pst = conn.prepareStatement("INSERT INTO Reserva (dataHoraReserva, idIEquipamento, nomeResponsavel, CPFResponsavel) values (?, ?, ?, ?)");

            pst.setString(1, res.getDataHoraReserva());
            pst.setInt(2, res.getEquipamento().getId());
            pst.setString(3, res.getNomeResponsavel());
            pst.setLong(4, res.getCpfResp());

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

            pst = conn.prepareStatement("UPDATE Reserva set dataHoraReserva = ?, idEquipamento = ?, nomeResponsavel = ?, cpfResponsavel = ? where id = ?");

            pst.setString(1, res.getDataHoraReserva());
            pst.setInt(2, res.getEquipamento().getId());
            pst.setString(3, res.getNomeResponsavel());
            pst.setLong(4, res.getCpfResp());
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
                res.setCpfResp(rs.getInt("CPFResponsavel"));
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
    
}
