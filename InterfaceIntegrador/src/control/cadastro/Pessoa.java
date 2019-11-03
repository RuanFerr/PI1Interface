package control.cadastro;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String cargo;
    private String nomeUsuario;
    private int matricula;
    private long cpf;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void realizarLogin(String email, String senha) {
        //autenticar no banco
    }

    public static boolean testCPF(String strCPF) {

        char[] charCPF = strCPF.toCharArray();
        boolean tamanho = false;
        boolean dig1test = false;
        boolean dig2test = false;

        if (charCPF.length == 11) {

            int dig1 = Integer.parseInt(String.valueOf(charCPF[9]));
            int dig2 = Integer.parseInt(String.valueOf(charCPF[10]));
            tamanho = true;
            int digit = 10;
            int somat = 0;
            int digitTest;

            for (int i = 0; i < charCPF.length - 2; i++) {
                int n = Integer.parseInt(String.valueOf(charCPF[i]));
                somat = somat + (digit * n);
                digit = digit - 1;
            }
            digitTest = somat % 11;

            if (digitTest < 2) {
                digitTest = 0;
            } else {
                digitTest = 11 - digitTest;
            }
            dig1test = (digitTest == dig1);

            if (dig1test) {

                digit = 11;
                somat = 0;

                for (int i = 0; i < charCPF.length - 1; i++) {
                    int n = Integer.parseInt(String.valueOf(charCPF[i]));
                    somat = somat + (digit * n);
                    digit = digit - 1;
                }
                digitTest = somat % 11;

                if (digitTest < 2) {
                    digitTest = 0;
                } else {
                    digitTest = 11 - digitTest;
                }
                dig2test = (digitTest == dig2);

            }
        }
        return (tamanho && dig1test && dig2test);
    }

}
