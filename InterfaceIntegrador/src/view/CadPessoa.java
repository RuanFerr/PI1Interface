/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.cadastro.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.DBC.PessoaDBC;

/**
 *
 * @author Kelli
 */
public class CadPessoa extends javax.swing.JPanel {

    /**
     * Creates new form CadPessoa
     */
    public CadPessoa() {
        initComponents();
    }

    public CadPessoa(int id) {

        initComponents();

        PessoaDBC pssDB = new PessoaDBC();

        Pessoa pss = pssDB.selectPessoa(id);

        cNome.setText(pss.getNome());
        cEmail.setText(pss.getEmail());
        cSenha.setText(pss.getSenha());
        cCPF.setText(pss.getCpf());
        Object cargo = pss.getCargo();
        cbCargo.setSelectedItem(cargo);

        this.id = id;

    }

    int id = -1;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<String>();
        cNome = new javax.swing.JTextField();
        cEmail = new javax.swing.JTextField();
        cCPF = new javax.swing.JTextField();
        cSenha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btCad = new javax.swing.JButton();

        jLabel1.setText("Nome");

        jLabel2.setText("Email");

        jLabel3.setText("CPF");

        jLabel4.setText("Senha");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cargo", "Gerente", "Funcionario" }));

        jLabel5.setText("Cargo");

        btCad.setText("Cadastrar");
        btCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btCad))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cCPF))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cEmail)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(btCad)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadActionPerformed
        if (testaCampos()) {

            if (testaEmail()) {

                if (testNumCPF(cCPF.getText()) && control.cadastro.Pessoa.testCPF(cCPF.getText())) {

                    Pessoa pss = new Pessoa();

                    pss.setCargo((String) cbCargo.getSelectedItem());
                    pss.setNome(cNome.getText());
                    pss.setCpf(cCPF.getText());
                    pss.setEmail(cEmail.getText());
                    pss.setSenha(cSenha.getText());
                    PessoaDBC pssDB = new PessoaDBC();
                    pssDB.insert(pss);
                    resetTab();
                } else {
                    JOptionPane.showMessageDialog(null, "CPF Inválido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Email indisponível");
            }
        } else {
            JOptionPane.showMessageDialog(null, "preencha todos os campos");
        }
    }//GEN-LAST:event_btCadActionPerformed

    private boolean testaCampos() {

        boolean nome = !this.cNome.getText().equals("");

        boolean email = !this.cEmail.getText().equals("");
        boolean senha = !this.cSenha.getText().equals("");
        boolean cpf = !this.cCPF.getText().equals("");
        boolean cargo = !this.cbCargo.getSelectedItem().equals("Cargo");

        return (nome && email && senha && cpf && cargo);
    }

    private boolean testaEmail() {

        PessoaDBC pessDB = new PessoaDBC();
        List<Pessoa> lista = pessDB.select();
        boolean valid = true;

        for (int i = 0; i < lista.size(); i++) {

            Pessoa p = lista.get(i);
            if (p.getEmail().equals(cEmail.getText())) {
                valid = false;
                i = lista.size();
            }
        }

        return valid;

    }

    private boolean testNumCPF(String CPF) {
        boolean ok;
        try {
            Long num = Long.parseLong(CPF);
            ok = true;
        } catch (NumberFormatException e) {
            ok = false;
        }
        return ok;
    }

    private void resetTab() {

        cNome.setText("");
        cEmail.setText("");
        cCPF.setText("");
        cSenha.setText("");
        cbCargo.setSelectedItem("cargo");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCad;
    private javax.swing.JTextField cCPF;
    private javax.swing.JTextField cEmail;
    private javax.swing.JTextField cNome;
    private javax.swing.JTextField cSenha;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
