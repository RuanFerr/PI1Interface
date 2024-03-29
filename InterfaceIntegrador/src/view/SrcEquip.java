/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.reserva.Equipamento;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DBC.EquipamentoDBC;
import static view.Menu.MainPNL;

/**
 *
 * @author Kelli
 */
public class SrcEquip extends javax.swing.JPanel {

    /**
     * Creates new form srcEqup
     */
    public SrcEquip() {

        initComponents();

    }

    public SrcEquip(boolean b) {

        initComponents();

        fillTabAll();

        pnExibir.setEnabled(false);

        pnExibir.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabEquip = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbExibir = new javax.swing.JComboBox<String>();
        pnExibir = new javax.swing.JPanel();
        btnDia = new javax.swing.JComboBox<Object>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAno = new javax.swing.JComboBox<String>();
        btnMes = new javax.swing.JComboBox<String>();
        btnBuscar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();

        tabEquip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "marca", "descricao", "Numero de Serie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabEquip);

        jLabel1.setText("Exibir");

        cbExibir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "locados", "disponiveis" }));
        cbExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExibirActionPerformed(evt);
            }
        });

        btnDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiaActionPerformed(evt);
            }
        });

        jLabel3.setText("Mês");

        jLabel2.setText("Dia");

        jLabel7.setText("Ano");

        btnAno.setModel(new javax.swing.DefaultComboBoxModel<>(control.reserva.Reserva.getAno()));
        btnAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnoActionPerformed(evt);
            }
        });

        btnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnExibirLayout = new javax.swing.GroupLayout(pnExibir);
        pnExibir.setLayout(pnExibirLayout);
        pnExibirLayout.setHorizontalGroup(
            pnExibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnExibirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnExibirLayout.setVerticalGroup(
            pnExibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnExibirLayout.createSequentialGroup()
                .addGroup(pnExibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(btnAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btDeletar.setText("Deletar");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbExibir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnExibir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbExibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnExibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btDeletar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiaActionPerformed

    }//GEN-LAST:event_btnDiaActionPerformed

    private void btnAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnoActionPerformed

        btnMes.setModel(new javax.swing.DefaultComboBoxModel<>(control.reserva.Reserva.getMes()));

    }//GEN-LAST:event_btnAnoActionPerformed

    private void btnMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesActionPerformed
        btnDia.setModel(new javax.swing.DefaultComboBoxModel<>(retornaDias()));
    }//GEN-LAST:event_btnMesActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        EquipamentoDBC EquipDB = new EquipamentoDBC();

        String opcao = (String) cbExibir.getSelectedItem();
        if (opcao.equals("Todos")) {
            fillTabAll();
        } else {

            String data = btnDia.getSelectedItem() + "/" + btnMes.getSelectedItem() + "/" + btnAno.getSelectedItem();

            List<Equipamento> lista = EquipDB.selectComData(opcao, data);

            DefaultTableModel dtm = (DefaultTableModel) tabEquip.getModel();

            dtm.setNumRows(0);

            for (Equipamento equip : lista) {

                Object[] row = {equip.getId(),
                    equip.getNome(),
                    equip.getMarca(),
                    equip.getDescricao(),
                    equip.getNumSerie()

                };

                dtm.addRow(row);

            }
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExibirActionPerformed

        if (((String) cbExibir.getSelectedItem()).equals("Todos")) {

            pnExibir.setVisible(false);
            pnExibir.setEnabled(false);

        } else {

            pnExibir.setVisible(true);
            pnExibir.setEnabled(true);

        }

    }//GEN-LAST:event_cbExibirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        if (tabEquip.getSelectedRow() != -1) {

            BorderLayout bl = new BorderLayout();

            bl.addLayoutComponent(new CadEquip(), null);

            MainPNL.setLayout(bl);
            MainPNL.removeAll();

            String idEquip = String.valueOf(tabEquip.getValueAt(tabEquip.getSelectedRow(), 0));

            int idEq = Integer.parseInt(idEquip);

            MainPNL.add(new CadEquip(idEq));

            MainPNL.updateUI();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Ocorrência");
        }

    }//GEN-LAST:event_btAlterarActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        if (tabEquip.getSelectedRow() != -1) {

            Object[] opcoes = {"Confirmar", "Cancelar"};
            if (JOptionPane.showOptionDialog(null, "Deleja deletar este registro?",
                    "Alterar Registro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]) == 0) {

                EquipamentoDBC equipDB = new EquipamentoDBC();
                Equipamento equip = new Equipamento();

                equip.setId(Integer.valueOf(String.valueOf(tabEquip.getValueAt(tabEquip.getSelectedRow(), 0))));

                equipDB.delete(equip);

                fillTabAll();

            } else {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Ocorrência");
        }
    }//GEN-LAST:event_btDeletarActionPerformed

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

    private void fillTabAll() {

        EquipamentoDBC eq = new EquipamentoDBC();
        List<Equipamento> list = eq.select();
        DefaultTableModel dtm = (DefaultTableModel) tabEquip.getModel();

        dtm.setNumRows(0);

        for (Equipamento equip : list) {

            Object[] row = {equip.getId(),
                equip.getNome(),
                equip.getMarca(),
                equip.getDescricao(),
                equip.getNumSerie()

            };

            dtm.addRow(row);

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JComboBox<String> btnAno;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Object> btnDia;
    private javax.swing.JComboBox<String> btnMes;
    private javax.swing.JComboBox<String> cbExibir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnExibir;
    private javax.swing.JTable tabEquip;
    // End of variables declaration//GEN-END:variables
}
