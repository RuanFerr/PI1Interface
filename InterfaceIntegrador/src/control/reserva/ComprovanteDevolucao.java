package control.reserva;

import java.util.Date;

public class ComprovanteDevolucao {

    private String nomeResponsavel;
    private Date DataDevolucao;
    private int horaDevolucao;
    
    
    
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Date getDataDevolucao() {
        return DataDevolucao;
    }

    public void setDataDevolucao(Date DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }

    public int getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(int horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public void imprimirComprovanteDevolucao() {
        
    }

}
