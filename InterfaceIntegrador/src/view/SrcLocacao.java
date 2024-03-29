/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.pdf.PdfName;
import control.reserva.Dano;
import control.reserva.Equipamento;
import control.reserva.HistoricoDevolucao;
import control.reserva.Locacao;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DBC.DanoDBC;
import model.DBC.EquipamentoDBC;
import model.DBC.LocacaoDBC;
import model.DBC.RelatorioDBC;

/**
 *
 * @author Kelli
 */
public class SrcLocacao extends javax.swing.JPanel {

    /**
     * Creates new form SrcLocacao
     *
     * @throws java.text.ParseException
     */
    public SrcLocacao() throws ParseException {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabLocacao = new javax.swing.JTable();
        btRegDevol = new javax.swing.JButton();
        checkDano = new javax.swing.JCheckBox();
        txtDano = new javax.swing.JTextField();

        tabLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID da Locação", "Equipamento", "Responsavel", "Data da locação", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabLocacao);

        btRegDevol.setText("Registrar Devolução");
        btRegDevol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegDevolActionPerformed(evt);
            }
        });

        checkDano.setText("Dano");
        checkDano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDanoActionPerformed(evt);
            }
        });

        txtDano.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btRegDevol, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(checkDano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDano, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRegDevol)
                    .addComponent(checkDano)
                    .addComponent(txtDano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btRegDevolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegDevolActionPerformed

        if (tabLocacao.getSelectedRow() != -1) {

            HistoricoDevolucao hist = new HistoricoDevolucao();

            Date datahj = new Date();

            hist.setDataOperacao(datahj);

            LocacaoDBC locDB = new LocacaoDBC();

            hist.setLocacao(locDB.selectLocacao((int) tabLocacao.getValueAt(tabLocacao.getSelectedRow(), 0)));

            hist.setIdFunc(control.login.Login.getSessao().getId());

            if (checkDano.isSelected()) {

                DanoDBC danoDB = new DanoDBC();

                Dano dano = new Dano();
                dano.setDano(txtDano.getText());
                dano.setEquip(new Equipamento());

                dano.getEquip().setId(hist.getLocacao().getIdEquipamento());

                danoDB.insert(dano);

                hist.setDano(danoDB.selectLast());

            } else {
                hist.setDano(new Dano());
                hist.getDano().setId(-1);
            }

            RelatorioDBC relDB = new RelatorioDBC();
            
            locDB.devolveLocacao(hist.getLocacao());

            try {
                relDB.insert(hist);
            } catch (ParseException ex) {
                Logger.getLogger(SrcLocacao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Locação");
        }

    }//GEN-LAST:event_btRegDevolActionPerformed

    private void checkDanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDanoActionPerformed
        if (checkDano.isSelected()) {

            txtDano.setEnabled(true);

        } else {
            txtDano.setEnabled(false);
        }

    }//GEN-LAST:event_checkDanoActionPerformed

    private void fillTabAll() throws ParseException {

        LocacaoDBC locDB = new LocacaoDBC();
        List<Locacao> lista = locDB.select();
        DefaultTableModel dtm = (DefaultTableModel) tabLocacao.getModel();
        dtm.setNumRows(0);

        for (Locacao loc : lista) {
            if (!loc.getStatus().equalsIgnoreCase("devolvido")) {

                EquipamentoDBC eqDB = new EquipamentoDBC();

                Equipamento eq = eqDB.selectEquip(loc.getIdEquipamento());

                Object[] row = {loc.getIdLocacao(),
                    eq.getNome() + " -- " + eq.getId(),
                    loc.getNomeResponsavel(),
                    loc.getDataLocacao(),
                    testSituacao(loc.getDataLocacao())};

                if (testSituacao(loc.getDataLocacao()).equalsIgnoreCase("atrasado")) {
                    locDB.atrasado(loc);
                }

                dtm.addRow(row);
            }
        }

    }

    private String testSituacao(String data) throws ParseException {

        Date dataLoc = control.reserva.Reserva.formatador.parse(data);

        dataLoc.setHours(23);
        dataLoc.setMinutes(59);
        dataLoc.setSeconds(59);

        Date dthj = new Date();

        if (dataLoc.before(dthj)) {

            return "atrasado";

        } else {
            return "locado";
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegDevol;
    private javax.swing.JCheckBox checkDano;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabLocacao;
    private javax.swing.JTextField txtDano;
    // End of variables declaration//GEN-END:variables
}
