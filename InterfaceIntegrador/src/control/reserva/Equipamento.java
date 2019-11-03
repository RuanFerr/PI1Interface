package control.reserva;

import java.util.ArrayList;

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

}
