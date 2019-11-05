/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import control.reserva.Equipamento;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kelli
 */
public class test {

    public static void main(String[] args) throws BadElementException, DocumentException, FileNotFoundException {
        try {
            Document document = new Document();

            PdfWriter pdf = PdfWriter.getInstance(document, new FileOutputStream("C:\\PDF_DevMedia.pdf"));

            // Abre documento
            document.open();

            PdfPTable table = PDFGenerator.criarCabecalho();
            List<Equipamento> list;
            list = new ArrayList<Equipamento>();
            Equipamento eq = new Equipamento();
            eq.setId(1);
            eq.setNome("lol");
            eq.setMarca("lol");
            eq.setDescricao("lol");
            eq.setNumSerie(1);

            list.add(eq);
            Equipamento qe = new Equipamento();
            qe.setId(2);
            qe.setNome("rofl");
            qe.setMarca("rofl");
            qe.setDescricao("rofl");
            qe.setNumSerie(2);
            list.add(qe);

            PDFGenerator.preencherDados(document, table, list);

            // Encerra documento
            document.close();

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

}
