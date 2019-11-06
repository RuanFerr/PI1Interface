package control.reserva;

import control.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Equipamento {

    private String nome;
    private String marca;
    private String descricao;
    private int numSerie;
    private int id;

    private static ArrayList<Equipamento> logEquipamento = new ArrayList();

    public Equipamento() {
    }

    public Equipamento(String nome, String marca, String descricao, int numSerie) {
        this.nome = nome;
        this.marca = marca;
        this.descricao = descricao;
        this.numSerie = numSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Equipamento> getLogEquipamento() {
        return logEquipamento;
    }

    public static boolean testaNumSerieUnico(String numSerie) {

        boolean num = testaNumSerie(numSerie);
        boolean result = false;

        if (num) {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement pst = null;

            ResultSet rs = null;

            List<Equipamento> lista = new ArrayList();

            try {

                pst = conn.prepareStatement("SELECT idEquipamento from Equipamento where idEquipamento = ?");

                pst.setInt(1, Integer.parseInt(numSerie));

                rs = pst.executeQuery();

                result = (rs.getFetchSize() == 0);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
            } finally {
                ConnectionFactory.closeConnection(conn, pst, rs);
            }

        }
        return result && num;
    }

    private static boolean testaNumSerie(String numSerie) {
        boolean test = false;
        try {
            int num = Integer.parseInt(numSerie);
            test = true;
        } catch (NumberFormatException e) {
            test = false;
        }
        return test;
    }
}
