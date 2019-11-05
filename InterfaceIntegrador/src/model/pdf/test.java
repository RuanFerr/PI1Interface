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
        
        String asd = "Projetorasdasda -- 13";
        
        int be = asd.lastIndexOf("--");
       
        System.out.println(asd.substring(be + 3)); 
    }

}
