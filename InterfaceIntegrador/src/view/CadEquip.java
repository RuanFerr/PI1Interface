/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.reserva.Equipamento;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import model.DBC.EquipamentoDBC;
import static view.Menu.MainPNL;

/**
 *
 * @author Kelli
 */
public class CadEquip extends javax.swing.JPanel {

    /**
     * Creates new form CadEquip
     */
    public CadEquip() {
        initComponents();
    }

    public CadEquip(int id) {

        initComponents();

        btSalvar.setText("alterar");

        this.id = id;

        EquipamentoDBC equipDB = new EquipamentoDBC();

        Equipamento e = equipDB.selectEquip(id);

        cNome.setText(e.getNome());
        cMarca.setText(e.getMarca());
        cNumSerie.setText(String.valueOf(e.getNumSerie()));
        cDescricao.setText(e.getDescricao());
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
        cNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cNumSerie = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();

        jLabel1.setText("Nome");

        jLabel2.setText("Descricao");

        jLabel3.setText("Marca");

        jLabel4.setText("Numero de Serie");

        btSalvar.setText("Cadastrar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cMarca)
                            .addComponent(cNumSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                    .addComponent(btSalvar)
                    .addComponent(cDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btSalvar)
                .addContainerGap(217, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (!testaCampos()) {

            if (Equipamento.testaNumSerieUnico(cNumSerie.getText())) {

                Equipamento eq = new Equipamento();
                eq.setNome(cNome.getText());
                eq.setDescricao(cDescricao.getText());
                eq.setMarca(cMarca.getText());
                eq.setNumSerie(Integer.parseInt(cNumSerie.getText()));

                EquipamentoDBC bdEquip = new EquipamentoDBC();

                if (id == -1) {

                    bdEquip.insert(eq);
                    limpaCampos();

                } else {

                    eq.setId(id);

                    Object[] opcoes = {"Confirmar", "Cancelar"};
                    if (JOptionPane.showOptionDialog(null, "Deleja alterar este registro?",
                            "Alterar Registro",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcoes,
                            opcoes[0]) == 0) {

                        bdEquip.update(eq);

                        BorderLayout bl = new BorderLayout();

                        bl.addLayoutComponent(new SrcEquip(), null);

                        MainPNL.setLayout(bl);
                        MainPNL.removeAll();
                        MainPNL.add(new SrcEquip(true));

                        MainPNL.updateUI();

                    } else {

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Numero de serie inválido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private boolean testaCampos() {

        boolean TNome = cNome.getText().equals("") || cNome.getText() == null;
        boolean TMarca = cMarca.getText().equals("") || cMarca.getText() == null;
        boolean TDescricao = cDescricao.getText().equals("") || cDescricao.getText() == null;
        boolean TNumSerie = cNumSerie.getText().equals("") || cNumSerie.getText() == null;

        return (TNome || TMarca || TDescricao || TNumSerie);
    }

    private void limpaCampos() {

        cNome.setText("");
        cDescricao.setText("");
        cNumSerie.setText("");
        cMarca.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField cDescricao;
    private javax.swing.JTextField cMarca;
    private javax.swing.JTextField cNome;
    private javax.swing.JTextField cNumSerie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
