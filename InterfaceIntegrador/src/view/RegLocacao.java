/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.reserva.Locacao;
import control.reserva.Reserva;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.DBC.LocacaoDBC;
import java.util.List;
import javax.swing.JOptionPane;
import model.DBC.ReservaDBC;

/**
 *
 * @author Kelli
 */
public class RegLocacao extends javax.swing.JPanel {

    /**
     * Creates new form RegLocacao
     */
    public RegLocacao() {
        initComponents();
    }
    
    public RegLocacao(boolean buscar) {
        
        initComponents();
        fillTab();
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
        btReg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cNomeResp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cCPFResp = new javax.swing.JTextField();

        tabLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Responsavel", "Equipamento", "Data", "id"
            }
        ));
        jScrollPane1.setViewportView(tabLocacao);

        btReg.setText("Registrar");
        btReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do responsavel");

        jLabel2.setText("CPF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cNomeResp, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cCPFResp, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btReg)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cNomeResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cCPFResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegActionPerformed
        
        if (testaCampos()) {
            
            if (testaCpfNumeros() && control.cadastro.Pessoa.testCPF(cCPFResp.getText())) {
                
                Locacao loc = new Locacao();
                loc.setCPFResponsavel(Long.parseLong(cCPFResp.getText()));
                Date data;
                data = new Date();
                String dt = control.reserva.Reserva.formatador.format(data);
                loc.setDataLocacao(dt);
                
                LocacaoDBC locDB = new LocacaoDBC();
                locDB.insert(loc);
                ReservaDBC resDB = new ReservaDBC();
                Reserva res = new Reserva();
                res.setIdReserva((int) tabLocacao.getValueAt(tabLocacao.getSelectedRow(), 3));
                resDB.delete(res);
                
            } else {
                JOptionPane.showMessageDialog(null, "CPF Inválido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
    }//GEN-LAST:event_btRegActionPerformed
    
    public boolean testaCampos() {
        
        boolean teste = false;
        
        if (cCPFResp.getText().equals("") && cNomeResp.getText().equals("")) {
            
            teste = true;
            
        }
        return teste;
    }
    
    public boolean testaCpfNumeros() {
        
        try {
            
            double num = Double.parseDouble(cCPFResp.getText());
            return true;
            
        } catch (NumberFormatException e) {
            
            return false;
            
        }
        
    }
    
    private void fillTab() {
        
        DefaultTableModel dtm = (DefaultTableModel) tabLocacao.getModel();
        dtm.setNumRows(0);
        Date dthj = new Date();
        String datahj = control.reserva.Reserva.formatador.format(dthj);
        
        ReservaDBC resDB = new ReservaDBC();
        
        List<Reserva> lista = resDB.selectData(datahj);
        for (Reserva r : lista) {
            
            Object[] row = {r.getNomeResponsavel(),
                r.getEquipamento().getNome(),
                r.getDataHoraReserva(),
                r.getIdReserva()};
            dtm.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReg;
    private javax.swing.JTextField cCPFResp;
    private javax.swing.JTextField cNomeResp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabLocacao;
    // End of variables declaration//GEN-END:variables
}