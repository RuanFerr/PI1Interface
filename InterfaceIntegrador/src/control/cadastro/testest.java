/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.cadastro;

/**
 *
 * @author LAB2
 */
public class testest {

    public static void main(String[] args) {
        
        String num = "08118120308";
        
        if (Pessoa.testCPF(num)) {
            System.out.println("CPF OK");
        } else {
             System.out.println("CPF INVALIDO");
        }
    }
}
