/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.reserva;

import java.util.Date;
import control.reserva.Equipamento;

/**
 *
 * @author Kelli
 */
public class Dano {

    public Dano() {
    }

    public Dano(Equipamento equip, Date Data, String dano) {
        
        this.equip = equip;
        
        this.data = data;
        
        this.dano = dano;
    }

    private Equipamento equip;
    private Date data;
    private String dano;
    private int Id;
    

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }
        
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Equipamento getEquip() {
        return equip;
    }

    public void setEquip(Equipamento equip) {
        this.equip = equip;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

}
