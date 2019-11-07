package control.login;

import javax.swing.JOptionPane;
import control.cadastro.*;
import java.sql.Connection;
import java.util.ArrayList;
import control.connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Login {

    private static ArrayList<Pessoa> grpPessoa = new ArrayList();

    private static Pessoa sessao;

    public static ArrayList<Pessoa> getGrpPessoa() {
        return grpPessoa;
    }

    public static void setGrpPessoa(ArrayList<Pessoa> grpPessoa) {
        Login.grpPessoa = grpPessoa;
    }

    public static Pessoa getSessao() {
        return sessao;
    }

    public static void setSessao(Pessoa sessao) {
        Login.sessao = sessao;
    }

    //este metodo faz login do banco
    public static boolean BDlogin(String email, String senha) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean auth = false;
        Pessoa pss;
        try {

            pst = con.prepareStatement("SELECT * from pessoa where email = ? AND senha = ?");
            pst.setString(1, email);

            pst.setString(2, senha);

            rs = pst.executeQuery();

            while (rs.next()) {

                pss = new Pessoa();
                pss.setNome(rs.getString("nome"));

                pss.setEmail(rs.getString("email"));
                pss.setSenha(rs.getString("senha"));

                pss.setCargo(rs.getString("cargo"));

                pss.setCpf(rs.getString("CPF"));
                pss.setId(rs.getInt("id"));

                auth = true;
                sessao = pss;
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return auth;
    }

}
