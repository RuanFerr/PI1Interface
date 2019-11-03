/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import control.reserva.Reserva;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class PDFGenerator {

    public static void imprimirComprovanteReserva(Reserva res) {
        Document doc = new Document();
        try {

            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Comprovante_" + res.getNomeResponsavel() + ".pdf"));
            doc.open();
            doc.add(new Paragraph("Equipamento: " + res.getEquipamento().getNome()));
            doc.add(new Paragraph("Marca: " + res.getEquipamento().getMarca()));
            doc.add(new Paragraph("descrição: " + res.getEquipamento().getDescricao()));
            doc.add(new Paragraph("Numero de serie: " + res.getEquipamento().getNumSerie()));
            doc.add(new Paragraph(""));
            doc.add(new Paragraph("Nome do responsável: " + res.getNomeResponsavel()));
            doc.add(new Paragraph("CPF do responsável: " + res.getCpfResp()));
            doc.add(new Paragraph(""));
            doc.add(new Paragraph("Data escolhida: " + res.getDataHoraReserva()));
            doc.add(new Paragraph("Situação: Reservado"));
            JOptionPane.showMessageDialog(null, "PDF salvo em DOCUMENTOS");

        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            doc.close();
        }
    }
}
