/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.reserva;

/**
 *
 * @author Kelli
 */
public class Locacao {

    String nomeResponsavel;
    String CPFResponsavel;
    String dataLocacao;
    int idFuncionarioLocacao;
    int idEquipamento;
    int idLocacao;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCPFResponsavel() {
        return CPFResponsavel;
    }

    public void setCPFResponsavel(String CPFResponsavel) {
        this.CPFResponsavel = CPFResponsavel;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public int getIdFuncionarioLocacao() {
        return idFuncionarioLocacao;
    }

    public void setIdFuncionarioLocacao(int idFuncionarioLocacao) {
        this.idFuncionarioLocacao = idFuncionarioLocacao;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }
    
    

}
