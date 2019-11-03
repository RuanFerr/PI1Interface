package control.login;

import javax.swing.JOptionPane;
import control.cadastro.*;
import java.sql.Connection;
import java.util.ArrayList;
import control.connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Login {

    private static ArrayList<Pessoa> grpPessoa = new ArrayList();

    private static int indexLogin;

    private static Pessoa sessao;

    public Login() {

    }

    public static boolean login(String login, String senha) {

        Pessoa ps = new Pessoa();

        ps.setEmail("teste@gmail.com");
        ps.setSenha("123456");

        if (login.equals(ps.getEmail()) && (senha.equals(ps.getSenha()))) {
            JOptionPane.showMessageDialog(null, "Login Efetuado Com Sucesso");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Email ou senha incorretos");
        }

        return false; // apenas por conveniencia por enquanto;

    }

    public static boolean newLogin(String login, String senha) {

        if (grpPessoa.isEmpty()) {
            grpPessoa.add(new Pessoa());
        }
        grpPessoa.get(0).setEmail("teste@gmail.com");
        grpPessoa.get(0).setSenha("123456");
        grpPessoa.get(0).setCargo("Gerente");
        grpPessoa.get(0).setNome("ADMIN");

        for (int i = 0; i < grpPessoa.size(); i++) {

            if (login.equals(grpPessoa.get(i).getEmail()) && senha.equals(grpPessoa.get(i).getSenha())) {

                sessao = grpPessoa.get(i);

                i = grpPessoa.size();

                JOptionPane.showMessageDialog(null, "Login Efetuado Com Sucesso");

                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Email ou senha incorretos");
        return false;

    }

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
        Pessoa pss = null;
        try {
            con.prepareStatement("SELECT * from pessoa where email = ? AND senha = ? ");
            pst.setString(1, email);
            pst.setString(2, senha);
            rs = pst.executeQuery();

            while (rs.next()) {

                pss = new Pessoa();
                pss.setNome(rs.getString("nome"));
                pss.setSobrenome(rs.getString("sobrenome"));
                pss.setEmail(rs.getString("email"));
                pss.setSenha(rs.getString("senha"));
                pss.setMatricula(rs.getInt("matricula"));
                pss.setCargo(rs.getString("cargo"));
                pss.setNomeUsuario(rs.getString("nomeUsuario"));
                pss.setCpf(rs.getInt("CPF"));
                pss.setId(rs.getInt("id"));

            }

            if (!(pss == null)) {
                auth = true;
                sessao = pss;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return auth;
    }

}
