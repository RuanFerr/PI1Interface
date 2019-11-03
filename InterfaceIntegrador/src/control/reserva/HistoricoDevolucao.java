/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.reserva;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelli
 */
public class HistoricoDevolucao {
    private Reserva reserva;
    private int idHistorico;
    private String operacao;
    private Date dataOperacao;
    private String nomeFunc;
    private int idFunc;

    private Dano dano;

    public HistoricoDevolucao() {

    }

    public HistoricoDevolucao(Reserva reserva, String operacao, Date dataOperacao, String nomeFunc) {

        this.reserva = reserva;
        this.nomeFunc = nomeFunc;
        this.dataOperacao = dataOperacao;
        this.operacao = operacao;

    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    private static ArrayList<HistoricoDevolucao> historicoDevolucao = new ArrayList();

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public static ArrayList<HistoricoDevolucao> getHistoricoDevolucao() {
        return historicoDevolucao;
    }

    public static void setHistoricoDevolucao(ArrayList<HistoricoDevolucao> historicoDevolucao) {
        HistoricoDevolucao.historicoDevolucao = historicoDevolucao;
    }

    public Dano getDano() {
        return dano;
    }

    public void setDano(Dano dano) {
        this.dano = dano;
    }

    public static boolean registrarDevolucao(Reserva res) {

        boolean resp = false;

        historicoDevolucao.add(new HistoricoDevolucao(res, "Devolucao", new Date(), control.login.Login.getSessao().getNome()));

        for (int i = 0; i < Reserva.reservas.size(); i++) {

            if (Reserva.reservas.get(i) == res) {

                Reserva.reservas.remove(i);

                i = Reserva.reservas.size();

                resp = true;
            }

        };

        return resp;
    }

    public void listarDadosDevolucao() {

    }

}
