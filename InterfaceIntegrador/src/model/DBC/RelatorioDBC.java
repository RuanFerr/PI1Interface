/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DBC;

import control.connection.ConnectionFactory;
import control.reserva.Dano;
import control.reserva.HistoricoDevolucao;
import control.reserva.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelli
 */
public class RelatorioDBC {

    public void insert(HistoricoDevolucao hist) throws ParseException {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("INSERT INTO relatorio (idDano, idReserva, nomePessoa, CPFPessoa, Situacao, idFuncionario, data) values (?, ?, ?, ?, ?, ?, ?)");

            pst.setInt(1, hist.getDano().getId());
            pst.setInt(2, hist.getReserva().getIdReserva());
            pst.setString(3, hist.getReserva().getNomeResponsavel());
            pst.setInt(4, ( (int) hist.getReserva().getCpfResp()));

            String data = hist.getReserva().getDataHoraReserva();
            data = Reserva.verSituacao(data);
            pst.setString(5, data);
            pst.setInt(6, hist.getIdFunc());
            pst.setString(7, control.reserva.Reserva.formatador.format(hist.getDataOperacao()));

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public void update(HistoricoDevolucao hist) throws ParseException {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("UPDATE Relatorio set idDano = ?, idReserva = ?, nomePessoa = ?, CPFPessoa = ?, Situacao = ?, idFuncionario = ?, data = ? where idRelatorio = ?");

            pst.setInt(1, hist.getDano().getId());
            pst.setInt(2, hist.getReserva().getIdReserva());
            pst.setString(3, hist.getReserva().getNomeResponsavel());
            pst.setInt(4, ( (int) hist.getReserva().getCpfResp()));
            String data = hist.getReserva().getDataHoraReserva();

            pst.setString(5, Reserva.verSituacao(data));

            pst.setInt(6, hist.getIdFunc());
            pst.setString(7, control.reserva.Reserva.formatador.format(hist.getDataOperacao()));
            pst.setInt(8, hist.getIdHistorico());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    public List<HistoricoDevolucao> select() throws ParseException {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        List<HistoricoDevolucao> lista = new ArrayList();

        try {

            pst = conn.prepareStatement("SELECT * from Equipamento");
            rs = pst.executeQuery();

            while (rs.next()) {

                HistoricoDevolucao hist = new HistoricoDevolucao();
                hist.setIdHistorico(rs.getInt("idRelatorio"));
                hist.setDano(new Dano());
                hist.getDano().setId(rs.getInt("idDano"));
                hist.setReserva(new Reserva());
                hist.getReserva().setIdReserva(rs.getInt("idReserva"));
                hist.getReserva().setNomeResponsavel(rs.getString("nomePessoa"));
                hist.getReserva().setCpfResp(rs.getInt("CPFPessoa"));
                hist.getReserva().setSituacao(rs.getString("Situacao"));
                String data = rs.getString("data");
                hist.setDataOperacao(control.reserva.Reserva.formatador.parse(data));
                lista.add(hist);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return lista;

    }

    public void delete(HistoricoDevolucao hist) {

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement("DELETE FROM Relatorio WHERE id = ?");
            pst.setInt(1, hist.getIdHistorico());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

}
