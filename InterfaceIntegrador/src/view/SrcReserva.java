/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.reserva.Equipamento;
import control.reserva.Reserva;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DBC.ReservaDBC;
import static view.Menu.MainPNL;

/**
 *
 * @author Kelli
 */
public class SrcReserva extends javax.swing.JPanel {

    /**
     * Creates new form SrcReserva
     */
    public SrcReserva() {
        initComponents();

        fillTabAll();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbExibir = new javax.swing.JComboBox<String>();
        pnExibir = new javax.swing.JPanel();
        btnDia = new javax.swing.JComboBox<Object>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAno = new javax.swing.JComboBox<String>();
        btnMes = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabRes = new javax.swing.JTable();
        tbAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Exibir");

        cbExibir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Selecionar Data" }));
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
                .addContainerGap(151, Short.MAX_VALUE))
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

        tabRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NomeEquipamento", "dataReserva", "Responsavel", "CPFResponsavel"
            }
        ));
        jScrollPane1.setViewportView(tabRes);

        tbAlterar.setText("Alterar");
        tbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAlterarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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
                        .addComponent(tbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbExibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnExibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbAlterar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        ReservaDBC resDB = new ReservaDBC();
        String opcao = (String) cbExibir.getSelectedItem();
        if (opcao.equals("Todos")) {
            fillTabAll();
        } else {
            String data = btnDia.getSelectedItem() + "/" + btnMes.getSelectedItem() + "/" + btnAno.getSelectedItem();
            List<Reserva> lista = resDB.selectComData(data);

            DefaultTableModel dtm = (DefaultTableModel) tabRes.getModel();

            dtm.setNumRows(0);

            for (Reserva res : lista) {

                Object[] row = {res.getIdReserva(),
                    res.getEquipamento().getId(),
                    res.getDataHoraReserva(),
                    res.getNomeResponsavel(),
                    res.getCpfResp()

                };

                dtm.addRow(row);

            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiaActionPerformed


    }//GEN-LAST:event_btnDiaActionPerformed

    private void btnAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnoActionPerformed

        btnMes.setModel(new javax.swing.DefaultComboBoxModel<>(control.reserva.Reserva.getMes()));

    }//GEN-LAST:event_btnAnoActionPerformed

    private void btnMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesActionPerformed

        btnDia.setModel(new javax.swing.DefaultComboBoxModel<>(retornaDias()));

    }//GEN-LAST:event_btnMesActionPerformed

    private void cbExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExibirActionPerformed

        if (((String) cbExibir.getSelectedItem()).equals("Todos")) {

            pnExibir.setVisible(false);
            pnExibir.setEnabled(false);

        } else {

            pnExibir.setVisible(true);
            pnExibir.setEnabled(true);

        }
    }//GEN-LAST:event_cbExibirActionPerformed

    private void tbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAlterarActionPerformed
        if (tabRes.getSelectedRow() != -1) {

            BorderLayout bl = new BorderLayout();

            bl.addLayoutComponent(new CadEquip(), null);

            String idReserva = String.valueOf(tabRes.getValueAt(tabRes.getSelectedRow(), 0));

            int idRes = Integer.parseInt(idReserva);

            try {

                MainPNL.setLayout(bl);
                MainPNL.removeAll();
                MainPNL.add(new RegReserva(idRes));

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }

            MainPNL.updateUI();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Reserva");
        }
    }//GEN-LAST:event_tbAlterarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        if (tabRes.getSelectedRow() != -1) {

            Object[] opcoes = {"Confirmar", "Cancelar"};
            if (JOptionPane.showOptionDialog(null, "Deleja alterar este registro?",
                    "Alterar Registro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]) == 0) {

                ReservaDBC resDB = new ReservaDBC();
                Reserva res = new Reserva();
                int idr = Integer.parseInt(String.valueOf(tabRes.getValueAt(tabRes.getSelectedRow(), 0)));
                res.setIdReserva(idr);

                resDB.delete(res);

                fillTabAll();

            } else {
            }

        } else {
        }

    }//GEN-LAST:event_btCancelarActionPerformed

    private void fillTabAll() {

        ReservaDBC rs = new ReservaDBC();
        List<Reserva> list = rs.select();
        DefaultTableModel dtm = (DefaultTableModel) tabRes.getModel();

        dtm.setNumRows(0);

        for (Reserva res : list) {

            Object[] row = {res.getIdReserva(),
                res.getEquipamento().getId(),
                res.getDataHoraReserva(),
                res.getNomeResponsavel(),
                res.getCpfResp()

            };

            dtm.addRow(row);

        }

    }

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
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
    private javax.swing.JTable tabRes;
    private javax.swing.JButton tbAlterar;
    // End of variables declaration//GEN-END:variables
}
