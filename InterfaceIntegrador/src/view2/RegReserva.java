/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view2;

import control.reserva.Equipamento;
import java.util.List;
import model.DBC.EquipamentoDBC;

/**
 *
 * @author Kelli
 */
public class RegReserva extends javax.swing.JPanel {

    /**
     * Creates new form RegLocacao
     */
    public RegReserva() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        btnAno2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnMes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnDia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbEquip = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        nomeResponsavel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CpfResp = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();

        jLabel7.setText("Ano");

        btnAno2.setModel(new javax.swing.DefaultComboBoxModel<>(control.reserva.Reserva.getAno()));
        btnAno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAno2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Mês");

        btnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesActionPerformed(evt);
            }
        });

        jLabel2.setText("Dia");

        btnDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiaActionPerformed(evt);
            }
        });

        jLabel3.setText("Equipamento");

        jLabel4.setText("Responsavel");

        jLabel6.setText("CPF ");

        btRegistrar.setText("Registrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cbEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(nomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(CpfResp, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btRegistrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(btnAno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CpfResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(btRegistrar)
                .addContainerGap(154, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAno2ActionPerformed
        btnMes.setModel(new javax.swing.DefaultComboBoxModel<>(control.reserva.Reserva.getMes()));
    }//GEN-LAST:event_btnAno2ActionPerformed

    private void btnMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesActionPerformed
        btnDia.setModel(new javax.swing.DefaultComboBoxModel<>(retornaDias()));
    }//GEN-LAST:event_btnMesActionPerformed

    private void btnDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiaActionPerformed
        cbEquip.setModel(new javax.swing.DefaultComboBoxModel<>(retornaNomeItem()));
    }//GEN-LAST:event_btnDiaActionPerformed

    public String[] retornaDias() {

        if (btnMes.getSelectedItem().equals("abril") || btnMes.getSelectedItem().equals("junho") || btnMes.getSelectedItem().equals("setembro") || btnMes.getSelectedItem().equals("novembro")) {
            return control.reserva.Reserva.getDia30();
        } else if (btnMes.getSelectedItem().equals("fevereiro")) {
            return control.reserva.Reserva.getDia28();
        } else if (btnMes.getSelectedItem().equals("mês")) {
            String[] vazio = {"dia"};
            return vazio;
        } else {

            return control.reserva.Reserva.getDia31();

        }

    }

    private String[] retornaNomeItem() {

        String data = btnDia.getSelectedItem() + "/" + btnMes.getSelectedItem() + "/ " + btnAno.getSelectedItem();
        EquipamentoDBC DBEquip = new EquipamentoDBC();
        List<Equipamento> lista = DBEquip.selectComData("", data);
        int tmn = lista.size();
        String[] nomes = new String[tmn];

        for (int i = 0; i < lista.size(); i++) {

            nomes[i] = lista.get(i).getNome();

        }

        return nomes;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CpfResp;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JComboBox<String> btnAno;
    private javax.swing.JComboBox<String> btnAno1;
    private javax.swing.JComboBox<String> btnAno2;
    private javax.swing.JComboBox<Object> btnDia;
    private javax.swing.JComboBox<String> btnMes;
    private javax.swing.JComboBox<String> cbEquip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nomeResponsavel;
    // End of variables declaration//GEN-END:variables
}
