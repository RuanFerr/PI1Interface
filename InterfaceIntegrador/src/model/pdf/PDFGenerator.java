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
import control.reserva.Locacao;
import control.reserva.Reserva;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static PdfPTable criarCabecalhoEquip(Document doc) throws DocumentException {

        float[] widths = {5f, 5f, 5f, 5f, 5f};

        PdfPTable tab = new PdfPTable(widths);

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

        tab.addCell(celulaID);

        tab.addCell(celulaNome);

        tab.addCell(celulaMarca);

        tab.addCell(celulaDescricao);

        tab.addCell(celulaNumSerie);

        return tab;

    }

    public static PdfPTable criarCabecalhoRes(Document doc) throws DocumentException {

        float[] widths = {5f, 6f, 5f, 5f, 6f, 5f};

        PdfPTable tab = new PdfPTable(widths);

        PdfPCell celulaID = new PdfPCell(new Phrase("ID"));

        celulaID.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaNome = new PdfPCell(new Phrase("nome Responsavel"));

        celulaNome.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulacpf = new PdfPCell(new Phrase("CPF"));

        celulacpf.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaData = new PdfPCell(new Phrase("data Reserva"));

        celulaData.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaIdEq = new PdfPCell(new Phrase("id Equipamento"));

        celulaIdEq.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaStatus = new PdfPCell(new Phrase("status"));
        celulaStatus.setHorizontalAlignment(Element.ALIGN_CENTER);

        tab.addCell(celulaID);

        tab.addCell(celulaNome);

        tab.addCell(celulacpf);

        tab.addCell(celulaData);

        tab.addCell(celulaIdEq);

        tab.addCell(celulaStatus);

        return tab;

    }

    public static PdfPTable criarCabecalhoLoc(Document doc) throws DocumentException {

        float[] widths = {5f, 6f, 5f, 5f, 6f, 5f};

        PdfPTable tab = new PdfPTable(widths);

        PdfPCell celulaID = new PdfPCell(new Phrase("ID"));

        celulaID.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaIdEq = new PdfPCell(new Phrase("id Equipamento"));

        celulaIdEq.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaNome = new PdfPCell(new Phrase("nome Responsavel"));

        celulaNome.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulacpf = new PdfPCell(new Phrase("CPF"));

        celulacpf.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaData = new PdfPCell(new Phrase("data Reserva"));

        celulaData.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaStatus = new PdfPCell(new Phrase("status"));
        celulaStatus.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell celulaIdFunc = new PdfPCell(new Phrase("id Funcionario"));
        celulaStatus.setHorizontalAlignment(Element.ALIGN_CENTER);

        tab.addCell(celulaID);

        tab.addCell(celulaNome);

        tab.addCell(celulacpf);

        tab.addCell(celulaData);

        tab.addCell(celulaIdEq);

        tab.addCell(celulaIdFunc);

        tab.addCell(celulaStatus);

        return tab;

    }

    public static void preencherDadosEquip(Document doc, PdfPTable table, List<Equipamento> list) throws DocumentException {
        if (doc.isOpen()) {

            for (int i = 0; i < list.size(); i++) {
                System.out.println(i);
                Equipamento eq = list.get(i);
                PdfPCell celula1 = new PdfPCell(new Phrase(String.valueOf(eq.getId())));
                System.out.println(eq.getId());
                PdfPCell celula2 = new PdfPCell(new Phrase(eq.getNome()));
                PdfPCell celula3 = new PdfPCell(new Phrase(eq.getMarca()));
                PdfPCell celula4 = new PdfPCell(new Phrase(eq.getDescricao()));
                PdfPCell celula5 = new PdfPCell(new Phrase(String.valueOf(eq.getNumSerie())));

                table.addCell(celula1);
                table.addCell(celula2);
                table.addCell(celula3);
                table.addCell(celula4);
                table.addCell(celula5);

                doc.add(table);
            }

        }
    }

    public static void preencherDadosRes(Document doc, PdfPTable table, List<Equipamento> list) throws DocumentException {
        if (doc.isOpen()) {

            for (int i = 0; i < list.size(); i++) {
                System.out.println(i);
                Equipamento eq = list.get(i);
                PdfPCell celula1 = new PdfPCell(new Phrase(String.valueOf(eq.getId())));
                System.out.println(eq.getId());
                PdfPCell celula2 = new PdfPCell(new Phrase(eq.getNome()));
                PdfPCell celula3 = new PdfPCell(new Phrase(eq.getMarca()));
                PdfPCell celula4 = new PdfPCell(new Phrase(eq.getDescricao()));
                PdfPCell celula5 = new PdfPCell(new Phrase(String.valueOf(eq.getNumSerie())));

                table.addCell(celula1);
                table.addCell(celula2);
                table.addCell(celula3);
                table.addCell(celula4);
                table.addCell(celula5);

                doc.add(table);
            }

        }
    }

    public void exportarEquipamentos(List<Equipamento> list) throws FileNotFoundException, DocumentException {
        Document doc = new Document();
        PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Equipamentos_.pdf"));

        doc.open();
        try {

            PdfPTable tab = criarCabecalhoEquip(doc);

            for (Equipamento equip : list) {
                PdfPCell celula1 = new PdfPCell(new Phrase(String.valueOf(equip.getId())));
                PdfPCell celula2 = new PdfPCell(new Phrase(equip.getNome()));
                PdfPCell celula3 = new PdfPCell(new Phrase(equip.getMarca()));
                PdfPCell celula4 = new PdfPCell(new Phrase(equip.getDescricao()));
                PdfPCell celula5 = new PdfPCell(new Phrase(String.valueOf(equip.getNumSerie())));

                tab.addCell(celula1);
                tab.addCell(celula2);
                tab.addCell(celula3);
                tab.addCell(celula4);
                tab.addCell(celula5);

            }

            doc.add(tab);

        } catch (DocumentException ex) {
            Logger.getLogger(PDFGenerator.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
        }

    }

    public void exportarReservas(List<Reserva> list) throws FileNotFoundException, DocumentException {
        Document doc = new Document();
        PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Reservas_.pdf"));

        doc.open();
        try {

            PdfPTable tab = criarCabecalhoRes(doc);

            for (Reserva res : list) {
                PdfPCell celula1 = new PdfPCell(new Phrase(String.valueOf(res.getIdReserva())));
                PdfPCell celula2 = new PdfPCell(new Phrase(res.getNomeResponsavel()));
                PdfPCell celula3 = new PdfPCell(new Phrase(res.getCpfResp()));
                PdfPCell celula4 = new PdfPCell(new Phrase(res.getDataHoraReserva()));
                PdfPCell celula5 = new PdfPCell(new Phrase(String.valueOf(res.getEquipamento().getId())));
                PdfPCell celula6 = new PdfPCell(new Phrase(res.getStatus()));

                tab.addCell(celula1);
                tab.addCell(celula2);
                tab.addCell(celula3);
                tab.addCell(celula4);
                tab.addCell(celula5);
                tab.addCell(celula6);

            }

            doc.add(tab);

        } catch (DocumentException ex) {
            Logger.getLogger(PDFGenerator.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
        }

    }

    public void exportarLocacao(List<Locacao> list) throws FileNotFoundException, DocumentException {
        Document doc = new Document();
        PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Locacoes_.pdf"));

        doc.open();
        try {

            PdfPTable tab = criarCabecalhoRes(doc);

            for (Locacao loc : list) {
                PdfPCell celula1 = new PdfPCell(new Phrase(String.valueOf(loc.getIdLocacao())));
                PdfPCell celula2 = new PdfPCell(new Phrase(loc.getNomeResponsavel()));
                PdfPCell celula3 = new PdfPCell(new Phrase(loc.getCPFResponsavel()));
                PdfPCell celula4 = new PdfPCell(new Phrase(loc.getDataLocacao()));
                PdfPCell celula5 = new PdfPCell(new Phrase(String.valueOf(loc.getIdEquipamento())));
                PdfPCell celula6 = new PdfPCell(new Phrase(String.valueOf(loc.getIdFuncionarioLocacao())));
                PdfPCell celula7 = new PdfPCell(new Phrase(loc.getStatus()));

                tab.addCell(celula1);
                tab.addCell(celula2);
                tab.addCell(celula3);
                tab.addCell(celula4);
                tab.addCell(celula5);
                tab.addCell(celula6);
                tab.addCell(celula7);

            }

            doc.add(tab);

        } catch (DocumentException ex) {
            Logger.getLogger(PDFGenerator.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
        }

    }

}
