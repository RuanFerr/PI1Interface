/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import control.reserva.Equipamento;
import control.reserva.Reserva;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
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

    public static PdfPTable criarCabecalho()
            throws DocumentException {
        PdfPTable table = new PdfPTable(new float[]{5f, 5f, 5f, 5f, 5f});
        PdfPCell celulaID = new PdfPCell(new Phrase("ID"));
        celulaID.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaNome = new PdfPCell(new Phrase("Nome"));
        celulaNome.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaMarca = new PdfPCell(new Phrase("Marca"));
        celulaMarca.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaDescricao = new PdfPCell(new Phrase("Descricao"));
        celulaDescricao.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaNumSerie = new PdfPCell(new Phrase("Numero de serie"));
        celulaNumSerie.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(celulaID);
        table.addCell(celulaNome);
        table.addCell(celulaMarca);
        table.addCell(celulaDescricao);
        table.addCell(celulaNumSerie);

        return table;

    }

    public static void preencherDados(Document document, PdfPTable table, List<Equipamento> equip) throws DocumentException {
        if (document.isOpen()) {
            for (Equipamento eq : equip) {
                PdfPCell celula1 = new PdfPCell(new Phrase(String.valueOf(eq.getId())));
                PdfPCell celula2 = new PdfPCell(new Phrase(eq.getNome()));
                PdfPCell celula3 = new PdfPCell(new Phrase(eq.getMarca()));
                PdfPCell celula4 = new PdfPCell(new Phrase(eq.getDescricao()));
                PdfPCell celula5 = new PdfPCell(new Phrase(String.valueOf(eq.getNumSerie())));

                table.addCell(celula1);
                table.addCell(celula2);
                table.addCell(celula3);
                table.addCell(celula4);
                table.addCell(celula5);
            }

            document.add(table);
        }
    }

}
